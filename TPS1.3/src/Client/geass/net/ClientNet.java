package Client.geass.net;

import Shared.geass.message.response.Response;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-5-12
 * Time: 下午3:57
 * To change this template use File | Settings | File Templates.
 */
public interface ClientNet {

    public void start(String ip,int port);
    public void dealCommand(Response response);//处理命令，不在直接子类中添加具体实现
    public void close();
}
