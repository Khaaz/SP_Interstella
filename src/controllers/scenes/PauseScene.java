package controllers.scenes;

import constants.SCENES;
import controllers.AController;
import controllers.PauseController;
import core.events.EventCollection;
import core.events.SceneEvent;
import core.managers.GameManager;
import javafx.event.Event;
import javafx.scene.Parent;
import javafx.scene.input.KeyEvent;

public class PauseScene extends AScene {

    private GameManager manager;
    public PauseScene(Parent root, AController controller, GameManager manager) {
        super(root, controller);
        this.manager = manager;
        ((PauseController)this.controller).setResetGameManager(this.manager::reset);
    }
    
    /**
     * ESCAPE : resume -> GameScene
     * @param event keyEvent
     */
    @Override
    protected void onKeyPressed(KeyEvent event) {
        switch(event.getCode()) {
            case ESCAPE: {
                Event e = new SceneEvent(EventCollection.SCENE_CHANGE, SCENES.GAMESCENE);
                this.getRoot().fireEvent(e);
                this.manager.restart();
                break;
            }
            default: {
                //
            }
        }
    }
}
