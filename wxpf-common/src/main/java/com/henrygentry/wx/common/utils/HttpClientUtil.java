/**
 * 文 件 名:  HttpClientUtil
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhouhaofeng
 * 修改时间:  2017/11/17
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.henrygentry.wx.common.utils;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.util.Map;

/**
 * httpclient工具类
 *
 * @author zhouhaofeng
 * @version 2017/11/17
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class HttpClientUtil
{
	private static final Logger logger = LoggerFactory.getLogger (HttpClientUtil.class);

	private static HttpClientUtil httpClientUtil;

	private CloseableHttpClient httpClient;

	private HttpClientUtil ()
	{
		ConnectionConfig defaultConnectionConfig = ConnectionConfig.custom ().setCharset (Consts.UTF_8).build ();
		PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager ();
		// 最大请求数100
		connectionManager.setMaxTotal (500);
		// 单个地址最大请求数20
		connectionManager.setDefaultMaxPerRoute (20);
		connectionManager.setDefaultConnectionConfig (defaultConnectionConfig);
		// 配置https并生成HttpClient对象
		SSLContext sslcontext = null;
		try
		{
			//创建一下不带证书的SSL上下文
			sslcontext = SSLContexts.custom ().loadTrustMaterial (null).build ();
		}
		catch (Exception e)
		{
			e.printStackTrace ();
			logger.error (">>>>>>>>>>>>>>>>>>>>init httpClient exception : {}", e.getMessage ());
		}

		//默认信任HTTPS请求的证书
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory (sslcontext,
				SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		httpClient = HttpClients.custom ().setConnectionManager (connectionManager).setSSLSocketFactory (sslsf)
				.build ();
	}

	/**
	 * 获取工具类单例
	 *
	 * @return HttpClient对象
	 */
	public static HttpClientUtil getInstance ()
	{
		if (httpClientUtil == null)
		{
			httpClientUtil = new HttpClientUtil ();
		}
		return httpClientUtil;
	}

	/**
	 * post发送xml报文
	 *
	 * @param url     请求地址
	 * @param xml     xml报文
	 * @param headers 请求头
	 * @return 响应报文
	 */
	public String postXML (String url, String xml, Map<String, String> headers)
	{
		CloseableHttpResponse response = null;
		HttpPost httpPost = new HttpPost (url);
		RequestConfig requestConfig = RequestConfig.custom ().setSocketTimeout (10 * 1000).setConnectTimeout (10 * 1000)
				.setConnectionRequestTimeout (10 * 1000).build ();
		httpPost.setConfig (requestConfig);
		//设置请求头
		if (headers != null)
		{
			headers.forEach ((k, v) -> httpPost.addHeader (k, v));
		}
		// 设置请求体
		StringEntity xmlEntity = new StringEntity (xml, ContentType.create ("application/xml", Consts.UTF_8));
		httpPost.setEntity (xmlEntity);
		logger.debug (">>>>>>>>>>>>>>>>>>>>Request xml :{}", xml);
		logger.debug (">>>>>>>>>>>>>>>>>>>>Request url :{}", url);
		try
		{
			response = httpClient.execute (httpPost);
			if (HttpStatus.SC_OK == response.getStatusLine ().getStatusCode ())
			{
				HttpEntity entity = response.getEntity ();
				if (entity != null)
				{
					String responseXML = EntityUtils.toString (entity, "UTF-8");
					logger.debug (">>>>>>>>>>>>>>>>>>>>Response xml :{}", responseXML);
					return responseXML;
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace ();
			logger.error (">>>>>>>>>>>>>>>>>>>>post xml exception :{}", e.getMessage ());
			return "";
		}
		finally
		{
			if (response != null)
			{
				try
				{
					response.close ();
				}
				catch (Exception e)
				{
					logger.error (">>>>>>>>>>>>>>>>>>>>Close Http Response Error:" + e);
				}

			}
		}
		return "";
	}

	/**
	 * post发送json报文
	 *
	 * @param url     请求地址
	 * @param json    请求报文
	 * @param headers 请求头
	 * @return 响应报文
	 */
	public String postJSON (String url, String json, Map<String, String> headers)
	{
		CloseableHttpResponse response = null;
		HttpPost httpPost = new HttpPost (url);
		RequestConfig requestConfig = RequestConfig.custom ().setSocketTimeout (10 * 1000).setConnectTimeout (10 * 1000)
				.setConnectionRequestTimeout (10 * 1000).build ();
		httpPost.setConfig (requestConfig);
		//设置请求头
		if (headers != null)
		{
			headers.forEach ((k, v) -> httpPost.addHeader (k, v));
		}
		// 设置请求体
		StringEntity jsonEntity = new StringEntity (json, ContentType.create ("application/json", Consts.UTF_8));
		httpPost.setEntity (jsonEntity);
		logger.debug (">>>>>>>>>>>>>>>>>>>>Request json :{}", json);
		logger.debug (">>>>>>>>>>>>>>>>>>>>Request url :{}", url);
		try
		{
			response = httpClient.execute (httpPost);
			if (HttpStatus.SC_OK == response.getStatusLine ().getStatusCode ())
			{
				HttpEntity entity = response.getEntity ();
				if (entity != null)
				{
					String responseJson = EntityUtils.toString (entity, "UTF-8");
					logger.debug (">>>>>>>>>>>>>>>>>>>>Response json :{}", responseJson);
					return responseJson;
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace ();
			logger.error (">>>>>>>>>>>>>>>>>>>>post json exception :{}", e.getMessage ());
			return "";
		}
		finally
		{
			if (response != null)
			{
				try
				{
					response.close ();
				}
				catch (Exception e)
				{
					logger.error (">>>>>>>>>>>>>>>>>>>>Close Http Response Error:" + e);
				}

			}
		}
		return "";
	}

	/**
	 * get请求
	 *
	 * @param url     请求地址
	 * @param headers 请求头
	 * @return 响应报文
	 */
	public String getRequest (String url, Map<String, String> headers)
	{
		CloseableHttpResponse response = null;
		HttpGet httpGet = new HttpGet (url);
		RequestConfig requestConfig = RequestConfig.custom ().setSocketTimeout (10 * 1000).setConnectTimeout (10 * 1000)
				.setConnectionRequestTimeout (10 * 1000).build ();
		httpGet.setConfig (requestConfig);
		//设置请求头
		if (headers != null)
		{
			headers.forEach ((k, v) -> httpGet.addHeader (k, v));
		}
		logger.debug (">>>>>>>>>>>>>>>>>>>>get req url :{}", url);
		try
		{
			response = httpClient.execute (httpGet);
			if (HttpStatus.SC_OK == response.getStatusLine ().getStatusCode ())
			{
				return EntityUtils.toString (response.getEntity(),"utf-8");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace ();
			logger.error (">>>>>>>>>>>>>>>>>>>>get req exception :{}",e.getMessage ());
			return "";
		}
		finally
		{
			if (response != null)
			{
				try
				{
					response.close ();
				}
				catch (Exception e)
				{
					logger.error (">>>>>>>>>>>>>>>>>>>>Close Http Response Error:" + e.getMessage ());
				}

			}
		}
		return "";
	}
}
