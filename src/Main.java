import Controllers.Scenes.AScene;
import Controllers.Scenes.GameScene;
import Controllers.Scenes.MenuScene;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import Controllers.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        AScene sceneMenu = new MenuScene();

        SceneManager.setup(primaryStage, sceneMenu);

        primaryStage.setTitle("Interstella 5555");
        primaryStage.show();

    }

    /*@Override
    public void start2(Stage primaryStage) {
        double height = 800;
        double width = 1000;
        double speed = 1;
        SpaceShip s = new SpaceShip(width, height, speed);
        SpaceShipV2 s2 = new SpaceShipV2();
        //GameBG d2 = new GameBG(width, height, "0d0852");

        Group root = new Group();
        Scene scene = new Scene(root, width, height);
        Decor d = new Decor(scene.getWidth(), scene.getHeight(), "0d0852");
        scene.setCursor(Cursor.NONE);

        //root.getChildren().add(d2);
        root.getChildren().add(d);
        //root.getChildren().add(s);
        root.getChildren().add(s2);

        //primaryStage.setTitle("Interstella 5555");

        primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
            d.setWidth((double)newVal);
        });

        primaryStage.heightProperty().addListener((obs, oldVal, newVal) -> {
            d.setHeight((double)newVal);
        });

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

        scene.setOnMouseMoved(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                s2.body.setX(event.getSceneX() - (s2.body.getFitWidth()/2));
                s2.body.setY(event.getSceneY() - (s2.body.getFitHeight()/2));
            }
        });

        scene.setOnMouseDragged(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                s2.body.setX(event.getSceneX() - (s2.body.getFitWidth()/2));
                s2.body.setY(event.getSceneY() - (s2.body.getFitHeight()/2));
            }
        });

        scene.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                root.getChildren().add(
                        new Bullet(event.getSceneX(),
                                s2.body.getY())
                );
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
    }*/

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}