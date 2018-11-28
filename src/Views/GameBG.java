package Views;

import javafx.scene.Parent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class GameBG extends Parent {
    public GameBG(double width, double height, String color) {
        super();
        Rectangle r = new Rectangle();
        r.setHeight(height);
        r.setWidth(width);
        r.setFill(Paint.valueOf(color));
        this.getChildren().add(r);
    }
}

