package plugin.enemydown;


import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.enemydown.command.EnemydowmCommand;

public final class Main extends JavaPlugin  {


    @Override
    public void onEnable() {
      EnemydowmCommand enemydowmCommand = new EnemydowmCommand();
//      これをするとnewは1か所。newしたやつを使う。（両方同じものを使う）



      Bukkit.getPluginManager().registerEvents(new EnemydowmCommand(), this);
      getCommand("enemyDown").setExecutor(new EnemydowmCommand());
//Listener情報として登録されたから、EnemyDownでイベントハンドラ使える
    }

}
