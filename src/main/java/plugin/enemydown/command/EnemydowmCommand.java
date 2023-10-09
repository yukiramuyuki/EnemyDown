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
//      プレイヤーの周囲（例30マス）の中の範囲に敵が発生する
      World world = player.getWorld();
//      自分の情報取得
      Location playerLocation = player.getLocation();

//      player.getLocationで変数導入
//     Location playerLocationにする

      world.spawnEntity(new Location(world, 10, 10, 10), EntityType.ZOMBIE);



    }
    return false;
  }


}
