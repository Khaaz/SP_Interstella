package core.managers;

import constants.PATH;
import controllers.scenes.AScene;
import controllers.scenes.GameScene;
import core.managers.collisionManager.CollisionManager;
import core.managers.moveManager.MoveManager;
import core.managers.scenarioManager.ScenarioManager;
import core.managers.timeManager.TimeManager;
import core.objects.configObject.ScenarioConfig;
import core.utility.Loader;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Game engine
 * Handle and manage all the game.
 */
public class GameManager {

    private AScene scene;

    private ArrayList<ScenarioConfig> scenarioConfigs;

    private ScenarioManager scenarioManager;
    private TimeManager timeManager;

    private CollisionManager collisionManager;
    private MoveManager moveManager;
    private ShowManager showManager;
    private InstanceManager instanceManager;
    private DamageManager damageManager;


    private Boolean paused;

    private double points;

    public GameManager(GameScene scene) {
        this.scene = scene;
        this.load();

        this.instanceManager = new InstanceManager(this);

        this.scenarioManager = new ScenarioManager(this);
        this.timeManager = new TimeManager(this);

        this.damageManager = new DamageManager(this);
        this.moveManager = new MoveManager(this.instanceManager);
        this.showManager = new ShowManager(this.instanceManager, this.scene::getRoot);
        this.collisionManager = new CollisionManager(this.instanceManager, this.damageManager);
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

    public MoveManager getMoveManager() {
        return moveManager;
    }

    public ShowManager getShowManager() {
        return showManager;
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
        this.paused = false;
        this.points = 0;

        // START main engine
        this.scenarioManager.start();
        this.timeManager.start();

        // start external services
        this.collisionManager.start();
        this.showManager.start();
        this.moveManager.start();
        this.instanceManager.start();

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
        this.instanceManager.pause();

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
        this.instanceManager.resume();

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
        this.instanceManager.reset();
        this.instanceManager = new InstanceManager(this);

        this.collisionManager.reset(this.instanceManager);
        this.showManager.reset(this.instanceManager);
        this.moveManager.reset(this.instanceManager);

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

    public void gameOver() {
        ((GameScene)this.scene).gameOver(this.points);
        // modele update points
        this.pause();
    }

    // POINTS MANAGEMENT
    public void increasePointByTime() {
        this.points += 0.1;
        //
    }

    public void increasePointByIter(int scenarioDifficulty) {
        this.points += 10 * (scenarioDifficulty + 1);
        //
    }

    public void increasePointByKill() {
        this.points += 20;
        //
    }
}
