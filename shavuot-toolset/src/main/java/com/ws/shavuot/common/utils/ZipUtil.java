package com.ws.shavuot.common.utils;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by mao on 2016/11/21.
 */
public class ZipUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ZipUtil.class);
    public enum ZipMatchPattern{
        MATCH_PATTERN_BOTH_ALL,      //文件和表达式一一对应
        MATCH_PATTERN_FILE_ALL,      //所有文件都能找到匹配表达式
        MATCH_PATTERN_EXPRESS_ALL;   //所有表达式都能找到匹配的文件
    }

    /**
     * 检查压缩包文件中文件是否和表达式匹配（目前只支持单层文件结构）
     * @param zipFile
     * @param expresses
     * @param pattern
     * @return
     * @throws IOException
     */
    public static boolean checkMatch(File zipFile, List<String> expresses,ZipMatchPattern pattern) throws IOException {
        if(zipFile==null || CollectionUtils.isEmpty(expresses)){
            return false;
        }
        //定义默认的匹配
        if(pattern==null){
            pattern= ZipMatchPattern.MATCH_PATTERN_BOTH_ALL;
        }
        boolean flag=true;
        ZipFile zip=new ZipFile(zipFile);
        Integer fileCount=zip.size();
        if(pattern.equals(ZipMatchPattern.MATCH_PATTERN_BOTH_ALL)){
            if(!fileCount.equals(expresses.size())){
                return false;
            }else{
                List<String> fileNames=getFileNames(zipFile);
                return checkOne2One(fileNames,expresses);
            }
        }else if(pattern.equals(ZipMatchPattern.MATCH_PATTERN_FILE_ALL)){
            if(fileCount>expresses.size()){
                return false;
            }else{
                //TODO 暂不实现
            }
        }else if(pattern.equals(ZipMatchPattern.MATCH_PATTERN_EXPRESS_ALL)){
            if(fileCount<expresses.size()){
                return false;
            }else{
                //TODO 暂不实现
            }
        }else{
            LOGGER.warn("ZipUtil未知的匹配模式："+pattern.toString());
            return false;
        }
        return flag;
    }

    public static boolean checkMatch(File zipFile, List<String> expresses) throws IOException{
        return checkMatch(zipFile,expresses,null);
    }

    /**
     * 从压缩包中获得指定文件
     * @param zipFile
     * @param express
     * @return
     * @throws IOException
     */
    public static File getZipFile(File zipFile,String express) throws IOException {
        ZipFile zip=new ZipFile(zipFile);
        Enumeration<ZipEntry> entries = (Enumeration<ZipEntry>)zip.entries();
        ZipEntry entry;
        File file=null;
        while(entries.hasMoreElements()){
            entry=entries.nextElement();
            if(isMatch(entry.getName(),express)){
                BufferedInputStream bufferedInputStream=new BufferedInputStream(zip.getInputStream(entry));
                file=new File(entry.getName());
                FileUtils.copyInputStreamToFile(bufferedInputStream,file);
                break;
            }
        }
        return file;
    }


    /**
     * 获取一个压缩包中的所有文件名
     * @param zipFile
     * @return
     * @throws IOException
     */
    public static List<String> getFileNames(File zipFile) throws IOException {
        List<String> fileNames=new ArrayList<>();
        ZipFile zip=new ZipFile(zipFile);
        Enumeration<ZipEntry> entries = (Enumeration<ZipEntry>)zip.entries();
        ZipEntry entry;
        while(entries.hasMoreElements()){
            entry=entries.nextElement();
            if(!entry.isDirectory()){
                fileNames.add(entry.getName());
            }
        }
        return fileNames;
    }

    public static boolean checkOne2One(List<String> names ,List<String> expresses) throws IOException {
        if(names.size()!=expresses.size()||CollectionUtils.isEmpty(names)||CollectionUtils.isEmpty(expresses)){
            return false;
        }else{

            for(String name:names){
                boolean flag=false;
                for(String express:expresses){
                    if(isMatch(name,express))
                    {
                        flag=true;
                        break;
                    }
                }
                if(!flag){
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean isMatch(String value,String express){
        Pattern pattern = Pattern.compile(express);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

}
