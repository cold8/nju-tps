package Shared.geass.message.response;

import Shared.geass.dataPOJO.User;

/**
 * User: Kite
 * Date: 13-6-1
 */
public class GetUserResponse extends Response{

    private static final long serialVersionUID = 1L;

    private User user;

    public GetUserResponse(User user) {
        this.user = user;
    }

    public User getUser(){
        return user;
    }


}
