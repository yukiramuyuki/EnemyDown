package plugin.enemydown.data;

import org.bukkit.entity.Player;

/**
 * EnemyDownのゲームを実行する際のスコア情報を扱うオブジェクト。
 * プレイヤー名、合計点数、日時などの情報をもつ。
 */

public class PlayerScore {
  //フィールドの情報を持ってくる（enemydowncommandからコピーで）
  private Player player;
  private int score;

}
