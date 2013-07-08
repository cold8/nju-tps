package Server.geass.serverController;

import Shared.geass.dataPOJO.User;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-4-7
 * Time: 下午8:50
 * To change this template use File | Settings | File Templates.
 */
public interface ServerUserControllerInterface {

    public boolean userNameValid(String name);
    public boolean checkPassword(String name,String password);
    public User getInfo(String name);
    public boolean updateUserInfo(User user);
    public boolean submitUserInfo(User user);

    /**
     *
     * @param name
     * @return 如果已经有登录则返回false，未登录返回true
     * V1.0似乎逻辑还有待完善
     */
    public boolean verifyRepeatlogin(String name);

}
