import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
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
	
	@BeforeGroups(groups={"group1","group2"})
	public void beforeMethod(){
		int var =5;
	}
	
	@Test(groups = { "group1", "group2" })
	public void verifyHomeTitle(){
		String expectedTitle = "APHOTE";
		expectedTitle.length();
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	
	@Test(groups = "group1")
	public void verifyVariable(){
		
	}
	
	@AfterTest
	public void endSession(){
		 driver.quit();
	}
	

}
