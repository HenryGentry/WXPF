/**
 * 文 件 名:  MsgTypeConstants
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
 * 消息类型常量类
 *
 * @author zhouhaofeng
 * @version 2017/11/20
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface MsgTypeConstants
{
	/**
	 * 文本消息类型
	 */
	String TEXT_MSG = "text";

	/**
	 * 图片消息类型
	 */
	String IMAGE_MSG = "image";

	/**
	 * 语音消息类型
	 */
	String VOICE_MSG = "voice";

	/**
	 * 视频消息类型
	 */
	String VIDEO_MSG = "video";

	/**
	 * 音乐消息类型
	 */
	String MUSIC_MSG = "music";

	/**
	 * 图文消息类型
	 */
	String NEWS_MSG = "news";

	/**
	 * 事件消息类型（事件主要有关注事件，取消关注事件，扫描带二维码参数事件等等）
	 */
	String EVENT_MSG = "event";

	/**
	 * 事件类型
	 */
	interface Event
	{
		/**
		 * 关注事件
		 */
		String SUBSCRIBE_EVENT = "subscribe";

		/**
		 * 取消关注事件
		 */
		String UNSUBSCRIBE_EVENT = "unsubscribe";

		/**
		 * 扫描带参数二维码事件
		 */
		String SCAN_EVENT = "SCAN";

		/**
		 * 自定义菜单事件
		 */
		String CLICK_EVENT = "CLICK";
	}
}
