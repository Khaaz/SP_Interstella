package core.objects.sprites.entities.enemies;

import constants.PATH;
import core.objects.PowerUpRate;
import core.objects.configObject.EnemyConfig;

public class Enemy1 extends AEnemy {
    public Enemy1(EnemyConfig conf) {
        super(PATH.enemy, conf, 10, 10, 10);
    }

    public Enemy1(EnemyConfig conf, PowerUpRate power) {
        super(PATH.enemy, conf, 10, 10, 10, power);
    }
}
