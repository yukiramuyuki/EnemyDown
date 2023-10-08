package plugin.enemydown;


import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.enemydown.command.EnemydowmCommand;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {

      Bukkit.getPluginManager().registerEvents(this, this);
      getCommand("enemyDown").setExecutor(new EnemydowmCommand());
//plugin.ymlのcommandsを変える必要がある。
//      setExecutorあかもじになる→Commandクラスの作成を。
//      今回はパッケージ先を変える（plugin.enemydown.command)
//      自動でcommandExecutorが作成されている。
    }
}
