package Shared.geass.message.request.user;

import Server.geass.traveller.userController.ServerUserController;
import Shared.geass.dataPOJO.User;
import Shared.geass.message.request.Request;
import Shared.geass.message.response.ConfirmResponse;
import Shared.geass.message.response.Response;

/**
 * User: Kite
 */
public class RegisterUserRequest extends Request {

    private static final long serialVersionUID = 1L;

    private User user;

    public RegisterUserRequest(User user){
        this.user = user;
    }

    @Override
    public Response invoke() {
        // TODO Auto-generated method stub
        boolean result = new ServerUserController().submitUserInfo(user);
        return new ConfirmResponse(result);
    }
}
