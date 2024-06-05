package plugin.enemydown.data;


/**
 * EnemyDownのゲームを実行する際のプレイヤー情報を扱うオブジェクト。 プレイヤー名、合計点数、日時などの情報をもつ。
 */
//新しく作るオブジェクトをPlayerScoreにするか迷う。
//  その時に、その名前にどちらがふさわしいか考える。

//PlayerScoreからExecutingPlayerに変更
//  PlayerScoreと言いながら、playerName,scoreなど実行中のプレイヤー情報

public class ExecutingPlayer {


  private String playerName;
  private int score;


  private int gameTime;

  public ExecutingPlayer(String playerName) {
    this.playerName = playerName;

  }



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
