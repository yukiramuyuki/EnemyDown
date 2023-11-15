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
//  public class BaseCommand implements CommandExecutor {


  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (sender instanceof Player player) {
     return onExecutePlayerCommand(player);
//  onExecutePlayerCommand(player)をしたら、存在しないので作成するか聞かれて、作成することができる


//      return true;
    }else {
      return onExecuteNPCCommand(sender);
    }


  }


  public abstract boolean onExecutePlayerCommand(Player player) ;
  public abstract boolean onExecuteNPCCommand(CommandSender sender) ;

//    private void onExecutePlayerCommand(Player player) {
//    privateにすると動かない

}

//boolean処理を行ったかどうか

//abstract(クラスにも必要）
//抽象クラスと呼ばれるもの。抽象的なのでこれだけでは動かない
//これをエクステンズ（継承）したら
//継承したonExecutePlayerCommandを実装することによって意味がでる

//onCommandの中で振る舞いを提示する
//（プレイヤーだったらonExecutePlayerCommandを実装する。）
