/**
 * 文 件 名:  ServletInitializer
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhouhaofeng
 * 修改时间:  2017/11/21
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.henrygentry.wx.core.boot;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * servlet初始化类
 *
 * @author zhouhaofeng
 * @version 2017/11/21
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ServletInitializer extends SpringBootServletInitializer
{
	@Override
	protected SpringApplicationBuilder configure (SpringApplicationBuilder application)
	{
		return application.sources (BootApplication.class);
	}
}
