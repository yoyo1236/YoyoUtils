package com.yoyo.utils.protocolframework1.director;

import com.yoyo.utils.protocolframework1.builder.ProtocolBuilder;

/**
* ProtocolDirector: 协议生成类
* @author yoyo Email:152106619@qq.com
* @version 创建时间：2012-8-17 下午1:08:38
*/
public interface ProtocolDirector {
	/**
	* 生成协议
	*/
	public abstract Object buildProtocol(ProtocolBuilder pb);
}
