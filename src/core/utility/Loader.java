package core.utility;

import core.objects.configObject.ScenarioConfig;
import core.utility.jsonDeserialiser.JsonDeserializer;

import java.io.IOException;
import java.util.ArrayList;

public class Loader {
    /**
     * Load a list of scenarioConfig from all the json in a directory
     * @param dirPath
     * @return
     * @throws IOException
     */
    public static ArrayList<ScenarioConfig> loadScenarios(String dirPath) throws IOException {
        // read directory
        ArrayList<String> files = Utils.readDir(dirPath);

        return JsonDeserializer.deserializeScenarios(files);
    }
}
