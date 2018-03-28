/**
 * 文 件 名:  BootApplication
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhouhaofeng
 * 修改时间:  2018/2/28
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.henrygentry.wx.core.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 项目启动类
 *
 * @author zhouhaofeng
 * @version 2018/2/28
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@SpringBootApplication
@ComponentScan ("com.henrygentry.wx")
public class BootApplication
{
	public static void main (String[] args)
	{
		SpringApplication.run (BootApplication.class, args);
	}
}
