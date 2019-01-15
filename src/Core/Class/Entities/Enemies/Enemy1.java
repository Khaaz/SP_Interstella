package Core.Class.Entities.Enemies;

import Constants.PATH;
import Core.Class.PowerupRate;
import Core.Class.ConfigClass.EnemyConfig;

public class Enemy1 extends AEnemy {
    public Enemy1(EnemyConfig conf) {
        super(PATH.enemy, conf, 10, 10, 10);
    }

    public Enemy1(EnemyConfig conf, PowerupRate power) {
        super(PATH.enemy, conf, 10, 10, 10, power);
    }
}
