package Core.objects.sprites.entities.enemies;

import Constants.PATH;
import Core.objects.PowerUpRate;
import Core.objects.configObject.EnemyConfig;

public class Enemy2 extends AEnemy {
    public Enemy2(EnemyConfig conf) {
        super(PATH.enemy, conf, 10, 10, 10);
    }

    public Enemy2(EnemyConfig conf, PowerUpRate power) {
        super(PATH.enemy, conf, 10, 10, 10, power);
    }
}
