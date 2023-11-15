package plugin.enemydown.command;
//  Day21onCommandなくす



import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * コマンドを実行して動かすプログイン処理の基底クラスです。
 */
public class BaseCommand implements CommandExecutor {
  //?implements CommandExecutorコピーしてきて貼り付け
//onCommand実装する
//  コマンドは実装せず、ifをコピーで持ってきて持ってきてreturn true;

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (sender instanceof Player player) {
      return true;
    }else {
      return true;
    }

//    return false;
  }
}
//コマンドを実行
//senderがプレイヤーなら処理をしてかえす
//そうでないならその処理をしてかえす。
