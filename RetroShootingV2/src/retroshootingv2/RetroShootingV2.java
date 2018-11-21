/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retroshootingv2;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 *
 * @author larossi
 */
public class RetroShootingV2 extends Application {

    public Boolean moveRight;
    
    @Override
    public void start(Stage primaryStage) {
        double height = 800;
        double width = 1000;
        double speed = 1;
        SpaceShip s = new SpaceShip(width, height, speed);
        
        Group root = new Group();
        
        Scene scene = new Scene(root, width, height);
        Decor d = new Decor(scene.getWidth(), scene.getHeight(), "0d0852");
        
        root.getChildren().add(d);
        root.getChildren().add(s);
        
        primaryStage.setTitle("LeRetroShootingDeLuisonEtLuisArmand");
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                switch(event.getCode()) {
                    case RIGHT:
                        s.moveRight = true;
                        break;
                    case LEFT:
                        s.moveLeft = true;
                        break;
                    case UP:
                        s.moveUp = true;
                        break;
                    case DOWN:
                        s.moveDown = true;
                        break;
                }
            }
        });
        
        scene.setOnKeyReleased(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                switch(event.getCode()) {
                    case RIGHT:
                        s.moveRight = false;
                        break;
                    case LEFT:
                        s.moveLeft = false;
                        break;
                    case UP:
                        s.moveUp = false;
                        break;
                    case DOWN:
                        s.moveDown = false;
                        break;
                }
            }
        });
        
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (s.moveDown) {
                    MoveManager.moveDown(s,scene);
                }
                else if (s.moveUp) {
                    MoveManager.moveUp(s,scene);
                }
                else if (s.moveRight) {
                    MoveManager.moveRight(s,scene);
                }
                else if (s.moveLeft) {
                    MoveManager.moveLeft(s,scene);
                }
            }
        }.start();
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
