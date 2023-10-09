package plugin.enemydown;


import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.enemydown.command.EnemydowmCommand;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
//      時間設定＆敵倒しても点は入らない
//      コマンドを実行しないと敵が発生しない
//      想定しているゲームスタート→敵ではない
      Bukkit.getPluginManager().registerEvents(this, this);
      getCommand("enemyDown").setExecutor(new EnemydowmCommand());

    }
}
