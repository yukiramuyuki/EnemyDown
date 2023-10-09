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

      world.spawnEntity(new Location(world, 10, 10, 10), EntityType.ZOMBIE);
///new Location(world,距離),EntityType.種類)
//      ゾンビが発生するでも、固定値なら困る
//      サーバーごとに座標が異なるのが厄介！！
//      非機能のspigotを使っていればどのサーバーでも導入できる
//      今回は自前でエリアを作っている。が、プラグインが勝手にエリアを作っているわけではないから、
//      エリアがあることを前提にしていない
//      敵の出現をあるていど、しぼめたら・・・。
    }

    return false;
  }


}
