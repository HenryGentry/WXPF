/**
 * 文 件 名:  ReplyNewsMessage
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
import com.henrygentry.wx.dto.message.base.media.Article;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 图文消息回复DTO
 *
 * @author zhouhaofeng
 * @version 2017/11/23
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
@XStreamAlias ("xml")
public class ReplyNewsMessage extends BaseReplyMessage implements Serializable
{
	private static final long serialVersionUID = - 1L;

	/**
	 * 多条图文消息信息，默认第一个item为大图,
	 * 注意，如果图文数超过8，则将会无响应
	 */
	@XStreamAlias ("Articles")
	private List<Article> articles;

	/**
	 * 图文消息个数，限制为8条以内
	 */
	@XStreamAlias ("ArticleCount")
	private Integer articleCount;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("ReplyNewsMessage{");
		sb.append ("articles=").append (articles);
		sb.append (", articleCount=").append (articleCount);
		sb.append ('}');
		return sb.toString ();
	}
}
