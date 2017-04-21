package com.ws.shavuot.OCR;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
/**
 * Created by mao on 2016/3/8 0008.
 */
public class OCRUtil {
    /**
     * @param fileBytes  要上传的的文件字节数组
     * @param url        服务器地址
     * @return
     */
    public static String postFile(byte[] fileBytes,String url){
        URL postUrl = null;
        try {
            postUrl = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
        HttpURLConnection connection=null;
        try {
            connection=(HttpURLConnection)postUrl.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        connection.setDoOutput(true);
        connection.setDoInput(true);
        try {
            connection.setRequestMethod("POST");
        } catch (ProtocolException e) {
            e.printStackTrace();
            return null;
        }
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);
        connection.setRequestProperty("Content-Type",
                "application/octet-stream");
        try {
            connection.connect();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        OutputStream outStrm = null;
        try {
            outStrm = connection.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        //写数据
        try {
            outStrm.write(fileBytes);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        try {
            outStrm.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        // 关闭流对象。此时，不能再向对象输出流写入任何数据，先前写入的数据存在于内存缓冲区中,
        // 再调用下边的getInputStream()函数时才把准备好的http请求正式发送到服务器
        try {
            outStrm.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        // 调用HttpURLConnection连接对象的getInputStream()函数,
        // 将内存缓冲区中封装好的完整的HTTP请求电文发送到服务端。
        InputStream inStrm=null;
        try {
            inStrm = connection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        String result=inputStream2String(inStrm);
        try {
            inStrm.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        JSONObject jsonObject=JSONObject.parseObject(result);
        List<String> list = JSONObject.parseObject(jsonObject.getString("linesText"), new TypeReference<List<String>>() {});
        StringBuilder stringBuilder=new StringBuilder();



        for(String s:list)
            stringBuilder.append(s);
        return stringBuilder.toString();
    }

    /**
     * @param file      要上传的文件
     * @param url       服务器地址
     * @return
     */
    public static String postFile(File file,String url)
    {
        return postFile(getBytes(file),url);
    }

    public static String postFile(String filePath,String url)
    {
        File file=new File(filePath);
        if(!file.exists())
            return null;
        return postFile(file,url);
    }



    //file转byte[]
    private static byte[] getBytes(File file){
        byte[] buffer = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return buffer;
    }


    //inputstream转string
    private static String inputStream2String(InputStream is){
        BufferedReader in = null;
        //指定读取输入流编码,utf-8防止中文乱码
        try {
            in = new BufferedReader(new InputStreamReader(is,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
        StringBuffer buffer = new StringBuffer();
        String line = "";
        try {
            while ((line = in.readLine()) != null){
                buffer.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return buffer.toString();
    }
}
