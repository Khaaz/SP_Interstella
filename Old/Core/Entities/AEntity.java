package old.Core.Entities;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AEntity extends Parent {

    public ImageView body;
    private Image skin;

    private int life;
    private int damages;

    public AEntity(int life, int damages, String skinPath) {
        super();
        this.life = life;
        this.damages = damages;
        this.createBody(skinPath);
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
