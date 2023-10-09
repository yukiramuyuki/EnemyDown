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
//武装や武器はプレイする度に同じになること

//  上書きするか、他に保存しておいて終わったら元に戻す
//  今回は強制上書き
//  対象プレイヤーのイベントリの中身を直接書き換えることで実現する。
//  コマンド実行時に差し替えt、最終的にはコマンド実行前の装備の状況を保存しておき、ゲーム終了後もとに戻したい。
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
