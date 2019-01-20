package core.utility.jsonDeserialiser.factory;

import core.objects.configObject.EnemyConfig;
import core.utility.jsonDeserialiser.jsonObjects.JsonEnemy;

import java.util.ArrayList;
import java.util.List;

public class EnemyConfigFactory {

    public static EnemyConfig createOneEnemy(JsonEnemy enemy) {
        return new EnemyConfig(enemy.type, enemy.posX, enemy.posY, enemy.trajectory);
    }

    public static ArrayList<EnemyConfig> createEnemies(List<JsonEnemy> jsonEnemies) {
        ArrayList<EnemyConfig> enemies = new ArrayList<>();
        for (JsonEnemy enemy : jsonEnemies) {
            enemies.add(EnemyConfigFactory.createOneEnemy(enemy));
        }
        return enemies;
    }
}
