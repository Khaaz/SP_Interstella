package old.Controllers;

import old.Controllers.Scenarios.AScenario;
import old.Core.Entities.AEntity;
import old.Core.Entities.Shep;

public class ScenarioManager {

    private Shep shep;

    private AScenario scenarios;

    public ScenarioManager(AEntity schep) {
        this.shep = (Shep)schep;

        //this.SCENARIOS = Loader.loadScenarios();

    }
}
