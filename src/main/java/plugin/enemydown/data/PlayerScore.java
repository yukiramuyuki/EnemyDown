package plugin.enemydown.data;

import org.bukkit.entity.Player;



/**
 * EnemyDownのゲームを実行する際のスコア情報を扱うオブジェクト。 プレイヤー名、合計点数、日時などの情報をもつ。
 */

public class PlayerScore {

  private String playerName;
//  publicに変更でも可能。
//  publicにすると弊害が起きることもある。

  private int score;

//  getter/setterはpublicなのでどこからでもしゅとくできる


  public String getPlayerName() {
    return playerName;
  }
//  しゅとくする

  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }
//  引数のplayerNameを自分のところにセットする

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }
}
