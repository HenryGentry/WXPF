/**
 * 文 件 名:  CheckSignatureUtil
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhouhaofeng
 * 修改时间:  2017/11/17
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.henrygentry.wx.common.utils;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 验证签名合法性工具类
 *
 * @author zhouhaofeng
 * @version 2017/11/17
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class CheckSignatureUtil
{
	/**
	 * 验证微信签名合法性，合法返回true，否则返回false
	 *
	 * @param timestamp 时间戳
	 * @param nonce     随机数
	 * @param token     微信上填的token
	 * @param signature 微信加密签名
	 * @return boolean 是否合法
	 */
	public static boolean checkSignature (String timestamp, String nonce, String token, String signature)
	{
		if (StringUtils.isEmpty (timestamp) || StringUtils.isEmpty (nonce) || StringUtils.isEmpty (token) || StringUtils
				.isEmpty (signature))
		{
			return false;
		}
		List<String> sortList = new ArrayList<> ();
		sortList.add (timestamp);
		sortList.add (nonce);
		sortList.add (token);
		Collections.sort (sortList);
		String result = sortList.get (0) + sortList.get (1) + sortList.get (2);
		return DigestUtil.sHA1 (result).equals (signature);
	}
}
