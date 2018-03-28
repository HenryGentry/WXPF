/**
 * 文 件 名:  SerializeException
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhouhaofeng
 * 修改时间:  2017/11/17
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.henrygentry.wx.common.exception;

/**
 * 序列化异常类（自定义异常）
 *
 * @author zhouhaofeng
 * @version 2017/11/17
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class SerializeException extends RuntimeException
{
	private String code;

	private String msg;

	public SerializeException (String code, String msg)
	{
		this.code = code;
		this.msg = msg;
	}

	public SerializeException (Throwable cause, String code, String msg)
	{
		this.code = code;
		this.msg = msg;
	}
}
