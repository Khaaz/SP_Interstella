package Core.Utility;

import Core.Class.Entities.Enemies.AEnemy;
import Core.Class.Entities.Enemies.Enemy1;
import Core.Class.Entities.Enemies.Enemy2;
import Core.Class.PowerupRate;
import Core.Class.ConfigClass.EnemyConfig;

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
    public static AEnemy createEnemy(EnemyConfig enemyConf, PowerupRate power) {
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
