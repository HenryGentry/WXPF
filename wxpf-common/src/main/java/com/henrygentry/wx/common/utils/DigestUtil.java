/**
 * 文 件 名:  DigestUtil
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhouhaofeng
 * 修改时间:  2017/11/17
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.henrygentry.wx.common.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具类
 *
 * @author zhouhaofeng
 * @version 2017/11/17
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class DigestUtil
{
	/**
	 * SHA1加密
	 *
	 * @param decript 要加密的字符串
	 * @return 加密后的字符串
	 */
	public static String sHA1 (String decript)
	{
		try
		{
			MessageDigest digest = MessageDigest.getInstance ("SHA-1");
			digest.update (decript.getBytes ());
			byte[] messageDigest = digest.digest ();
			StringBuilder hexString = new StringBuilder ();
			for (byte m : messageDigest)
			{
				String shaHex = Integer.toHexString (m & 0xFF);
				if (shaHex.length () < 2)
				{
					hexString.append (0);
				}
				hexString.append (shaHex);
			}
			return hexString.toString ();
		}
		catch (NoSuchAlgorithmException e)
		{
			return "";
		}
	}

	/**
	 * MD5加密
	 *
	 * @param decript 加密前的字符串
	 * @return 加密后的字符串
	 */
	public static String md5 (String decript)
	{
		try
		{
			MessageDigest md = MessageDigest.getInstance ("MD5");
			md.update (decript.getBytes ());
			return new BigInteger (1, md.digest ()).toString (16);
		}
		catch (Exception e)
		{
			return "";
		}
	}
}
