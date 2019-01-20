package core.objects.entities.sprites.enemies;

import constants.PATH;
import core.objects.PowerUpRate;
import core.objects.configObject.EnemyConfig;

public class Enemy2 extends AEnemy {
    public Enemy2(EnemyConfig conf) {
        super(PATH.enemy, conf, 10, 10, 10);
    }

    public Enemy2(EnemyConfig conf, PowerUpRate power) {
        super(PATH.enemy, conf, 10, 10, 10, power);
    }
}
