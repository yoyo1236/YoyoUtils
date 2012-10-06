package com.yoyo.utils.protocolframework1.builder;

import java.io.IOException;

import org.jdom.JDOMException;


/**
* ProtocolFactory: 协议生成工厂
* @author yoyo Email:152106619@qq.com
* @version 创建时间：2012-8-17 下午1:08:59
*/
public class ProtocolFactory {
	private static ProtocolFactory INSTANCE = null;
	private static String CLASS_PATH = null;
	
	private ProtocolFactory(String classPath)
	{
		CLASS_PATH = classPath;
	}
	
	public static ProtocolFactory getInstance(String classPath) throws JDOMException, IOException {
		if (INSTANCE == null) {
			INSTANCE = new ProtocolFactory(classPath);
		}
		
		return INSTANCE;
	}
	
	
	/**
	* @Title createBuilder
	* @Description 创建协议类
	* @return ProtocolBuilder type对应的协议类
	* @param protocolType 协议类型
	* @return
	* @author yoyo Email:152106619@qq.com
	* @date 2012-8-17 下午1:09:27
	* @ModificationHistory
	* Date  Author  Version  Description
	* ---------------------------------------------------------*
	* 2012-8-17  yoyo Email:152106619@qq.com v1.0.0   修改原因
	*/
	public ProtocolBuilder createBuilder(String protocolType) {
		String classPath = CLASS_PATH;
		classPath = classPath.substring(0, classPath.lastIndexOf(".")+1)
			      + protocolType + "_"
			      + classPath.substring(classPath.lastIndexOf(".")+1);
		ProtocolBuilder instance = null;
		
		try {
			Class<?> classReference = Class.forName(classPath);
			instance = (ProtocolBuilder) classReference.newInstance();
			//instance.setType();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		  
		return instance;
	}
	
}
