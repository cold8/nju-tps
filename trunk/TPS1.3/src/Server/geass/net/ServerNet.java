package Server.geass.net;

import Shared.geass.message.request.Request;
import Shared.geass.message.response.Response;

/**
 * User: Kite
 * Date: 13-5-1
 */
public interface ServerNet {

    public void start(int port);
    public Response dealCommand(Request request);//处理信息的方法，在其直接子类中不实现，在控制类的内部类中实现
    public void sendCommand(Response response);
    public void dealException(Exception e,int num);
    public void close();
}
