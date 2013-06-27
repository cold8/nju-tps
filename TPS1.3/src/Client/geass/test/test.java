package Client.geass.test;

import Client.geass.gui.guiController.guiUserController.ClientUserController;
import Client.geass.net.ClientMessageSender;
import Shared.geass.message.request.user.LoginRequest;
import Shared.geass.message.response.StatusReponse;

import java.io.IOException;

/**
 * User: Kite
 * Date: 13-6-2
 */
public class test {

    public static void main(String args[]){
        ClientUserController cuc = new ClientUserController();
        ClientMessageSender infoSender = new ClientMessageSender();
        try {
            //int result = cuc.login("c","c");
            LoginRequest loginRequest = new LoginRequest("c","c");
            System.out.println("uc.sendPassword  "+loginRequest.name+"  "+loginRequest.password);
            infoSender.start("127.0.0.1",8887);
            Object ob = infoSender.sendRequest(loginRequest);
            StatusReponse statusReponse = (StatusReponse)ob;
            //StatusReponse statusReponse = (StatusReponse)loginRequest.invoke();
            System.out.println("status"+statusReponse.getStatus());
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }



}
