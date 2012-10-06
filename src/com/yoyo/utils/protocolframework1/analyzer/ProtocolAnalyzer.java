package com.yoyo.utils.protocolframework1.analyzer;
 
/**
* ProtocolAnalyzer: 协议分析类
* @author yoyo Email:152106619@qq.com
* @version 创建时间：2012-8-17 下午1:07:58
*/
public interface ProtocolAnalyzer {
	/**
	* 每一种协议分析者都有协议分析方法
	*/
	public abstract int analysis(Object str);
	/**
	* 每一种协议都有协议类型，获取该协议类型
	*/
	public abstract Object getProtocolType();
	/**
	* 每一种协议都有值，获取该值
	*/
	public abstract Object getProtocolValue();
}
