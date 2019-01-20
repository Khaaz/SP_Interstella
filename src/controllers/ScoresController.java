package controllers;
import constants.SCENES;
import core.events.EventCollection;
import core.events.SceneEvent;
import core.objects.Score;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.scene.control.ListView;
import models.ScoresModel;
import views.components.ButtonCpnt;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ScoresController extends AController implements Initializable {

    ObservableList<String> listeScores = FXCollections.observableArrayList();



    @FXML
    ButtonCpnt menu;
    @FXML
    ListView<String> bestScores;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        menu.setOnAction(e -> {
            Event eventGame = new SceneEvent(EventCollection.SCENE_CHANGE, SCENES.MENUSCENE);
            menu.fireEvent(eventGame);
        });

        ArrayList<Score> allScores= ScoresModel.getAllScores();

        for (Score s :allScores) {
            String jackie = s.getNbPoints();
            jackie = jackie +"\t\t" + s.getPlayername();
            listeScores.add(jackie);
        }

        bestScores.setItems(listeScores);


    }

    @Override
    public void refresh() {
        //
    }
}
