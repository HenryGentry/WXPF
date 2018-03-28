/**
 * 文 件 名:  Music
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
 * 音乐实体类
 *
 * @author zhouhaofeng
 * @version 2017/11/23
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
public class Music
{
	@XStreamAlias ("Title")
	private String title;

	@XStreamAlias ("Description")
	private String description;

	@XStreamAlias ("MusicUrl")
	private String musicUrl;

	@XStreamAlias ("HQMusicUrl")
	private String hqMusicUrl;

	@XStreamAlias ("ThumbMediaId")
	private String thumbMediaId;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("Music{");
		sb.append ("title='").append (title).append ('\'');
		sb.append (", description='").append (description).append ('\'');
		sb.append (", musicUrl='").append (musicUrl).append ('\'');
		sb.append (", hqMusicUrl='").append (hqMusicUrl).append ('\'');
		sb.append (", thumbMediaId='").append (thumbMediaId).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
