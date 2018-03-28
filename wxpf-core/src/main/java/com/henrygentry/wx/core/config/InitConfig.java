/**
 * 文 件 名:  InitConfig
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
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * mybatis扫描路径配置
 *
 * @author zhouhaofeng
 * @version 2017/9/15
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Configuration
public class InitConfig
{
	private static final Logger logger = LoggerFactory.getLogger (InitConfig.class);

	/**
	 * 实体类包位置
	 */
	private static final String MODEL_PACKAGE_PATH = "com.henrygentry.wx.dao.entity";

	/**
	 * mybatis映射文件路径
	 */
	private static final String MAPPER_PATH = "classpath:mapper/*.xml";

	@Autowired
	private DruidDataSource dataSource;

	@Bean (name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory ()
	{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean ();
		sqlSessionFactoryBean.setDataSource (dataSource);

		//扫描实体类包
		sqlSessionFactoryBean.setTypeAliasesPackage (MODEL_PACKAGE_PATH);

		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver ();

		try
		{
			//扫描mybatis配置文件
			sqlSessionFactoryBean.setMapperLocations (resolver.getResources (MAPPER_PATH));
			return sqlSessionFactoryBean.getObject ();
		}
		catch (Exception e)
		{
			logger.error ("init database error.", e);
			e.printStackTrace ();
			throw new RuntimeException ("init database error");
		}
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate (SqlSessionFactory sqlSessionFactory)
	{
		return new SqlSessionTemplate (sqlSessionFactory);
	}

}
