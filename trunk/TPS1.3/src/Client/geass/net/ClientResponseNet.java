package Client.geass.net;

import Server.geass.net.ServerResponseNet;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.Response;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * User: Kite
 * Date: 13-6-2
 */
public abstract class ClientResponseNet implements ClientNet{

    private int port;
    private String ip;
    private Socket socket;

    @Override
    public void start(String ip, int port) {
        // TODO Auto-generated method stub
        this.port = port;
        this.ip = ip;
    }

    public void sendRespondentCommand(Request request){//内部处理回馈
        new Thread(new Sender(request)).start();
    }

    @Override
    public void close(){
        try {
            socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    class Sender implements Runnable{

        private Request request;

        public Sender(Request request){
            this.request = request;
        }

        @Override
        public void run() {
            // TODO Auto-generated method stub
            try	{
                socket = new Socket(ip,port);
                ObjectOutputStream oo = new ObjectOutputStream(socket.getOutputStream());
                oo.writeObject(request);
                oo.flush();
                ObjectInputStream oi = new ObjectInputStream(socket.getInputStream());
                Object com;
                if((com=oi.readObject())!=null){//需要处理若长时间没有收到回馈的情况
                    dealCommand((Response)com);
                }
                oo.close();
                oi.close();
                socket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


}
