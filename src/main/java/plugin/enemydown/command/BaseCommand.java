package plugin.enemydown.command;
//  Day21onCommand�Ȃ���



import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * �R�}���h�����s���ē������v���O�C�������̊��N���X�ł��B
 */
public class BaseCommand implements CommandExecutor {
  //?implements CommandExecutor�R�s�[���Ă��ē\��t��
//onCommand��������
//  �R�}���h�͎��������Aif���R�s�[�Ŏ����Ă��Ď����Ă���return true;

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
//�R�}���h�����s
//sender���v���C���[�Ȃ珈�������Ă�����
//�����łȂ��Ȃ炻�̏��������Ă������B
