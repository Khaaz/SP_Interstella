package controllers.scenes;

import constants.CONFIG;
import constants.SCENES;
import controllers.AController;
import core.events.EventCollection;
import core.events.SceneEvent;
import javafx.event.Event;
import javafx.scene.input.KeyEvent;
import views.roots.ARoot;

import javafx.scene.Parent;
import javafx.scene.Scene;

public abstract class AScene extends Scene {
    protected AController controller;
    public AScene(Parent r, AController controller) {
        super(r, CONFIG.WIDTH, CONFIG.HEIGHT);
        this.controller = controller;

        this.setOnKeyPressed(this::onKeyPressed);
    }

    /**
     * Refresh the controller on every scene call
     * Dynamically change the view without re instantiating the scene
     */
    public void refresh() {
        if (this.controller != null) {
            this.controller.refresh();
        }
    }

    /**
     * ESCAPE : menu -> menuScene
     * @param event keyEvent
     */
    protected void onKeyPressed(KeyEvent event) {
        switch(event.getCode()) {
            case ESCAPE: {
                Event e = new SceneEvent(EventCollection.SCENE_CHANGE, SCENES.MENUSCENE);
                this.getRoot().fireEvent(e);
                break;
            }
            default: {
                //
            }
        }
    }

    /**
     * Only called if the root instance is type of ARoot
     * @param height height of the current scene
     */
    public void resizeHeight(double height) {
        ((ARoot)this.getRoot()).resizeBackgroundHeight(height);
    }

    /**
     * Only called if the root instance is type of ARoot
     * @param width width of the current scene
     */
    public void resizeWidth(double width) {
        ((ARoot)this.getRoot()).resizeBackgroundWidth(width);
    }

    /**
     * Resize all element in the background / reset position
     */
    public void onResize() {
        ((ARoot)this.getRoot()).resizeComponents();
    }
}
