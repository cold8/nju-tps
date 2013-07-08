package Client.geass.net;

import Shared.geass.message.request.Request;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * User: Kite
 * Date: 13-6-2
 */
public abstract class ClientNotResponseNet implements ClientNet{

    private int port;
    private String ip;
    private Socket socket;
    private ClientSocketHandler cs;

    @Override
    public void start(String ip, int port) {
        // TODO Auto-generated method stub
        this.port = port;
        this.ip = ip;
        try {
            socket = new Socket(ip,port);
            cs = new ClientSocketHandler(socket,this);
            new Thread(cs).start();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void sendNon_returnCommand(Request request){
        try {
            ObjectOutputStream oo = new ObjectOutputStream(socket.getOutputStream());
            oo.writeObject(request);
            oo.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
           // System.out.println("UnidirectionBearer down");
            start(ip,port);
        }

    }

    @Override
    public void close(){
        try {
            cs.stop();
            socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public int getPort(){
        return port;
    }

    public String getIp(){
        return ip;
    }


}
