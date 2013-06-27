package Client.geass.test;

import Client.geass.clientController.CityClient;
import Client.geass.net.ClientMessageSender;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * User: Kite Date: 13-6-2
 */
public class test {

    public static void main(String args[]) {
        ClientMessageSender infoSender = new ClientMessageSender();
        infoSender.start("127.0.0.1", 8887);
        CityClient cityclient = new CityClient();
        cityclient.setInfoSender(infoSender);
        try {
            cityclient.searchCityByName("曼谷");
            cityclient.searchCityBySeason("冬");
            cityclient.searchPlanByCityDate("曼谷",new Date());
            cityclient.searchPlanByTwoDate(new Date(),new Date());
        } catch (IOException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    //        ClientUserController cuc = new ClientUserController();
    //        try {
    //            //int result = cuc.login("c","c");
    //            LoginRequest loginRequest = new LoginRequest("c", "c");
    //            System.out.println("uc.sendPassword  " + loginRequest.name + "  " + loginRequest.password);
    //
    //            Object ob = infoSender.sendRequest(loginRequest);
    //            StatusReponse statusReponse = (StatusReponse) ob;
    //            //StatusReponse statusReponse = (StatusReponse)loginRequest.invoke();
    //            System.out.println("status" + statusReponse.getStatus());
    //        } catch (IOException e) {
    //        }
    //        }
        
    }
}
