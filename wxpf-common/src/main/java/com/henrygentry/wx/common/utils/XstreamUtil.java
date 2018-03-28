/**
 * 文 件 名:  XstreamUtil
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhouhaofeng
 * 修改时间:  2017/11/22
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.henrygentry.wx.common.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * xstream工具类
 *
 * @author zhouhaofeng
 * @version 2017/11/22
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class XstreamUtil
{
	private static final Logger logger = LoggerFactory.getLogger (XstreamUtil.class);

	public static <T> T convertXmlToVo (String xml, Class<T> clazz)
	{
		try
		{
			logger.debug (">>>>>>>>>>>>>>>>>>>>convertXmlToVo xml = " + xml);
			XStream xStream = new XStream (new DomDriver ("UTF-8"));
			xStream.ignoreUnknownElements ();
			xStream.processAnnotations (clazz);
			@SuppressWarnings ("unchecked")
			T convertToObj = (T) xStream.fromXML (xml);
			return convertToObj;
		}
		catch (Exception e)
		{
			logger.error (">>>>>>>>>>>>>>>>>>>>Convert XML Error:" + e);
			return null;
		}
	}
}
