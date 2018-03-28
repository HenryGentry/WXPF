/**
 * 文 件 名:  DateUtil
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhouhaofeng
 * 修改时间:  2018/1/11
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.henrygentry.wx.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期/时间工具类
 *
 * @author zhouhaofeng
 * @version 2018/1/11
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class DateUtil
{
	/**
	 * 时间戳转对应格式的时间
	 *
	 * @param timeStamps 时间戳(String)
	 * @param format     时间格式 ex:yyyy-MM-dd HH:mm:ss
	 * @return 对应格式的时间字符串
	 */
	public static String timeFormate (String timeStamps, String format)
	{
		SimpleDateFormat sdf = new SimpleDateFormat (format);
		Date date = new Date (Long.valueOf (timeStamps + "000"));
		return sdf.format (date);
	}

	/**
	 * 时间戳转对应格式的时间
	 *
	 * @param timeStamps 时间戳(long)
	 * @param format     时间格式 ex:yyyy-MM-dd HH:mm:ss
	 * @return 对应格式的时间字符串
	 */
	public static String timeFormate (long timeStamps, String format)
	{
		SimpleDateFormat sdf = new SimpleDateFormat (format);
		return sdf.format (new Date (timeStamps * 1000));
	}
}
