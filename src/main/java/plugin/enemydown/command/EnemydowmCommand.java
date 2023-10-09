package plugin.enemydown.command;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
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
//          プレイヤーからワールド情報を
//      リファクタリングから変数の導入
      world.spawnEntity();
//      spawn or spawnEntity
//      spawnの方がクラス取れる。分かりやすくするためEntity

    }

    return false;
  }


}
