package plugin.enemydown;


import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.enemydown.command.EnemydowmCommand;

public final class Main extends JavaPlugin  {
//implementsListenerいらない

    @Override
    public void onEnable() {

      Bukkit.getPluginManager().registerEvents(new EnemydowmCommand(), this);
//      ここの行いらない。なぜならイベントをここでは受け取っていないから！！
      getCommand("enemyDown").setExecutor(new EnemydowmCommand());
//enemydowncommandをthisに
    }

}
