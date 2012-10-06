package com.yoyo.utils;

import java.io.IOException;
import java.io.StringReader;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

/**
* GeneralUtils: TODO(类说明)
* @author yoyo Email:152106619@qq.com
* @version 创建时间：2012-8-17 下午1:05:14
*/
public class GeneralUtils {
	/**
	* @Title stringToXML
	* @Description String转XML
	* @return Element
	* @param msg
	* @return
	* @author yoyo Email:152106619@qq.com
	* @date 2012-8-17 下午1:05:20
	* @ModificationHistory
	* Date  Author  Version  Description
	* ---------------------------------------------------------*
	* 2012-8-17  yoyo Email:152106619@qq.com v1.0.0   修改原因
	*/
	public static Element stringToXML(String msg) {
		if(msg == null || msg.equals(""))
			return null;
		msg = msg.split("\0")[0];
		//创建一个新的字符串 
        StringReader read = new StringReader(msg); 
        //创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入 
        InputSource source = new InputSource(read); 
        //创建一个新的SAXBuilder 
        SAXBuilder sb = new SAXBuilder(); 
        //通过输入源构造一个Document 
        Element root = null;
		try {
			Document doc = sb.build(source);
			root = doc.getRootElement(); 
			doc.detachRootElement();
		} catch (JDOMException | IOException e) {
			e.printStackTrace();
		} 
        return root;
	}
}
