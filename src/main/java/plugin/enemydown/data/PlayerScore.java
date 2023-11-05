package plugin.enemydown.data;

import org.bukkit.entity.Player;

/**
 * EnemyDownのゲームを実行する際のスコア情報を扱うオブジェクト。 プレイヤー名、合計点数、日時などの情報をもつ。
 */

public class PlayerScore {

  private String playerName;
//  enemydownでplayerを使いたいわけではなくplayernameを使いたい
//  playerをStringにしてplayernameでも
//  playerたくさん情報持っていて便利だが、必要なものに絞る
//  ここのクラスでもっておきたいもの。項目は絞る
  private int score;

}
