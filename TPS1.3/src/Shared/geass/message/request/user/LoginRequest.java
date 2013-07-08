package Shared.geass.message.request.user;

import Server.geass.serverController.ServerUserController;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.Response;
import Shared.geass.message.response.StatusReponse;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-5-2
 * Time: 上午10:56
 * To change this template use File | Settings | File Templates.
 */
public class LoginRequest extends Request {

    private static final long serialVersionUID = 1L;

    public String name;
    public String password;

    public LoginRequest(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void print(){

        System.out.println("name "+name+"password "+password);
    }

    @Override
    public Response invoke() {
        int status = 0;
        ServerUserController userController = ServerUserController.getInstance();
        if(userController.verifyRepeatlogin(name)){
            status = 1;
        }
        if(!userController.verifyRepeatlogin(name)){
            boolean judge = userController.checkPassword(name, password);
            if(judge)
                status = 2;
        }
        if(status == 2) {
            userController.addToNameList(name);
        }
        return new StatusReponse(status);
    }
}
