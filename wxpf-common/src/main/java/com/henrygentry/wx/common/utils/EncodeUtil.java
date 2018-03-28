/**
 * 文 件 名:  EncodeUtil
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhouhaofeng
 * 修改时间:  2017/9/26
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.henrygentry.wx.common.utils;

import java.util.Base64;

/**
 * base64编码解码工具类
 *
 * @author zhouhaofeng
 * @version 2017/9/26
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class EncodeUtil
{
	/**
	 * base64编码
	 *
	 * @param str base64编码前的字符串
	 * @return base64编码后的字符串
	 */
	public static String base64Encode (String str)
	{
		return Base64.getEncoder ().encodeToString (str.getBytes ());
	}

	/**
	 * base64编码
	 *
	 * @param bytes base64编码前byte
	 * @return base64编码后的字符串
	 */
	public static String base64Encode (byte[] bytes)
	{
		return Base64.getEncoder ().encodeToString (bytes);
	}

	/**
	 * base64解码
	 *
	 * @param base64Str base64解码前的字符串
	 * @return base64解码后的字符串
	 */
	public static String base64Decode (String base64Str)
	{
		byte[] strByte = Base64.getDecoder ().decode (base64Str);
		return new String (strByte);
	}

	/**
	 * base64解码
	 *
	 * @param base64Str base64解码前的字符串
	 * @return base64解码后的byte数组
	 */
	public static byte[] base64DecodeToByte (String base64Str)
	{
		return Base64.getDecoder ().decode (base64Str);
	}
}
