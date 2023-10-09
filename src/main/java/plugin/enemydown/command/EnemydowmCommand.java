package plugin.enemydown.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnemydowmCommand implements CommandExecutor {

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if(sender instanceof  Player player) {
      player.setHealth(20);
      player.setFoodLevel(20);

    }
//  playerだったら何をするか？前回はセットレベルや、メッセージを表示させたりした
//今回はMAXにするのみ。今は引数とらない。
//  HP/レベルを20に
//  シンプルなものを1つずつ。確実に！！一気にしない。
    return false;
  }


}
