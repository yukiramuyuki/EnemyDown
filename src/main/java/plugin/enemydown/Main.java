package plugin.enemydown;


import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.enemydown.command.EnemyDownCommand;

public final class Main extends JavaPlugin {

//�}���`�v���C

//  ���݂͈�l���̃v���C���[�̏�񂵂��ۑ��ł��Ȃ�
//pribate Playayer player:
//
//player�͎��s�̏�悹
//�}���`�v���C�ɂ���ƌ㏟���ɂȂ��Ă��܂�
//���Ƃ̃v���C���[����悹����Ă��܂�����
//
//���̂��߃}���`�v���C�ɂ���
  @Override
  public void onEnable() {
    EnemyDownCommand enemydownCommand = new EnemyDownCommand();

    Bukkit.getPluginManager().registerEvents(enemydownCommand, this);
    getCommand("enemyDown").setExecutor(enemydownCommand);


  }
}
