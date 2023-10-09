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
  //一定のエリア内でしか敵は発生しない
//  (一定のエリアでしか敵が発生しない）
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if(sender instanceof  Player player) {
      player.setHealth(20);
      player.setFoodLevel(20);
      World world = player.getWorld();
      Location playerLocation = player.getLocation();

      double x = playerLocation.getX();
      double y = playerLocation.getY();
      double z = playerLocation.getZ();
      //      ランダムを生成する

      int random=new SplittableRandom().nextInt(10) + 1;
//（100)ならintの中のrandomが０～９９に。100個100までではない。0スタートだから。
//      0なら自分と同じ場所。少なくとも1離れていたい。+1
//      -出したいとき（後ろ）－20。0が出たら、最低値が－20。全部マイナスになる。（20）－10くらい。に


      world.spawnEntity(new Location(world,(x + random)  , y,(z + random) ), EntityType.ZOMBIE);
//randomをｘにつける
//      作法的にクセ付けしておく。
//      yにすると頭上から出たり地下に埋まったりするからしない



    }
    return false;
  }


}
