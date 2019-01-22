package core.managers.scenarioManager.scenarios;

import core.objects.entities.spaceships.enemies.AEnemy;

import java.util.List;

/**
 * Concrete class for a Scenario
 */
public class Scenario extends AScenario {
    public Scenario(int difficulty, List<AEnemy> enemies) {
        super(difficulty, enemies);
    }
}
