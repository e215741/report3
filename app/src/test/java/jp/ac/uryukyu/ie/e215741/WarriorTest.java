package jp.ac.uryukyu.ie.e215741;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class WarriorTest {
    /**
     * attackWithWeponSkillを3回実行し、3回ともattackの150%ダメージになっていることを検証。
     * 検証手順
     *  (1) 戦士と敵を準備。戦士の攻撃力は10とする。
     *  (2) 戦士が殴り、敵も殴る。敵は倒されないことを期待。
     *  (3) 敵の体力が15減っているかを確認。
     *  (4) (1)~(3)を3回繰り返す。
     * 　　つまり戦士が毎回15ダメージを敵に与えることを期待。これを検証する。
     */
    @Test
    void attackTest() {
        int defaultWarriorattack = 10;
        int defaultEnemyHp = 100;
        Warrior demoWarrior = new Warrior("デモ戦士", 100, defaultWarriorattack);
        Enemy slime = new Enemy("スライムもどき", defaultEnemyHp, 0);
        for(int i=0;i<3;i++){
            int beforeslimeHp = slime.getHitPoint();
            demoWarrior.attackWithWeponSkill(slime);
            slime.attack(demoWarrior);
            int afterslimeHp = slime.getHitPoint();
            assertEquals(defaultWarriorattack * 1.5,beforeslimeHp - afterslimeHp);
        }
    }   
}
