package com.yoyo.utils.protocolframework1.builder;

/**
* ProtocolBuilder: 协议类
* @author yoyo Email:152106619@qq.com
* @version 创建时间：2012-8-17 下午1:08:18
*/
public interface ProtocolBuilder {
	/**
	* 每一种协议分析者都有协议类型，设置协议类型
	*/
	public abstract void setProtocolType(Object o);
	/**
	* 生成协议
	*/
	public abstract Object buildProtocol();
	/**
	* 每一种协议都有值，获取该值
	*/
	public abstract Object getProtocolType();
	
}
