package core.managers;

import constants.PATH;
import controllers.scenes.AScene;
import controllers.scenes.GameScene;
import core.managers.collisionManager.CollisionManager;
import core.managers.moveManager.PositionManager;
import core.managers.scenarioManager.ScenarioManager;
import core.managers.timeManager.TimeManager;
import core.objects.configObject.ScenarioConfig;
import core.utility.Loader;
import javafx.application.Platform;
import models.ScoresModel;

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
    private PositionManager positionManager;
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
        this.positionManager = new PositionManager(this.instanceManager);
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

    // GETTER
    public InstanceManager getInstanceManager() {
        return instanceManager;
    }

    public PositionManager getPositionManager() {
        return positionManager;
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
     * Start all services
     */
    public void start() {
        this.paused = false;
        this.points = 0;

        ((GameScene)this.scene).updateScoreDisplay(0);
        ((GameScene)this.scene).updateTimeDisplay(0);
        ((GameScene)this.scene).updateLifeDisplay(this.instanceManager.getShep().getCurLife(), this.instanceManager.getShep().getLife());

        // START main engine
        this.scenarioManager.start();
        this.timeManager.start();

        // start external services
        this.collisionManager.start();
        this.showManager.start();
        this.positionManager.start();
        this.instanceManager.start();


        System.out.println("start call gamemanager");
    }

    /**
     * Pause the game
     * Pause all services
     * @return
     */
    public Boolean pause() {
        if (this.paused) {
            return false;
        }
        ScoresModel.currentScore(this.points);
        this.paused = true;
        this.scenarioManager.pause();
        this.timeManager.pause();

        // pause external services
        this.collisionManager.pause();
        this.showManager.pause();
        this.positionManager.pause();
        this.instanceManager.pause();

        System.out.println("pause call gamemanager");
        return true;
    }

    /**
     * Start the game after a pause
     * resume all services
     * @return
     */
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
        this.positionManager.resume();
        this.instanceManager.resume();

        System.out.println("resume call gamemanager");
        return true;
    }

    /**
     * Reset all values
     * Reset the game
     * Call all reset from all managers
     * A new start call will be possible to start a new game
     * @return
     */
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
        this.positionManager.reset(this.instanceManager);

        System.out.println("reset call gamemanager");
        return true;
    }

    /**
     * Restart the game (new game)
     * restart potentially all services (call start)
     * @return
     */
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

    /**
     * Update the points in the DB
     * Call gameOver in the scene (scene change)
     */
    public void gameOver() {
        // modele update points
        ScoresModel.currentScore(this.points);

        ((GameScene)this.scene).gameOver(this.points);
        this.pause();
    }

    // POINTS MANAGEMENT

    /**
     * 1 point/100 milisecond
     */
    public void increasePointByTime() {
        this.points += 0.01;
        this.updateDisplayedScore();
    }

    /**
     * 10 * scenario difficulty
     * @param scenarioDifficulty
     */
    public void increasePointByIter(int scenarioDifficulty) {
        this.points += 10 * (scenarioDifficulty + 1);
        this.updateDisplayedScore();
    }

    /**
     * 20 points/kill
     */
    public void increasePointByKill() {
        this.points += 20;
        this.updateDisplayedScore();
    }

    public void updateDisplayedTime(double time) {
        Platform.runLater(() -> ((GameScene)this.scene).updateTimeDisplay(time));
    }

    public void updateDisplayedScore() {
        Platform.runLater(() -> ((GameScene)this.scene).updateScoreDisplay(this.points));
    }

    public void updateDisplayedLife(double curLife, double maxLife) {
        Platform.runLater(() -> ((GameScene)this.scene).updateLifeDisplay(curLife, maxLife));
    }
}
