package Views.Backgrounds;

import Configuration.Config;
import javafx.scene.Parent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;


public abstract class ABackground extends Parent {
    private Rectangle body;
    public ABackground() {
        super();
        this.body = new Rectangle();
        this.body.setHeight(Config.height);
        this.body.setWidth(Config.width);
        this.body.setFill(Paint.valueOf(Config.BGColor));
        this.getChildren().add(this.body);
    }

    public void resizeHeight(double height) {
        this.body.setHeight(height);
    }

    public void resizeWidth(double width) {
        this.body.setWidth(width);
    }
}
