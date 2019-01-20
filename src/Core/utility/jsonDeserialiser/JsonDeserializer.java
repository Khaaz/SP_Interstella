package Core.utility.jsonDeserialiser;

import Core.objects.configObject.ScenarioConfig;
import Core.utility.jsonDeserialiser.jsonObjects.JsonScenario;
import Core.utility.jsonDeserialiser.factory.ScenarioConfigFactory;
import com.google.gson.Gson;

import java.util.ArrayList;

public class JsonDeserializer {
    /**
     * Transform all JSON string into JsonScenario objects
     * @param files Array of files content (json)
     * @return Array ScenarioConfigs objects
     */
    public static ArrayList<ScenarioConfig> deserializeScenarios(ArrayList<String> files) {
        Gson gson = new Gson();

        ArrayList<JsonScenario> jsonScenarios = new ArrayList<>();
        // create a list of JsonScenario
        for (String f : files) {
            jsonScenarios.add(gson.fromJson(f, JsonScenario.class));
        }

        return ScenarioConfigFactory.createScenarios(jsonScenarios);
    }
}
