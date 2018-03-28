/**
 * 文 件 名:  MessageParseUtil
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhouhaofeng
 * 修改时间:  2017/11/22
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.henrygentry.wx.common.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 微信消息处理工具类
 *
 * @author zhouhaofeng
 * @version 2017/11/22
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class MessageParseUtil
{
	/**
	 * 获取请求报文
	 *
	 * @param request HTTP请求
	 * @return 请求报文
	 */
	public static String parseXMlMessage (HttpServletRequest request) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader (request.getInputStream (),"UTF-8"));
		StringBuilder sb = new StringBuilder ();
		String line ;
		while ((line = in.readLine()) != null) {
			sb.append(line);
		}
		in.close ();
		return sb.toString ();
	}
}
