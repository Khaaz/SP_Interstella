package core.objects.entities.spaceships.enemies;

import constants.ENEMYCONF;
import core.objects.PowerUpRate;
import core.objects.configObject.EnemyConfig;

public class Enemy1 extends AEnemy {
    public Enemy1(EnemyConfig conf) {
        super(ENEMYCONF.SKIN_1,
                ENEMYCONF.WIDTH_1,
                ENEMYCONF.HEIGHT_1,
                conf,
                ENEMYCONF.LIFE_1,
                ENEMYCONF.DAMAGE_1,
                ENEMYCONF.SPEED_1,
                ENEMYCONF.BULLET_SPEED_1,
                ENEMYCONF.BULLET_RATE_1);
    }

    public Enemy1(EnemyConfig conf, PowerUpRate power) {
        super(ENEMYCONF.SKIN_1,
                ENEMYCONF.WIDTH_1,
                ENEMYCONF.HEIGHT_1,
                conf,
                ENEMYCONF.LIFE_1,
                ENEMYCONF.DAMAGE_1,
                ENEMYCONF.SPEED_1,
                ENEMYCONF.BULLET_SPEED_1,
                ENEMYCONF.BULLET_RATE_1,
                power);
    }
}
