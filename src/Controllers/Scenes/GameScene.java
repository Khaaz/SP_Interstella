package Controllers.Scenes;

import Views.Roots.GameRoot;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;

public class GameScene extends AScene {
    public GameScene() {
        super(new GameRoot());

        this.setCursor(Cursor.NONE);
        Parent root = this.getRoot();
        /*this.setOnMouseMoved(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                s2.body.setX(event.getSceneX() - (s2.body.getFitWidth()/2));
                s2.body.setY(event.getSceneY() - (s2.body.getFitHeight()/2));
            }
        });

        this.setOnMouseDragged(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                s2.body.setX(event.getSceneX() - (s2.body.getFitWidth()/2));
                s2.body.setY(event.getSceneY() - (s2.body.getFitHeight()/2));
            }
        });

        this.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                root.getChildren().add(
                        new Bullet(event.getSceneX(),
                                s2.body.getY())
                );
            }
        });*/
    }
}
