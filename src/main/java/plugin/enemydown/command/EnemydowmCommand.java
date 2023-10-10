package plugin.enemydown.command;

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
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class EnemydowmCommand implements CommandExecutor {
//  dowm nと間違えてる
  private  int score;
//

  @Override
//敵を倒すと点数が手に入ること

  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if(sender instanceof  Player player) {
      World world = player.getWorld();
      Location playerLocation = player.getLocation();

//     プレイヤーの状態を初期化。（体力と空腹値を最大に）
      player.setHealth(20);
      player.setFoodLevel(20);


      //ゾンビ出現させる

      double x = playerLocation.getX();
      double y = playerLocation.getY();
      double z = playerLocation.getZ();


      int random=new SplittableRandom().nextInt(10) + 1;



      world.spawnEntity(new Location(world,(x + random)  , y,(z + random) ), EntityType.ZOMBIE);



//プレイヤーの武装
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

  public void onEnemyDeath(EntityDeathEvent e){
 score += 10;
 e.getEntity().getKiller().sendMessage("敵を倒した！");
//     entityの情報をとる。
//    getkiller倒したentity。プレイヤーの情報
//    敵を倒した時メッセージを。（敵を倒した時だけメッセージ）
//    コマンド実行したか関係ない。

//    killerがコマンドを実行したプレイヤーかどうか判別できていない。
//    マルチプレーのとき自分ではなくても加算される。

//    点数の加算は誰がした時にするか。で少しややこしい（難しい）
  }

}


