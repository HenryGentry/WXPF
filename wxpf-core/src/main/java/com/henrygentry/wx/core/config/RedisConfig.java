/**
 * 文 件 名:  RedisConfig
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhouhaofeng
 * 修改时间:  2017/11/21 0021
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.henrygentry.wx.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * redis配置类
 *
 * @author zhouhaofeng
 * @version 2017/11/21 0021
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Configuration
public class RedisConfig
{
	@Autowired
	private RedisConnectionFactory redisConnectionFactory;

	/**
	 * 实例化 RedisTemplate 对象
	 */
	@Bean
	public RedisTemplate<String, Object> functionDomainRedisTemplate ()
	{
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<> ();
		this.initRedisTemplate (redisTemplate, redisConnectionFactory);
		return redisTemplate;
	}

	/**
	 * 序列化设置
	 */
	private void initRedisTemplate (RedisTemplate<String, Object> redisTemplate, RedisConnectionFactory factory)
	{
		redisTemplate.setKeySerializer (new StringRedisSerializer ());
		redisTemplate.setHashKeySerializer (new StringRedisSerializer ());
		redisTemplate.setHashValueSerializer (new JdkSerializationRedisSerializer ());
		redisTemplate.setValueSerializer (new JdkSerializationRedisSerializer ());
		redisTemplate.setConnectionFactory (factory);
	}

	@Bean
	public HashOperations<String, String, Object> hashOperations (RedisTemplate<String, Object> redisTemplate)
	{
		return redisTemplate.opsForHash ();
	}

	@Bean
	public ValueOperations<String, Object> valueOperations (RedisTemplate<String, Object> redisTemplate)
	{
		return redisTemplate.opsForValue ();
	}

	@Bean
	public ListOperations<String, Object> listOperations (RedisTemplate<String, Object> redisTemplate)
	{
		return redisTemplate.opsForList ();
	}

	@Bean
	public SetOperations<String, Object> setOperations (RedisTemplate<String, Object> redisTemplate)
	{
		return redisTemplate.opsForSet ();
	}

	@Bean
	public ZSetOperations<String, Object> zSetOperations (RedisTemplate<String, Object> redisTemplate)
	{
		return redisTemplate.opsForZSet ();
	}
}