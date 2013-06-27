package Client.geass.gui.guiController.guiUserController;

import java.io.IOException;

import javax.swing.JOptionPane;

import Client.geass.clientController.ClientController;
import Client.geass.clientController.UserClient;
import Shared.geass.dataPOJO.User;

/**
 * User: Kite
 * Date: 13-5-1
 */
public class ClientUserController implements ClientUserControllerInterface{

    private UserClient userClient;
    private static User user;

    public ClientUserController(){
        System.out.println("clientusercontrooler  ini");
        userClient = UserClient.getInstance();
        user = new User();
    }

    public ClientUserController(UserClient userClient) {
        this.userClient = userClient;
        this.user = new User();
    }

    @Override
    public int login(String userName, String password) throws IOException  {
        int result = checkPassword(userName,password);
        if(result==2){
            user = getUserInfo(userName);
            if(user!=null){
                ClientController.hasUser = true;
                ClientController.userName = userName;
            }
        }
        return result;
    }

    @Override
    public String getUserName() {
        if(user!=null){
            return user.getName();
        }
        return null;
    }

    @Override
    public int checkPassword(String userName,String password) throws IOException {
        int success = 0;
        success = userClient.sendPassword(userName, password);
        return success;
    }


    @Override
    public User getUserInfo(String userName){
        User user = null;
        try {
            user = userClient.getUserInfo(userName);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "网络连接异常", "无法获取用户信息", JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void submitUserInfo(String userName,String password) throws IOException{
        user.setName(userName);
        user.setPassword(password);
        userClient.sendUserInfo(user);
    }

    @Override
    public boolean userNameValid(String userName) {
        try {
            return userClient.sendUserName(userName);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "网络连接异常", "无法获取用户信息",JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
        }
        return true;
    }
}
