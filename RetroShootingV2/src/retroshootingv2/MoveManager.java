/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retroshootingv2;

import javafx.scene.Scene;
import javafx.scene.shape.Shape;

/**
 *
 * @author larossi
 */
public class MoveManager {
    public static void moveRight(Shape object, Scene s) {
        double speed = ((SpaceShip)object).getSpeed();
        double cur = object.getTranslateX();
        if (cur == s.getWidth()) {
            return;
        }
        if (cur + speed > s.getWidth()) {
            object.setTranslateX(s.getWidth());
            return;
        }
        object.setTranslateX(cur + speed);
    }
    public static void moveLeft(Shape object, Scene s) {
        double speed = ((SpaceShip)object).getSpeed();
        double cur = object.getTranslateX();
        if (cur == 0) {
            return;
        }
        if (cur - speed < 0) {
            object.setTranslateX(0);
            return;
        }
        object.setTranslateX(cur - speed);
    }
    public static void moveUp(Shape object, Scene s) {
        double speed = ((SpaceShip)object).getSpeed();
        double cur = object.getTranslateY();
        if (cur == 0) {
            return;
        }
        if (cur - speed < 0) {
            object.setTranslateY(0);
            return;
        }
        object.setTranslateY(cur - speed);
    }
    public static void moveDown(Shape object, Scene s) {
        double speed = ((SpaceShip)object).getSpeed();
        double cur = object.getTranslateY();
        if (cur == s.getHeight()) {
            return;
        }
        if (cur + speed > s.getHeight()) {
            object.setTranslateY(s.getHeight());
            return;
        }
        object.setTranslateY(cur + speed);
    }
    
}
