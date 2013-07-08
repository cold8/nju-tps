/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.geass.net;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tin
 */
public class ClientFTPNetTest {
    
    public ClientFTPNetTest() {
    }

    /**
     * Test of ftpLogin method, of class ClientFTPNet.
     */
    @Test
    public void testFtpLogin() {
        System.out.println("ftpLogin");
        ClientFTPNet instance = null;
        boolean expResult = false;
        boolean result = instance.ftpLogin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ftpLogOut method, of class ClientFTPNet.
     */
    @Test
    public void testFtpLogOut() {
        System.out.println("ftpLogOut");
        ClientFTPNet instance = null;
        instance.ftpLogOut();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of uploadFile method, of class ClientFTPNet.
     */
    @Test
    public void testUploadFile() {
        System.out.println("uploadFile");
        String localFilePath = "";
        String romotUpLoadePath = "";
        ClientFTPNet instance = null;
        boolean expResult = false;
        boolean result = instance.uploadFile(localFilePath, romotUpLoadePath);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of downloadFile method, of class ClientFTPNet.
     */
    @Test
    public void testDownloadFile() {
        System.out.println("downloadFile");
        String remoteFileName = "";
        String localDires = "";
        String remoteDownLoadPath = "";
        ClientFTPNet instance = new ClientFTPNet("192.168.61.1", 21, "anonymous", "anonymous");
        boolean expResult = false;
        boolean result = instance.downloadFile(remoteFileName, localDires, remoteDownLoadPath);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


}