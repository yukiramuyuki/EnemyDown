package plugin.enemydown;


import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.enemydown.command.EnemyDownCommand;

public final class Main extends JavaPlugin {


  @Override
  public void onEnable() {
    EnemyDownCommand enemydownCommand = new EnemyDownCommand(this);

    Bukkit.getPluginManager().registerEvents(enemydownCommand, this);
    getCommand("enemyDown").setExecutor(enemydownCommand);

  }
}
