package Server.geass.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-4-7
 * Time: 下午3:53
 * To change this template use File | Settings | File Templates.
 */
public class DBConnectionPool {

    private String dbUsername ;
    private String dbPassword ;
    private String dbUrl;
    private String dbDriver ;

    private int maxcon;
    private int currentcon;

    private ArrayList<Connection> connections;

    public DBConnectionPool(String username, String password, String url, String driver, int maxcon) {
        this.dbUsername = username;
        this.dbPassword = password;
        this.dbUrl = url;
        this.dbDriver = driver;
        this.maxcon = maxcon;
        this.connections = new ArrayList<Connection>();

    }

    /*递归调用建立新连接*/
    public synchronized Connection getDBConnection(){

        Connection connection = null;

        if(connections.size()>0){
            connection = connections.get(0);
            connections.remove(0);
            try{
                if(connection.isClosed()){
                    connection = getDBConnection();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(maxcon==0||currentcon<maxcon){
            connection = newDBConnection();
        }
        if(connection!=null){
            currentcon++;
        }


        return connection;

    }


    public synchronized Connection getDBConnection(long timeout)  {

        long starttime  = System.currentTimeMillis();
        Connection connection = null;
        while((connection=getDBConnection())==null){
            try{
                wait(timeout);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            if(System.currentTimeMillis()-starttime >= timeout){
                return null;
            }
        }
        return connection;
    }

    public synchronized Connection newDBConnection(){
        Connection connection = null;
        try{
            if(this.dbUsername == null){
                try{
                    Class.forName(dbDriver);
                    connection = DriverManager.getConnection(this.dbUrl);
                }catch (ClassNotFoundException e){
                    e.printStackTrace();
                }
            }else{
                try{
                    Class.forName(dbDriver);
                    connection = DriverManager.getConnection(this.dbUrl,this.dbUsername,this.dbPassword);
                }catch (ClassNotFoundException e){
                    e.printStackTrace();
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
    /*释放连接*/
    public synchronized void freeDBConnection(Connection connection){
        if(connection != null){
            connections.add(connection);
            currentcon--;
            notifyAll();//重启wait所在函数
        }
    }

    public synchronized void release(){
        Iterator<Connection> iterator = connections.iterator();
        Connection connection = null;
        while(iterator.hasNext()){
            try{
                connection = iterator.next();
                connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        while (iterator.hasNext()){
            connections.remove(iterator.next()) ;
        }


    }
}
