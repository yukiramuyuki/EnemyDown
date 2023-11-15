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
//���̊���EnemyDownCommand�Ɍp������

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (sender instanceof Player player) {
     return onExecutePlayerCommand(player);

    }else {
      return onExecuteNPCCommand(sender);
    }


  }

  /**
   * �R�}���h���s�҂��v���C���[�������ꍇ�Ɏ��s���܂��B
   * @param player �R�}���h�����s�����v���C���[
   * @return �����̎��s�L��
   */

  public abstract boolean onExecutePlayerCommand(Player player) ;

  /**
   * �R�}���h�̎��s�҂��v���C���[�ӊO�������ꍇ�Ɏ��s���܂��B
   * @param sender �R�}���h���s��
   * @return �����̎��s�L��
   */
  public abstract boolean onExecuteNPCCommand(CommandSender sender) ;


}

