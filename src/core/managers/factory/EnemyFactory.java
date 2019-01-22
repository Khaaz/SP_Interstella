package core.managers.factory;

import core.objects.PowerUpRate;
import core.objects.configObject.EnemyConfig;
import core.objects.entities.spaceships.enemies.AEnemy;
import core.utility.Instantiator;

import java.util.ArrayList;

/**
 * Create an Enemy from an Enemy Config
 */
public class EnemyFactory {

    /**
     * Create an Enemy without bonus
     * @param config
     * @return Enemy
     */
    public static AEnemy createOneEnemy(EnemyConfig config) {
        return Instantiator.createEnemy(config);
    }

    /**
     * Create anEnemy with a bonus
     * @param config
     * @param power
     * @return Enemy
     */
    public static AEnemy createOneEnemy(EnemyConfig config, PowerUpRate power) {
        return Instantiator.createEnemy(config, power);
    }

    public static ArrayList<AEnemy> createEnemies(ArrayList<EnemyConfig> configs) {
        ArrayList<AEnemy> enemies = new ArrayList<>();

        for(EnemyConfig c : configs) {
            enemies.add(EnemyFactory.createOneEnemy(c));
        }
        return enemies;
    }

    public static ArrayList<AEnemy> createEnemies(ArrayList<EnemyConfig> configs, PowerUpRate power) {
        ArrayList<AEnemy> enemies = new ArrayList<>();

        for(EnemyConfig c : configs) {
            enemies.add(EnemyFactory.createOneEnemy(c, power));
        }
        return enemies;
    }
}
