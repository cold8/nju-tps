package Client.geass.net;

import Shared.geass.message.response.Response;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * User: Kite
 * Date: 13-6-2
 */
public class ClientSocketHandler implements Runnable{

    private Socket socket;
    private ClientNet sn;
    private boolean isOn;

    ClientSocketHandler(Socket socket,ClientNet sn){
        this.socket = socket;
        this.sn = sn;
        isOn = true;
    }

    @Override
    public void run() {
        try {
            while(isOn){
                ObjectInputStream oi = new ObjectInputStream(socket.getInputStream());
                Object com;
                if((com=oi.readObject())!=null){
                    sn.dealCommand((Response)com);
                }
//			oi.close();
            }
        }catch (SocketException e){
            if(isOn==true){
                System.out.println("网络异常，正在尝试重连");
                ClientNotResponseNet cub = (ClientNotResponseNet)sn;
                try {
                    socket = new Socket(cub.getIp(),cub.getPort());
                    new Thread(this).start();
                } catch (UnknownHostException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void stop(){
        isOn =false;
    }
}
