package Core.Utility;

import Core.Class.ConfigClass.ScenarioConfig;
import Core.Utility.JsonDeserialiser.JsonDeserializer;

import java.io.IOException;
import java.util.ArrayList;

public class Loader {
    public static ArrayList<ScenarioConfig> loadScenarios(String dirPath) throws IOException {
        // read directory
        ArrayList<String> files = Utils.readDir(dirPath);

        return JsonDeserializer.deserializeScenarios(files);
    }
}
