package controllers.scenes;

import constants.SCENES;
import core.events.EventCollection;
import core.events.SceneEvent;
import core.managers.GameManager;
import core.objects.sprites.entities.ASprite;
import core.objects.sprites.entities.Shep;

import javafx.event.Event;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class GameScene extends AScene {

    private GameManager gameManager;

    private ASprite shep;

    /**
     * Controller
     * Responsible of events
     * @param root game root
     */
    public GameScene(Parent root, GameManager gameManager) {
        super(root, null);

        this.shep = new Shep();

        this.addElement(this.shep);

        this.gameManager = gameManager;
        this.gameManager.start(this.shep);

        this.setCursor(Cursor.NONE);

        this.setOnMouseMoved(event -> this.onMouseMoved(shep, event));
        this.setOnMouseDragged(event -> this.onMouseMoved(shep, event));
    }

    public void pause() {
        this.gameManager.pause();
    }

    @Override
    public void refresh() {
        if (this.gameManager.getRunning()) {
            this.reset();
        } else {
            this.restart();
        }

        // ?
        this.setCursor(Cursor.NONE);
    }

    public void restart() {
        this.gameManager.restart();
    }

    public void reset() {
        this.gameManager.reset();
    }

    /*
    public void removeElement(ASprite e) {
        ObservableList<Node> list = ((Group)this.getRoot()).getChildren();
        Node n = list
            .stream()
            .filter(o -> o instanceof ASprite)
            .filter(o -> ((ASprite)o).getID() == e.getID())
            .findFirst();
    }*/

    private void onMouseMoved(ASprite Shep, MouseEvent event) {
        Shep.body.setX(event.getSceneX() - (Shep.body.getFitWidth()/2));
        Shep.body.setY(event.getSceneY() - (Shep.body.getFitHeight()/2));
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
