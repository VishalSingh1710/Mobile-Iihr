package Firsttestingpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirsttestNGfile {
	public String baseUrl = "http://demo.guru99.com/test/newtours/";
    public WebDriver driver ; 
	
  @Test
	  public void verifyHomePageTitle() {
		  System.out.println("launching firefox browser"); 
	      driver = new ChromeDriver();
	      driver.get(baseUrl);
	      String expectedTitle = "Welcome: Mercury Tours";
	      String actualTitle = driver.getTitle();
	      Assert.assertEquals(actualTitle, expectedTitle);
	      driver.close();
	  }
  }

