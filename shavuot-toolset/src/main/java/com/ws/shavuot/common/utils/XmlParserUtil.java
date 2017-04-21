package com.ws.shavuot.common.utils;

import org.dom4j.*;


import java.util.Iterator;
import java.util.List;

/**
 * 用来获得xml的指定节点的值和属性，如果节点不唯一，返回第一次出现的节点，不存在返回null.
 */
public class XmlParserUtil {
	/**
	 * 获取指定节点的值
	 * @param xml
	 * @param nodeName
	 * @return
	 */
	public static String getValue(String xml,String nodeName)
	{
		Document document=null;
		try {
			document= DocumentHelper.parseText(xml);
		} catch (DocumentException e) {
			e.printStackTrace();
			return null;
		}
		Element root = document.getRootElement();
		return listNodes(root,nodeName);
	}
	/**
	 * 获取指定节点的指定属性的值
	 * @param xml
	 * @param nodeName
	 * @param attrName
	 * @return
	 */
	public static String getValue(String xml,String nodeName,String attrName)
	{
		Document document=null;
		try {
			document=DocumentHelper.parseText(xml);
		} catch (DocumentException e) {
			e.printStackTrace();
			return null;
		}
		Element root = document.getRootElement();   
		return listNodes(root,nodeName,attrName);		
	}
			
	private static String listNodes(Element root,String nodeName) 
	{ 
		if(root.getName().equals(nodeName)) 
		{
			return root.getText();
		}
	    // 当前节点下面子节点迭代器  
		@SuppressWarnings("unchecked")
		Iterator<Element> it = root.elementIterator();  
	    // 遍历
	    while (it.hasNext()) {  
	        // 获取某个子节点对象  
	        Element e = it.next();  
	        // 对子节点进行遍历  
	        String str=listNodes(e,nodeName);
	        if(str!=null)
	        	return str;
	    }
	    return null;
	} 
	
	private static String listNodes(Element root,String nodeName,String attrName) 
	{ 
		if(root.getName().equals(nodeName)) 
		{
			@SuppressWarnings("unchecked")
			List<Attribute> list = root.attributes();
	        // 遍历属性节点  
	        for (Attribute attr : list) { 
	            if(attr.getName().equals(attrName))  
	            	return attr.getValue();
	        } 
		}
	    // 当前节点下面子节点迭代器  
		@SuppressWarnings("unchecked")
		Iterator<Element> it = root.elementIterator();  
	    // 遍历
	    while (it.hasNext()) {  
	        // 获取某个子节点对象  
	        Element e = it.next();  
	        // 对子节点进行遍历  
	        String str=listNodes(e,nodeName,attrName);
	        if(str!=null)
	        	return str;
	    }
	    return null;
	}
	
	/**
	 * 遍历节点和属性
	 * @param node
	 */
	public static void listNodes(Element node) { 
        System.out.println("当前节点的名称：：" + node.getName());  
        // 获取当前节点的所有属性节点  
        @SuppressWarnings("unchecked")
		List<Attribute> list = node.attributes();  
        // 遍历属性节点  
        for (Attribute attr : list) {  
            System.out.println(attr.getText() + "-----" + attr.getName()  
                    + "---" + attr.getValue());  
        }  
  
        if (!(node.getTextTrim().equals(""))) {  
            System.out.println("文本内容：：：：" + node.getText());  
        }  
  
        // 当前节点下面子节点迭代器  
        @SuppressWarnings("unchecked")
		Iterator<Element> it = node.elementIterator();  
        // 遍历
        while (it.hasNext()) {  
            // 获取某个子节点对象  
            Element e = it.next();  
            // 对子节点进行遍历  
            listNodes(e);  
        }  
    }

	/**
	 * 检查是否存在某标签
	 * @param xml
	 * @param tag		标签名称
	 * @return
	 */
	public static boolean checkExistence(String xml,String tag)
	{
		String value=getValue(xml,tag);
		if(value!=null)
			return true;
		else
			return false;
	}
}

 
