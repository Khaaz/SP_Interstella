package Core.Utility.JsonDeserialiser.Factory;

import Core.Class.ConfigClass.EnemyConfig;
import Core.Utility.JsonDeserialiser.Class.JsonEnemy;

import java.util.ArrayList;
import java.util.List;

public class EnemyFactory {

    public static EnemyConfig createOneEnemy(JsonEnemy enemy) {
        return new EnemyConfig(enemy.type, enemy.posX, enemy.posY, enemy.trajectory);
    }

    public static ArrayList<EnemyConfig> createEnemies(List<JsonEnemy> jsonEnemies) {
        ArrayList<EnemyConfig> enemies = new ArrayList<>();
        for (JsonEnemy enemy : jsonEnemies) {
            enemies.add(EnemyFactory.createOneEnemy(enemy));
        }
        return enemies;
    }
}
