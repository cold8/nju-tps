package Shared.geass.message.request.user;

import Server.geass.serverController.ServerUserController;
import Shared.geass.dataPOJO.User;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.GetUserResponse;
import Shared.geass.message.response.Response;

/**
 * User: Kite
 * Date: 13-6-1
 */
public class GetUserRequest extends Request {

    private static final long serialVersionUID = 1L;

    private String username;

    public GetUserRequest(String username) {
        this.username = username;
    }

    @Override
    public Response invoke() {
        User user = new ServerUserController().getInfo(username);
        return new GetUserResponse(user);  //To change body of implemented methods use File | Settings | File Templates.
    }
}
