package Views.Components;

import Controllers.SceneManager;
import Controllers.Scenes.GameScene;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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

        // Position inside tile
        this.setAlignment(Pos.CENTER);
        //this.setTileAlignment(Pos.CENTER);

        // Space between tiles
        this.setVgap(50);

        Label titreMenu = new LabelCpnt("Interstella 5555 : The Game");


        // Buttons
        Button button = new ButtonCpnt("JOUER");
        Button button2 = new ButtonCpnt("Scores");
        Button button3 = new ButtonCpnt("Quitter");

        button.setOnAction(event -> SceneManager.setScene(new GameScene()));
        button3.setOnAction(event -> System.exit(0));

        this.getChildren().addAll(titreMenu, button, button2, button3);
    }
}
