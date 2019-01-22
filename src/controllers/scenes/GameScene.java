package controllers.scenes;

import constants.SCENES;
import core.events.EventCollection;
import core.events.SceneEvent;
import core.managers.GameManager;
import core.objects.entities.spaceships.ASpaceship;

import javafx.event.Event;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import views.roots.GameRoot;

public class GameScene extends AScene {

    private GameManager gameManager;

    /**
     * Controller
     * Responsible of events
     * @param root game root
     */
    public GameScene(Parent root) {
        super(root, null);

        this.gameManager = new GameManager(this);
        this.gameManager.start();

        this.setCursor(Cursor.NONE);

        this.setOnMouseMoved(event -> this.onMouseMoved(this.gameManager.getInstanceManager().getShep(), event));
        this.setOnMouseDragged(event -> this.onMouseMoved(this.gameManager.getInstanceManager().getShep(), event));
    }

    public GameManager getGameManager() {
        return gameManager;
    }

    /**
     * If game is paused -> resume
     * Else -> restart (new game)
     */
    @Override
    public void refresh() {
        if (this.gameManager.getPaused()) {
            this.resume();
        } else {
            this.setRoot(new GameRoot());
            this.restart();
        }

        this.setCursor(Cursor.NONE);
    }

    public void pause() {
        this.gameManager.pause();
    }

    public void resume() {
        this.gameManager.resume();
    }

    public void restart() {
        this.gameManager.restart();
    }


    public void updateTimeDisplay(double time) {
        ((GameRoot)this.getRoot()).updateTime(time);
    }

    public void updateScoreDisplay(double score) {
        ((GameRoot)this.getRoot()).updateScore(score);
    }

    public void updateLifeDisplay(double curLife, double maxLife) {
        ((GameRoot)this.getRoot()).updateLife(curLife, maxLife);
    }

    /**
     * Called when the Shep is out of life => gameover
     * call the gameOver scene
     *
     * @param points number of points earned
     */
    public void gameOver(double points) {
        System.out.println(points);
        Event e = new SceneEvent(EventCollection.SCENE_CHANGE, SCENES.GAMEOVERSCENE);
        this.getRoot().fireEvent(e);
    }

    /**
     * Move the shep according to the mouse location
     * @param shep the Shep instance
     * @param event mouse event
     */
    private void onMouseMoved(ASpaceship shep, MouseEvent event) {
        shep.body.setLayoutX(event.getSceneX() - (shep.body.getFitWidth()/2));
        shep.body.setLayoutY(event.getSceneY() - (shep.body.getFitHeight()/2));
    }

    /**
     * ESCAPE : pause -> PauseScene
     * @param event keyEvent
     */
    @Override
    protected void onKeyPressed(KeyEvent event) {
        switch(event.getCode()) {
            case ESCAPE: {
                this.pause();
                Event e = new SceneEvent(EventCollection.SCENE_CHANGE, SCENES.PAUSESCENE);
                this.getRoot().fireEvent(e);
                break;
            }
            default: {
                //
            }
        }
    }
}
