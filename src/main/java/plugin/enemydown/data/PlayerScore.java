package plugin.enemydown.data;

import org.bukkit.entity.Player;


/**
 * EnemyDownのゲームを実行する際のスコア情報を扱うオブジェクト。 プレイヤー名、合計点数、日時などの情報をもつ。
 */
//lombokをしない方法で実行する
//  行は長くなるがこのプレジェクトで進行したいため
//  右クリック進行ゲッターセッターで作成

public class PlayerScore {


  private String playerName;


  private int score;


  public String getPlayerName() {
    return playerName;
  }

  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }
}
