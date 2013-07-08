package Server.geass.serverController;

import java.util.ArrayList;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.dataPOJO.User;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-4-7
 * Time: 下午8:53
 * To change this template use File | Settings | File Templates.
 */
public class ServerUserController implements ServerUserControllerInterface {

    private static ServerUserController instance;

    private DatabaseController databaseController = null;
    private ArrayList<String> userList = new ArrayList<String>();

    public ServerUserController(){
        databaseController = DatabaseController.getInstance();
    }

    public static ServerUserController getInstance(){
         if(instance == null)
             instance = new ServerUserController();
         return instance;
    }
    @Override
    public boolean userNameValid(String name) {
        User user  = databaseController.getUserInfo(name) ;
        if(user ==null){
            return true;
        }
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean checkPassword(String name, String password) {
        User user  = databaseController.getUserInfo(name) ;
        if(user!=null){
            if(user.getPassword().equals(password))
                return true;
        }
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public User getInfo(String name) {
        User user = null;
        user = databaseController.getUserInfo(name);
        userList.add(name);
        return user;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean submitUserInfo(User user) {
        if(userNameValid(user.getName())){
            return databaseController.submitUserInfo(user);
        }
        return databaseController.modifyUserInfo(user);
    }

    public void addToNameList(String name){
        userList.add(name);
    }
    
    public void deleteFromNameList(String name){
    	
    	userList.remove(name);
    }

    public void userLogout(String name){
    	
    	userList.remove(name);
    }
    
    public  boolean updateUserInfo(User user){

        if(userNameValid(user.getName()))
            return databaseController.submitUserInfo(user);
        return databaseController.modifyUserInfo(user);
    }

    @Override
    public boolean verifyRepeatlogin(String name) {
        System.out.print("userlist: ");
        for(String user:userList){
            System.out.print(" "+user);
        }
        System.out.println();
        for(String user:userList){
            if(user.equals(name))
                return true;
        }
        return false;
    }
}
