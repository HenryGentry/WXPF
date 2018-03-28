/**
 * 文 件 名:  Video
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
 * 视频实体类
 *
 * @author zhouhaofeng
 * @version 2017/11/23
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
public class Video
{
	/**
	 * 通过素材管理中的接口上传多媒体文件，得到的id
	 */
	@XStreamAlias ("MediaId")
	private String mediaId;

	/**
	 * 视频消息的标题
	 */
	@XStreamAlias ("Title")
	private String title;

	/**
	 * 视频消息的描述
	 */
	@XStreamAlias ("Description")
	private String description;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("Video{");
		sb.append ("mediaId='").append (mediaId).append ('\'');
		sb.append (", title='").append (title).append ('\'');
		sb.append (", description='").append (description).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
