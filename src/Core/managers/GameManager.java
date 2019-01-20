package Core.managers;

import Constants.PATH;
import Core.managers.scenarioManager.ScenarioManager;
import Core.objects.configObject.ScenarioConfig;
import Core.objects.sprites.entities.ASprite;
import Core.utility.Loader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Game engine
 * Handle and manage all the game.
 */
public class GameManager {

    private Boolean running;

    private ArrayList<ScenarioConfig> scenarioConfigs;


    private final CollisionManager collisionManager;
    private ScenarioManager scenarioManager;
    private TimeManager timeManager;

    private int iteration;
    private long time;

    public GameManager(ASprite shep) {
        this.load();

        this.collisionManager = new CollisionManager(shep);
        this.scenarioManager = new ScenarioManager(this);

        // Create the time manager (count every mili second)
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(0);
        this.timeManager = new TimeManager(this::incrementTime, 1, 1, TimeUnit.MILLISECONDS, scheduler);
    }

    /**
     * Load SCENARIOS configs (create from JSON)
     */
    private void load() {
        try {
            this.scenarioConfigs = Loader.loadScenarios(PATH.SCENARIOS);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            for (StackTraceElement err : e.getStackTrace()) {
                System.out.println(err.toString());
            }
        }
    }

    public CollisionManager getCollisionManager() {
        return collisionManager;
    }

    public ArrayList<ScenarioConfig> getScenarioConfigs() {
        return scenarioConfigs;
    }

    /**
     * Start the game Engine
     */
    public void start() {
        this.running = true;
        this.time = 0;
        this.iteration = 0;
        this.scenarioManager.start();
        this.timeManager.start();
    }

    public void pause() {
        this.running = false;
        this.scenarioManager.pause();
        this.timeManager.pause();
    }

    public void restart() {
        this.running = false;
        this.scenarioManager.restart();
        this.timeManager.restart();
    }

    public void reset() {
        this.running = false;
        this.scenarioManager = new ScenarioManager(this);
        this.time = 0;
    }

    private void incrementTime() {
        this.time += 1;
        //
    }

    public void incrementIter() {
        this.iteration += 1;
        //
    }
}
