package Views.Components;

import Controllers.SceneManager;
import Controllers.Scenes.GameScene;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class MenuCpnt extends TilePane {
    public MenuCpnt() {
        super();

        this.setMinSize(SceneManager.getCurWidth(), SceneManager.getCurHeight());

        this.setOrientation(Orientation.VERTICAL);

        // Position inside tiole
        this.setAlignment(Pos.CENTER);
        this.setTileAlignment(Pos.CENTER);

        // Space between tiles
        this.setVgap(150);

        // Buttons
        Button button = new ButtonCpnt("Jouer");
        Button button2 = new ButtonCpnt("Jouer2");
        Button button3 = new ButtonCpnt("Jouer3");
        button.setOnAction(event -> SceneManager.setScene(new GameScene()));

        this.getChildren().addAll(button, button2, button3);
    }
}
