import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestTitle {
	public String baseUrl = "http://staging.aphote.com/";
	public WebDriver driver;
	
	@BeforeTest
	public void setBaseUrl(){
		driver = new ChromeDriver();
		driver.get(baseUrl);		
	}
	
	@Test
	public void verifyHomeTitle(){
		String expectedTitle = "APHOTE";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@AfterTest
	public void endSession(){
		 driver.quit();
	}
	

}
