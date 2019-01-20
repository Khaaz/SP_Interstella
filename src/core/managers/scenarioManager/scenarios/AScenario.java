package core.managers.scenarioManager.scenarios;

import core.managers.CollisionManager;
import core.objects.sprites.entities.enemies.AEnemy;

import java.util.ArrayList;
import java.util.List;

public abstract class AScenario {
    private int difficulty;
    private ArrayList<AEnemy> enemies;

    public AScenario(int difficulty, List<AEnemy> enemies) {
        this.difficulty = difficulty;
        this.enemies = (ArrayList<AEnemy>)enemies;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public ArrayList<AEnemy> getEnemies() {
        return enemies;
    }

    /**
     * Main method for a scenario
     * @param collisionManager
     */
    public void start(CollisionManager collisionManager) {

        for(AEnemy e : enemies) {

        }
    }
}
