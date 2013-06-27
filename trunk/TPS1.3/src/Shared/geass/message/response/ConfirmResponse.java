package Shared.geass.message.response;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-5-1
 * Time: 上午10:47
 * 关联的request：LoginRequest |  ConnectRequest
 */
public class ConfirmResponse extends Response{

    private static final long serialVersionUID = 1L;

    private boolean confirmed;

    public ConfirmResponse(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public boolean isConfirmed(){
        return confirmed;
    }
}
