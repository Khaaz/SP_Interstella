package Core.utility.jsonDeserialiser.factory;

import Core.objects.configObject.ScenarioConfig;
import Core.utility.jsonDeserialiser.jsonObjects.JsonScenario;

import java.util.ArrayList;

public class ScenarioConfigFactory {

    public static ScenarioConfig createOneScenario(JsonScenario scenario) {
        return new ScenarioConfig(scenario.difficulty, EnemyConfigFactory.createEnemies(scenario.enemies));
    }

    public static ArrayList<ScenarioConfig> createScenarios(ArrayList<JsonScenario> jsonScenarios) {
        ArrayList<ScenarioConfig> scenarios = new ArrayList<>();
        for (JsonScenario scenario : jsonScenarios) {
            scenarios.add(ScenarioConfigFactory.createOneScenario(scenario));
        }
        return scenarios;
    }
}
