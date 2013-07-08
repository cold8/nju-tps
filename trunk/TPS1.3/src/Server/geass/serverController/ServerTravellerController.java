package Server.geass.serverController;

/**
 * User: Kite
 * Date: 13-6-1
 */
public class ServerTravellerController implements ServerTravellerControllerInterface{

    private static ServerTravellerController instance;


    static public ServerTravellerController getInstance() {
        if(instance == null)
            instance = new ServerTravellerController();
        return instance;
    }




}
