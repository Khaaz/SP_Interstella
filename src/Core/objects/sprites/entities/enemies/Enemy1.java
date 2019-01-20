package Core.objects.sprites.entities.enemies;

import Constants.PATH;
import Core.objects.PowerUpRate;
import Core.objects.configObject.EnemyConfig;

public class Enemy1 extends AEnemy {
    public Enemy1(EnemyConfig conf) {
        super(PATH.enemy, conf, 10, 10, 10);
    }

    public Enemy1(EnemyConfig conf, PowerUpRate power) {
        super(PATH.enemy, conf, 10, 10, 10, power);
    }
}
