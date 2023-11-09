package plugin.enemydown;


import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.enemydown.command.EnemyDownCommand;

public final class Main extends JavaPlugin {


  @Override
  public void onEnable() {
    EnemyDownCommand enemydownCommand = new EnemyDownCommand(this);
//    ①enemydownkomanndに渡す
//    コンストラクタ―を渡すとenemydowncommandに作成される

    Bukkit.getPluginManager().registerEvents(enemydownCommand, this);
    getCommand("enemyDown").setExecutor(enemydownCommand);

  }
}
