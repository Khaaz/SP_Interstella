package Controllers.Scenes;

import Configuration.Config;
import Views.Roots.ARoot;
import javafx.scene.Scene;

public abstract class AScene extends Scene {
    public AScene(ARoot r) {
        super(r, Config.width, Config.height);
    }

    public void resizeHeight(double height) {
        ((ARoot)this.getRoot()).resizeBackgroundHeight(height);
    }

    public void resizeWidth(double width) {
        ((ARoot)this.getRoot()).resizeBackgroundWidth(width);
    }

    public abstract void onResize();
}
