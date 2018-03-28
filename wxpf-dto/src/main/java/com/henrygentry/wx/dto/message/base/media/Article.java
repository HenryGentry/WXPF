/**
 * 文 件 名:  Article
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhouhaofeng
 * 修改时间:  2017/11/23
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.henrygentry.wx.dto.message.base.media;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;

/**
 * 图文实体类
 *
 * @author zhouhaofeng
 * @version 2017/11/23
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
@XStreamAlias ("item")
public class Article
{
	/**
	 * 图文消息标题
	 */
	@XStreamAlias ("Title")
	private String title;

	/**
	 * 图文消息描述
	 */
	@XStreamAlias ("Description")
	private String description;

	/**
	 * 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
	 */
	@XStreamAlias ("PicUrl")
	private String picUrl;

	/**
	 * 点击图文消息跳转链接
	 */
	@XStreamAlias ("Url")
	private String url;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("Article{");
		sb.append ("title='").append (title).append ('\'');
		sb.append (", description='").append (description).append ('\'');
		sb.append (", picUrl='").append (picUrl).append ('\'');
		sb.append (", url='").append (url).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
