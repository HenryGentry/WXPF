/**
 * 文 件 名:  MessageService
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhouhaofeng
 * 修改时间:  2018/3/1
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.henrygentry.wx.service.messagehandler;

import com.henrygentry.wx.common.utils.XstreamUtil;
import com.henrygentry.wx.dto.message.base.BaseReplyMessage;
import com.henrygentry.wx.dto.message.req.WechatInMessage;
import com.henrygentry.wx.service.messagehandler.handler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * 消息业务处理
 *
 * @author zhouhaofeng
 * @version 2018/3/1
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Service
public class MessageService
{
	@Autowired
	private TextHandler textHandler;

	@Autowired
	private EventHandler eventHandler;

	@Autowired
	private ImageHandler imageHandler;

	@Autowired
	private VideoHandler videoHandler;

	@Autowired
	private FinnalMessageHandler finnalMessageHandler;

	@PostConstruct
	public void init ()
	{
		textHandler.setNextHandler (eventHandler);
		eventHandler.setNextHandler (imageHandler);
		imageHandler.setNextHandler (videoHandler);
		videoHandler.setNextHandler (finnalMessageHandler);
	}

	/**
	 * 微信消息处理
	 *
	 * @param messageXml 请求消息xml
	 * @return 响应消息
	 */
	public String messageProcess (String messageXml)
	{
		WechatInMessage wechatInMessage = XstreamUtil.convertXmlToVo (messageXml, WechatInMessage.class);
		BaseReplyMessage baseReplyMessage = textHandler.handleMessage (wechatInMessage);
		if (baseReplyMessage == null)
		{
			return "success";
		}
		return baseReplyMessage.toXml ();
	}
}
