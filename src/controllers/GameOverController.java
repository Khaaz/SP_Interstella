package controllers;

import constants.SCENES;
import core.events.EventCollection;
import core.events.SceneEvent;
import core.objects.Score;
import javafx.event.Event;
//import models.GameOverModel;
import models.ScoresModel;
import views.components.ButtonCpnt;
import views.components.LabelCpnt;
import views.components.TextFieldCpnt;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class GameOverController extends AController implements Initializable, IResetManager {

    private Supplier<Boolean> resetGameManager;

    @FXML
    LabelCpnt nbPointsScored;
    @FXML
    TextFieldCpnt playerName;
    @FXML
    ButtonCpnt scoreSaving;
    @FXML
    LabelCpnt tooLong;
    @FXML
    ButtonCpnt menu;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.showScore();

        tooLong.setVisible(false);

        menu.setOnAction(e -> {
            Event eventGame = new SceneEvent(EventCollection.SCENE_CHANGE, SCENES.MENUSCENE);
            menu.fireEvent(eventGame);
            this.resetGameManager.get();
        });

        scoreSaving.setOnAction(e -> {
            if (playerName.getText().length() < 3 || playerName.getText().length() > 20){
                tooLong.setVisible(true);
            } else {
                int templatescore = 1000;
                Score s = new Score(playerName.getText(), templatescore);
                ScoresModel.saveScore(s);

                Event eventGame = new SceneEvent(EventCollection.SCENE_CHANGE, SCENES.MENUSCENE);
                scoreSaving.fireEvent(eventGame);
                this.resetGameManager.get();
            }

        });
    }

    private void showScore() {
        double nbPoints = Math.round(ScoresModel.getCurrentScore());
        SimpleStringProperty nbpp = new SimpleStringProperty(String.valueOf(nbPoints));
        nbPointsScored.textProperty().bind(nbpp);
    }

    @Override
    public void setResetGameManager(Supplier<Boolean> resetGameManager) {
        this.resetGameManager = resetGameManager;
    }

    @Override
    public void refresh() {
        this.showScore();
    }
}

