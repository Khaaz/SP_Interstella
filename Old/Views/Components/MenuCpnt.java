package old.Views.Components;

import old.Configuration.SCENES;
import old.Controllers.SceneManager;
import old.Core.Events.EventCollection;
import old.Core.Events.SceneEvent;
import javafx.event.Event;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;


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


        button.setOnAction(event -> {
            Event eventGame = new SceneEvent(EventCollection.SCENE_CHANGE, SCENES.GAMESCENE);
            this.fireEvent(eventGame);
        });

        button3.setOnAction(event -> {
            Event eventExit = new SceneEvent(EventCollection.SCENE_CHANGE, SCENES.EXIT);
            this.fireEvent(eventExit);
        });

        this.getChildren().addAll(titreMenu, button, button2, button3);
    }
}
