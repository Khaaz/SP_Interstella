/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author larossi
 */
public class Bullet extends Parent {
    
    public ImageView body;
    private Image skin;
    
    // x = exactement moitie vaisseau
    // y = la ou on fait apparaitre bullet (avant du vaiseau)
    public Bullet(double x, double y) {
        
        this.skin = new Image("file:assets/bullet.png");
        this.body = new ImageView(this.skin);
        
        this.body.setFitWidth(20/3);
        this.body.setFitHeight(100/3);
        
        this.body.setPreserveRatio(true);
        this.body.setSmooth(true);
        this.body.setCache(true);
        
        this.body.setX(x - (this.body.getFitWidth()/2));
        this.body.setY(y - this.body.getFitHeight());
        this.getChildren().add(this.body);
    }
}
