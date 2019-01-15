package Core.Utility.JsonDeserialiser.Factory;

import Core.Managers.Scenarios.Scenario;
import Core.Utility.JsonDeserialiser.Class.JsonScenario;

import java.util.ArrayList;

public class ScenarioFactory {

    public static Scenario createOneScenario(JsonScenario scenario) {
        return new Scenario(scenario.difficulty, EnemyFactory.createEnemies(scenario.enemies));
    }

    public static ArrayList<Scenario> createScenarios(ArrayList<JsonScenario> jsonScenarios) {
        ArrayList<Scenario> scenarios = new ArrayList<>();
        for (JsonScenario scenario : jsonScenarios) {
            scenarios.add(ScenarioFactory.createOneScenario(scenario));
        }
        return scenarios;
    }
}
