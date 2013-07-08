package Server.geass.net;

import Server.geass.serverController.ServerSocketHandler;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.Response;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * User: Kite
 * Date: 13-6-1
 */
public abstract class ServerResponseNet implements ServerNet {


    private int port;
    private ServerSocket ss;
    private Socket socket;
    private boolean isOn;

    @Override
    public void start(int po) {
        // TODO Auto-generated method stub
        this.port = po;
        new Thread(new Listener()).start();
        isOn=true;
    }

    @Override
    public void sendCommand(Response response){
        try {
            ObjectOutputStream oo = new ObjectOutputStream(socket.getOutputStream());
            oo.writeObject(response);
            oo.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public InetAddress getInetAddress(){
        return socket.getInetAddress();
    }

    @Override
    public void close(){
        try {
            ss.close();
            isOn = false;
            System.out.println(port+"端口关闭");
            //日志记录端口关闭
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class Listener implements Runnable{

        @Override
        public void run() {
            try {
                ss = new ServerSocket(port);
                while(true){
                    socket = ss.accept();
                    //为新连接的socket开启一个线程
                    new Thread(new ServerSocketHandler(socket,0,ServerResponseNet.this)).start();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                if(isOn)
                    System.out.println(port+"端口断开");
            }
        }
    }
}
