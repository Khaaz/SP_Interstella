package Core.Managers.Scenarios;

import Core.Class.Entities.Enemies.AEnemy;

import java.util.ArrayList;
import java.util.List;

public abstract class AScenario {
    private int difficulty;
    private ArrayList<AEnemy> enemies;

    public AScenario(int difficulty, List<AEnemy> enemies) {
        this.difficulty = difficulty;
        this.enemies = (ArrayList<AEnemy>)enemies;
    }
}
