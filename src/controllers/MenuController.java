package controllers;

import constants.SCENES;
import core.events.EventCollection;
import core.events.SceneEvent;
import javafx.event.Event;
import views.components.ButtonCpnt;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController extends AController implements Initializable {


    @FXML
    ButtonCpnt play;
    @FXML
    ButtonCpnt hangar;
    @FXML
    ButtonCpnt scores;
    @FXML
    ButtonCpnt credits;
    @FXML
    ButtonCpnt exit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        play.setOnAction(e -> {
            Event eventGame = new SceneEvent(EventCollection.SCENE_CHANGE, SCENES.GAMESCENE);
            play.fireEvent(eventGame);
        });
        hangar.setOnAction(e -> {
            Event eventGame = new SceneEvent(EventCollection.SCENE_CHANGE, SCENES.HANGARSCENE);
            play.fireEvent(eventGame);
        });
        scores.setOnAction(e -> {
            Event eventGame = new SceneEvent(EventCollection.SCENE_CHANGE, SCENES.SCORESCENE);
            scores.fireEvent(eventGame);
        });
        credits.setOnAction(e -> {
            Event eventGame = new SceneEvent(EventCollection.SCENE_CHANGE, SCENES.CREDITSCENE);
            credits.fireEvent(eventGame);
        });
        exit.setOnAction(e -> {
            Event eventGame = new SceneEvent(EventCollection.SCENE_CHANGE, SCENES.EXIT);
            exit.fireEvent(eventGame);
        });

    }

    @Override
    public void refresh() {
        //
    }

}
