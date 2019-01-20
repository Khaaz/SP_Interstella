package core.objects.sprites.entities.enemies;

import constants.PATH;
import core.objects.PowerUpRate;
import core.objects.configObject.EnemyConfig;

public class Enemy3 extends AEnemy {
    public Enemy3(EnemyConfig conf) {
        super(PATH.enemy, conf, 10, 10, 10);
    }

    public Enemy3(EnemyConfig conf, PowerUpRate power) {
        super(PATH.enemy, conf, 10, 10, 10, power);
    }
}
