package plugin.enemydown.command;
//  Day21onCommand�Ȃ���



import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * �R�}���h�����s���ē������v���O�C�������̊��N���X�ł��B
 */
public abstract class BaseCommand implements CommandExecutor {
//  public class BaseCommand implements CommandExecutor {


  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (sender instanceof Player player) {
     return onExecutePlayerCommand(player);
//  onExecutePlayerCommand(player)��������A���݂��Ȃ��̂ō쐬���邩������āA�쐬���邱�Ƃ��ł���


//      return true;
    }else {
      return onExecuteNPCCommand(sender);
    }


  }


  public abstract boolean onExecutePlayerCommand(Player player) ;
  public abstract boolean onExecuteNPCCommand(CommandSender sender) ;

//    private void onExecutePlayerCommand(Player player) {
//    private�ɂ���Ɠ����Ȃ�

}

//boolean�������s�������ǂ���

//abstract(�N���X�ɂ��K�v�j
//���ۃN���X�ƌĂ΂����́B���ۓI�Ȃ̂ł��ꂾ���ł͓����Ȃ�
//������G�N�X�e���Y�i�p���j������
//�p������onExecutePlayerCommand���������邱�Ƃɂ���ĈӖ����ł�

//onCommand�̒��ŐU�镑����񎦂���
//�i�v���C���[��������onExecutePlayerCommand����������B�j
