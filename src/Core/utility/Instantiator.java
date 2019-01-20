package Core.utility;

import Core.objects.sprites.entities.enemies.AEnemy;
import Core.objects.sprites.entities.enemies.Enemy1;
import Core.objects.sprites.entities.enemies.Enemy2;
import Core.objects.PowerUpRate;
import Core.objects.configObject.EnemyConfig;

public class Instantiator {

    /**
     * Dynamically create an AEnemy regardingthe type to create
     * @param enemyConf
     * @return AEnemy
     */
    public static AEnemy createEnemy(EnemyConfig enemyConf) {
        switch (enemyConf.getType()) {
            case "enemy1": {
                return new Enemy1(enemyConf);
            }
            case "enemy2": {
                return new Enemy2(enemyConf);
            }
            default: {
                return new Enemy1(enemyConf);
            }
        }
    }

    /**
     * Dynamically create an AEnemy regardingthe type to create
     *
     * @param enemyConf
     * @param power
     * @return AEnemy
     */
    public static AEnemy createEnemy(EnemyConfig enemyConf, PowerUpRate power) {
        switch (enemyConf.getType()) {
            case "enemy1": {
                return new Enemy1(enemyConf, power);
            }
            case "enemy2": {
                return new Enemy2(enemyConf, power);
            }
            default: {
                return new Enemy1(enemyConf, power);
            }
        }
    }
}
