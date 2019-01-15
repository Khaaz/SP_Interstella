package Core.Managers.Scenes;

import Constants.CONFIG;
import old.Views.Roots.ARoot;
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

    public abstract void onResize();
}
