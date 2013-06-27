package Server.geass.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Shared.geass.dataPOJO.City;


public class CityDAO {

    Connection connection = null;
    
    public City mapSearch(String cityname){
        connection = DatabaseConnection.getDBConnection();
        Statement statement= null;
        ResultSet resultSet = null;
        City city = null;
        try{
            statement = connection.createStatement();
            String query4 = "select * from city where cityname = '"+cityname+"'";
            resultSet = statement.executeQuery(query4);
            if(resultSet.next()){
                city = new City(resultSet.getString("cityid"),cityname,
                		resultSet.getString("province"),resultSet.getString("country"),
                		resultSet.getString("description"),resultSet.getString("bestseason"),
                		resultSet.getString("picturehref"),resultSet.getString("longtitude"),
                		resultSet.getString("latitude"));
                System.out.println("查询了城市:"+city.getCityname());
            }
        }catch(SQLException e){
           e.printStackTrace();
        }finally {
            try{
                if(resultSet!=null){
                    resultSet.close();
                    if(statement!=null){
                        statement.close();
                    }
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            DatabaseConnection.freeDBConnection(connection);
        }
        return city;
    }

}