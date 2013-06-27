package Server.geass.serverController;

/**
 * User: Kite
 * Date: 13-6-1
 */
public class TravellerController {

    private static TravellerController instance;


    static public TravellerController getInstance() {
        if(instance == null)
            instance = new TravellerController();
        return instance;
    }




}
