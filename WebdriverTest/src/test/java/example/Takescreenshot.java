package example;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.sun.corba.se.impl.util.Utility;

public class Takescreenshot {
	WebDriver driver;
	@Test
	public void captureScreenshot() throws Exception{
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		//library.Utility.captureScreenshot(driver, "browser is launched");
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//input[@id=\"emaillllllllllll\"]")).sendKeys("vishalsingh");	
	}
	
	@AfterMethod
	public void tearDown(ITestResult result){
		if (ITestResult.FAILURE==result.getStatus()) {
			library.Utility.captureScreenshot(driver, result.getName());
		}
		driver.quit();
	}
	
	
}
