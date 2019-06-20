package library;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	
	public static void captureScreenshot(WebDriver driver,String screenshotName){
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File("/home/zolipe/Desktop/Vishal/WebdriverTest/Screenshots/"+screenshotName+".png"));
		} catch (Exception e) {
			System.out.println("Exception occured"+e.getMessage());
			
		}
		System.out.println("Screenshot taken");
		
	}

}
