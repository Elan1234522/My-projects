package Testing;



import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class estamp{
	
	
	// private static String Url_login="https://docuexec.com/login";
		private static String Url_login = "https://uat.docuexec.com/login";
		// private static String Url_login="http://10.10.20.60:6656/login";
		String Loginurl = Url_login;

		private static String URL = "https://uat.docuexec.com/docUpload";
		// private static String Url1="https://docuexec.com/docUpload";
		// private static String URL="http://10.10.20.60:6656/login";

		String Doc_url = URL;

		private static String uaturl3 = "https://uat.docuexec.com/inbox";
		// private static String uaturl3="https://docuexec.com/inbox";
		// private static String uaturl3="https://10.10.20.60:6656/inbox";
		public static String Inbox1 = uaturl3;
		
		private static String uaturl4 = "https://uat.docuexec.com/accountInfo";
		// private static String uaturl4="https://docuexec.com/accountInfo";
		// private static String uaturl4="https://10.10.20.60:6656/accountInfo";
		public static String accountInfo = uaturl4;
		
		
		
		private static String uaturl1 = "https://uat.docuexec.com/download/tokenSignDownload";
		//private static String uaturl1="https://docuexec.com/download/tokenSignDownload";
		//private static String uaturl1="https://10.10.20.60:6656/download/tokenSignDownload";
			public static String download = uaturl1;

		WebDriver driver;
		public WebDriver driverOP() throws Exception {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			ChromeDriver driver = new ChromeDriver(options);
			return driver;
		}

		@Test
		public void Launchapp() throws Exception {
			
			driver = driverOP();

			driver.get(Loginurl);
			driver.findElement(By.name("username")).sendKeys("9940783459");
			driver.findElement(By.id("myPassword")).sendKeys("Test@1234");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[3]/div[1]/button")).click();
			Thread.sleep(3000);
			System.out.println("login successfully");
		}

	
	@Test
	public void stamping_credentails() throws Exception {
		Launchapp();
		driver.manage().window().maximize();

		Robot robot = new Robot();

		Thread.sleep(5000);
		WebElement signup = driver.findElement(By.linkText("Sign Document"));
		signup.click();
		driver.get(Doc_url);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"pdf-container1\"]/section/div/div/div/div/span[3]/input")).click();
		// uploading document by controlling my keyboard
		Thread.sleep(5000);

		StringSelection string = new StringSelection(
				"D:\\Pdf for testing\\test.pdf");

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(string, null);
		Thread.sleep(5000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(2000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"next-button\"]/span")).click();// uploading document
	
		Thread.sleep(5000);
		WebElement moving = driver
				.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div/div[1]/div/div[1]/div[2]/p"));// dragAnddrop
		Actions builder = new Actions(driver);
		int x = moving.getLocation().getX();
		int y = moving.getLocation().getY();
		builder.dragAndDropBy(moving, x + 70, y + 90).perform();
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		 driver.findElement(By.id("eStampingCheckbox")).click();
		    driver.findElement(By.id("eStampDropdown")).click();
		    driver.findElement(By.id("purchasedByinput")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("purchasedByinput")).clear();
		    driver.findElement(By.id("purchasedByinput")).sendKeys("Elango");
		    driver.findElement(By.id("descofDocinput")).click();
		    driver.findElement(By.id("descofDocinput")).clear();
		    Thread.sleep(2000);
		    driver.findElement(By.id("descofDocinput")).sendKeys("Test Document");
		    driver.findElement(By.id("propertydescinput")).click();
		    driver.findElement(By.id("propertydescinput")).clear();
		    Thread.sleep(2000);
		    driver.findElement(By.id("propertydescinput")).sendKeys("Testing PDF");
		    driver.findElement(By.id("consdpriceinput")).click();
		    driver.findElement(By.id("consdpriceinput")).clear();
		    driver.findElement(By.id("consdpriceinput")).sendKeys("10000");
		    driver.findElement(By.id("firstPartyinput")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("firstPartyinput")).clear();
		    driver.findElement(By.id("firstPartyinput")).sendKeys("Raj kumar");
		    driver.findElement(By.id("firstpartyaddr1input")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("firstpartymobilenuminput")).click();
		    driver.findElement(By.id("firstpartymobilenuminput")).clear();
		    driver.findElement(By.id("firstpartymobilenuminput")).sendKeys("9110848375");
		    driver.findElement(By.id("secondpartyinput")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("secondpartyinput")).clear();
		    driver.findElement(By.id("secondpartyinput")).sendKeys("Elango");
		    driver.findElement(By.id("secondpartymobilenuminput")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("secondpartymobilenuminput")).clear();
		    driver.findElement(By.id("secondpartymobilenuminput")).sendKeys("6380695905");
		    driver.findElement(By.id("stampdutypaidbyinput")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("stampdutypaidbyinput")).clear();
		    driver.findElement(By.id("stampdutypaidbyinput")).sendKeys("Elango");
		    driver.findElement(By.id("stampdutyamtinput")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("stampdutyamtinput")).clear();
		    driver.findElement(By.id("stampdutyamtinput")).sendKeys("30");
		    driver.findElement(By.id("eStampinputFieldCheckbox")).click();
		    Thread.sleep(2000);
		    
			
		    JavascriptExecutor js =(JavascriptExecutor) driver;
		    
		    js.executeScript("window.scroll(0,800)");
		 //   driver.findElement(By.id("markerDisplayInfo")).click();
		    Thread.sleep(2000);
		  //  driver.findElement(By.xpath("//div[@id='submitBtn']/button/span")).click();
		    Thread.sleep(2000);
		  //  driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Terms & Conditions'])[1]/following::span[2]")).click();
}
	private static String URL1="https://uat.docuexec.com/inbox";
	//private static String URL1="https://docuexec.com/inbox";
	//private static String URL1="http://10.10.20.60:6656/inbox";
	
	 public static String Inbox=URL1;
	private static String acc="https://uat.docuexec.com/accountInfo";
	//private static String acc="https://docuexec.com/accountInfo";
	//private static String acc="http://10.10.20.60:6656/accountInfo";
	
	 public static String Account=acc;
	@Test
	public void Completesign() throws Exception {
	stamping_credentails();
		Thread.sleep(3000);
//		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[4]/button/span")).click();
		System.out.println("moves to priview page");
		Thread.sleep(8000);
		driver.findElement(By.id("completeSigningBtn")).click();// Completesign
		Thread.sleep(2000);
		String surl = driver.getCurrentUrl();
		String page = download;
		if (page.equals(surl)) {
			System.out.println("electronic sign done  successfully");
		} else {
			System.out.println("error");
		}
		driver.get("Inbox");
		Thread.sleep(3000);
		String Status = driver.findElement(By.xpath(
				"//*[@id=\"defaultBackGround\"]/main/div[2]/div/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[5]/span"))
				.getText();
		System.out.println(Status);
		driver.findElement(By.xpath(
				"//*[@id=\"defaultBackGround\"]/main/div[2]/div/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[5]/span")).isDisplayed();
		driver.navigate().to(Account);
		Thread.sleep(3000);
		String wallet=driver.findElement(By.xpath("//*[@id=\"subscribedplans\"]/div/div[2]")).getText();
		System.out.println(wallet);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/ul[2]/li/a/h6")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/ul[2]/li/div/button[2]")).click();
	    driver.getCurrentUrl();
	    driver.getTitle();
}
	@Test
	public void validating_Stamping_details() throws Exception {
		
		Launchapp();
		Robot robot = new Robot();

		Thread.sleep(5000);
		WebElement signup = driver.findElement(By.linkText("Sign Document"));
		signup.click();
		driver.get(Doc_url);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"pdf-container1\"]/section/div/div/div/div/span[3]/input")).click();
		// uploading document by controlling my keyboard
		Thread.sleep(5000);

		StringSelection string = new StringSelection(
				"D:\\Pdf for testing\\test.pdf");

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(string, null);
		Thread.sleep(5000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(2000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"next-button\"]/span")).click();// uploading document
	
		Thread.sleep(5000);
		WebElement moving = driver
				.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div/div[1]/div/div[1]/div[2]/p"));// dragAnddrop
		Actions builder = new Actions(driver);
		int x = moving.getLocation().getX();
		int y = moving.getLocation().getY();
		builder.dragAndDropBy(moving, x + 70, y + 100).perform();
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		 driver.findElement(By.id("eStampingCheckbox")).click();
		    driver.findElement(By.id("eStampDropdown")).click();
		    driver.findElement(By.id("purchasedByinput")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("purchasedByinput")).clear();
		    driver.findElement(By.id("purchasedByinput")).sendKeys("Akshay");
		    driver.findElement(By.id("descofDocinput")).click();
		    driver.findElement(By.id("descofDocinput")).clear();
		    Thread.sleep(2000);
		    driver.findElement(By.id("descofDocinput")).sendKeys("Test Document");
		    driver.findElement(By.id("propertydescinput")).click();
		    driver.findElement(By.id("propertydescinput")).clear();
		    Thread.sleep(2000);
		    driver.findElement(By.id("propertydescinput")).sendKeys("Testing PDF");
		    driver.findElement(By.id("consdpriceinput")).click();
		    driver.findElement(By.id("consdpriceinput")).clear();
		    driver.findElement(By.id("consdpriceinput")).sendKeys("10000");
		    driver.findElement(By.id("firstPartyinput")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("firstPartyinput")).clear();
		    driver.findElement(By.id("firstPartyinput")).sendKeys("Raj kumar");
		    driver.findElement(By.id("firstpartyaddr1input")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("firstpartymobilenuminput")).click();
		    driver.findElement(By.id("firstpartymobilenuminput")).clear();
		    driver.findElement(By.id("firstpartymobilenuminput")).sendKeys("9110848375");
		    driver.findElement(By.id("secondpartyinput")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("secondpartyinput")).clear();
		    driver.findElement(By.id("secondpartyinput")).sendKeys("Elango");
		    driver.findElement(By.id("secondpartymobilenuminput")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("secondpartymobilenuminput")).clear();
		    driver.findElement(By.id("secondpartymobilenuminput")).sendKeys("6380695905");
		    driver.findElement(By.id("stampdutypaidbyinput")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("stampdutypaidbyinput")).clear();
		    driver.findElement(By.id("stampdutypaidbyinput")).sendKeys("Elango");
		    driver.findElement(By.id("stampdutyamtinput")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("stampdutyamtinput")).clear();
		    driver.findElement(By.id("stampdutyamtinput")).sendKeys("10");
		    driver.findElement(By.id("eStampinputFieldCheckbox")).click();
		    Thread.sleep(2000);
		    
			
		    JavascriptExecutor js =(JavascriptExecutor) driver;
		    
		    js.executeScript("window.scroll(0,800)");
		 //   driver.findElement(By.id("markerDisplayInfo")).click();
		    Thread.sleep(2000);
		
		
	}
}

