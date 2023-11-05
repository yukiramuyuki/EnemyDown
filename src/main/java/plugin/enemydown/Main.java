package plugin.enemydown;


import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.enemydown.command.EnemyDownCommand;

public final class Main extends JavaPlugin {

//マルチプレイ

//  現在は一人分のプレイヤーの情報しか保存できない
//pribate Playayer player:
//
//playerは実行の上乗せ
//マルチプレイにすると後勝ちになってしまう
//あとのプレイヤーが上乗せされてしまうから
//
//そのためマルチプレイにする
  @Override
  public void onEnable() {
    EnemyDownCommand enemydownCommand = new EnemyDownCommand();

    Bukkit.getPluginManager().registerEvents(enemydownCommand, this);
    getCommand("enemyDown").setExecutor(enemydownCommand);


  }
}
