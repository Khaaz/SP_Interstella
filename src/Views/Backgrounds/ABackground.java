package Views.Backgrounds;

import Constants.CONFIG;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public abstract class ABackground extends Parent {

    private ImageView body;
    private Image skin;

    public ABackground(String imagePath) {
        super();

        this.skin = new Image(imagePath);
        this.body = new ImageView(this.skin);
        this.formatImage(CONFIG.width, CONFIG.height);

        this.getChildren().add(this.body);
    }

    protected void formatImage(double width, double height) {
        this.body.setFitWidth(width);
        this.body.setFitHeight(height);

        this.body.setSmooth(true);
        this.body.setCache(true);
    }

    public void resizeHeight(double height) {
        this.body.setFitHeight(height);
    }

    public void resizeWidth(double width) {
        this.body.setFitWidth(width);
    }

}
