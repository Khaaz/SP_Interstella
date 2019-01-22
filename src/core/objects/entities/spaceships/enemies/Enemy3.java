package core.objects.entities.spaceships.enemies;

import constants.ENEMYCONF;
import core.objects.PowerUpRate;
import core.objects.configObject.EnemyConfig;

public class Enemy3 extends AEnemy {
    public Enemy3(EnemyConfig conf) {
        super(ENEMYCONF.SKIN_3,
                ENEMYCONF.WIDTH_3,
                ENEMYCONF.HEIGHT_3,
                conf,
                ENEMYCONF.LIFE_3,
                ENEMYCONF.DAMAGE_3,
                ENEMYCONF.SPEED_3,
                ENEMYCONF.BULLET_SPEED_3,
                ENEMYCONF.BULLET_RATE_3);    }

    public Enemy3(EnemyConfig conf, PowerUpRate power) {
        super(ENEMYCONF.SKIN_3,
                ENEMYCONF.WIDTH_3,
                ENEMYCONF.HEIGHT_3,
                conf,
                ENEMYCONF.LIFE_3,
                ENEMYCONF.DAMAGE_3,
                ENEMYCONF.SPEED_3,
                ENEMYCONF.BULLET_SPEED_3,
                ENEMYCONF.BULLET_RATE_3,
                power);    }
}
