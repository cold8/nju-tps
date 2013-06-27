package Server.geass.serverController;

import Server.geass.net.ServerNet;
import Server.geass.net.ServerResponseNet;
import Shared.geass.message.request.ConnectRequest;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.ConfirmResponse;
import Shared.geass.message.response.Response;

/**
 * User: Kite
 * Date: 13-6-1
 */
public class ServerController {

    private int port;
    private int signalPort;
    private ServerNet inforBearer;
    private ServerNet signalBearer;
    private TravellerController travellerController;
    private ClientRecorder clientRecorder;

    public ServerController(int port,int signalPort){
        this.port = port;
        this.signalPort = signalPort;
        //travellerController = TravellerController.getInstance();
        /**
         * 用户日志处理
         */
        clientRecorder = clientRecorder.getInstance();
        new Thread(clientRecorder).start();
        initializeNet();
    }

    private void initializeNet(){
        inforBearer = new MainBearer();
        inforBearer.start(port);
        signalBearer = new SignalBearer();
        signalBearer.start(signalPort);
    }

    private Response dealRequest(Request re){
        return re.invoke();
    }

    private Response dealHello(Request request){
        ConnectRequest hello = (ConnectRequest)request;
        clientRecorder.deal(hello.getUsername());
        return new ConfirmResponse(true);
    }

    class MainBearer extends ServerResponseNet{

        @Override
        public Response dealCommand(Request request) {
            return dealRequest(request);
        }

        @Override
        public void dealException(Exception e, int num) {

        }

    }

    class SignalBearer extends ServerResponseNet{

        @Override
        public Response dealCommand(Request request) {
            return dealHello(request);
        }

        @Override
        public void dealException(Exception e, int num) {

        }

    }

    public static void main(String arges[]){
        new ServerController(8887,8889);

    }


}
