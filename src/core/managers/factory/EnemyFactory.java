package core.managers.factory;

import core.objects.PowerUpRate;
import core.objects.configObject.EnemyConfig;
import core.objects.sprites.entities.enemies.AEnemy;
import core.utility.Instantiator;

import java.util.ArrayList;

public class EnemyFactory {

    public static AEnemy createOneEnemy(EnemyConfig config) {
        return Instantiator.createEnemy(config);
    }

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
