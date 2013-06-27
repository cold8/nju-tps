package Shared.geass.assist;

import javax.imageio.*;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-5-1
 * Time: 上午10:54
 * To change this template use File | Settings | File Templates.
 */
public class FileTransport {

    /**
     *
     * @param object
     * @param path
     * @return
     */
    public static boolean storeObjectTo(Serializable object,String path){
        File file = new File(path);
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(object);
            oos.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     *
     * @param path
     * @return
     */
    public static Object readObjectFrom(String path) {
        File file = new File(path);
        try {
            if (!file.exists())
                file.createNewFile();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            Object obj =  ois.readObject();
            ois.close();
            return obj;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 把图像写入文件
     * @param image
     * @param savePath
     * @throws IOException
     */
    public static void saveImage(BufferedImage image,String savePath) throws IOException {
        ImageWriter writer = null;
        ImageTypeSpecifier type =
                ImageTypeSpecifier.createFromRenderedImage(image);
        String imgTypeString = "jpg";
        writer = ImageIO.getImageWriters(type, imgTypeString).next();
        IIOImage iioImage = new IIOImage(image, null, null);
        ImageWriteParam param = writer.getDefaultWriteParam();

        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(1);
        ImageOutputStream outputStream =
                ImageIO.createImageOutputStream(new File(savePath));
        writer.setOutput(outputStream);
        writer.write(null, iioImage, param);
        outputStream.close();
    }

}
