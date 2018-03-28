/**
 * 文 件 名:  DataSource
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhouhaofeng
 * 修改时间:  2017/9/15
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.henrygentry.wx.core.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

/**
 * 数据源配置
 *
 * @author zhouhaofeng
 * @version 2017/9/15
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
@ToString
@Configuration
@ConfigurationProperties (prefix = "spring.datasource")
public class DataSource
{
	private String url;

	private String username;

	private String password;

	private String driverClassName;

	private String maxActive;

	private String initialSize;

	private String maxWait;

	private String minIdle;

	private String timeBetweenEvictionRunsMillis;

	private String minEvictableIdleTimeMillis;

	@Bean
	public DruidDataSource druidDataSource () throws SQLException
	{
		DruidDataSource dataSource = new DruidDataSource ();
		dataSource.setUrl (url);
		dataSource.setDriverClassName (driverClassName);
		dataSource.setPassword (password);
		dataSource.setUsername (username);
		dataSource.setMaxActive (Integer.valueOf (maxActive));
		dataSource.setMinIdle (Integer.valueOf (minIdle));
		dataSource.setTimeBetweenEvictionRunsMillis (new Long (timeBetweenEvictionRunsMillis));
		dataSource.setMinEvictableIdleTimeMillis (new Long (minEvictableIdleTimeMillis));
		return dataSource;
	}
}
