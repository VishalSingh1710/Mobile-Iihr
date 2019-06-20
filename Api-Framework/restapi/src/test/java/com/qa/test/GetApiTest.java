package com.qa.test;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.util.TestUtil;
public class GetApiTest extends TestBase{
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

	
	/*
	@Test(priority = 1)
	public void getAPITestwithoutHeaders() throws ClientProtocolException, IOException{
		restClient = new RestClient();
		closeableHttpResponse = restClient.get(url);


		///A. -Return response code/////////////////////////////////////////////////////////////////////////////////////
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("statusCode-->"+statusCode);
		Assert.assertEquals("Status code is not 200", 200, statusCode);
		
		
		

		///B.-json string//store the o/p in the string variable/////////////////////////////////////////////////////
		String reponseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		////convert string to json format
		JSONObject responsejson = new JSONObject(reponseString);
		System.out.println("Response json Api	"+responsejson);
		
		
		

		//////////1. verify per_page valu...///Json o/p//////////////
		String perPageValue = TestUtil.getValueByJPath(responsejson,"/per_page");
		System.out.println("value of perpage is "+perPageValue);
		Assert.assertEquals("3", perPageValue);
		
		
		////////////////2. verify total value..../////json o/p
		String totalValue = TestUtil.getValueByJPath(responsejson, "/total");
		System.out.println("value of total is "+totalValue);
		Assert.assertEquals(12, Integer.parseInt(totalValue));
		
		
		////////////3. Verify the value from json array///////////
		String Name = TestUtil.getValueByJPath(responsejson, "/data[0]/name");
		String year = TestUtil.getValueByJPath(responsejson, "/data[0]/year");
		String color = TestUtil.getValueByJPath(responsejson, "/data[0]/color");
		String pantoneValue = TestUtil.getValueByJPath(responsejson, "/data[0]/pantone_value");	
		
		System.out.println("Value of name is "+Name);
		System.out.println("Value of year is "+year);	
		System.out.println("value of color is "+color);
		System.out.println("value of pantone is "+pantoneValue);
	


		//C.-All headers//get all the o/p headers //////////////////////////////////////////////////////////////////
		Header[] headerArray = closeableHttpResponse.getAllHeaders();

		HashMap<String, String> allHeaders = new HashMap<String, String>();

		for (Header header: headerArray) {
			allHeaders.put(header.getName(), header.getValue());		
		}
		System.out.println("Headers array-->"+allHeaders);


	}
	
	
*/
	
	@Test(priority = 2)
	public void getAPITestwithHeaders() throws ClientProtocolException, IOException{
		restClient = new RestClient();
		
		
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Accept", "application/json");
		headerMap.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjVhZjMyNGMyMTk1ZGJiOTA1NDViZDAwOTgxNGM2YzFiMGZmMzY5YTZjZTc3YTkzNDU4MDRjYTEyOTJiNDg3OGEwNjQ3ZmJkMzQzMjg3ODg1In0.eyJhdWQiOiIxIiwianRpIjoiNWFmMzI0YzIxOTVkYmI5MDU0NWJkMDA5ODE0YzZjMWIwZmYzNjlhNmNlNzdhOTM0NTgwNGNhMTI5MmI0ODc4YTA2NDdmYmQzNDMyODc4ODUiLCJpYXQiOjE1NjAzMjk1ODgsIm5iZiI6MTU2MDMyOTU4OCwiZXhwIjoxNTkxOTUxOTg4LCJzdWIiOiIxNzAiLCJzY29wZXMiOltdfQ.EXmoWzrtZZuoPZcZRQsjAv0TK7mZSdsAqbVoHn_TWJntOYUpDEUsB1oTRSWXQun4OaxxDE0YNQFIc_J_g76smviuxlju3oOOE_Q7BK7xSqL2q3U-z02KdTKdMiuKk5it4y5RzMaCRmR0yfcWojx51_V7t_9f_4olN48lLqY94URaCTKUdVID-W_uc6aE0bgTZ84If5DK83hZKtdJ9o7M84R-QQRmAmygPMA7UVgazJxEUeXsJkwne2hkjEWEJb4hbMQOZwJiCS3tpwK2j6p65X0c_IdW_Urk5q7SH4QXROZtaca- PHseiAZuqymmviqgYjeicubIu3VAmRw7cskzUrLB_3I1hFVvfTuo5PKJ57RmwRVNrnlz_YSaAdta_4wteoDYemCQQR5orxRz_GpAowEF1wsG1JWw2j0kepwiX69-ijs6tGT3uPkLcJwjwVDFa8R4U6Rx80QaIZ9ahi-4tIAV5pyDVUCK_PgVj2_ZJATosegV0lYIor94y-Eo7isYuNy4MoeIBaDYs0MCiuhrjrjB6B7Eay8S4qQ2tTkRJAo8VrlGvh0A8X6dcBHqyGFrbX2lntEFquMoPluuPD4dd_6tS1kt-I8LeyOnp9M5vX44WDaOWozjnStw6AtsWKZpmqj6D0yedUfQAqLnDCzKtHx-qGfZ0x0nxmbqr4M9hPc");

		closeableHttpResponse = restClient.get(url,headerMap);
		
		

		///A. -Return response code/////////////////////////////////////////////////////////////////////////////////////
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("statusCode-->"+statusCode);
		Assert.assertEquals("Status code is not 200", 200, statusCode);
			
		

		///B.-json string//store the o/p in the string variable/////////////////////////////////////////////////////
		String reponseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		////convert string to json format
		JSONObject responsejson = new JSONObject(reponseString);
		System.out.println("Response json Api	"+responsejson);
		
		
		
		
		/*
		
		//////////1. verify per_page valu...///Json o/p//////////////
		String perPageValue = TestUtil.getValueByJPath(responsejson,"/per_page");
		System.out.println("value of perpage is "+perPageValue);
		Assert.assertEquals("3", perPageValue);
		
		
		////////////////2. verify total value..../////json o/p
		String totalValue = TestUtil.getValueByJPath(responsejson, "/total");
		System.out.println("value of total is "+totalValue);
		Assert.assertEquals(12, Integer.parseInt(totalValue));
		
		
		////////////3. Verify the value from json array///////////
		String Name = TestUtil.getValueByJPath(responsejson, "/data[0]/name");
		String year = TestUtil.getValueByJPath(responsejson, "/data[0]/year");
		String color = TestUtil.getValueByJPath(responsejson, "/data[0]/color");
		String pantoneValue = TestUtil.getValueByJPath(responsejson, "/data[0]/pantone_value");	
		
		System.out.println("Value of name is "+Name);
		System.out.println("Value of year is "+year);	
		System.out.println("value of color is "+color);
		System.out.println("value of pantone is "+pantoneValue);
	*/


		//C.-All headers//get all the o/p headers //////////////////////////////////////////////////////////////////
		Header[] headerArray = closeableHttpResponse.getAllHeaders();

		HashMap<String, String> allHeaders = new HashMap<String, String>();

		for (Header header: headerArray) {
			allHeaders.put(header.getName(), header.getValue());		
		}
		System.out.println("Headers array-->"+allHeaders);


	}


}


