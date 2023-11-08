package plugin.enemydown.command;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SplittableRandom;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import plugin.enemydown.data.PlayerScore;

public class EnemyDownCommand implements CommandExecutor, Listener {




  private List<PlayerScore> playerScoreList = new ArrayList<>();


  @Override

  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (sender instanceof Player player) {
//メゾット名をaddNewPlayerに
      if (playerScoreList.isEmpty()) {
        addNewPlayer(player);
      } else {
        for (PlayerScore playerScore : playerScoreList) {
          if (!playerScore.getPlayerName().equals(player.getName())) {
            addNewPlayer(player);
          }

        }
      }

      World world = player.getWorld();



/**
 *  プレイヤーの状態を初期化。（体力と空腹値を最大に）
 */

      player.setHealth(20);
      player.setFoodLevel(20);

      /**
       * ゾンビ出現させる
       */

      world.spawnEntity(getEnemySpanLocation(player, world), EntityType.ZOMBIE);





//
//      world.spawnEntity(new Location(world, (x + random), y, (z + random)), EntityType.ZOMBIE);

/**
 *       プレイヤーの武装
 */
      PlayerInventory inventory = player.getInventory();

      inventory.setHelmet(new ItemStack(Material.DIAMOND_HELMET));
      inventory.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
      inventory.setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
      inventory.setBoots(new ItemStack(Material.DIAMOND_BOOTS));
      inventory.setItemInMainHand(new ItemStack(Material.DIAMOND_SWORD));

    }

    return false;
  }

  /**
   * 敵の出現場所を取得します
   * 出現エリアにX軸とZ軸は自分の位置からプラスランダムで、－10～９の値が設定されます。
   * Y軸はプレイヤーと同じ位置になります。
   *
   * @param player　コマンドを実行したプレイヤー
   *           ＊プレイヤーだけだと複数ユーザーが実行することを考えるとコマンドを実行したプレイヤーと書く。
   * @param world　コマンドを実行したプレイヤーが所属するワールド　　　　
   * @return 敵の出現場所
   */

  private Location getEnemySpanLocation(Player player, World world) {
    Location playerLocation = player.getLocation();
    int randomX = new SplittableRandom().nextInt(20) -10;
    int randomZ = new SplittableRandom().nextInt(20) - 10;
//    0~19生成される
//    0なら－10、19なら９

    double x = playerLocation.getX() + randomX;
    double y = playerLocation.getY();
    double z = playerLocation.getZ() + randomZ;

    return new Location(world, x, y, z);

  }


  @EventHandler
/**
 * 敵を倒すと点数が手に入ること
 */

  public void onEnemyDeath(EntityDeathEvent e) {
    Player player = e.getEntity().getKiller();

    if (Objects.isNull(player) || playerScoreList.isEmpty()) {
      return;
    }
    for (PlayerScore playerScore : playerScoreList) {
      if (playerScore.getPlayerName().equals(player.getName())) {
        playerScore.setScore(playerScore.getScore() + 10);
        player.sendMessage("敵をたおした！現在のスコアは" + playerScore.getScore() + "点！");

      }
    }


  }

  /**
   * 新規のプレイヤー情報をリストに追加します
   *
   * @param player 　コマンドを実行したプレイヤー
   */

  private void addNewPlayer(Player player) {
    PlayerScore newPlayer = new PlayerScore();
    newPlayer.setPlayerName(player.getName());
    playerScoreList.add(newPlayer);
  }
}


