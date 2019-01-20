package core.managers;

import constants.PATH;
import core.managers.collisionManager.CollisionManager;
import core.managers.moveManager.MoveManager;
import core.managers.scenarioManager.ScenarioManager;
import core.managers.showManager.ShowManager;
import core.managers.timeManager.TimeManager;
import core.objects.configObject.ScenarioConfig;
import core.utility.Loader;
import views.roots.ARoot;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Game engine
 * Handle and manage all the game.
 */
public class GameManager {

    private ARoot root;

    private ArrayList<ScenarioConfig> scenarioConfigs;

    private ScenarioManager scenarioManager;
    private TimeManager timeManager;

    private CollisionManager collisionManager;
    private MoveManager moveManager;
    private ShowManager showManager;
    private InstanceManager instanceManager;


    private Boolean paused;

    private long points;

    public GameManager(ARoot root) {
        this.load();

        this.root = root;

        this.instanceManager = new InstanceManager();

        this.scenarioManager = new ScenarioManager(this);
        this.timeManager = new TimeManager(this);

        this.moveManager = new MoveManager(this.instanceManager);
        this.showManager = new ShowManager(this.instanceManager, this.root);
        this.collisionManager = new CollisionManager(this.instanceManager);

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

    public InstanceManager getInstanceManager() {
        return instanceManager;
    }

    public ArrayList<ScenarioConfig> getScenarioConfigs() {
        return scenarioConfigs;
    }

    public Boolean getPaused() {
        return paused;
    }

    /**
     * Start the game Engine
     */
    public void start() {
        //this.collisionManager = new CollisionManager(shep);

        this.paused = false;
        this.points = 0;

        // START main engine
        this.scenarioManager.start();
        this.timeManager.start();

        // start external services
        this.collisionManager.start();
        this.showManager.start();
        this.moveManager.start();

        System.out.println("start call gamemanager");
    }

    public Boolean pause() {
        if (this.paused) {
            return false;
        }
        this.paused = true;
        this.scenarioManager.pause();
        this.timeManager.pause();

        // pause external services
        this.collisionManager.pause();
        this.showManager.pause();
        this.moveManager.pause();

        System.out.println("pause call gamemanager");
        return true;
    }

    public Boolean resume() {
        if (!this.paused) {
            return false;
        }
        this.paused = false;

        this.scenarioManager.resume();
        this.timeManager.resume();

        // resume external service
        this.collisionManager.resume();
        this.showManager.resume();
        this.moveManager.resume();

        System.out.println("resume call gamemanager");
        return true;
    }

    public Boolean reset() {
        if (!this.paused) {
            return false;
        }

        this.points = 0;
        this.paused = false;

        // reset main managers (threads)
        this.scenarioManager.reset();
        this.scenarioManager = null;

        this.timeManager.reset();
        this.timeManager = null;

        // reset external service
        this.instanceManager = new InstanceManager();

        this.collisionManager.reset();
        this.showManager.reset();
        this.moveManager.reset();

        System.out.println("reset call gamemanager");
        return true;
    }

    public Boolean restart() {
        if (this.paused) {
            return false;
        }
        this.scenarioManager = new ScenarioManager(this);
        this.timeManager = new TimeManager(this);

        System.out.println("restart call gamemanager");
        this.start();
        return true;
    }

    // POINTS MANAGEMENT
    public void increasePointByTime() {
        this.points += 1;
        //
    }

    public void increasePointByIter(int scenarioDifficulty) {
        this.points += 10 * (scenarioDifficulty + 1);
        //
    }
}
