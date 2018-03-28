/**
 * 文 件 名:  WechatOpenController
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhouhaofeng
 * 修改时间:  2018/2/28
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.henrygentry.wx.web;

import com.henrygentry.wx.common.config.WechatConfiguration;
import com.henrygentry.wx.common.utils.CheckSignatureUtil;
import com.henrygentry.wx.common.utils.MessageParseUtil;
import com.henrygentry.wx.common.utils.XstreamUtil;
import com.henrygentry.wx.service.messagehandler.MessageService;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信平台入口控制器
 *
 * @author zhouhaofeng
 * @version 2018/2/28
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RestController
@EnableAutoConfiguration
public class WechatOpenController
{
	private static final Logger logger = LoggerFactory.getLogger (WechatOpenController.class);

	/**
	 * 微信公众号相关配置
	 */
	@Autowired
	private WechatConfiguration wechatConfiguration;

	@Autowired
	private MessageService messageService;

	/**
	 * 消息加密方式（默认为aes）
	 */
	private static final String ENCTYPE = "aes";

	/**
	 * 微信服务器验证
	 *
	 * @param signature 微信加密签名
	 * @param timestamp 时间戳
	 * @param nonce     随机数
	 * @param echostr   随机字符串
	 * @return 响应字符串
	 */
	@GetMapping ("/open")
	public String validateWechat (String signature, String timestamp, String nonce, String echostr)
	{
		logger.info (">>>>>>>>>>>>>>>>>>>>validate.....");
		//验证处理
		logger.info (">>>>>>>>>>>>>>>>>>>>signature : {}", signature);
		logger.info (">>>>>>>>>>>>>>>>>>>>timestamp : {}", timestamp);
		logger.info (">>>>>>>>>>>>>>>>>>>>nonce : {}", nonce);
		logger.info (">>>>>>>>>>>>>>>>>>>>echostr : {}", echostr);
		if (CheckSignatureUtil.checkSignature (timestamp, nonce, wechatConfiguration.getToken (), signature))
		{
			logger.info (">>>>>>>>>>>>>>>>>>>>validate success......");
			return echostr;
		}
		else
		{
			return "fail";
		}
	}

	/**
	 * 获取微信推送信息（用户消息，推送事件等）
	 *
	 * @param request      HTTP请求
	 * @param signature    微信加密签名
	 * @param timestamp    时间戳
	 * @param nonce        随机数
	 * @param encType      加密类型
	 * @param msgSignature 消息体签名
	 * @return 响应字符串
	 */
	@PostMapping (value = "/open", consumes = "text/xml; charset=UTF-8", produces = "application/xml; charset=UTF-8")
	public String getWechatMessage (HttpServletRequest request, @RequestParam ("signature") String signature,
			@RequestParam ("timestamp") String timestamp, @RequestParam ("nonce") String nonce,
			@RequestParam (name = "encrypt_type", required = false) String encType,
			@RequestParam (name = "msg_signature", required = false) String msgSignature)
	{
		//校验请求是否来自微信服务器
		logger.debug (">>>>>>>>>>>>>>>>>>>>encrypt_type : {}", encType);
		logger.debug (">>>>>>>>>>>>>>>>>>>>msg_signature : {}", msgSignature);

		if (! CheckSignatureUtil.checkSignature (timestamp, nonce, wechatConfiguration.getToken (), signature))
		{
			return "fail";
		}

		try
		{
			request.setCharacterEncoding ("utf-8");
			//若消息传输方式为aes加密方式
			if (ENCTYPE.equals (encType))
			{
				logger.debug (">>>>>>>>>>>>>>>>>>>>token:{}", wechatConfiguration.getToken ());
				logger.debug (">>>>>>>>>>>>>>>>>>>>encodingKey:{}", wechatConfiguration.getEncodingKey ());
				logger.debug (">>>>>>>>>>>>>>>>>>>>appid:{}", wechatConfiguration.getAppID ());

				//初始化
				WXBizMsgCrypt wxBizMsgCrypt = new WXBizMsgCrypt (wechatConfiguration.getToken (),
						wechatConfiguration.getEncodingKey (), wechatConfiguration.getAppID ());

				//解密
				String plainText = wxBizMsgCrypt
						.decryptMsg (msgSignature, timestamp, nonce, MessageParseUtil.parseXMlMessage (request));

				//加密返回
				return wxBizMsgCrypt.encryptMsg (messageService.messageProcess (plainText), timestamp, nonce);
			}
			//明文传输
			else
			{
				return messageService.messageProcess (MessageParseUtil.parseXMlMessage (request));
			}
		}
		catch (Exception e)
		{
			logger.error ("error:", e);
			logger.error (">>>>>>>>>>>>>>>>>>>>we get a exception : {}", e.getMessage ());
			return "";
		}
	}
}
