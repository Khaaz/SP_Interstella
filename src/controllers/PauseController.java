package controllers;

import constants.SCENES;
import core.events.EventCollection;
import core.events.SceneEvent;
import javafx.event.Event;
import models.ScoresModel;
import views.components.ButtonCpnt;
import views.components.LabelCpnt;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class PauseController extends AController implements Initializable, IResetManager {

    private Supplier<Boolean> resetGameManager;

    @FXML
    LabelCpnt currPoints;
    @FXML
    ButtonCpnt resume;
    @FXML
    ButtonCpnt menu;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        double nbPoints = ScoresModel.currentScore;
        SimpleStringProperty nbpp = new SimpleStringProperty(String.valueOf(nbPoints));
        currPoints.textProperty().bind(nbpp);

        resume.setOnAction(e -> {
            Event eventGame = new SceneEvent(EventCollection.SCENE_CHANGE, SCENES.GAMESCENE);
            resume.fireEvent(eventGame);
        });

        menu.setOnAction(e -> {
            Event eventGame = new SceneEvent(EventCollection.SCENE_CHANGE, SCENES.MENUSCENE);
            menu.fireEvent(eventGame);
            this.resetGameManager.get();
        });

    }

    @Override
    public void setResetGameManager(Supplier<Boolean> resetGameManager) {
        this.resetGameManager = resetGameManager;
    }

    @Override
    public void refresh() {
        double nbPoints = ScoresModel.currentScore;
        SimpleStringProperty nbpp = new SimpleStringProperty(String.valueOf(nbPoints));
        currPoints.textProperty().bind(nbpp);
    }
}

