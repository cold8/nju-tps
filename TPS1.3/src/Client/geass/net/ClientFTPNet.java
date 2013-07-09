/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.geass.net;

/**
 *
 * @author tin
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.TimeZone;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPReply;

public class ClientFTPNet {

    private FTPClient ftpClient;
    private String strIp;
    private int intPort;
    private String user;
    private String password;
    
    

    public ClientFTPNet(String strIp, int intPort, String user, String Password) {
        this.strIp = strIp;
        this.intPort = intPort;
        this.user = user;
        this.password = Password;
        this.ftpClient = new FTPClient();
    }

    /**
     * @return 判断是否登入成功
     *
     */
    public boolean ftpLogin() {
        boolean isLogin = false;
        FTPClientConfig ftpClientConfig = new FTPClientConfig();
        ftpClientConfig.setServerTimeZoneId(TimeZone.getDefault().getID());
        this.ftpClient.setControlEncoding("GBK");
        this.ftpClient.configure(ftpClientConfig);
        try {
            if (this.intPort > 0) {
                this.ftpClient.connect(this.strIp, this.intPort);
            } else {
                this.ftpClient.connect(this.strIp);
            }
            // FTP服务器连接回答  
            int reply = this.ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                this.ftpClient.disconnect();
                System.out.println("登录FTP服务失败！");
                return isLogin;
            }
            this.ftpClient.login(this.user, this.password);
            // 设置传输协议  
            this.ftpClient.enterLocalPassiveMode();
            this.ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            System.out.println(this.user + "成功登陆FTP服务器");
            isLogin = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(this.user + "登录FTP服务失败！" + e.getMessage());
        }
        this.ftpClient.setBufferSize(1024 * 2);
        this.ftpClient.setDataTimeout(30000);
        return isLogin;
    }

    /**
     * @退出关闭服务器链接
     *
     */
    public void ftpLogOut() {
        if (null != this.ftpClient && this.ftpClient.isConnected()) {
            try {
                boolean reuslt = this.ftpClient.logout();// 退出FTP服务器  
                if (reuslt) {
                    System.out.println("成功退出服务器");
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("退出FTP服务器异常！" + e.getMessage());
            } finally {
                try {
                    this.ftpClient.disconnect();// 关闭FTP服务器的连接  
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("关闭FTP服务器的连接异常！");
                }
            }
        }
    }

    /**
     * 上传Ftp文件
     * @param localFile 本地文件
     * @param romotUpLoadePath上传服务器路径 - 应该以/结束
     *
     */
    public boolean uploadFile(String localFilePath, String romotUpLoadePath) {
        BufferedInputStream inStream = null;
        boolean success = false;
        File localFile;
        try {
            localFile = new File(localFilePath);
            System.out.println(localFile.getAbsolutePath());
            System.out.println(localFile.getName());

            this.ftpClient.changeWorkingDirectory(romotUpLoadePath);// 改变工作路径  
            inStream = new BufferedInputStream(new FileInputStream(localFile));
            System.out.println(localFile.getName() + "开始上传.....");
            success = this.ftpClient.storeFile(localFile.getName(), inStream);
            if (success == true) {
                System.out.println(localFile.getName() + "上传成功");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(localFilePath + "未找到");
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (inStream != null) {
                try {
                    inStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(success);
            return success;
        }
    }

    /**
     * *
     * 下载文件
     *
     * @param remoteFileName 待下载文件名称
     * @param localDires 下载到当地那个路径下
     * @param remoteDownLoadPath remoteFileName所在的路径
     *
     */
    public boolean downloadFile(String remoteDownLoadPath,String remoteFileName, String localDires ) {
        File localDir = new File(localDires);
        if(!localDir.exists()){
            localDir.mkdir();
        }
            
        String strFilePath = localDires + remoteFileName;
        BufferedOutputStream outStream = null;
        boolean success = false;
        try {
            this.ftpClient.changeWorkingDirectory(remoteDownLoadPath);
            outStream = new BufferedOutputStream(new FileOutputStream(
                    strFilePath));
            System.out.println(remoteFileName + "开始下载....");
            Thread downloadthread = new Thread();
            success = this.ftpClient.retrieveFile(remoteFileName, outStream);
            if (success == true) {
                System.out.println(remoteFileName + "成功下载到" + strFilePath);
                return success;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(remoteFileName + "下载失败");
        } finally {
            if (null != outStream) {
                try {
                    outStream.flush();
                    outStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (success == false) {
                System.out.println(remoteFileName + "下载失败");
            }
            return success;
        }

    }

    public static void main(String[] args) throws IOException {

        ClientFTPNet ftp = new ClientFTPNet("192.168.61.1", 21, "anonymous", "anonymous");
        //FTPClient ftpc = new FTPClient();

        ftp.ftpLogin();
        ftp.uploadFile("C:\\Users\\tin\\Downloads\\original_EWk8_46b7000018b6125f.jpg", "/2013");
        ftp.downloadFile("/","少年Pi的奇幻漂流.Life.of.Pi.2012.DVDSCR-MP4-人人影视原创翻译中英双语字幕.mp4", "D:\\traveller\\temp\\" );
        ftp.ftpLogOut();
    }
}
