package plugin.enemydown;


import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.enemydown.command.EnemydowmCommand;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
//      一定のエリア内でしか敵は発生しないこと
//敵の種類はランダムであること
      Bukkit.getPluginManager().registerEvents(this, this);
      getCommand("enemyDown").setExecutor(new EnemydowmCommand());

    }
}
