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

public class EnemyDownCommand implements CommandExecutor , Listener {

private Player player;
private int score;





  @Override


  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if(sender instanceof  Player player) {
      this.player=player;

      World world = player.getWorld();


//     プレイヤーの状態を初期化。（体力と空腹値を最大に）
      player.setHealth(20);
      player.setFoodLevel(20);


      //ゾンビ出現させる
      Location playerLocation = player.getLocation();

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
//敵を倒すと点数が手に入ること
public void onEnemyDeath(EntityDeathEvent e) {
  Player player = e.getEntity().getKiller();
  if(this.player.getName().equals(player.getName())) {
    score += 10;
    player.sendMessage("てきをたおした！現在のスコアは" + score + "点！");
  }

}

}


