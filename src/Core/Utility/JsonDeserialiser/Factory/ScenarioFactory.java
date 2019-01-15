package Core.Utility.JsonDeserialiser.Factory;

import Core.Class.ConfigClass.ScenarioConfig;
import Core.Utility.JsonDeserialiser.Class.JsonScenario;

import java.util.ArrayList;

public class ScenarioFactory {

    public static ScenarioConfig createOneScenario(JsonScenario scenario) {
        return new ScenarioConfig(scenario.difficulty, EnemyFactory.createEnemies(scenario.enemies));
    }

    public static ArrayList<ScenarioConfig> createScenarios(ArrayList<JsonScenario> jsonScenarios) {
        ArrayList<ScenarioConfig> scenarios = new ArrayList<>();
        for (JsonScenario scenario : jsonScenarios) {
            scenarios.add(ScenarioFactory.createOneScenario(scenario));
        }
        return scenarios;
    }
}
