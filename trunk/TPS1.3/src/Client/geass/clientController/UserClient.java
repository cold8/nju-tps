package Client.geass.clientController;

import java.io.IOException;

import Client.geass.net.ClientMessageSender;
import Shared.geass.dataPOJO.User;
import Shared.geass.message.request.Request;
import Shared.geass.message.request.user.CheckNameRequest;
import Shared.geass.message.request.user.GetUserRequest;
import Shared.geass.message.request.user.LoginRequest;
import Shared.geass.message.request.user.RegisterUserRequest;
import Shared.geass.message.response.ConfirmResponse;
import Shared.geass.message.response.GetUserResponse;
import Shared.geass.message.response.StatusReponse;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-5-6
 * Time: 下午2:32
 * To change this template use File | Settings | File Templates.
 */
public class UserClient {

    private static UserClient instance ;
    private static ClientMessageSender infoSender;

    public UserClient() {

    }


    public static UserClient getInstance(){
        if(instance == null){
            System.out.println("no userclient instance");
            instance = new UserClient()  ;
        }
        return instance;
    }

    public void setInfoSender(ClientMessageSender infoSender){
        this.infoSender = infoSender;
    }

    public boolean sendUserName(String userName) throws IOException{
        Object object = infoSender.sendRequest(new CheckNameRequest(userName));
        ConfirmResponse confirmResponse = (ConfirmResponse)object;
        return confirmResponse.isConfirmed();
    }

    public int sendPassword(String userName,String password) throws IOException {
        LoginRequest loginRequest = new LoginRequest(userName,password);
        Object ob = infoSender.sendRequest(loginRequest);
        StatusReponse statusReponse = (StatusReponse)ob;
        return statusReponse.getStatus();
    }

    public boolean sendUserInfo(User user) throws IOException{
        System.out.println(user.getName());
        Request rur = new RegisterUserRequest(user);
        Object ob =infoSender.sendRequest(rur);
        ConfirmResponse cr = (ConfirmResponse)ob;
        return cr.isConfirmed();
    }

    public User getUserInfo(String userName) throws IOException {
        Request gur = new GetUserRequest(userName);
        GetUserResponse guf = (GetUserResponse)infoSender.sendRequest(gur);
        return guf.getUser();
    }






}
