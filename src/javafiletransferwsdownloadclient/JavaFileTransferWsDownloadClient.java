/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafiletransferwsdownloadclient;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Vishal Prasad
 */
public class JavaFileTransferWsDownloadClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String fileName = "image.png";
        String filePath = "C:/Users/Vishal Prasad/Desktop/Download/" + fileName;
        byte[] fileBytes = download(fileName);
         
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            BufferedOutputStream outputStream = new BufferedOutputStream(fos);
            outputStream.write(fileBytes);
            outputStream.close();
             
            System.out.println("File downloaded: " + filePath);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    

    private static byte[] download(java.lang.String arg0) {
        com.mindfire.filetransfer.FileTransferWS_Service service = new com.mindfire.filetransfer.FileTransferWS_Service();
        com.mindfire.filetransfer.FileTransferWS port = service.getFileTransferWSPort();
        return port.download(arg0);
    }
    
}
