package Server.geass.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Shared.geass.dataPOJO.City;
import Shared.geass.dataPOJO.Plan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;

public class DBcity {

    Connection connection = null;

    /**
     * map模块查询
     *
     * @param cityname
     * @return
     */
    public City mapSearch(String cityname) {
        connection = DBConnection.getDBConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        City city = null;
        try {
            statement = connection.createStatement();
            String query4 = "select * from city where cityname = '" + cityname + "'";
            resultSet = statement.executeQuery(query4);
            if (resultSet.next()) {
                city = new City(resultSet.getString("cityid"), resultSet.getString("cityname"),
                        resultSet.getString("province"), resultSet.getString("country"),
                        resultSet.getString("description"), resultSet.getString("bestseason"),
                        resultSet.getString("picturehref"), resultSet.getString("longtitude"),
                        resultSet.getString("latitude"));
                System.out.println("查询了城市:" + city.getCityname());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                    if (statement != null) {
                        statement.close();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBConnection.freeDBConnection(connection);
        }
        return city;
    }

    /**
     * 根据季节名模糊搜索
     *
     * @param bestseason
     * @return
     */
    public ArrayList<City> searchCityBySeason(String bestseason) {
        ArrayList<City> cities = new ArrayList<City>();
        connection = DBConnection.getDBConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        City city = null;
        try {
            statement = connection.createStatement();
            String query4 = "select * from city where bestseason like '%" + bestseason + "%'";
            resultSet = statement.executeQuery(query4);
            while (resultSet.next()) {
                city = new City(resultSet.getString("cityid"), resultSet.getString("cityname"),
                        resultSet.getString("province"), resultSet.getString("country"),
                        resultSet.getString("description"), resultSet.getString("bestseason"),
                        resultSet.getString("picturehref"), resultSet.getString("longtitude"),
                        resultSet.getString("latitude"));
                cities.add(city);

            }
            System.out.println("查询了最佳旅游时间为‘" + bestseason + "’的城市数目:" + cities.size());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                    if (statement != null) {
                        statement.close();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBConnection.freeDBConnection(connection);
        }
        return cities;
    }

    /**
     * 根据城市名模糊搜索
     *
     * @param cityname
     * @return
     */
    public ArrayList<City> searchCityByName(String cityname) {
        ArrayList<City> cities = new ArrayList<City>();
        connection = DBConnection.getDBConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        City city = null;
        try {
            statement = connection.createStatement();
            String query4 = "select * from city where cityname like '%" + cityname + "%'";
            resultSet = statement.executeQuery(query4);
            while (resultSet.next()) {
                city = new City(resultSet.getString("cityid"), resultSet.getString("cityname"),
                        resultSet.getString("province"), resultSet.getString("country"),
                        resultSet.getString("description"), resultSet.getString("bestseason"),
                        resultSet.getString("picturehref"), resultSet.getString("longtitude"),
                        resultSet.getString("latitude"));
                cities.add(city);

            }
            System.out.println("查询了和‘" + cityname + "’有关的城市:" + city.getCityname());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                    if (statement != null) {
                        statement.close();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBConnection.freeDBConnection(connection);
        }
        return cities;
    }

    /**
     * 根据时间搜索计划,严格按照在这个时间段内，没有任何时间的交叉
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<Plan> searchPlanByTwoDate(Date beginDate, Date endDate) {
        ArrayList<Plan> plans = new ArrayList<Plan>();
        connection = DBConnection.getDBConnection();
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            String sql = "select * from plan where startdate >= ? and enddate <= ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setDate(2, new java.sql.Date(endDate.getTime()));
            pstmt.setDate(1, new java.sql.Date(beginDate.getTime()));
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                plans.add(new Plan(resultSet.getInt("planid"), resultSet.getString("plantitle"), resultSet.getString("username"), resultSet.getDate("startdate"), resultSet.getDate("enddate")));
            }
            System.out.println("执行：" + sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return plans;
    }

    public ArrayList<Plan> searchPlanByCityDate(String cityName, Date indate) {
        // TODO Auto-generated method stub
        //这里的indate 是 当天
        ArrayList<Plan> plans = new ArrayList<Plan>();
        connection = DBConnection.getDBConnection();
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            String sql = "select plan.planid, plan.plantitle,plan.username,plan.startdate,plan.enddate from plan"
                     + " join phase on phase.planid = plan.planid and phase.date = ? and phase.cityname like ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setDate(1, new java.sql.Date(indate.getTime()));
            pstmt.setString(2, "%"+cityName+"%");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("planid"));
                plans.add(new Plan(resultSet.getInt("planid"), resultSet.getString("plantitle"), resultSet.getString("username"), resultSet.getDate("startdate"), resultSet.getDate("enddate")));
            }
            System.out.println("执行：" + sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return plans;
    }
}
