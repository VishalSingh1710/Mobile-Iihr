package getRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
public class GetData {
	
	@Test
	public void testResponseCode(){
		int statusCode = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").getStatusCode();
		System.out.println("status code is "+statusCode);
		Assert.assertEquals(statusCode, 200);	
	}
	
	@Test
	public void testBody(){
	Response resp = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
	String data = resp.asString();
	System.out.println("Data is "+data);
	System.out.println("Response timing is "+resp.getTime());
		
		
	}

}
