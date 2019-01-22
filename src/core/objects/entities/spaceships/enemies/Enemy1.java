package core.objects.entities.spaceships.enemies;

import constants.CONFIG;
import constants.PATH;
import core.objects.PowerUpRate;
import core.objects.configObject.EnemyConfig;

public class Enemy1 extends AEnemy {
    public Enemy1(EnemyConfig conf) {
        super(PATH.ENEMY,
                CONFIG.DEFAULT_ENTITY_WIDTH,
                CONFIG.DEFAULT_ENTITY_HEIGHT,
                conf,
                CONFIG.DEFAULT_ENEMY_LIFE,
                CONFIG.DEFAULT_ENEMY_DAMAGE,
                CONFIG.DEFAULT_ENEMY_SPEED,
                CONFIG.DEFAULT_ENEMY_BULLET_SPEED,
                0);
    }

    public Enemy1(EnemyConfig conf, PowerUpRate power) {
        super(PATH.ENEMY,
                CONFIG.DEFAULT_ENTITY_WIDTH,
                CONFIG.DEFAULT_ENTITY_HEIGHT,
                conf,
                CONFIG.DEFAULT_ENEMY_LIFE,
                CONFIG.DEFAULT_ENEMY_DAMAGE,
                CONFIG.DEFAULT_ENEMY_SPEED,
                CONFIG.DEFAULT_ENEMY_BULLET_SPEED,
                0,
                power);
    }
}
