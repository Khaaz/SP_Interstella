package Core.Class.ConfigClass;

import java.util.ArrayList;

public class ScenarioConfig {
    private int difficulty;
    private ArrayList<EnemyConfig> enemies;

    public ScenarioConfig(int difficulty, ArrayList<EnemyConfig> enemies) {
        this.difficulty = difficulty;
        this.enemies = enemies;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public ArrayList<EnemyConfig> getEnemies() {
        return enemies;
    }
}
