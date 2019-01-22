package core.managers.scenarioManager;

import constants.CONFIG;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ScenarioDifficultyManager {

    private ScenarioManager scenarioManager;

    private Boolean capped;

    public ScenarioDifficultyManager(ScenarioManager scenarioManager) {
        this.scenarioManager = scenarioManager;
        this.capped = false;
    }

    /**
     * Increase the difficulty if needed
     */
    protected void increaseDifficulty(int iteration) {
        // Reduce maxInterval (scenario happens more often)
        if(!this.capped && iteration % CONFIG.STEP_TO_REDUCE_MAX_INTERVAL == 0) {

            long maxInterval = (long)(this.scenarioManager.maxInterval * CONFIG.MAX_INTERVAL_REDUCER);

            System.out.println(maxInterval);
            if (maxInterval > CONFIG.CAP_INTERVAL_REDUCER) {
                this.scenarioManager.maxInterval = maxInterval;
                this.scenarioManager.scenarioTask.updateIntervals(this.scenarioManager.minInterval, this.scenarioManager.maxInterval);
            } else {
                this.capped = true;
                System.out.println("capped");
            }
        }

        // Increase scenario difficulty (add scenario of the next difficulty level in the total SCENARIOS)
        if (iteration % CONFIG.STEP_TO_INCREASE_SCENARIO_DIFFICULTY == 0) {

            this.scenarioManager.difficulty += 1;
            this.scenarioManager.scenarioConfigs = this.scenarioManager.getGameManager().getScenarioConfigs().stream()
                    .filter(s -> s.getDifficulty() <  this.scenarioManager.difficulty)
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        // Increase difficulty by adding a POWERUP to enemies
        if (iteration % CONFIG.STEP_TO_POWERUP_ENEMIES == 0) {

            this.scenarioManager.powerup.buffLifeMultiplier(CONFIG.POWERUP_LIFE_MULTIPLIER);
            this.scenarioManager.powerup.buffDamageMultiplier(CONFIG.POWERUP_DAMAGE_MULTIPLIER);
            this.scenarioManager.powerup.buffSpeedMultiplier(CONFIG.POWERUP_SPEED_MULTIPLIER);
        }
    }
}
