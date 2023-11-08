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

//今はすべて上から実行している
//  それを一定周期で実装するには
//  ループ処理で何度も実行する
//  sledsleep?で実行したら●秒まって停止するをすることは可能
//  全ての処理が停止してしまう
//  場合によってはマイクラ全てが止まるかも！
//  カウントではなく時間停止になる

//  javaだけで時間の管理をするのはめちゃ難しい！！
//  ウェブアプリではフレームワークやマイクラのspigotが仕組みを提供してくれている

//機能設計
//  時間制限を設定できること
//  スケジューラ―をつかって、一定周期で敵を出現させる。
//  一定時間が経過したらその敵を出現させる処理を停止する。


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

      Location playerLocation = player.getLocation();

      double x = playerLocation.getX();
      double y = playerLocation.getY();
      double z = playerLocation.getZ();

      int random = new SplittableRandom().nextInt(10) + 1;
      
      //Day13の敵の種類をランダムのところができていない！！
      Location enemySpanLocation = new Location(world, (x + random), y, (z + random));
      world.spawnEntity(enemySpanLocation, EntityType.ZOMBIE);
//new Location(world, (x + random), y, (z + random))リファクタリング変数の導入

      world.spawnEntity(new Location(world, (x + random), y, (z + random)), EntityType.ZOMBIE);

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


