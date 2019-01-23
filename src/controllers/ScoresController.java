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

    private ObservableList<String> listScores = FXCollections.observableArrayList();
    private ScoresModel ScoresModel = new ScoresModel();

    private int Ranker =1; //Selecteur de classement (0 = Decroissant/ 1 = Croissant)

    @FXML
    ButtonCpnt menu;
    @FXML
    ButtonCpnt croissant;
    @FXML
    ButtonCpnt decroissant;
    @FXML
    ListView<String> bestScores;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if(ScoresModel.isDBConnected()){
            System.out.println("DATABASE CONNECTED");
        }
        else {
            System.out.println("DATABASE NOT CONNECTED");
        }

        updateScore();

        croissant.setOnAction(e->{
            Ranker=1;
            refresh();
        });

        decroissant.setOnAction(e->{
            Ranker=0;
            refresh();
        });

        menu.setOnAction(e -> {
            Event eventGame = new SceneEvent(EventCollection.SCENE_CHANGE, SCENES.MENUSCENE);
            menu.fireEvent(eventGame);
        });

    }

    @Override
    public void refresh() {
        updateScore();
    }

    private void updateScore() { //Remplit la "listScores" en fonction du "Ranker"
        listScores.clear();

        //System.out.println(listScores);
        ArrayList<Score> allScores = null;

        int classement=0;

        if(Ranker == 0) {
            allScores = ScoresModel.getAllScoresDecroissant();
            classement=1;

        }
        if(Ranker == 1) {
            allScores = ScoresModel.getAllScoresCroissant();
            classement=allScores.size();
        }


        for (Score s : allScores) {
            String currScore = String.valueOf(classement);
            currScore = currScore +"\t\t" + s.getPlayername();
            currScore = currScore +"\t\t" + s.getNbPoints();
            listScores.add(currScore);
            if (Ranker == 0){ classement++;}
            if (Ranker == 1){ classement--;}

        }

        this.bestScores.setItems(this.listScores);
    }
}
