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
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class EnemydowmCommand implements CommandExecutor , Listener {

private Player player;
private int score;

//  dowm nと間違えてる



  @Override
//敵を倒すと点数が手に入ること

  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if(sender instanceof  Player player) {
      this.player=player;

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
  Player player = e.getEntity().getKiller();
  if(this.player.getName().equals(player)) {
  }
//  this.の情報と一致したら
  score += 10;
//  スコアを加算
 player.sendMessage("てきをたおした！現在のスコアは" + score + "点！");

// コマンドを実行したプレイヤーの情報がthisに上書きされて、
// 敵が出現したのをプレイヤーが倒した時、killerの情報をとってきて（getkiller)、
// killerの情報がコマンドを実行したプレイヤーと同じ名前だったら、
// 加算＆メッセージを
}

}


