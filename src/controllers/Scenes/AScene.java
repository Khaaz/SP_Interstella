package controllers.Scenes;

import constants.CONFIG;
import views.roots.ARoot;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

public abstract class AScene extends Scene {
    public AScene(Parent r) {
        super(r, CONFIG.WIDTH, CONFIG.HEIGHT);
    }

    public void resizeHeight(double height) {
        ((ARoot)this.getRoot()).resizeBackgroundHeight(height);
    }

    public void resizeWidth(double width) {
        ((ARoot)this.getRoot()).resizeBackgroundWidth(width);
    }

    protected void addElement(Node e) {
        ((Group)this.getRoot()).getChildren().add(e);
    }

    public void onResize() {
        ((ARoot)this.getRoot()).resizeComponents();
    }
}
