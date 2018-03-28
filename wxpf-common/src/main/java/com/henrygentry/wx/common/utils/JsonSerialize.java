/**
 * 文 件 名:  JsonSerialize
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhouhaofeng
 * 修改时间:  2017/11/17
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.henrygentry.wx.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.henrygentry.wx.common.exception.SerializeException;

import java.io.IOException;

/**
 * JSON工具类
 *
 * @author zhouhaofeng
 * @version 2017/11/17
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class JsonSerialize
{
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper ()
			.configure (DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true)
			.configure (DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
			.configure (DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true)
			.configure (DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, true)
			.configure (DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true)
			.configure (SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

	public static String toJson (Object obj)
	{
		if (null == obj)
		{
			return null;
		}
		try
		{
			OBJECT_MAPPER.setSerializationInclusion (JsonInclude.Include.NON_NULL);
			return OBJECT_MAPPER.writeValueAsString (obj);
		}
		catch (JsonProcessingException e)
		{
			throw new SerializeException ("9999", String.format ("object to json error. %s", e));
		}
	}

	/**
	 * json字符串转java对象
	 *
	 * @param json  json字符串
	 * @param clazz java class类
	 * @param <T>   java类型
	 * @return 对象
	 */
	public static <T> T parseJson (String json, Class<T> clazz)
	{
		T result;

		if ((null == json) || ("".equals (json)))
		{
			return null;
		}

		try
		{
			result = OBJECT_MAPPER.readValue (json, clazz);
		}
		catch (Exception e)
		{
			throw new SerializeException ("9999", String.format ("json parse object error. %s", e));
		}
		return result;
	}

	public static <T> T parseJson (String json, JavaType type)
	{
		try
		{
			return OBJECT_MAPPER.readValue (json, type);
		}
		catch (IOException e)
		{
			throw new SerializeException ("9999", "json parse object error.");
		}
	}
}
