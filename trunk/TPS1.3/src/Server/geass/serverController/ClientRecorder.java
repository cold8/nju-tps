package Server.geass.serverController;

import java.util.ArrayList;

/**
 * User: Kite
 * Date: 13-6-1
 */
public class ClientRecorder implements Runnable{

    private ArrayList<String> userList;
    private ArrayList<Integer> signalList;
    private TravellerController travellerController;
    private static ClientRecorder instance;

    static public ClientRecorder getInstance() {
        if(instance == null)
            instance = new ClientRecorder();
        return instance;
    }

    private ClientRecorder(){
        userList = new ArrayList<String>();
        signalList =new ArrayList<Integer> ();
        travellerController = TravellerController.getInstance();
    }

    public void add(String name){

        signalList.add(0);
        userList.add(name);
    }

    public boolean checkUser(String userName){
        if(userList.contains(userName))
            return true;
        else
            return false;
    }

    public void remove(String name){
        int n = userList.indexOf(name);
        userList.remove(name);
        signalList.remove(n);
        //日志记录用户断线的处理
        System.out.println(name+"断开连接");
    }

    public void deal(String name){
        int n = userList.indexOf(name);
        if(n!=-1){
            signalList.set(n, 0);
        }
    }

    public void run(){
        while(true){
            synchronized(userList){
                //System.out.println("ClientRecorder:user size   "+userList.size());
                for(int i = 0;i<userList.size();i++){
                    if(signalList.get(i)>1){
                        //"日志记录用户断开连接"
                        System.out.println(userList.get(i)+"断开连接");
                        remove(userList.get(i));
                        continue;
                    }
                    signalList.set(i, signalList.get(i)+1);
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
