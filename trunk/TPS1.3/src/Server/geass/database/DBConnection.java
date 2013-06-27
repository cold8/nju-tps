package Server.geass.database;

import java.sql.Connection;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-4-7
 * Time: 下午3:53
 * To change this template use File | Settings | File Templates.
 */
public class DBConnection {

    private static String user = "root";
    private static String password = "root";
    private static String url = "jdbc:mysql://127.0.0.1:3306/TPSDB";
    private static String driver = "com.mysql.jdbc.Driver";
    private static int maxcon = 20;
    private static DBConnectionPool pool = new DBConnectionPool(user,password,url,driver,maxcon);

    public static Connection getDBConnection(){
        return pool.getDBConnection(1000);
    }

    public static void freeDBConnection(Connection connection){
          pool.freeDBConnection(connection);
    }



}
