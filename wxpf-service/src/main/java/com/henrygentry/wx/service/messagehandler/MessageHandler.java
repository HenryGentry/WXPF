/**
 * 文 件 名:  MessageHandler
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhouhaofeng
 * 修改时间:  2018/3/1
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.henrygentry.wx.service.messagehandler;

import com.henrygentry.wx.dto.message.base.BaseReplyMessage;
import com.henrygentry.wx.dto.message.req.WechatInMessage;

/**
 * 消息处理抽象接口
 *
 * @author zhouhaofeng
 * @version 2018/3/1
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface MessageHandler
{
	/**
	 * 处理消息抽象方法
	 *
	 * @param wechatInMessage 微信输入消息
	 * @return 响应消息
	 */
	BaseReplyMessage handleMessage (WechatInMessage wechatInMessage);

	/**
	 * 设置下一个处理消息的处理器
	 *
	 * @param messageHandler 消息处理类
	 */
	void setNextHandler (MessageHandler messageHandler);
}
