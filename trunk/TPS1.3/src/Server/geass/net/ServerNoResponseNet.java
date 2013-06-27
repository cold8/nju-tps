package Server.geass.net;

import Shared.geass.message.request.Request;
import Shared.geass.message.response.Response;

/**
 * User: Kite
 * Date: 13-6-1
 */
public abstract class ServerNoResponseNet implements ServerNet {
    @Override
    public void start(int port) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Response dealCommand(Request request) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void sendCommand(Response response) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void dealException(Exception e, int num) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void close() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
