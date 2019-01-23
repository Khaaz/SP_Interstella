package models;

import core.objects.Datasave;
import core.utility.SqliteConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatasaveModel {

    private Connection connection;
    private Datasave DS;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public DatasaveModel() {
        connection = SqliteConnection.Connector();
        String query ="SELECT * FROM TDATASAVE;";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                this.DS = new Datasave(resultSet.getString(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getInt(6));
            }
            preparedStatement.close();
            resultSet.close();
        }catch (Exception e) {
            e.printStackTrace();
        }


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

    public Datasave getDS() {
        return this.DS;
    }

    private void updateDB(){
        String query ="UPDATE TDATASAVE SET SKIN =?, MONEY =?, LIFE =?, DAMAGE =?, BULLETSPEED =?, FIRERATE =?;";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,DS.getSkin());
            preparedStatement.setInt(2,DS.getMoney());
            preparedStatement.setInt(3,DS.getLife());
            preparedStatement.setInt(4,DS.getDamage());
            preparedStatement.setInt(5,DS.getBulletspeed());
            preparedStatement.setInt(6,DS.getFirerate());
            preparedStatement.execute();
            System.out.println("UPDATE CORRECTEMENT EFFECTUE");
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void upgradeLife(){
        if (DS.getMoney()>=1000){
            DS.setMoney(DS.getMoney()-1000);
            DS.setLife(DS.getLife()+20);
            updateDB();
        }
    }
    public void upgradeDamages(){
        if (DS.getMoney()>=1000){
            DS.setMoney(DS.getMoney()-1000);
            DS.setDamage(DS.getDamage()+10);
            updateDB();
        }
    }
    public void upgradeBulletspeed(){
        if (DS.getMoney()>=1000){
            DS.setMoney(DS.getMoney()-1000);
            DS.setBulletspeed(DS.getBulletspeed()+1);
            updateDB();
        }
    }
    public void upgradeFirerate(){
        if(DS.getFirerate()>1) {
            if (DS.getMoney() >= 1000) {
                DS.setMoney(DS.getMoney() - 1000);
                DS.setFirerate(DS.getFirerate() - 1);
                updateDB();
            }
        }
    }

    public void addMoney(int money){
        DS.setMoney(DS.getMoney()+money);
        updateDB();
    }


}
