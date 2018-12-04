package Views.Roots;

import Views.Backgrounds.ABackground;
import javafx.scene.Parent;

public abstract class ARoot extends Parent {
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
        this.background.resizeHeight(width);
    }
}
