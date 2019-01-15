package Core.Utility.JsonDeserialiser;

import Core.Managers.Scenarios.Scenario;
import Core.Utility.JsonDeserialiser.Class.JsonScenario;
import Core.Utility.JsonDeserialiser.Factory.ScenarioFactory;
import Core.Utility.Utils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

public class JsonDeserializer {
    public static ArrayList<Scenario> deserializeScenarios(String dirPath) throws IOException {
        // read directory
        ArrayList<String> files = Utils.readDir(dirPath);

        Gson gson = new Gson();

        ArrayList<JsonScenario> jsonScenarios = new ArrayList<JsonScenario>();
        // create a list of JsonScenario
        for (String f : files) {
            jsonScenarios.add(gson.fromJson(f, JsonScenario.class));
        }

        return ScenarioFactory.createScenarios(jsonScenarios);
    }
}
