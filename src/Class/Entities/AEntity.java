package Class.Entities;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AEntity extends Parent {

    private ImageView body;
    private Image skin;

    private int life;
    private int damages;

    public AEntity(int life, int damages) {
        super();
        this.life = life;
        this.damages = damages;
    }

    private void formatImage(double width, double height) {
        this.body.setFitWidth(width);
        this.body.setFitHeight(height);

        this.body.setPreserveRatio(true);
        this.body.setSmooth(true);
        this.body.setCache(true);
    }

    private void setSkin(Image i) {
        this.skin = i;
        this.body.setImage(this.skin);
    }

    public void changeSkin(String skin) {
        if (skin.equals("v1")) {
            this.setSkin(new Image("file:assets/SpaceShip/spaceship.png"));
        } else {
            this.setSkin(new Image("file:assets/SpaceShip/spaceship2.png"));
        }

    }
}
