package Shared.geass.message.request;

import Shared.geass.message.response.ConfirmResponse;
import Shared.geass.message.response.Response;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-5-1
 * Time: 上午10:46
 * 用于客户端和服务器确认连接的请求
 */
public class ConnectRequest extends Request{

    private static final long serialVersionUID = 1L;
    private String username;

    public ConnectRequest(String username){
         this.username = username;
    }

    public String getUsername (){
        return this.username;
    }

    public Response invoke() {
        return new ConfirmResponse(true);  //To change body of implemented methods use File | Settings | File Templates.
    }
}
