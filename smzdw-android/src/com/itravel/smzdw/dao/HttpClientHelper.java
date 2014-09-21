package com.itravel.smzdw.dao;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import android.util.Log;

public final class HttpClientHelper {
	private final HttpClient client = new DefaultHttpClient();
	private static final String HOST = "http://115.28.129.120";
	
	private static final class HttpClientHelperHolder {
		private static HttpClientHelper instance = new HttpClientHelper();
		
	}
	private HttpClientHelper(){
	}
	public static final HttpClientHelper getInstance(){
		return HttpClientHelperHolder.instance;
	}
	
	
	public HttpResponse executeGet(String requestPath,List<NameValuePair> queryParams){
		
		try {
			HttpGet httpGet = null;
			if(queryParams!=null){
				String query = URLEncodedUtils.format(queryParams, HTTP.UTF_8);
				httpGet = new HttpGet(HOST+requestPath+"?"+query);
			}
			else {
				httpGet = new HttpGet(HOST+requestPath);
			}
			return this.client.execute(httpGet);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public NameValuePair createQueryParam(String key,Object value){
		return new BasicNameValuePair(key,String.valueOf(value));
	}
	
}
