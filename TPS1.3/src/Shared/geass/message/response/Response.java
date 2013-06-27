package Shared.geass.message.response;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-5-1
 * Time: 上午10:14
 * To change this template use File | Settings | File Templates.
 */
public abstract  class Response implements Serializable {

    private static final long serialVersionUID = 1L;

    String message;

    public void invoke(){
        System.out.println(message);
    }


}
