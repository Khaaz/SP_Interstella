package controllers;

import constants.SCENES;
import core.events.EventCollection;
import core.events.SceneEvent;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.Event;
import models.DatasaveModel;
import views.components.ButtonCpnt;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import views.components.LabelCpnt;

import java.net.URL;
import java.util.ResourceBundle;

public class HangarController extends AController implements Initializable{

    public DatasaveModel DataSaveModel = new DatasaveModel();

    @FXML
    ButtonCpnt life;
    @FXML
    LabelCpnt currlife;
    @FXML
    ButtonCpnt atk;
    @FXML
    LabelCpnt curratk;
    @FXML
    ButtonCpnt bulletspeed;
    @FXML
    LabelCpnt currbs;
    @FXML
    ButtonCpnt firerate;
    @FXML
    LabelCpnt currfr;
    @FXML
    ButtonCpnt ship;
    @FXML
    ButtonCpnt menu;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int health = DataSaveModel.getDS().getLife();
        SimpleStringProperty hp = new SimpleStringProperty("Current Health : " + health);
        int damages = DataSaveModel.getDS().getDamage();
        SimpleStringProperty dmg = new SimpleStringProperty("Current Damages : " + damages);
        int bls = DataSaveModel.getDS().getBulletspeed();
        SimpleStringProperty bs = new SimpleStringProperty("Current Bullet Speed : " + bls);
        int firer = DataSaveModel.getDS().getFirerate();
        SimpleStringProperty fr = new SimpleStringProperty("Current Firerate : " + firer);

        if(DataSaveModel.isDBConnected()){
            System.out.println("DATABASE CONNECTED");
        }
        else {
            System.out.println("DATABASE NOT CONNECTED");
        }

        life.setOnAction(e -> {
            DataSaveModel.upgradeLife();
            refresh();
        });

        atk.setOnAction(e -> {
            DataSaveModel.upgradeDamages();
            refresh();
        });

        bulletspeed.setOnAction(e -> {
            DataSaveModel.upgradeBulletspeed();
            refresh();
        });

        firerate.setOnAction(e -> {
            DataSaveModel.upgradeFirerate();
            refresh();
        });

        ship.setOnAction(e -> {
            //Change Skin
            //Decrease $
            System.out.println("ship changed, $withdrawn");
        });

        menu.setOnAction(e -> {
            Event eventGame = new SceneEvent(EventCollection.SCENE_CHANGE, SCENES.MENUSCENE);
            menu.fireEvent(eventGame);
        });

        currlife.textProperty().bind(hp);
        curratk.textProperty().bind(dmg);
        currbs.textProperty().bind(bs);
        currfr.textProperty().bind(fr);

    }

    @Override
    public void refresh() {
        int health = DataSaveModel.getDS().getLife();
        SimpleStringProperty hp = new SimpleStringProperty("Current Health : " + health);
        currlife.textProperty().bind(hp);

        int damages = DataSaveModel.getDS().getDamage();
        SimpleStringProperty dmg = new SimpleStringProperty("Current Damages : " + damages);
        curratk.textProperty().bind(dmg);

        int bls = DataSaveModel.getDS().getBulletspeed();
        SimpleStringProperty bs = new SimpleStringProperty("Current BulletSpeed : " + bls);
        currbs.textProperty().bind(bs);

        int firer = DataSaveModel.getDS().getFirerate();
        SimpleStringProperty fr = new SimpleStringProperty("Current Bullet Speed : " + firer);
        currfr.textProperty().bind(fr);

    }
}

