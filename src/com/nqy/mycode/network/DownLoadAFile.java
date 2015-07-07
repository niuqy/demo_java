package com.nqy.mycode.network;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by abner on 7/3/15.
 */
public class DownLoadAFile {
    public static void main(String[] args) {
        HttpURLConnection conn = null;
        InputStream is = null;
        try {
            URL url = new URL("http://smartthinking.ir/dl/Asking%20the%20Right%20Questions,%20A%20Guide%20to%20Critical%20Thinking,%208th%20Ed.pdf");
            conn = (HttpURLConnection) url.openConnection();
            is = conn.getInputStream();
            Save2PDF save2PDF = new Save2PDF();
            save2PDF.save(is,"asking the right questions");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(conn != null){
                conn.disconnect();
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public interface saveInputStream2File{
        public  void save(InputStream is,String fileName);
    }

    static class Save2PDF implements saveInputStream2File{

        @Override
        public void save(InputStream is,String fileName) {
            int len = -1;
            byte[] buf = new byte[1024];
            File dest = new File(fileName+".pdf");
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(dest);
                len = is.read(buf);
                while(len != -1){
                    fos.write(buf,0,len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    if(fos != null){
                        fos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
