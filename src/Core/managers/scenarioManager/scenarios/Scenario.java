package Core.managers.scenarioManager.scenarios;

import Core.objects.sprites.entities.enemies.AEnemy;

import java.util.List;

public class Scenario extends AScenario {
    public Scenario(int difficulty, List<AEnemy> enemies) {
        super(difficulty, enemies);
    }
}
