package plugin.enemydown.data;

import org.bukkit.entity.Player;


/**
 * EnemyDownのゲームを実行する際のスコア情報を扱うオブジェクト。
 * プレイヤー名、合計点数、日時などの情報をもつ。
 */


public class PlayerScore {


  private String playerName;
  private int score;


  private int gameTime;











//

  public int getGameTime() {
    return gameTime;
  }

  public void setGameTime(int gameTime) {
    this.gameTime = gameTime;
  }


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
