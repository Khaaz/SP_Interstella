package core.managers.factory;

import core.managers.scenarioManager.scenarios.Scenario;
import core.objects.PowerUpRate;
import core.objects.configObject.ScenarioConfig;

import java.util.ArrayList;

/**
 * Create a Scenario from a Scenario config
 */
public class ScenarioFactory {

    /**
     * Create a scenario without bonus
     * @param config
     * @return Scenario
     */
    public static Scenario createOneScenario(ScenarioConfig config) {
        return new Scenario(
                config.getDifficulty(),
                EnemyFactory.createEnemies(config.getEnemies())
        );
    }

    /**
     * Create a Scenario with a bonus
     * @param config
     * @param power
     * @return Scenario
     */
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
