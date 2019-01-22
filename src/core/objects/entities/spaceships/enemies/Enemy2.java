package core.objects.entities.spaceships.enemies;

import constants.ENEMYCONF;
import core.objects.PowerUpRate;
import core.objects.configObject.EnemyConfig;

public class Enemy2 extends AEnemy {
    public Enemy2(EnemyConfig conf) {
        super(ENEMYCONF.SKIN_2,
                ENEMYCONF.WIDTH_2,
                ENEMYCONF.HEIGHT_2,
                conf,
                ENEMYCONF.LIFE_2,
                ENEMYCONF.DAMAGE_2,
                ENEMYCONF.SPEED_2,
                ENEMYCONF.BULLET_SPEED_2,
                ENEMYCONF.BULLET_RATE_2);    }

    public Enemy2(EnemyConfig conf, PowerUpRate power) {
        super(ENEMYCONF.SKIN_2,
                ENEMYCONF.WIDTH_2,
                ENEMYCONF.HEIGHT_2,
                conf,
                ENEMYCONF.LIFE_2,
                ENEMYCONF.DAMAGE_2,
                ENEMYCONF.SPEED_2,
                ENEMYCONF.BULLET_SPEED_2,
                ENEMYCONF.BULLET_RATE_2,
                power);    }
}
