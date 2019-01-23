package models;

import core.objects.Score;
import core.utility.SqliteConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ScoresModel {

    private static double currentScore = 0;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ScoresModel(){
        connection = SqliteConnection.Connector();
        if (connection == null) {
            System.out.println("DB CONNECTION ERROR");
            System.exit(-1);
        }

    }
    public boolean isDBConnected(){
        try {
            return !connection.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Score> getAllScoresDecroissant() {
        ArrayList<Score> allScores = new ArrayList<>();
        String query ="SELECT * FROM TSCORES ORDER BY NBPOINTS DESC;";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Score s = new Score(resultSet.getString(1),resultSet.getInt(2));
                allScores.add(s);
            }
            preparedStatement.close();
            resultSet.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

        return allScores;
    }

    public ArrayList<Score> getAllScoresCroissant() {
        ArrayList<Score> allScores = new ArrayList<>();
        String query ="SELECT * FROM TSCORES ORDER BY NBPOINTS;";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Score s = new Score(resultSet.getString(1),resultSet.getInt(2));
                allScores.add(s);
            }
            preparedStatement.close();
            resultSet.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

        return allScores;
    }

    public void saveScore(Score s) {
        String query ="INSERT INTO TSCORES VALUES (?,?);";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,s.getPlayername());
            preparedStatement.setInt(2,Integer.valueOf(s.getNbPoints()));
            preparedStatement.execute();
            System.out.println("INSERT DU SCORE CORRECTEMENT EFFECTUE");
            preparedStatement.close();
            resultSet.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setCurrentScore(double score) {
        ScoresModel.currentScore = score;
    }

    public static double getCurrentScore() {
        return ScoresModel.currentScore;
    }
}
