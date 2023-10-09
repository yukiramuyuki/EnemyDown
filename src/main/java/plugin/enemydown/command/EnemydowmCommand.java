package plugin.enemydown.command;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class EnemydowmCommand implements CommandExecutor {

  @Override
  //一定のエリア内でしか敵は発生しない
//  (一定のエリアでしか敵が発生しない）
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if(sender instanceof  Player player) {
      player.setHealth(20);
      player.setFoodLevel(20);
      World world = player.getWorld();
      Location playerLocation = player.getLocation();
//      ランダムを生成する
//      playerLocationよく使う？かもだから取得しておく.変数として導入。
      double x = playerLocation.getX();
      double y = playerLocation.getY();
      double z = playerLocation.getZ();

      world.spawnEntity(new Location(world, x, y, z), EntityType.ZOMBIE);
//      プレイヤーと同じところ（重なってゾンビが発生する）



    }
    return false;
  }


}
