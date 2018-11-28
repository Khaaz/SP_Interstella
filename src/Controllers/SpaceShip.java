package Controllers;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class SpaceShip extends Polygon {
    private double speed;
    public boolean moveRight = false;
    public boolean moveUp = false;
    public boolean moveDown = false;
    public boolean moveLeft = false;
    
    public SpaceShip(double x, double y, double speed) {
        super(new double[] {
            x/2, y*82/100,
            x*47/100, y*95/100,
            x*53/100, y*95/100
        });
        this.setFill(Color.WHITE);
        this.speed = speed;
    }
    
    public double getSpeed() {
        return this.speed;
    }
}
