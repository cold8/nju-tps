package Shared.geass.message.response;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-5-12
 * Time: 下午5:26
 * To change this template use File | Settings | File Templates.
 */
public class StatusReponse extends Response {

    private static final long serialVersionUID = 1L;

    private int status;

    public StatusReponse(int status){
        this.status = status;
    }

    public int getStatus(){
        return status;
    }

}
