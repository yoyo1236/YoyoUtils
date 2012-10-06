package com.yoyo.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;

/**
* ConfigFileReader: 读取配置文件类
* @author yoyo Email:152106619@qq.com
* @version 创建时间：2012-8-17 下午1:06:26
*/
public class ConfigFileReader {
	private static ConfigFileReader INSTANCE = null;
	
    private SAXBuilder builder = null;
    private Document doc = null;
	
	private ConfigFileReader(String fileName) throws JDOMException, IOException {
		builder = new SAXBuilder();
		doc = builder.build(new File(fileName));
	}
	
	public static ConfigFileReader getInstance(String fileName) throws JDOMException, IOException {
		if (INSTANCE == null) {
			INSTANCE = new ConfigFileReader(fileName);
		}
		
		return INSTANCE;
	}

	/**
	* @Title getElement
	* @Description 获取path标签的值
	* @return Element
	* @param path
	* @return
	* @throws JDOMException
	* @author yoyo Email:152106619@qq.com
	* @date 2012-8-17 下午1:07:03
	* @ModificationHistory
	* Date  Author  Version  Description
	* ---------------------------------------------------------*
	* 2012-8-17  yoyo Email:152106619@qq.com v1.0.0   修改原因
	*/
	public Element getElement(String path) throws JDOMException {
        XPath xpath = XPath.newInstance(path);
        List<?> items = xpath.selectNodes(doc);
        if (items.size() == 1) {
        	return (Element)items.get(0);
        } else {
        	return null;
        }
	}
}
