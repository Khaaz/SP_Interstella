package Controllers;

import Models.PauseModel;
import Views.Components.ButtonCpnt;
import Views.Components.LabelCpnt;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class PauseController implements Initializable {
    @FXML
    LabelCpnt currPoints;
    @FXML
    ButtonCpnt resume;
    @FXML
    ButtonCpnt menu;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int nbPoints = PauseModel.getNbPoints();
        SimpleStringProperty nbpp = new SimpleStringProperty(String.valueOf(nbPoints));
        currPoints.textProperty().bind(nbpp);

        resume.setOnAction(e -> System.out.println("resume!"));
        menu.setOnAction(e -> System.out.println("menu!"));

    }
}

