package core.objects.entities;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AEntity extends Parent {

    public ImageView body;
    private Image skin;
    private double imageWidth;
    private double imageHeight;

    public AEntity(String skinPath,double imageWidth, double imageHeight) {
        super();
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.createBody(skinPath);
    }

    /**
     * Setup default Image format
     */
    protected void formatImage() {
        this.body.setFitWidth(this.imageWidth);
        this.body.setFitHeight(this.imageHeight);

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
        this.formatImage();

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
