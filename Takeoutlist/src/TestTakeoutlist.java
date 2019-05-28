import java.awt.Window;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestTakeoutlist {
	public static void main(String[] args) throws InterruptedException {
		
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.google.com/");
	driver.manage().window().maximize();
	driver.navigate().to("http://takeoutlist.zolipe.com");
	driver.findElement(By.id("about-link")).click();
	driver.findElement(By.xpath("//input[@placeholder=\"Email\"]")).sendKeys("vishal@zolipe.com");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("1234		");
	driver.findElement(By.xpath("// input[@type=\"submit\"] [@value=\"Login\"]")).click();
	// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	Thread.sleep(3000);
	((JavascriptExecutor) driver).executeScript("window.scrollTo(0,1500)");

	driver.findElement(By.xpath("//h4[text() = \"Yak The Kathmandu Kitchen Fairhope\"]")).click();

	/////// Second merchant///////
	// driver.findElement(By.xpath("//h4[text() = \"Yak The Kathmandu Kitchen
	// Mobile\"]")).click();

	((JavascriptExecutor) driver).executeScript("window.scrollTo(0,700)");

	driver.findElement(By.xpath("//*[@id=\"menu-list-wrapper\"]/div[1]/div[2]/div/div/div[1]/div")).click();

	//////////select delivery type/////////////
	Select deliveryType = new Select(driver.findElement(By.name("popup_delivery_type")));
	Thread.sleep(3000);
	
	// deliveryType.selectByValue("dinein");
	
	// delivery type pickup
	deliveryType.selectByValue("pickup");
	Thread.sleep(3000);
	
	//////////select date/////////////
	driver.findElement(By.xpath("//input[@id=\"popup_delivery_date12\"]")).click();
	
	Thread.sleep(3000);	
	
	List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
	int total_nodes = dates.size(); 
	for (int i = 0; i < total_nodes; i++) {
	String date = dates.get(i).getText(); 
	if (date.equals("28")) 
	{
	dates.get(i).click(); 
	break; 
	}
	}
	 
	Thread.sleep(3000);
	
	//////////select time///////
	driver.findElement(By.xpath("//input[@id=\"delivery_time1\"]")).click();	
	List<WebElement> times = driver.findElements(By.xpath("//ul[@class=\"ui-timepicker-viewport\"]//li"));
	int total_time = times.size();
	for(int i =0;i<total_time;i++)
	{
		String time = times.get(i).getText();
		if (time.equals("10:30 AM")) {
			times.get(i).click();
			break;
		}
	}
	
	driver.findElement(By.xpath("//button[@class=\"pickupoption\"]")).click();	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/div[2]/div/div/div[4]/div/a")).click();
	Thread.sleep(2000);		
	
	/////select spice preference//////////
	driver.findElement(By.xpath("//input[@value=\"Medium\"]")).click();
	
	//driver.findElement(By.xpath("//input[@value=\"Hot\"]")).click();
	
	//driver.findElement(By.xpath("//input[@value=\" Mild\"]")).click();
	
	////////add to cart button///////////
	driver.findElement(By.xpath("//input[@value=\"add to cart\"]")).click();
	
	Thread.sleep(3000);
	///////checkout/////////////////
	driver.findElement(By.xpath("//a[text()=\"Checkout\"]")).click();
	
	Thread.sleep(3000);
	//////////////card details///////////
	
	driver.switchTo().frame("bambora-card-number-iframe");	
	System.out.println("framedone");	
	driver.findElement(By.id("bambora-card-number")).sendKeys("4030000010001234");
	driver.switchTo().defaultContent();
	
	System.out.println("pass");
	Thread.sleep(2000);
	driver.switchTo().frame("bambora-cvv-iframe");
	driver.findElement(By.id("bambora-cvv")).sendKeys("123");
	driver.switchTo().defaultContent();
	
	
	Thread.sleep(2000);
	driver.switchTo().frame("bambora-expiry-iframe");
	driver.findElement(By.id("bambora-expiry")).sendKeys("2222");
	driver.switchTo().defaultContent();
	
	
	driver.findElement(By.xpath("//input[@id=\"pay-button\"]")).click();	
	driver.close();

}
}

