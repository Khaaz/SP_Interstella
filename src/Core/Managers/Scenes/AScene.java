package Core.Managers.Scenes;

import Constants.CONFIG;
import Views.Roots.ARoot;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;

public abstract class AScene extends Scene {
    public AScene(ARoot r) {
        super(r, CONFIG.width, CONFIG.height);
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
