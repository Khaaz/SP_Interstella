package Controllers;
import Core.Class.Score;
import Models.ScoresModel;
import Views.Components.ButtonCpnt;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ScoresController implements Initializable {

    Score premier = ScoresModel.getScores();

    @FXML
    ButtonCpnt menu;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        menu.setOnAction(e -> System.out.println("menu!"));

    }
}
