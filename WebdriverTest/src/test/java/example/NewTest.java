package example;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class NewTest {
	public String baseUrl = "https://mobile.iihr.res.in/user";
	public WebDriver driver ; 

	@BeforeTest
	public void lauchingBrowser(){
		System.out.println("launching chrome browser"); 
		driver = new ChromeDriver();
		driver.get(baseUrl);

	}	

	@Test
	public void verifyfunctionality1() throws InterruptedException {

		////////////////////////////////////LOGIN////////////////////////////////////////////////////////////////////////////////////
		driver.findElement(By.xpath("//input[@id=\"edit-name\"]")).sendKeys("zolipetester");
		driver.findElement(By.xpath("//input[@id=\"edit-pass\"]")).sendKeys("tester");



		//////////////////////////////////////////CAPTCHA///////////////////////////////////////////////////////////////////////////////
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the captcha");
		String captcha = sc.nextLine();
		driver.findElement(By.xpath("//input[@id=\"edit-captcha-response\"]")).sendKeys(captcha);
		driver.findElement(By.xpath("//button[@id=\"edit-submit\"]")).click();
		driver.manage().window().maximize();


		////////////////////////////////////////////////GENERAL INDENT//////////////////////////////////////////////////////////////////
		driver.findElement(By.xpath("//*[@id=\"block-menu-menu-iihrdashboard\"]/div[2]/ul/li[3]/span")).click();
		Actions act = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.xpath("//*[@id=\"indent-management\"]"));
		act.moveToElement(menuHoverLink).perform();
		WebElement subHoverLink = driver.findElement(By.xpath("//*[@id=\"create-indent\"]"));
		act.moveToElement(subHoverLink).perform();  
		WebElement subLink1 = driver.findElement(By.cssSelector("a[href='/admin/general_indent_form']"));
		subLink1.click();


		/////////////////////////////////////////FILL SUBJECT//////////////////////////////////////////////////////////////////////////
		driver.findElement(By.xpath("//input[@id=\"edit-subject\"]")).sendKeys("Test");


		//////////////////////////////////////UPLOAD FILES///////////////////////////////////////////////////////////////////////////////
		driver.findElement(By.xpath("//input[@id=\"edit-rate-table-logo-upload\"]")).sendKeys("/home/zolipe/Desktop/sample.pdf");
		driver.findElement(By.xpath("//input[@id=\"edit-rate-table-logo-upload-button\"]")).click();

		driver.findElement(By.xpath("//input[@id=\"edit-rate-table-logo1-upload\"]")).sendKeys("/home/zolipe/Desktop/sample.pdf");
		driver.findElement(By.xpath("//input[@id=\"edit-rate-table-logo1-upload-button\"]")).click();

		driver.findElement(By.xpath("//input[@id=\"edit-rate-table-logo2-upload\"]")).sendKeys("/home/zolipe/Desktop/sample.pdf");
		driver.findElement(By.xpath("//input[@id=\"edit-rate-table-logo2-upload-button\"]")).click();

		driver.findElement(By.xpath("//input[@id=\"edit-submit\"]")).click();
		Thread.sleep(2000);



		//////////////////////////////////////////////////NEW PAGE IN GENERAL INDENT/////////////////////////////////////////////////////
		driver.findElement(By.xpath("//div[@class=\"chosen-container chosen-container-single form-select required chosen-processed\"]")).click();
		List<WebElement> allSupervisor = driver.findElements(By.xpath("//ul[@class=\"chosen-results\"]//li"));
		int asv = allSupervisor.size();
		for(int i =0;i<asv;i++){
			String supervisor = allSupervisor.get(i).getText();
			if (supervisor.equals("Zolipe Tester 2")) {
				allSupervisor.get(i).click();
				break;		
			}		
		}
		driver.findElement(By.xpath("//input[@id=\"edit-submit\"]")).click();
		Thread.sleep(2000);



		/////////////////////////////////////////////////VEHICAL INDENT///////////////////////////////////////////////////////////////////
		driver.findElement(By.xpath("//*[@id=\"block-menu-menu-iihrdashboard\"]/div[2]/ul/li[3]/span")).click();
		Actions act1 = new Actions(driver);
		WebElement menuHoverLink1 = driver.findElement(By.xpath("//*[@id=\"indent-management\"]"));
		act1.moveToElement(menuHoverLink1).perform();
		WebElement subsubHoverLink1 = driver.findElement(By.xpath("//*[@id=\"create-indent\"]"));
		act1.moveToElement(subsubHoverLink1).perform();
		WebElement sublink1 = driver.findElement(By.cssSelector("a[href='/admin/vehicle_indent_form']"));
		sublink1.click();



		/////////////////////////////////////////////FILL SUBJECT AND ALL OTHER DETAILS////////////////////////////////////////////////////////
		driver.findElement(By.xpath("//input[@id=\"edit-subject\"]")).sendKeys("Test");

		driver.findElement(By.xpath("//input[@id=\"edit-from\"]")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//input[@id=\"edit-to\"]")).sendKeys("Mysore");

		driver.findElement(By.xpath("//input[@id=\"edit-date-datepicker-popup-0\"]")).sendKeys("31-05-2019");
		driver.findElement(By.xpath("//input[@id=\"edit-date--popup-1\"]")).sendKeys("14:48");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@id=\"edit_vehicle_type_chosen\"]")).click();
		List<WebElement> allVehicals   = driver.findElements(By.xpath("//ul[@class=\"chosen-results\"]//li"));
		int n = allVehicals.size();
		for (int i = 0; i < n; i++) {
			String vehicals = allVehicals.get(i).getText();
			if (vehicals.equals("Bus")) {
				allVehicals.get(i).click();
				break;

			}
		}

		////////////////////////////////UPLOAD FILES///////////////////////////////////////////////////////////////////////////////////
		driver.findElement(By.xpath("//input[@id=\"edit-rate-table-logo-upload\"]")).sendKeys("/home/zolipe/Desktop/sample.pdf");
		driver.findElement(By.xpath("//input[@id=\"edit-rate-table-logo-upload-button\"]")).click();

		driver.findElement(By.xpath("//input[@id=\"edit-rate-table-logo1-upload\"]")).sendKeys("/home/zolipe/Desktop/sample.pdf");
		driver.findElement(By.xpath("//input[@id=\"edit-rate-table-logo1-upload-button\"]")).click();

		driver.findElement(By.xpath("//input[@id=\"edit-rate-table-logo2-upload\"]")).sendKeys("/home/zolipe/Desktop/sample.pdf");
		driver.findElement(By.xpath("//input[@id=\"edit-rate-table-logo2-upload-button\"]")).click();

		driver.findElement(By.xpath("//input[@id=\"edit-submit\"]")).click();
		Thread.sleep(2000);



		///////////////////////////////NEW PAGE IN GENERAL INDENT/////////////////////////////////////////////////////////////////////
		driver.findElement(By.xpath("//div[@class=\"chosen-container chosen-container-single form-select required chosen-processed\"]")).click();
		List<WebElement> allSupervisor1 = driver.findElements(By.xpath("//ul[@class=\"chosen-results\"]//li"));
		int asv1 = allSupervisor1.size();
		for(int i =0;i<asv1;i++){
			String supervisor1 = allSupervisor1.get(i).getText();
			if (supervisor1.equals("Zolipe Tester 2")) {
				allSupervisor1.get(i).click();
				break;		
			}		
		}
		driver.findElement(By.xpath("//input[@id=\"edit-submit\"]")).click();
		Thread.sleep(2000);



		//////////////////////////////////////////WORK INDENT//////////////////////////////////////////////////////////////////////////
		driver.findElement(By.xpath("//*[@id=\"block-menu-menu-iihrdashboard\"]/div[2]/ul/li[3]/span")).click();
		Actions act2 = new Actions(driver);
		WebElement menuHoverLink2 = driver.findElement(By.xpath("//*[@id=\"indent-management\"]"));
		act2.moveToElement(menuHoverLink2).perform();
		WebElement subsubHoverLink2 = driver.findElement(By.xpath("//*[@id=\"create-indent\"]"));
		act2.moveToElement(subsubHoverLink2).perform();
		WebElement sublink2 = driver.findElement(By.cssSelector("a[href='/admin/work_indent_form']"));
		sublink2.click();



		////////////////////////////////////////FILL SUJECT//////////////////////////////////////////////////////////////////////////////
		driver.findElement(By.xpath("//input[@id=\"edit-subject\"]")).sendKeys("Test");

		driver.findElement(By.xpath("//input[@id=\"edit-work-name\"]")).sendKeys("Worktest");

		driver.findElement(By.xpath("//input[@id=\"edit-work-location\"]")).sendKeys("testlocation");

		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,700)");

		driver.findElement(By.xpath("//div[@id=\"edit_unit_chosen\"]")).click();
		List<WebElement> allunits = driver.findElements(By.xpath("//ul[@class=\"chosen-results\"]//li"));
		int totalUnits = allunits.size();
		for(int i = 0;i<totalUnits;i++){	
			String unit = allunits.get(i).getText();
			if (unit.equals("Civil")) {
				allunits.get(i).click();
				break;
			}
		}

		/////////////////////////////UPLOAD FILES/////////////////////////////////////////////////////////////////////////////////////////////
		driver.findElement(By.xpath("//input[@id=\"edit-rate-table-logo-upload\"]")).sendKeys("/home/zolipe/Desktop/sample.pdf");
		driver.findElement(By.xpath("//input[@id=\"edit-rate-table-logo-upload-button\"]")).click();

		driver.findElement(By.xpath("//input[@id=\"edit-rate-table-logo1-upload\"]")).sendKeys("/home/zolipe/Desktop/sample.pdf");
		driver.findElement(By.xpath("//input[@id=\"edit-rate-table-logo1-upload-button\"]")).click();

		driver.findElement(By.xpath("//input[@id=\"edit-rate-table-logo2-upload\"]")).sendKeys("/home/zolipe/Desktop/sample.pdf");
		driver.findElement(By.xpath("//input[@id=\"edit-rate-table-logo2-upload-button\"]")).click();

		driver.findElement(By.xpath("//input[@id=\"edit-submit\"]")).click();


		////////////////NEW PAGE IN GENERAL INDENT///////////////////////////////////////////////////////////////////////////////////////
		driver.findElement(By.xpath("//div[@class=\"chosen-container chosen-container-single form-select required chosen-processed\"]")).click();
		List<WebElement> allSupervisor2 = driver.findElements(By.xpath("//ul[@class=\"chosen-results\"]//li"));
		int asv2 = allSupervisor2.size();
		for(int i =0;i<asv2;i++){
			String supervisor2 = allSupervisor2.get(i).getText();
			if (supervisor2.equals("Zolipe Tester 2")) {
				allSupervisor2.get(i).click();
				break;		
			}		
		}
		driver.findElement(By.xpath("//input[@id=\"edit-submit\"]")).click();
		Thread.sleep(5000);


		///////////////////////////////LOGOUT////////////////////////////////////////////////////////////////////////////////////////////////////
		driver.findElement(By.cssSelector("a[href='/user/logout?current=admin/indent_dashboard']")).click();
	}



	@Test(priority=1)
	public void loginAsTester2() throws InterruptedException{
		driver.findElement(By.xpath("//input[@id=\"edit-name\"]")).sendKeys("zolipetester2");
		driver.findElement(By.xpath("//input[@id=\"edit-pass\"]")).sendKeys("tester");

		////////////////CAPTCHA/////////////////////////////////////////////////////////////////////////////////////////////////////
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the captcha");
		String captcha = sc.nextLine();
		driver.findElement(By.xpath("//input[@id=\"edit-captcha-response\"]")).sendKeys(captcha);
		driver.findElement(By.xpath("//button[@id=\"edit-submit\"]")).click();
		driver.manage().window().maximize();


		///////////////////////////VI//////////////////////////////////////////////////////////////////////////////////////////////
		driver.findElement(By.xpath("//*[@id=\"block-menu-menu-iihrdashboard\"]/div[2]/ul/li[3]/span")).click();
		Actions act = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.xpath("//*[@id=\"indent-management\"]"));
		act.moveToElement(menuHoverLink).perform();
		WebElement inboxlink = driver.findElement(By.cssSelector("a[href='/admin/indent_dashboard']"));
		inboxlink.click();
		driver.findElement(By.xpath("//*[contains(text(),'VI_zolipe tester')]")).click();


		////////////////////SELECT ACTIONS //////////////////////////////////////////////////////////////////////////////////////////
		driver.findElement(By.xpath("//div[@id=\"edit_action_taken_chosen\"]")).click();
		List<WebElement> allActions = driver.findElements(By.xpath("//*[@id=\"edit_action_taken_chosen\"]/div/ul//li"));
		int asize = allActions.size();
		for (int i = 0; i < asize; i++) {
			String action = allActions.get(i).getText();
			if (action.equals("Forward")) {
				allActions.get(i).click();
				break;
			}
		}


		////////////////////SELECT USERS //////////////////////////////////////////////////////////////////////////////////////////////
		driver.findElement(By.xpath("//div[@id=\"edit_node_chosen\"]")).click();
		List<WebElement> allUSERS = driver.findElements(By.xpath("//*[@id=\"edit_node_chosen\"]/div/ul//li"));
		System.out.println("pass1");
		int auser = allUSERS.size();
		for (int i = 0; i < auser; i++) {
			String user = allUSERS.get(i).getText();
			if (user.equals("Basavaprabhu")) {
				allUSERS.get(i).click();
				break;
			}
		}


		//////////////////////SUBMIT/////////////////////////////////////////////////////////////////////////////////////////////////////
		driver.findElement(By.xpath("//input[@id=\"edit-submit\"]")).click();


		//////////////////////////GI/////////////////////////////////////////////////////////////////////////////////////////////////////
		driver.findElement(By.xpath("//*[@id=\"block-menu-menu-iihrdashboard\"]/div[2]/ul/li[3]/span")).click();
		Actions act1 = new Actions(driver);
		WebElement menuHoverLink1 = driver.findElement(By.xpath("//*[@id=\"indent-management\"]"));
		act1.moveToElement(menuHoverLink1).perform();
		WebElement inboxlink1 = driver.findElement(By.cssSelector("a[href='/admin/indent_dashboard']"));
		inboxlink1.click();
		driver.findElement(By.xpath("//*[contains(text(),'GI_zolipe tester')]")).click();


		//////////////////////SELECT ACTIONS ///////////////////////////////////////////////////////////////////////////////////////////
		driver.findElement(By.xpath("//div[@id=\"edit_action_taken_chosen\"]")).click();
		List<WebElement> allActions1 = driver.findElements(By.xpath("//*[@id=\"edit_action_taken_chosen\"]/div/ul//li"));
		int asize1 = allActions1.size();
		for (int i = 0; i < asize1; i++) {
			String action1 = allActions1.get(i).getText();
			if (action1.equals("Forward")) {
				allActions1.get(i).click();
				break;
			}
		}


		////////////////////SELECT USERS //////////////////////////////////////////////////////////////////////////////////////////
		driver.findElement(By.xpath("//div[@id=\"edit_node_chosen\"]")).click();
		List<WebElement> allUSERS1 = driver.findElements(By.xpath("//*[@id=\"edit_node_chosen\"]/div/ul//li"));
		int auser1 = allUSERS1.size();
		for (int i = 0; i < auser1; i++) {
			String user1 = allUSERS1.get(i).getText();
			if (user1.equals("Basavaprabhu")) {
				allUSERS1.get(i).click();
				break;
			}
		}


		////////////////SUBMIT/////////////////////////////////////////////////////////////////////////////////////////////////////
		driver.findElement(By.xpath("//input[@id=\"edit-submit\"]")).click();


		/////////////////////WI/////////////////////////////////////////////////////////////////////////////////////////////////////
		driver.findElement(By.xpath("//*[@id=\"block-menu-menu-iihrdashboard\"]/div[2]/ul/li[3]/span")).click();
		Actions act2 = new Actions(driver);
		WebElement menuHoverLink2 = driver.findElement(By.xpath("//*[@id=\"indent-management\"]"));
		act2.moveToElement(menuHoverLink2).perform();
		WebElement inboxlink2 = driver.findElement(By.cssSelector("a[href='/admin/indent_dashboard']"));
		inboxlink2.click();
		driver.findElement(By.xpath("//*[contains(text(),'WI_zolipe tester')]")).click(); 


		////////////////////SELECT ACTIONS //////////////////////////////////////////////////////////////////////////////////////////
		driver.findElement(By.xpath("//div[@id=\"edit_action_taken_chosen\"]")).click();
		List<WebElement> allActions2 = driver.findElements(By.xpath("//*[@id=\"edit_action_taken_chosen\"]/div/ul//li"));
		int asize2 = allActions2.size();
		for (int i = 0; i < asize2; i++) {
			String action2 = allActions2.get(i).getText();
			if (action2.equals("Forward")) {
				allActions2.get(i).click();
				break;
			}
		}


		////////////////////SELECT USERS /////////////////////////////////////////////////////////////////////////////////////
		driver.findElement(By.xpath("//div[@id=\"edit_node_chosen\"]")).click();
		List<WebElement> allUSERS2 = driver.findElements(By.xpath("//*[@id=\"edit_node_chosen\"]/div/ul//li"));
		int auser2 = allUSERS2.size();
		for (int i = 0; i < auser2; i++) {
			String user2 = allUSERS2.get(i).getText();
			if (user2.equals("Basavaprabhu")) {
				allUSERS2.get(i).click();
				break;
			}
		}


		////////////////SUBMIT//////////////////////////////////////////////////////////////////////////////////////////////////
		driver.findElement(By.xpath("//input[@id=\"edit-submit\"]")).click();




		//////////////////////////////////////////COPY TEXT////////////////////////////////////////////////////////////////////
		driver.findElement(By.xpath("//*[@id=\"block-menu-menu-iihrdashboard\"]/div[2]/ul/li[3]/span")).click();
		Actions act3 = new Actions(driver);
		WebElement menuHoverLink3 = driver.findElement(By.xpath("//*[@id=\"indent-management\"]"));
		act3.moveToElement(menuHoverLink3).perform();
		WebElement outboxlink3 = driver.findElement(By.cssSelector("a[href='/admin/indent_outbox']"));
		outboxlink3.click();

		String WItext = driver.findElement(By.xpath("//*[contains(text(),'WI_zolipe tester')]")).getText();
		System.out.println(WItext);

		String GItext = driver.findElement(By.xpath("//*[contains(text(),'GI_zolipe tester')]")).getText();
		System.out.println(GItext);

		String VItext = driver.findElement(By.xpath("//*[contains(text(),'VI_zolipe tester')]")).getText();
		System.out.println(VItext);
		System.out.println();
		System.out.println();
		
		
		//////////////////////LOGOUT////////////////////////////////////////////////////////////////////////////////////////////////////
		driver.findElement(By.cssSelector("a[href='/user/logout?current=admin/indent_outbox']")).click();





		////////////////////////////////////LOGIN AS TESTER 3RD////////////////////////////////////////////////////////////////////////////
		driver.findElement(By.xpath("//input[@id=\"edit-name\"]")).sendKeys("zolipe");
		driver.findElement(By.xpath("//input[@id=\"edit-pass\"]")).sendKeys("sai");


		/////////////////////////////////////////////////Captcha1//////////////////////////////////////////////////////////////////////////
		Scanner sc1 = new Scanner(System.in);
		System.out.println("enter the captcha");
		String captcha1 = sc1.nextLine();
		driver.findElement(By.xpath("//input[@id=\"edit-captcha-response\"]")).sendKeys(captcha1);
		driver.findElement(By.xpath("//button[@id=\"edit-submit\"]")).click();
		driver.manage().window().maximize();		

		driver.findElement(By.xpath("//*[@id=\"block-menu-menu-iihrdashboard\"]/div[2]/ul/li[3]/span")).click();
		Actions act11 = new Actions(driver);
		WebElement menuHoverLink11 = driver.findElement(By.xpath("//*[@id=\"indent-management\"]"));
		act11.moveToElement(menuHoverLink11).perform();
		WebElement inboxlink11 = driver.findElement(By.cssSelector("a[href='/admin/indent_dashboard']"));
		inboxlink11.click();

		/////////////////////////////CHECKING DUPLICATION////////////////////////////////////////////////////////////////////////////////
		List<WebElement> VIsize = driver.findElements(By.linkText(VItext)); 	
		int size = VIsize.size();
		if (size > 1) {
			System.out.println("VI Duplicates are present for this "+VItext);
		}
		else
			System.out.println("VI Duplicates are not presentfor this "+VItext);


		List<WebElement> WIsize = driver.findElements(By.linkText(WItext)); 	
		int size1 = WIsize.size();
		if (size1 > 1) {
			System.out.println("WI Duplicates are present for this "+WItext);
		}
		else
			System.out.println("WI Duplicates are not presentfor this "+WItext);


		List<WebElement> GIsize = driver.findElements(By.linkText(GItext)); 	
		int size2 = GIsize.size();
		if (size2 > 1) {
			System.out.println("GI Duplicates are present for this "+GItext);
		}
		else
			System.out.println("GI Duplicates are not presentfor this "+GItext);
		System.out.println();
		System.out.println();


		//////////////////////COPY TEXT FROM 3RD TESTER///////////////////////////////////////////////////////////////////////////////////
		String VItext1 = driver.findElement(By.xpath("//*[contains(text(),'VI_zolipe tester')]")).getText();
		System.out.println(VItext1);

		String GItext1 = driver.findElement(By.xpath("//*[contains(text(),'GI_zolipe tester')]")).getText();
		System.out.println(GItext1);

		String WItext1 = driver.findElement(By.xpath("//*[contains(text(),'WI_zolipe tester')]")).getText();
		System.out.println(WItext1);
		System.out.println();
		System.out.println();



		////////////////////////////////////compare VEHICAL indent/////////////////////////////////////////////////////////////////////
		if (VItext.equals(VItext1)) {
			System.out.println("Same VEHICAL indent exist in inbox");		
		}
		else 
			System.out.println("Same VEHICAL indent is not exist in inbox");



		//////////////////////////////////compare WORK indent//////////////////////////////////////////////////////////////////////////
		if (WItext.equals(WItext1)) {
			System.out.println("Same WORK indent exist in inbox");		
		}
		else 
			System.out.println("Same WORK indent is not exist in inbox");


		///////////////////////////compare GENERAL indent//////////////////////////////////////////////////////////////////////////////
		if (GItext.equals(GItext1)) {
			System.out.println("Same GENERAL indent exist in inbox");		
		}
		else 
			System.out.println("Same GENERAL indent is not exist in inbox");
		System.out.println();
		System.out.println();

	}


	@AfterTest
	public void closeBrowser(){
		//driver.close();	 
	}


}


