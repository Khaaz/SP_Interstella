package Core.Managers.Scenarios;

import Core.Class.Entities.Enemies.AEnemy;

import java.util.List;

public class Scenario extends AScenario {
    public Scenario(int difficulty, List<AEnemy> enemies) {
        super(difficulty, enemies);
    }
}
