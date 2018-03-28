/**
 * 文 件 名:  WechatInMessage
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhouhaofeng
 * 修改时间:  2017/11/18 0018
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.henrygentry.wx.dto.message.req;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;

/**
 * 微信推送信息DTO
 *
 * @author zhouhaofeng
 * @version 2017/11/18 0018
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
@XStreamAlias ("xml")
public class WechatInMessage
{
	private static final long serialVersionUID = 1L;

	/**
	 * 开发者微信号
	 */
	@XStreamAlias ("ToUserName")
	private String toUserName;

	/**
	 * 发送方帐号（一个OpenID）
	 */
	@XStreamAlias ("FromUserName")
	private String fromUserName;

	/**
	 * 消息创建时间（整型）
	 */
	@XStreamAlias ("CreateTime")
	private String createTime;

	/**
	 * 消息类型
	 */
	@XStreamAlias ("MsgType")
	private String msgType;

	/**
	 * 文本消息内容
	 */
	@XStreamAlias ("Content")
	private String content;

	/**
	 * 消息id，64位整型
	 */
	@XStreamAlias ("MsgId")
	private String msgId;

	/**
	 * 图片链接（由系统生成）
	 */
	@XStreamAlias ("PicUrl")
	private String picUrl;

	/**
	 * 图片消息媒体id/语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
	 */
	@XStreamAlias ("MediaId")
	private String mediaId;

	/**
	 * 语音格式，如amr，speex等
	 */
	@XStreamAlias ("Format")
	private String format;

	/**
	 * 语音识别结果，UTF8编码
	 */
	@XStreamAlias ("Recognition")
	private String recognition;

	/**
	 * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
	 */
	@XStreamAlias ("ThumbMediaId")
	private String thumbMediaId;

	/**
	 * 地理位置维度
	 */
	@XStreamAlias ("Location_X")
	private String locationX;

	/**
	 * 地理位置经度
	 */
	@XStreamAlias ("Location_Y")
	private String locationY;

	/**
	 * 地图缩放大小
	 */
	@XStreamAlias ("Scale")
	private String scale;

	/**
	 * 地理位置信息
	 */
	@XStreamAlias ("Label")
	private String label;

	/**
	 * 消息标题
	 */
	@XStreamAlias ("Title")
	private String title;

	/**
	 * 消息描述
	 */
	@XStreamAlias ("Description")
	private String description;

	/**
	 * 消息链接
	 */
	@XStreamAlias ("Url")
	private String url;

	/**
	 * 事件类型，subscribe(订阅)、unsubscribe(取消订阅)
	 */
	@XStreamAlias ("Event")
	private String event;

	/**
	 * 1、用户未关注时，qrscene_为前缀，后面为二维码的参数值（EVENT=subscribe）
	 * 2、用户已经关注，则是一个32位无符号整数，即创建二维码时的二维码scene_id（EVENT=SCAN）
	 * 3、事件KEY值，与自定义菜单接口中KEY值对应（EVENT=CLICK）
	 * 4、事件KEY值，设置的跳转URL(Event=VIEW)
	 */
	@XStreamAlias ("EventKey")
	private String eventKey;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("WechatInMessage{");
		sb.append ("toUserName='").append (toUserName).append ('\'');
		sb.append (", fromUserName='").append (fromUserName).append ('\'');
		sb.append (", createTime='").append (createTime).append ('\'');
		sb.append (", msgType='").append (msgType).append ('\'');
		sb.append (", content='").append (content).append ('\'');
		sb.append (", msgId='").append (msgId).append ('\'');
		sb.append (", picUrl='").append (picUrl).append ('\'');
		sb.append (", mediaId='").append (mediaId).append ('\'');
		sb.append (", format='").append (format).append ('\'');
		sb.append (", recognition='").append (recognition).append ('\'');
		sb.append (", thumbMediaId='").append (thumbMediaId).append ('\'');
		sb.append (", locationX='").append (locationX).append ('\'');
		sb.append (", locationY='").append (locationY).append ('\'');
		sb.append (", scale='").append (scale).append ('\'');
		sb.append (", label='").append (label).append ('\'');
		sb.append (", title='").append (title).append ('\'');
		sb.append (", description='").append (description).append ('\'');
		sb.append (", url='").append (url).append ('\'');
		sb.append (", event='").append (event).append ('\'');
		sb.append (", eventKey='").append (eventKey).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}