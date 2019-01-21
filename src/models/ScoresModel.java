package models;

import core.objects.Score;

import java.util.ArrayList;

public class ScoresModel {

    public static double currentScore;
    public static Score score;

    public static ArrayList<Score> getAllScores(){

        //Query SQL

        Score first = new Score("louis",1000);
        Score second = new Score("louison",999);
        Score third = new Score("maxime",998);
        Score fourth = new Score("dorian",997);
        Score fifth = new Score("neness",996);
        Score sixth = new Score("lison",995);
        Score seventh = new Score("leanne",994);

        ArrayList<Score> allScores = new ArrayList<Score>(){{
            add(first);
            add(second);
            add(third);
            add(fourth);
            add(fifth);
            add(sixth);
            add(seventh);
        }
        };
        return(allScores);
    }

    public static void saveScore(Score s) {

    }

    public static void currentScore(double s) {
        ScoresModel.currentScore = s;
    }
}
