package controllers;

import views.components.ButtonCpnt;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @FXML
    ButtonCpnt play;
    @FXML
    ButtonCpnt scores;
    @FXML
    ButtonCpnt credits;
    @FXML
    ButtonCpnt quitter;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        play.setOnAction(e -> System.out.println("play!"));
        scores.setOnAction(e -> System.out.println("scores!"));
        credits.setOnAction(e -> System.out.println("credits!"));
        quitter.setOnAction(e -> System.out.println("quitter!"));

    }

}
