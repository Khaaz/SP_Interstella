package Core.Class.Entities;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AEntity extends Parent {

    public ImageView body;
    private Image skin;

    private double life;
    private double damages;
    private double speed;

    public AEntity(String skinPath, double life, double damages, double speed) {
        super();
        this.life = life;
        this.damages = damages;
        this.speed = speed;
        this.createBody(skinPath);
    }

    public double getLife() {
        return life;
    }

    public double getDamages() {
        return damages;
    }

    public double getSpeed() {
        return speed;
    }

    protected void formatImage(double width, double height) {
        this.body.setFitWidth(width);
        this.body.setFitHeight(height);

        this.body.setPreserveRatio(true);
        this.body.setSmooth(true);
        this.body.setCache(true);
    }

    private void createBody(String skin) {
        this.skin = new Image(skin);
        this.body = new ImageView(this.skin);
        this.formatImage(150, 150);
        this.getChildren().add(this.body);
    }

    public void setSkin(String skin) {
        this.skin = new Image(skin);
        this.body.setImage(this.skin);
    }
}
