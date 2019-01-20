package core.managers.scenarioManager.scenarios;

import core.objects.sprites.entities.enemies.AEnemy;

import java.util.List;

public class Scenario extends AScenario {
    public Scenario(int difficulty, List<AEnemy> enemies) {
        super(difficulty, enemies);
    }
}
