
package plugin.enemydown.mapper.data;

/**
 * �v���C���[�̃X�R�A���������I�u�W�F�N�g�B DB�ɑ��݂���e�[�u���ƘA������B
 */

/**
 * @Getter&@Setter
 */
public class PlayerScore {

  private int id;
  private String playerName;
  private int score;
  private String difficulty;
  private String registered_at;
  //  ���t������łƂ��Ă��Ă邩��String


  /**
   *������Getter/Setter
   * @return
   */
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public String getDifficulty() {
    return difficulty;
  }

  public void setDifficulty(String difficulty) {
    this.difficulty = difficulty;
  }

  public String getRegistered_at() {
    return registered_at;
  }

  public void setRegistered_at(String registered_at) {
    this.registered_at = registered_at;
  }

}
