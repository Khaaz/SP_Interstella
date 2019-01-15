package Core.Utility.JsonDeserialiser;

import Core.Class.ConfigClass.ScenarioConfig;
import Core.Utility.JsonDeserialiser.Class.JsonScenario;
import Core.Utility.JsonDeserialiser.Factory.ScenarioFactory;
import com.google.gson.Gson;

import java.util.ArrayList;

public class JsonDeserializer {
    public static ArrayList<ScenarioConfig> deserializeScenarios(ArrayList<String> files) {
        Gson gson = new Gson();

        ArrayList<JsonScenario> jsonScenarios = new ArrayList<>();
        // create a list of JsonScenario
        for (String f : files) {
            jsonScenarios.add(gson.fromJson(f, JsonScenario.class));
        }

        return ScenarioFactory.createScenarios(jsonScenarios);
    }
}
