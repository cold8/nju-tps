package Shared.geass.message.request.user;

import Server.geass.database.Controller.DatabaseController;
import Shared.geass.dataPOJO.User;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.ConfirmResponse;
import Shared.geass.message.response.Response;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-5-12
 * Time: 下午5:19
 * To change this template use File | Settings | File Templates.
 */
public class CheckNameRequest extends Request {

    private static final long serialVersionUID = 1L;

    private String userName;

    public CheckNameRequest(String name){
        this.userName = name;
    }

    @Override
    public Response invoke() {
        boolean confirmed = true;
        User user = DatabaseController.getInstance().getUserInfo(userName);
        if(user != null)
            confirmed = false;
        System.out.println(confirmed);
        return new ConfirmResponse(confirmed);
    }
}
