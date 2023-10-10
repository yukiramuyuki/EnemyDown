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

      Bukkit.getPluginManager().registerEvents(new EnemydowmCommand(), this);

      getCommand("enemyDown").setExecutor(new EnemydowmCommand());
//newが二つあると、登録されたもの、実際に動くものべつもの
//      インスタンスという考え方

//      enemydownに基づいてインスタンス（設計書のような）が作られる。
//      newしたら別々になるそれぞれA,B EnemydownCommand
//      実際登録されても、違うものが動いてしまうことも
//      →一時変数で受け取るを実行
    }

}
