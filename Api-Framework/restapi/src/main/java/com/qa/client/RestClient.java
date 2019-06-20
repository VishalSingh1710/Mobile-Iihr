package com.qa.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
public class RestClient {

	//1.Get method without headers
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException{
		//create client connection 
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//create get connection with this url//http get request 
		HttpGet httpget = new HttpGet(url);
		//it wil exexcute //eg - click on send(hit the url) 
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpget);	
		return closeableHttpResponse;
	}
	
	
	
	
	///2. Get Method with headers
	public CloseableHttpResponse get(String url,HashMap<String, String> headerMap) throws ClientProtocolException, IOException{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		
		for(Map.Entry<String, String> entry : headerMap.entrySet()){
			httpget.addHeader(entry.getValue(),entry.getKey());
		}
		
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpget);
		return closeableHttpResponse;
		
	}
	
	
	
	////3. POST METHOD
	public CloseableHttpResponse post(String url, String entity, HashMap<String, String> headerMap) throws ClientProtocolException, IOException{
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);////////http post request
		httpPost.setEntity(new StringEntity(entity));///////for data(Payload)
		
		/////for header
		for(Map.Entry<String, String> entry: headerMap.entrySet()){
			httpPost.addHeader(entry.getKey(),entry.getValue());
		}
		
		CloseableHttpResponse  closeableHttpResponse = httpClient.execute(httpPost);
		 return closeableHttpResponse;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}