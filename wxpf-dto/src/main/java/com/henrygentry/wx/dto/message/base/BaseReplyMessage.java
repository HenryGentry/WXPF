/**
 * 文 件 名:  BaseReplyMessage
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhouhaofeng
 * 修改时间:  2017/11/20
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.henrygentry.wx.dto.message.base;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import lombok.Getter;
import lombok.Setter;

/**
 * 回复信息基础父类
 *
 * @author zhouhaofeng
 * @version 2017/11/20
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
public class BaseReplyMessage
{
	@XStreamAlias ("ToUserName")
	private String toUserName;

	@XStreamAlias ("FromUserName")
	private String fromUserName;

	@XStreamAlias ("CreateTime")
	private String createTime;

	@XStreamAlias ("MsgType")
	private String msgType;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("BaseReplyMessage{");
		sb.append ("toUserName='").append (toUserName).append ('\'');
		sb.append (", fromUserName='").append (fromUserName).append ('\'');
		sb.append (", createTime='").append (createTime).append ('\'');
		sb.append (", msgType='").append (msgType).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}

	public String toXml ()
	{
		XStream xStream = new XStream (new DomDriver ("UTF-8", new XmlFriendlyNameCoder ("-_", "_")));
		xStream.processAnnotations (this.getClass ());
		return xStream.toXML (this);
	}
}
