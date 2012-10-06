package com.yoyo.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
* NetUtils: 网络工具类
* @author yoyo Email:152106619@qq.com
* @version 创建时间：2012-8-17 下午1:03:07
*/
public class NetUtils {
	/**
	* @Title getHostAddress
	* @Description 获取IP地址
	* @return String 返回IP地址（如，192.168.1.1）
	* @return
	* @author yoyo Email:152106619@qq.com
	* @date 2012-8-17 下午1:03:50
	* @ModificationHistory
	* Date  Author  Version  Description
	* ---------------------------------------------------------*
	* 2012-8-17  yoyo Email:152106619@qq.com v1.0.0   修改原因
	*/
	public static String getHostAddress() {
		InetAddress addr = null;
		try {
			addr = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		String ip = addr.getHostAddress().toString();//获得本机IP
		return ip;
	}
	
	/**
	* @Title getHostName
	* @Description 获取主机名
	* @return String
	* @return
	* @author yoyo Email:152106619@qq.com
	* @date 2012-8-17 下午1:04:57
	* @ModificationHistory
	* Date  Author  Version  Description
	* ---------------------------------------------------------*
	* 2012-8-17  yoyo Email:152106619@qq.com v1.0.0   修改原因
	*/
	public static String getHostName() {
		InetAddress addr = null;
		try {
			addr = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		String name = addr.getHostName().toString();
		return name;
	}
}
