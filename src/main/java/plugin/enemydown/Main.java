package plugin.enemydown;

import java.net.http.WebSocket.Listener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {
//implements�����
  @Override
  public void onEnable() {
    Bukkit.getPluginManager().registerEvents(this, this);
//    �v���O�C���g����������
  }
}


