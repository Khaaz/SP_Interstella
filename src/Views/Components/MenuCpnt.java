package Views.Components;

import Controllers.SceneManager;
import Controllers.Scenes.GameScene;
import Core.Events.SceneSensor;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class MenuCpnt extends TilePane implements IResizableElement {
    public MenuCpnt() {
        super();

        this.setMinSize(SceneManager.getCurWidth(), SceneManager.getCurHeight());

        this.setOrientation(Orientation.VERTICAL);

        // Position inside tile
        this.setAlignment(Pos.CENTER);
        //this.setTileAlignment(Pos.CENTER);

        // Space between tiles
        this.setVgap(50);


        // Buttons
        Button button = new ButtonCpnt("JOUER");
        Button button2 = new ButtonCpnt("Scores");
        Button button3 = new ButtonCpnt("Quitter");


        button.setOnAction(event -> SceneManager.setScene(new GameScene()));
        button2.setOnAction(event -> {
            System.out.println("ok");
            SceneSensor sensor = new SceneSensor();
            sensor.fireSceneChanged("wtf");
        });

        button3.setOnAction(event -> System.exit(0));

        this.getChildren().addAll(button, button2, button3);
    }

    @Override
    public void resizeElement() {

    }
}
