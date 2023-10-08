package plugin.enemydown;


import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {

      Bukkit.getPluginManager().registerEvents(this, this);
      getCommand("enemyDownStart").setExecutor(new SetLevelCommand());
//コピーしてくる。それをしないと時間かかる
//      コマンドまだない。名前もコピーからのものを使いたいわけじゃない
//      今回回復するコマンドではなく、ゲームをしたい
//      ゲームの実行コマンド
//      ゲームスタートだと、何をスタートするのか分からない。
//      今回はenemydownスタート
    }
}
