package plugin.enemydown;


import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.enemydown.command.EnemyDownCommand;

public final class Main extends JavaPlugin {


  @Override
  public void onEnable() {
    EnemyDownCommand enemydownCommand = new EnemyDownCommand();

    Bukkit.getPluginManager().registerEvents(enemydownCommand, this);
    getCommand("enemyDown").setExecutor(enemydownCommand);

//    変数のenemydownCommand
//    newではなく、

//    new２つだと別に二つ別々に管理されてしまう
//    イベント登録されているものが別々に動いてしまう
//    →一時変数にする！！
  }
  
}
