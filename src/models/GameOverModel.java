package models;

import controllers.GameOverController;
import core.objects.Score;

public class GameOverModel {

    public static int getNbPoints(){
        int nbPoints = 12525;

        return (nbPoints);
    }

    public static void saveScore(Score s){
        //Ajout SQL

        System.out.println(s.getNbPoints());
        System.out.println(s.getPlayername());
    }

}
