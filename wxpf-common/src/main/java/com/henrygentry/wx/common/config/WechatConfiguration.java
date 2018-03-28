/**
 * 文 件 名:  WechatConfiguration
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhouhaofeng
 * 修改时间:  2017/11/19 0019
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.henrygentry.wx.common.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 微信相关配置
 *
 * @author zhouhaofeng
 * @version 2017/11/19 0019
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
@Component
@ConfigurationProperties(prefix="wechat")
public class WechatConfiguration
{
	/**
	 * 微信开发配置时填写的token
	 */
	private String token;

	/**
	 * 消息加解密密钥(AES)
	 */
	private String encodingKey;

	/**
	 * 开发者ID
	 */
	private String appID;

	/**
	 * 开发者密码
	 */
	private String appSecret;
}