package plugin.enemydown.command;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.SplittableRandom;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import plugin.enemydown.Main;
import plugin.enemydown.data.PlayerScore;


/**
 * 制限時間内にランダムで出現する敵を倒してスコアを獲得するゲームを起動するコマンドです。 スコアは敵によって変わり、倒せた敵に合計によってスコアが変動します。
 * 結果はプレイヤー名、点数、日時などで保存されます。
 */
public class EnemyDownCommand extends BaseCommand implements Listener {

  public static final int GAME_TIME = 20;

  private Main main;
  private List<PlayerScore> playerScoreList = new ArrayList<>();

  public EnemyDownCommand(Main main) {
    this.main = main;

  }
//  Day22 StreamAPI


  @Override
  public boolean onExecutePlayerCommand(Player player) {

    PlayerScore nowPlayerScore = getPlayerScore(player);
//    今から実行されるスコアの情報（今の）

    initPlayerStatus(player);
//    プレイヤーの状態が消化されて

    gamePlay(player, nowPlayerScore);
//    ゲームプレイには、両方の情報が入る

    return true;
//    実行したらtrueで返す

  }


  @Override
  public boolean onExecuteNPCCommand(CommandSender sender) {
    return false;
  }


  @EventHandler
/**
 * 敵を倒すと点数が手に入ること
 */

  public void onEnemyDeath(EntityDeathEvent e) {

    LivingEntity enemy = e.getEntity();
    Player player = enemy.getKiller();

    if (Objects.isNull(player) || playerScoreList.isEmpty()) {
      return;
    }
    for (PlayerScore playerScore : playerScoreList) {
      if (playerScore.getPlayerName().equals(player.getName())) {
        int point = getPoint(enemy);

        playerScore.setScore(playerScore.getScore() + point);
        player.sendMessage("敵をたおした！現在のスコアは" + playerScore.getScore() + "点！");

      }
    }

  }


  /**
   * 現在実行しているプレイヤーのスコア情報を取得する。
   *
   * @param player コマンドを実行したプレイヤー
   * @return 現在進行しているプレイヤーのスコア情報
   */
  private PlayerScore getPlayerScore(Player player) {
    PlayerScore playerScore = new PlayerScore();

    if (playerScoreList.isEmpty()) {

    } else {

      playerScore = playerScoreList.stream().findFirst().map(ps
          -> ps.getPlayerName().equals(player.getName())
          ? ps
          : addNewPlayer(player)).orElse(playerScore);
    }

    playerScore.setGameTime(GAME_TIME);

    return playerScore;

  }


  /**
   * 新規のプレイヤー情報をリストに追加します
   *
   * @param player 　コマンドを実行したプレイヤー
   * @return 新規プレイヤー
   */

  private PlayerScore addNewPlayer(Player player) {
    PlayerScore newPlayer = new PlayerScore();
    newPlayer.setPlayerName(player.getName());
    playerScoreList.add(newPlayer);
    return newPlayer;
  }

  /**
   * ゲームを始める前にプレイヤーの状態を設定する 体力と空腹度を最大にして、装備はネザライト一式になる
   *
   * @param player コマンドを実行したプレイヤー
   */
  private static void initPlayerStatus(Player player) {
    player.setHealth(20);
    player.setFoodLevel(20);

    PlayerInventory inventory = player.getInventory();
    inventory.setHelmet(new ItemStack(Material.NETHERITE_HELMET));
    inventory.setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
    inventory.setLeggings(new ItemStack(Material.NETHERITE_LEGGINGS));
    inventory.setBoots(new ItemStack(Material.NETHERITE_BOOTS));
    inventory.setItemInMainHand(new ItemStack(Material.NETHERITE_SWORD));
  }

  /**
   * ゲームを実行します。基底の時間内に敵を倒すとスコアが加算されます。合計スコアを時間経過後に表示します
   *
   * @param player    コマンドを実行したプレイヤー
   * @param nowPlayer プレイヤースコア情報
   */


  private void gamePlay(Player player, PlayerScore nowPlayer) {
    Bukkit.getScheduler().runTaskTimer(main, Runnable -> {
      if (nowPlayer.getGameTime() <= 0) {
        Runnable.cancel();
        player.sendTitle("ゲームが終了しました。",
            nowPlayer.getPlayerName() + " 合計" + nowPlayer.getScore() + "点！",
            0, 60, 0);
        nowPlayer.setScore(0);

        List<Entity> nearbyEnemies = player.getNearbyEntities(50, 0, 50);
        for (Entity enemy : nearbyEnemies) {
          switch (enemy.getType()) {
            case ZOMBIE, SKELETON, WITCH -> enemy.remove();
          }

        }

        return;

      }

      player.getWorld().spawnEntity(getEnemySpanLocation(player), getEnemy());
      nowPlayer.setGameTime(nowPlayer.getGameTime() - 5);


    }, 0, 5 * 20);
  }

  /**
   * 敵の出現場所を取得します 出現エリアにX軸とZ軸は自分の位置からプラスランダムで、－10～９の値が設定されます。 Y軸はプレイヤーと同じ位置になります。
   *
   * @param player 　コマンドを実行したプレイヤー
   * @return 敵の出現場所
   */

  private Location getEnemySpanLocation(Player player) {
    Location playerLocation = player.getLocation();
    int randomX = new SplittableRandom().nextInt(20) - 10;
    int randomZ = new SplittableRandom().nextInt(20) - 10;

    double x = playerLocation.getX() + randomX;
    double y = playerLocation.getY();
    double z = playerLocation.getZ() + randomZ;

    return new Location(player.getWorld(), x, y, z);


  }

  /**
   * ランダムで敵を抽出して、その結果の敵を取得します
   *
   * @return 敵
   */

  private EntityType getEnemy() {

    List<EntityType> enemyList = List.of(EntityType.ZOMBIE, EntityType.SKELETON, EntityType.WITCH);
    return enemyList.get(new SplittableRandom().nextInt(enemyList.size()));
  }

  /**
   * 敵の種類ごとに取得するスコアを変える
   *
   * @param enemy
   * @return
   */
  private static int getPoint(LivingEntity enemy) {
    int point = switch (enemy.getType()) {
      case ZOMBIE -> 10;
      case SKELETON, WITCH -> 20;
      default -> 0;
    };
    return point;
  }
}


