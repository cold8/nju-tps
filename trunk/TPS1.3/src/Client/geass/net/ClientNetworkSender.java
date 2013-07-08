/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.geass.net;

import static Client.geass.clientController.ClientController.hasUser;
import static Client.geass.clientController.ClientController.start;
import static Client.geass.clientController.ClientController.userName;
import Client.geass.clientController.TravellerClient;
import Shared.geass.message.request.ConnectRequest;
import java.io.IOException;

/**
 *
 * @author tin
 */
public class ClientNetworkSender implements Runnable {

    ClientMessageSender signalSender;

    public ClientNetworkSender(ClientMessageSender signalSender) {
        this.signalSender = signalSender;
    }

    @Override
    public void run() {
        while (start) {
            try {
                if (hasUser) {
                    //System.out.println("hello");
                    signalSender.sendRequest(new ConnectRequest(userName));
                    Thread.sleep(1000);
                }
            } catch (IOException e) {
                System.out.println("网络中断");
                start = false;
                if (TravellerClient.getInstance().isTravellerStill()) {
                    //GUIController.getInstance().reConnect(ClientController.this);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}