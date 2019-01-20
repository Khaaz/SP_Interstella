package Core.managers.factory;

import Core.managers.scenarioManager.scenarios.Scenario;
import Core.objects.PowerUpRate;
import Core.objects.configObject.ScenarioConfig;

import java.util.ArrayList;

public class ScenarioFactory {

    public static Scenario createOneScenario(ScenarioConfig config) {
        return new Scenario(
                config.getDifficulty(),
                EnemyFactory.createEnemies(config.getEnemies())
        );
    }

    public static Scenario createOneScenario(ScenarioConfig config, PowerUpRate power) {
        return new Scenario(
                config.getDifficulty(),
                EnemyFactory.createEnemies(config.getEnemies(), power)
        );
    }

    public static ArrayList<Scenario> createScenarios(ArrayList<ScenarioConfig> configs) {
        ArrayList<Scenario> scenarios = new ArrayList<>();

        for(ScenarioConfig c : configs) {
            scenarios.add(ScenarioFactory.createOneScenario(c));
        }
        return scenarios;
    }
}
