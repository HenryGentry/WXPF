/**
 * 文 件 名:  WechatUrlConstants
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhouhaofeng
 * 修改时间:  2017/11/20
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.henrygentry.wx.common.constants;

/**
 * 微信接口地址
 *
 * @author zhouhaofeng
 * @version 2017/11/20
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface WechatUrlConstants
{
	/**
	 * 获取微信Token URL
	 */
	String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";

	/**
	 * 获取用户信息URL
	 */
	String GET_USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s&lang=zh_CN";

	/**
	 * 获取js_api_ticket URL
	 */
	String GET_JS_API_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=%s&type=jsapi";

	/**
	 * 获取菜单列表 URL
	 */
	String GET_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=%s";

	/**
	 * 创建菜单 URL
	 */
	String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s";

	/**
	 * 获取素材列表 URL
	 */
	String BATCH_GET_MATERIAL_URL = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=%s";

	/**
	 * 查询指定素材 URL
	 */
	String GET_MATERIAL_URL = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=%s";

	/**
	 * 创建二维码 URL
	 */
	String CREATE_QRCODE_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=%s";

	/**
	 * 获取二维码图片地址 URL
	 */
	String SHOW_QRCODE_URL = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=%s";

	/**
	 * 客服发送消息 URL
	 */
	String CUSTOM_SEND_MESSAGE_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=%s";
}
