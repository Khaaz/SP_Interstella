package controllers.scenes;

import constants.SCENES;
import core.events.EventCollection;
import core.events.SceneEvent;
import core.managers.GameManager;
import core.objects.entities.sprites.ASpaceship;

import javafx.event.Event;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

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

        //ASpaceship shep = this.gameManager.getInstanceManager().getShep();

        this.setOnMouseMoved(event -> this.onMouseMoved(this.gameManager.getInstanceManager().getShep(), event));
        this.setOnMouseDragged(event -> this.onMouseMoved(this.gameManager.getInstanceManager().getShep(), event));
    }

    public GameManager getGameManager() {
        return gameManager;
    }

    public void pause() {
        this.gameManager.pause();
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
            this.restart();
        }

        this.setCursor(Cursor.NONE);
    }

    public void resume() {
        this.gameManager.resume();
    }

    public void restart() {
        this.gameManager.restart();
    }

    /*
    public void removeElement(ASpaceship e) {
        ObservableList<Node> list = ((Group)this.getRoot()).getChildren();
        Node n = list
            .stream()
            .filter(o -> o instanceof ASpaceship)
            .filter(o -> ((ASpaceship)o).getID() == e.getID())
            .findFirst();
    }*/

    private void onMouseMoved(ASpaceship shep, MouseEvent event) {
        shep.body.setLayoutX(event.getSceneX() - (shep.body.getFitWidth()/2));
        shep.body.setLayoutY(event.getSceneY() - (shep.body.getFitHeight()/2));
        //System.out.println(shep.body.getX());
        //System.out.println(shep.body.getY());
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
