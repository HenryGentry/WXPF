/**
 * 文 件 名:  AbstractMessageHandler
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
import lombok.Getter;
import lombok.Setter;

/**
 * 消息处理器抽象类
 *
 * @author zhouhaofeng
 * @version 2018/3/1
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
public abstract class AbstractMessageHandler implements MessageHandler
{
	/**
	 * 消息下一个处理器
	 */
	protected MessageHandler nextMessageHandler;

	/**
	 * 消息若未能处理则执行最后的处理器
	 */
	protected MessageHandler finnalMessageHandler;

	/**
	 * 发送方（用户）
	 */
	protected String fromUserName;

	/**
	 * 接收方（公众号）
	 */
	protected String toUserName;

	/**
	 * 模板方法实现主要的处理逻辑，是自己处理还是交给下游处理
	 *
	 * @param wechatInMessage 微信输入消息
	 * @return 回复消息
	 */
	@Override
	public BaseReplyMessage handleMessage (WechatInMessage wechatInMessage)
	{
		fromUserName = wechatInMessage.getFromUserName ();
		toUserName = wechatInMessage.getToUserName ();
		if (canDo (wechatInMessage))
		{
			return handleByMe (wechatInMessage);
		}
		return nextMessageHandler.handleMessage (wechatInMessage);
	}

	/**
	 * 该处理器是否能够处理该消息
	 *
	 * @param wechatInMessage 微信输入消息
	 * @return true 是 false 否
	 */
	public abstract boolean canDo (WechatInMessage wechatInMessage);

	/**
	 * 详细消息处理逻辑
	 *
	 * @param wechatInMessage 微信输入消息
	 * @return 回复消息
	 */
	public abstract BaseReplyMessage handleByMe (WechatInMessage wechatInMessage);
}
