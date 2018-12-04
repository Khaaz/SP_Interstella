/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SpaceShipV2 extends Parent {
    
    private int life;
    public ImageView body;
    private Image skin;
    
    public SpaceShipV2() {
        this.life = 10;
        
        this.skin = new Image("file:assets/Shep/Shep.png");
        this.body = new ImageView(this.skin);
        
        this.body.setFitWidth(100);
        this.body.setFitHeight(100);
        this.body.setPreserveRatio(true);
        this.body.setSmooth(true);
        this.body.setCache(true);
        
        this.getChildren().add(this.body);
    }
    
    private void setSkin(Image i) {
        this.skin = i;
        this.body.setImage(this.skin);
    }
    
    public void changeSkin(String skin) {
        if (skin == "v1") {
            this.setSkin(new Image("file:assets/Shep/spaceship.png"));
        } else {
            this.setSkin(new Image("file:assets/Shep/Shep.png"));
        }
        
    }
}
