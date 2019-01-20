package core.objects.sprites;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AEntity extends Parent {

    public ImageView body;
    private Image skin;

    public AEntity(String skinPath) {
        super();
        this.createBody(skinPath);
    }

    /**
     * Setup default Image format
     * @param width width
     * @param height height
     */
    protected void formatImage(double width, double height) {
        this.body.setFitWidth(width);
        this.body.setFitHeight(height);

        this.body.setPreserveRatio(true);
        this.body.setSmooth(true);
        this.body.setCache(true);
    }

    /**
     * Create the body (Image viewable in game)
     * @param skin path to skin
     */
    private void createBody(String skin) {
        this.skin = new Image(skin);
        this.body = new ImageView(this.skin);
        this.formatImage(150, 150);
        this.getChildren().add(this.body);
    }

    /**
     * SetSkin (can be dynamic)
     * @param skin path to skin
     */
    public void setSkin(String skin) {
        this.skin = new Image(skin);
        this.body.setImage(this.skin);
    }
}
