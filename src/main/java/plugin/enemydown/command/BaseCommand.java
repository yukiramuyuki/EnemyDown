package plugin.enemydown.command;
//  Day21onCommandなくす



import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * コマンドを実行して動かすプログイン処理の基底クラスです。
 */
public abstract class BaseCommand implements CommandExecutor {
  //  コマンドのオプションでプレイヤーの強さ、敵の種類をある程度コントロールできる
//  難易度を変える（敵の種類を変える）
//  enemydownに引数を設定できる必要がある


  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (sender instanceof Player player) {
     return onExecutePlayerCommand(player,command,label,args);
//     senderのみある。引数受けられなくなっている。ベースコマンドのバグ。コマンド、ラベル、アーグスをきちんとわたす。

    }else {
      return onExecuteNPCCommand(sender,command,label,args);
    }


  }

  /**
   * コマンド実行者がプレイヤーだった場合に実行します。
   * @param player コマンドを実行したプレイヤー
   * @return 処理の実行有無
   */

  public abstract boolean onExecutePlayerCommand(Player player) ;

  /**
   * コマンドの実行者がプレイヤー意外だった場合に実行します。
   * @param sender コマンド実行者
   * @return 処理の実行有無
   */
  public abstract boolean onExecuteNPCCommand(CommandSender sender) ;


}

