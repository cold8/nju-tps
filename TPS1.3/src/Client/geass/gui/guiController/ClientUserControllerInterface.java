package Client.geass.gui.guiController;

import java.io.IOException;

import Shared.geass.dataPOJO.User;

/**
 * User: Kite
 * Date: 13-5-1
 */
public interface ClientUserControllerInterface {

    public int login(String userName,String password) throws IOException;
    public String getUserName();
    public User getUserInfo(String userName);
    public int checkPassword(String userName,String password) throws IOException;
    public void submitUserInfo(String userName,String password)  throws IOException;
    public boolean userNameValid(String userName);

}
