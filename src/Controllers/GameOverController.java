package Controllers;

import Core.Class.Score;
import Core.Managers.SceneManager;
import Models.GameOverModel;
import Views.Components.ButtonCpnt;
import Views.Components.LabelCpnt;
import Views.Components.TextFieldCpnt;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class GameOverController implements Initializable {
    @FXML
    LabelCpnt nbPointsScored;
    @FXML
    TextFieldCpnt playerName;
    @FXML
    ButtonCpnt scoreSaving;
    @FXML
    ButtonCpnt menu;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int nbPoints = GameOverModel.getNbPoints();
        SimpleStringProperty nbpp = new SimpleStringProperty(String.valueOf(nbPoints));

        menu.setOnAction(e -> System.out.println("menu!"));
        scoreSaving.setOnAction(e -> GameOverModel.saveScore(new Score(playerName.getText(),nbPoints)));
        nbPointsScored.textProperty().bind(nbpp);


    }
}

