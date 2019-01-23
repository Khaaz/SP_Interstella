package controllers;

import constants.SCENES;
import core.events.EventCollection;
import core.events.SceneEvent;
import core.objects.Datasave;
import core.objects.Score;
import javafx.event.Event;
//import models.GameOverModel;
import models.DatasaveModel;
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
    private ScoresModel ScoresModel = new ScoresModel();
    public DatasaveModel DataSaveModel = new DatasaveModel();

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
        if(ScoresModel.isDBConnected()){
            System.out.println("SCORE DATABASE CONNECTED");
        }
        else {
            System.out.println("SCORE DATABASE NOT CONNECTED");
        }
        if(DataSaveModel.isDBConnected()){
            System.out.println("DATABASE CONNECTED");
        }
        else {
            System.out.println("DATABASE NOT CONNECTED");
        }

        //System.out.println(Math.round(ScoresModel.getCurrentScore()*0.1));
        DataSaveModel.addMoney((int)Math.round((ScoresModel.getCurrentScore())*0.1));

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
                Score s = new Score(playerName.getText(), (int)Math.round(ScoresModel.getCurrentScore()));
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
        playerName.clear();
        this.showScore();
        tooLong.setVisible(false);
        System.out.println(Math.round(ScoresModel.getCurrentScore()));


    }
}

