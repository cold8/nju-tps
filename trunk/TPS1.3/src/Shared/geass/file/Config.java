package Shared.geass.file;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-5-1
 * Time: 上午10:54
 * To change this template use File | Settings | File Templates.
 */
public class Config {

    private static Properties ini = null;

    /**
     * 配置文件
     */
    static  private File file=new File("config/config.ini");

    /**
     * 读取配置文件
     */
    static {
        try {
            ini = new Properties ();
            ini.load (new FileInputStream(file));
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 通过指定的键值得到某项设置的字符串
     * @param key 键值
     * @return 键对应的字符串
     */
    public static String getIniKey (String key) {
        if(!ini.containsKey (key)) {
            return "";
        }
        return ini.get(key).toString ();
    }

    /**
     * 用一个字符串设置对应键的属性值
     * @param key  the key to be placed into this property list
     * @param value the value corresponding to key
     */
    public static void setIniKey(String key,String value){
        ini.setProperty(key, value);
    }

}
