package views.roots;

import views.backgrounds.ABackground;
import javafx.scene.Group;

public abstract class ARoot extends Group {
    private ABackground background;

    public ARoot(ABackground bg) {
        super();
        this.background = bg;
        this.getChildren().add(this.background);
    }

    public void resizeBackgroundHeight(double height) {
        this.background.resizeHeight(height);
    }

    public void resizeBackgroundWidth(double width) {
        this.background.resizeWidth(width);
    }

    public abstract void resizeComponents();
}
