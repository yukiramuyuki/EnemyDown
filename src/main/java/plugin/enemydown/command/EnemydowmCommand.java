package plugin.enemydown.command;

import java.util.SplittableRandom;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class EnemydowmCommand implements CommandExecutor {

  @Override
//難しいのは、時間制限＆保存する情報はスコアとプレイヤー名と日時、上書きではなく、すべて保存
//  保存の情報その次に点数が出る
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if(sender instanceof  Player player) {
      player.setHealth(20);
      player.setFoodLevel(20);
      World world = player.getWorld();
      Location playerLocation = player.getLocation();

      double x = playerLocation.getX();
      double y = playerLocation.getY();
      double z = playerLocation.getZ();


      int random=new SplittableRandom().nextInt(10) + 1;



      world.spawnEntity(new Location(world,(x + random)  , y,(z + random) ), EntityType.ZOMBIE);




    }
    return false;
  }


}
