package Client.geass.clientController;

import Client.geass.net.ClientMessageSender;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-5-16
 * Time: 下午4:06
 * To change this template use File | Settings | File Templates.
 */
public class TravellerClient {

    private static TravellerClient instance ;
    private boolean isTravellerStill;
    private ClientMessageSender infoSender;




    public static TravellerClient getInstance(){
        if(instance == null)
            instance = new TravellerClient()  ;
        return instance;
    }

    public void setInfoSender(ClientMessageSender infoSender){
        this.infoSender = infoSender;
    }

    public boolean isTravellerStill(){
        return isTravellerStill;
    }



}
