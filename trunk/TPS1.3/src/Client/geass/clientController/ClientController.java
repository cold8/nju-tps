package Client.geass.clientController;

import Client.geass.gui.loginGUI.LoginJFrame;
import Client.geass.gui.guiController.GUIController;
import Client.geass.net.ClientFTPNet;
import Client.geass.net.ClientMessageSender;
import Shared.geass.file.Config;
import Shared.geass.message.request.ConnectRequest;

import javax.swing.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-5-6
 * Time: 下午2:30
 * To change this template use File | Settings | File Templates.
 */
public class ClientController {


    static String ip;
    private int infoPort;
    private int signalPort;
    private ClientFTPNet clientFtp;
    private LoginJFrame loginFrame;

    ClientMessageSender infoSender;
    ClientMessageSender signalSender;

    static public boolean start;
    static public boolean hasUser;
    static public String userName;

    public ClientController(String ip, int infoPort, int signalPort) {
        this.ip = ip;
        this.infoPort = infoPort;
        this.signalPort = signalPort;
        loginFrame = new LoginJFrame();
        loginFrame.setVisible(true);
        intialize();
    }

    private void intialize(){
        System.out.println("clientmanager inni");

        infoSender = new ClientMessageSender();
        infoSender.start(ip,infoPort);
        signalSender = new ClientMessageSender();
        signalSender.start(ip, signalPort);
        start = true;
        this.start();
        UserClient.getInstance().setInfoSender(infoSender);
        TravellerClient.getInstance().setInfoSender(infoSender);
        PlanClient.getInstance().setInfoSender(infoSender);
        CityClient.getInstance().setInfoSender(infoSender);
    }

    public void start(){
        new Thread(new SignalSender(signalSender)).start();
    }

    class SignalSender implements Runnable{

        ClientMessageSender signalSender;

        public SignalSender(ClientMessageSender signalSender){
            this.signalSender = signalSender;
        }

        @Override
        public void run() {
            while(start){
                try {
                    if(hasUser){
						//System.out.println("hello");
                        signalSender.sendRequest(new ConnectRequest(userName));
                        Thread.sleep(1000);
                    }
                } catch (IOException e) {
                    System.out.println("网络中断");
                    start = false;
                    if(TravellerClient.getInstance().isTravellerStill()){
                        GUIController.getInstance().reConnect(ClientController.this);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String arges[]){
        try {
            UIManager.setLookAndFeel("org.jb2011.lnf.beautyeye.BeautyEyeLookAndFeelCross");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        ClientController clientController = new ClientController(Config.getIniKey("serverip"),Integer.parseInt(Config.getIniKey("serverport")),Integer.parseInt(Config.getIniKey("signalport")));
        System.out.println(Config.getIniKey("serverip")+"  "+Integer.parseInt(Config.getIniKey("serverport"))+"  "+Integer.parseInt(Config.getIniKey("signalport")));
    }

}
