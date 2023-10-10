package plugin.enemydown;


import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.enemydown.command.EnemydowmCommand;

public final class Main extends JavaPlugin implements Listener {
  private  int score;

    @Override
    public void onEnable() {

      Bukkit.getPluginManager().registerEvents(this, this);
      getCommand("enemyDown").setExecutor(new EnemydowmCommand());

    }
  @EventHandler

  public void onEnemyDeath(EntityDeathEvent e){
    score += 10;
// カウント処理で"private int"で
//    +＝で加算される（足しこむ）10点足す。
//    他のものが倒されても足される
  }
}
