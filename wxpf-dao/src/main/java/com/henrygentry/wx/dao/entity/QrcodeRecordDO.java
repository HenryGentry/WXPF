/**
 * 文 件 名:  QrcodeRecordDO
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhouhaofeng
 * 修改时间:  2018/3/1
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.henrygentry.wx.dao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 二维码保存记录对象
 *
 * @author zhouhaofeng
 * @version 2018/3/1
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
@ToString
public class QrcodeRecordDO
{
	private String objectId;

	private String mediaId;
}
