package core.objects.entities.sprites.enemies;

import constants.CONFIG;
import constants.PATH;
import core.objects.PowerUpRate;
import core.objects.configObject.EnemyConfig;

public class Enemy2 extends AEnemy {
    public Enemy2(EnemyConfig conf) {
        super(PATH.enemy, CONFIG.DEFAULT_ENTITY_WIDTH, CONFIG.DEFAULT_ENTITY_HEIGHT, conf, 10, 10, 10);
    }

    public Enemy2(EnemyConfig conf, PowerUpRate power) {
        super(PATH.enemy, CONFIG.DEFAULT_ENTITY_WIDTH, CONFIG.DEFAULT_ENTITY_HEIGHT, conf, 10, 10, 10, power);
    }
}
