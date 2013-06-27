package Client.geass.net;

import Client.geass.clientController.TravellerClient;
import Client.geass.gui.guiController.GUIController;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.Response;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-5-12
 * Time: 下午3:50
 * To change this template use File | Settings | File Templates.
 */
public class ClientMessageSender {

    private int port;
    private String ip;

    public void start(String ip, int port) {
        this.port = port;
        this.ip = ip;
    }

    public Response sendRequest(Request request) throws IOException{

        Socket socket;
        long start ;
        long end ;
        socket = new Socket(ip,port);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(request);
        start =  Calendar.getInstance().getTimeInMillis();
        objectOutputStream.flush();
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        Object object;
        try {
            /**
             * 处理长时间没有收到对请求的回应的情况
             */
            if((object=objectInputStream.readObject())!=null){
                end = Calendar.getInstance().getTimeInMillis();
                int time = (int)(end-start)/1000;
                if(TravellerClient.getInstance().isTravellerStill()&&time>=2)
                    GUIController.getInstance().showStatus("您的网络状况不佳，延迟已达到" + time + "s");

                return (Response) object;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

       return null;
    }



}
