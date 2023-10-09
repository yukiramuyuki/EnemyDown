package plugin.enemydown.command;

import java.util.SplittableRandom;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class EnemydowmCommand implements CommandExecutor {

  @Override
//武装や武器はプレイする度に同じになること

  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if(sender instanceof  Player player) {
      World world = player.getWorld();
//分けてメモしておく（改行に意味を持たせてみたり）
//     プレイヤーの状態を初期化。（体力と空腹値を最大に）
      player.setHealth(20);
      player.setFoodLevel(20);

      Location playerLocation = player.getLocation();

      PlayerInventory inventory = player.getInventory();
      ItemStack helmet = inventory.getHelmet();
//      gethelmet情報とってくる。
      inventory.setHelmet();
//      ゲーム終了
      inventory.setHelmet(helmet);
//      情報のhelmet戻る。元に戻すのはそんなに難しくない。時間制限のあとにでも・・・。




//      double x = playerLocation.getX();
//      double y = playerLocation.getY();
//      double z = playerLocation.getZ();
//
//
//      int random=new SplittableRandom().nextInt(10) + 1;
//
//
//
//      world.spawnEntity(new Location(world,(x + random)  , y,(z + random) ), EntityType.ZOMBIE);




    }
    return false;
  }


}
