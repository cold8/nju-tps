package Shared.geass.message.request;

import Shared.geass.message.response.Response;
import java.io.Serializable;


/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-5-1
 * Time: 上午10:14
 * To change this template use File | Settings | File Templates.
 */
public abstract class Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public abstract Response invoke();

}
