package controllers;

import constants.SCENES;
import core.events.EventCollection;
import core.events.SceneEvent;
import core.objects.Score;
import javafx.event.Event;
import models.GameOverModel;
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
        int nbPoints = GameOverModel.getNbPoints();
        SimpleStringProperty nbpp = new SimpleStringProperty(String.valueOf(nbPoints));

        tooLong.setVisible(false);

        menu.setOnAction(e -> {
            Event eventGame = new SceneEvent(EventCollection.SCENE_CHANGE, SCENES.MENUSCENE);
            menu.fireEvent(eventGame);
        });

        scoreSaving.setOnAction(e -> {
            if(playerName.getText().length()< 3 || playerName.getText().length()> 20){
                tooLong.setVisible(true);
            }
            else{
                Score s = new Score(playerName.getText(),GameOverModel.getNbPoints());
                GameOverModel.saveScore(s);
                Event eventGame = new SceneEvent(EventCollection.SCENE_CHANGE, SCENES.MENUSCENE);
                menu.fireEvent(eventGame);
            }

        });
        nbPointsScored.textProperty().bind(nbpp);


    }

    @Override
    public void setResetGameManager(Supplier<Boolean> resetGameManager) {
        this.resetGameManager = resetGameManager;
    }

    @Override
    public void refresh() {
        //
    }
}
