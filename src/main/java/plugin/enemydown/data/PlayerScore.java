package plugin.enemydown.data;

import org.bukkit.entity.Player;

/**
 * EnemyDown�̃Q�[�������s����ۂ̃X�R�A���������I�u�W�F�N�g�B �v���C���[���A���v�_���A�����Ȃǂ̏������B
 */

public class PlayerScore {

  private String playerName;

 private int score;
//����ł悭������@������͂��邽��
//  private���炷��

//  �E�N���b�N����
//  gette��setter
//  �ӂ��N���b�NOK

//  �������̂��̂��쐬�����



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
