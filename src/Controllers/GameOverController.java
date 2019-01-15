package Controllers;

import Models.GameOverModel;
import Views.Components.LabelCpnt;
import Views.Components.LabelCpnt;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class GameOverController implements Initializable {
    @FXML
    LabelCpnt nbPointsScored;

    String nbp;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int nbPoints = GameOverModel.getNbPoints();
        this.nbp = resources.getString(String.valueOf(nbPoints));
        //nbPointsScored.textProperty().bind(nbp);
    }
}
