/**
 * 文 件 名:  SpringUtil
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhouhaofeng
 * 修改时间:  2017/11/20 0020
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.henrygentry.wx.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * spring获取bean工具
 *
 * @author zhouhaofeng
 * @version 2017/11/20 0020
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Component
public class SpringUtil implements ApplicationContextAware
{
	private static final Logger logger = LoggerFactory.getLogger (SpringUtil.class);

	private static ApplicationContext applicationContext = null;

	@Override
	public void setApplicationContext (ApplicationContext applicationContext) throws BeansException
	{
		logger.debug (">>>>>>>>>>>>>>>>>>>>init ApplicationContext......");
		if (SpringUtil.applicationContext == null)
		{
			SpringUtil.applicationContext = applicationContext;
		}
	}

	/**
	 * 获取applicationContext
	 *
	 * @return applicationContext
	 */
	private static ApplicationContext getApplicationContext ()
	{
		return applicationContext;
	}

	/**
	 * 通过name获取bean
	 *
	 * @param name bean的name
	 * @return 对应bean的对象
	 */
	public static Object getBean (String name)
	{
		return getApplicationContext ().getBean (name);
	}

	/**
	 * 通过class获取Bean
	 *
	 * @param clazz class类
	 * @param <T>   泛型
	 * @return T
	 */
	public static <T> T getBean (Class<T> clazz)
	{
		return getApplicationContext ().getBean (clazz);
	}

	/**
	 * 通过name,以及Clazz返回指定的Bean
	 *
	 * @param name  bean的name
	 * @param clazz 类的class
	 * @param <T>   T
	 * @return T
	 */
	public static <T> T getBean (String name, Class<T> clazz)
	{
		return getApplicationContext ().getBean (name, clazz);
	}
}