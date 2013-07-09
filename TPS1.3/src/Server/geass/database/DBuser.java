package Server.geass.database;

import Shared.geass.dataPOJO.User;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * To change this template use File | Settings | File Templates.
 */
public class DBuser {

    Connection connection = null;

    
    /**
     * 添加用户
     * @param user
     * @return 
     */
    public boolean addUser(User user){
        connection = DBConnection.getDBConnection();
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try{
            String query1 = "select * from user where name = ?";
            pstmt = connection.prepareStatement(query1);
            pstmt.setString(1,user.getName());
            resultSet = pstmt.executeQuery();
            if(!resultSet.next()){
                String sql =  "insert into user (name,password,gender,phone,Email,address) values (?,?,?,?,?,?)";
                pstmt = connection.prepareStatement(sql);
                pstmt.setString(1,user.getName());
                pstmt.setString(2,user.getPassword());
                pstmt.setString(3,user.getGender());
                pstmt.setString(4,user.getPhone());
                pstmt.setString(5,user.getEmail());
                pstmt.setString(6,user.getAddress());
                pstmt.executeUpdate();
                System.out.println("执行："+sql);
            }else{
                System.out.println("用户名重复");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(resultSet!=null)
                    resultSet.close();
                if(pstmt!=null)
                    pstmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            DBConnection.freeDBConnection(connection);
        }

        return true;
    }

    
    /**
     * 
     * @param user
     * @return 
     */
    public boolean deleteUser(User user){
        connection = DBConnection.getDBConnection();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            String query2 ="delete from user where name='"+user.getName()+"'";
            stmt.executeUpdate(query2);
            System.out.println("执行："+ query2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try{
                if(stmt!=null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBConnection.freeDBConnection(connection);
        }
        return true;

    }

    /**
     * 修改用户信息
     * @param user
     * @return 
     */
    public boolean modifyUserInfo(User user){
        connection = DBConnection.getDBConnection() ;
        Statement stmt = null;
        try{
            stmt = connection.createStatement();
            String query3 = "Update User set password='"+user.getPassword()+"'"+",gender='"+user.getGender()+"'"+",phone='"+user.getPhone()+"'"+",Email='"+user.getEmail()+",address='"+user.getAddress()+"'";
            stmt.executeQuery(query3);
            System.out.println("执行了："+query3);
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            DBConnection.freeDBConnection(connection);
        }

        return true;
    }

    /**
     * 通过用户名获取用户信息
     * @param name
     * @return 
     */
    public User getUserByName(String name){

        connection = DBConnection.getDBConnection();
        Statement statement= null;
        ResultSet resultSet = null;
        User user = null;

        try{
            statement = connection.createStatement();
            String query4 = "select * from user where name = '"+name+"'";
            resultSet = statement.executeQuery(query4);
            if(resultSet.next()){
                user = new User(name,resultSet.getString("password"),resultSet.getString("gender"),resultSet.getString("phone"),resultSet.getString("Email"),resultSet.getString("address"));
                System.out.println("读取了:"+user.getName()+"的用户信息,密码为"+user.getPassword());
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
            DBConnection.freeDBConnection(connection);
        }
        return user;
    }

    
    /**
     * 获取所有的用户信息
     * @return 
     */
    public ArrayList<User> fetchAllUsers(){
         return  null;
    }

}
