/**
 * 文 件 名:  EventHandler
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhouhaofeng
 * 修改时间:  2018/3/1
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.henrygentry.wx.service.messagehandler.handler;

import com.henrygentry.wx.common.constants.MsgTypeConstants;
import com.henrygentry.wx.dto.message.base.BaseReplyMessage;
import com.henrygentry.wx.dto.message.req.WechatInMessage;
import com.henrygentry.wx.service.messagehandler.AbstractMessageHandler;
import com.henrygentry.wx.service.messagehandler.MessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 事件消息处理器
 *
 * @author zhouhaofeng
 * @version 2018/3/1
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Component
public class EventHandler extends AbstractMessageHandler
{
	private static final Logger logger = LoggerFactory.getLogger (EventHandler.class);

	/**
	 * 设置下一个处理消息的处理器
	 *
	 * @param messageHandler 消息处理类
	 */
	@Override
	public void setNextHandler (MessageHandler messageHandler)
	{
		nextMessageHandler = messageHandler;
	}

	/**
	 * 该处理器是否能够处理该消息
	 *
	 * @param wechatInMessage 微信输入消息
	 * @return true 是 false 否
	 */
	@Override
	public boolean canDo (WechatInMessage wechatInMessage)
	{
		return wechatInMessage != null && MsgTypeConstants.EVENT_MSG.equals (wechatInMessage.getMsgType ());
	}

	/**
	 * 详细消息处理逻辑
	 *
	 * @param wechatInMessage 微信输入消息
	 * @return 回复消息
	 */
	@Override
	public BaseReplyMessage handleByMe (WechatInMessage wechatInMessage)
	{
		logger.debug ("处理事件消息");
		return null;
	}
}
