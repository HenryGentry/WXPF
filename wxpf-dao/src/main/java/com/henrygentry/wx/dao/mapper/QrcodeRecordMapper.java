/**
 * 文 件 名:  QrcodeRecordMapper
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhouhaofeng
 * 修改时间:  2018/3/1
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.henrygentry.wx.dao.mapper;

import com.henrygentry.wx.dao.entity.QrcodeRecordDO;

/**
 * 用户二维码记录mapper
 *
 * @author zhouhaofeng
 * @version 2018/3/1
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface QrcodeRecordMapper
{
	/**
	 * 新增用户二维码记录
	 *
	 * @param qrcodeRecordDO 二维码记录DO
	 */
	void insertRecord (QrcodeRecordDO qrcodeRecordDO);
}
