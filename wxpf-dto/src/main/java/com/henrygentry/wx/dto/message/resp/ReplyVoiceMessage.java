/**
 * 文 件 名:  ReplyVoiceMessage
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhouhaofeng
 * 修改时间:  2017/11/23
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.henrygentry.wx.dto.message.resp;

import com.henrygentry.wx.dto.message.base.BaseReplyMessage;
import com.henrygentry.wx.dto.message.base.media.Voice;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 语音消息回复DTO
 *
 * @author zhouhaofeng
 * @version 2017/11/23
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
@XStreamAlias ("xml")
public class ReplyVoiceMessage extends BaseReplyMessage implements Serializable
{
	private static final long serialVersionUID = - 1L;

	@XStreamAlias ("Voice")
	private Voice voice;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("ReplyVoiceMessage{");
		sb.append ("voice=").append (voice);
		sb.append ('}');
		return sb.toString ();
	}
}
