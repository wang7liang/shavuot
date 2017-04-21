package com.ws.shavuot.common.utils;

import java.io.*;

/**
 * Created by chenqian on 2016/11/4.
 */
public class FileUtil {
    public static void saveFileFromInputStream(InputStream stream, String path, String filename)
    {
        FileOutputStream fs= null;
        try {
            File file = new File(path);
            if(!file.exists()){
                file.mkdirs();
            }

            fs = new FileOutputStream( path + "/"+ filename);
            byte[] buffer =new byte[1024*1024];
            int bytesum = 0;
            int byteread = 0;
            while ((byteread=stream.read(buffer))!=-1)
            {
                bytesum+=byteread;
                fs.write(buffer,0,byteread);
                fs.flush();
            }

            fs.close();
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
    }
    }
}
