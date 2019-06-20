package com.qa.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.data.Users;

import junit.framework.Assert;

public class PostApiTest extends TestBase{
	
	TestBase testBase;
	String serviceUrl;
	String apiUrl;
	String url;
	RestClient restClient;
	CloseableHttpResponse closeableHttpResponse;
	
	
	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException{

		testBase  = new TestBase();

		//serviceUrl = "https://reqres.in/";
		//apiUrl ="api/user";
		serviceUrl = prop.getProperty("URL");
		apiUrl = prop.getProperty("serviceURL");
		url = serviceUrl + apiUrl;

	}
	
	
	@Test
	public void postApiTest() throws JsonGenerationException, JsonMappingException, IOException{
		restClient = new RestClient();
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Accept", "application/json");//Headers
		
		///Jackson Api
		ObjectMapper mapper = new ObjectMapper();
		Users users = new Users("morpous","leader");//Data   /////////Expected Users Obj ///marshalling
		
		
		//obj to json
		mapper.writeValue(new File("/home/zolipe/Desktop/Vishal/restapi/src/main/java/com/qa/data/users.json"), users);
		
		
		
		///Obj to json in String
		String usersJsonString = mapper.writeValueAsString(users);
		System.out.println(usersJsonString);
		
		
		closeableHttpResponse = restClient.post(url, usersJsonString, headerMap);
		
		
		////1. Status Code
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		Assert.assertEquals(testBase.RESPONSE_STATUS_CODE_201, statusCode);
		
		
		
		///2.Json String
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");

		
		JSONObject responseJson  = new JSONObject(responseString);
		System.out.println("The response from APi is "+responseJson);
		
		///Json to java Obj
	   Users userRestObj = mapper.readValue(responseString, Users.class);  //////Actual Users OBj after unmarshalling
	   
	   
	   //Assert.assertTrue(users.getName().equals(userRestObj.getName())); /////Compare both object
	   
	  // Assert.assertTrue(users.getJob().equals(userRestObj.getJob()));
	   
	   System.out.println(users.getName().equals(userRestObj.getName()));
	   
	   System.out.println(users.getJob().equals(userRestObj.getJob()));
	   
	   System.out.println(userRestObj.getId());
	   System.out.println(userRestObj.getCreatedAt());
		
		
		 
		
		
		
		
		
		
		
		
		
		
		
	}	
	
}
