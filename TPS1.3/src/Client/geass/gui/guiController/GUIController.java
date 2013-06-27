package Client.geass.gui.guiController;

import Client.geass.clientController.ClientController;
import Client.geass.gui.travellerGUI.ReconnectJFrame;
import Client.geass.gui.travellerGUI.TravellerFrame;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-5-12
 * Time: 下午4:08
 * To change this template use File | Settings | File Templates.
 */
public class GUIController implements GUIControllerInterface {

    private static GUIController instance ;
    private static TravellerFrame travellerFrame;

    public GUIController() {

    }


    public static GUIController getInstance(){
        if(instance == null)
            instance = new GUIController()  ;
        return instance;
    }

    /**
     * 状态，包括延迟等
     * @param string
     */
    public void showStatus(String string){
        travellerFrame.setTitle(string);
    }

    @Override
    public void reConnect(ClientController clientController){
        ReconnectJFrame re=new ReconnectJFrame(travellerFrame,clientController);
        re.setVisible(true);
    }


}
