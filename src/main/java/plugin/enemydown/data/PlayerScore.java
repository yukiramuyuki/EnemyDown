package plugin.enemydown.data;

import org.bukkit.entity.Player;


/**
 * EnemyDown�̃Q�[�������s����ۂ̃X�R�A���������I�u�W�F�N�g�B �v���C���[���A���v�_���A�����Ȃǂ̏������B
 */
//lombok�����Ȃ����@�Ŏ��s����
//  �s�͒����Ȃ邪���̃v���W�F�N�g�Ői�s����������
//  �E�N���b�N�i�s�Q�b�^�[�Z�b�^�[�ō쐬

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
