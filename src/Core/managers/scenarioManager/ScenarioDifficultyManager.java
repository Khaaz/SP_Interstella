package Core.managers.scenarioManager;

import Constants.CONFIG;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ScenarioDifficultyManager {

    private ScenarioManager scenarioManager;

    public ScenarioDifficultyManager(ScenarioManager scenarioManager) {
        this.scenarioManager = scenarioManager;
    }

    /**
     * Increase the difficulty if needed
     */
    protected void increaseDifficulty(int iteration) {
        // Reduce maxInterval (scenario happens more often)
        if(iteration % CONFIG.STEP_TO_REDUCE_MAX_INTERVAL == 0) {

            this.scenarioManager.maxInterval = (long)(this.scenarioManager.maxInterval * CONFIG.MAX_INTERVAL_REDUCER);
            this.scenarioManager.scenarioTask.updateIntervals(this.scenarioManager.minInterval, this.scenarioManager.maxInterval);
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
