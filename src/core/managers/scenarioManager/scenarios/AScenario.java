package core.managers.scenarioManager.scenarios;

import core.managers.InstanceManager;
import core.objects.entities.sprites.enemies.AEnemy;

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
     * @param instanceManager instance manager
     */
    public void start(InstanceManager instanceManager) {

        for(AEnemy e : this.enemies) {
            instanceManager.addEnemy(e);
        }
    }
}
