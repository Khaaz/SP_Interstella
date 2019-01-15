package Core.Utility.JsonDeserialiser.Factory;

import Core.Class.Entities.Enemies.AEnemy;
import Core.Utility.JsonDeserialiser.Class.JsonEnemy;

import java.util.ArrayList;
import java.util.List;

public class EnemyFactory {

    public static AEnemy createOneEnemy(JsonEnemy enemy) {
        return new AEnemy();
    }

    public static ArrayList<AEnemy> createEnemies(List<JsonEnemy> jsonEnemies) {
        ArrayList<AEnemy> enemies = new ArrayList<>();
        for (JsonEnemy enemy : jsonEnemies) {
            enemies.add(EnemyFactory.createOneEnemy(enemy));
        }
        return enemies;
    }
}
