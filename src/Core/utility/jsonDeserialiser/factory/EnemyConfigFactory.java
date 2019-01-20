package Core.utility.jsonDeserialiser.factory;

import Core.objects.configObject.EnemyConfig;
import Core.utility.jsonDeserialiser.jsonObjects.JsonEnemy;

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
