package Client.geass.gui.travellerGUI;

import Client.geass.clientController.ClientController;
import Client.geass.gui.guiController.GUIControllerInterface;

import java.awt.*;

/**
 * User: Kite
 * Date: 13-6-1
 */
public class ReconnectJFrame extends javax.swing.JFrame{

    private TravellerFrame mainFrame;
    private GUIControllerInterface guicontroller;
    private ClientController clientController;


    public ReconnectJFrame(TravellerFrame mainFrame, ClientController clientController) throws HeadlessException {
        this.mainFrame = mainFrame;
        this.clientController = clientController;
    }
}
