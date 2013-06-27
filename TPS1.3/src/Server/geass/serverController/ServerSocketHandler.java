package Server.geass.serverController;

import Server.geass.net.ServerNet;
import Shared.geass.message.request.Request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

/**
 * User: Kite
 * Date: 13-6-2
 */
public class ServerSocketHandler implements Runnable{
    private Socket socket;
    private int num;//显示改socket的编号
    private ServerNet sn;

    public ServerSocketHandler(Socket socket,int num,ServerNet sn){
        this.socket = socket;
        this.num = num;
        this.sn = sn;
    }

    @Override
    public void run() {
        synchronized(this){
            try {
                ObjectInputStream oi = new ObjectInputStream(socket.getInputStream());
                Object com;
                if((com=oi.readObject())!=null){
                    ObjectOutputStream oo = new ObjectOutputStream(socket.getOutputStream());
                    oo.writeObject(sn.dealCommand((Request)com));
                    oo.flush();
                }
            }catch (SocketException e){
                sn.dealException(e,num);
                e.printStackTrace();
            }catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


}
