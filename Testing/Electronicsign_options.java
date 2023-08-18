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

public class Electronicsign_options {

	private static String testurl = "https://uat.docuexec.com/login";
//private static String testurl="https://docuexec.com/login";
//private static String  testurl="http://10.10.20.60:6656/login";

	public static String url = testurl;

	WebDriver driver;
	public WebDriver driverOP() throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		return driver;
	}

	public void Openingapp() throws Exception {

		driver = driverOP();

		driver.get(url);
		driver.findElement(By.name("username")).sendKeys("9940783459");
		driver.findElement(By.id("myPassword")).sendKeys("Test@1234");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[3]/div[1]/button")).click();

		Thread.sleep(3000);

		String url = driver.getTitle();
		String page1 = "DocuExec";
		if (page1.equals(url)) {
			System.out.println("Login successfully");
		} else {
			System.out.println("login failed");
		}
	}

	@Test

	public void Signing() throws Exception {
		Openingapp();
		Thread.sleep(3000);
		WebElement details = driver
				.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div[2]/div/div[2]"));
		String acc = details.getText();
		System.out.println("Account details before signing : " + acc);
		Robot robot = new Robot();

		Thread.sleep(5000);
		driver.manage().window().maximize();
		WebElement signup = driver.findElement(By.linkText("Sign Document"));
		signup.click();
		// driver.get("https://uat.docuexec.com/docUpload");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"pdf-container1\"]/section/div/div/div/div/span[3]/input")).click();
		// uploading document by controlling my keyboard
		Thread.sleep(5000);

		StringSelection string = new StringSelection("D:\\Pdf for testing\\test.pdf");

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
				.findElement(By.xpath("//*[@id=\"markerDisplayInfo\"]"));// dragAnddrop
		Actions builder = new Actions(driver);
		int x = moving.getLocation().getX();
		int y = moving.getLocation().getY();
		builder.dragAndDropBy(moving, x + 70, y + 90).perform();

		Thread.sleep(3000);
//		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div/div[2]/div/div[3]/button"))
//				.click();
		Thread.sleep(3000);
		
		Comments();
		//driver.findElement(By.id("firstPageRadio")).click();// click on page first
		// apge signature

//		driver.findElement(By.id("lastPageRadio")).click();
		// driver.findElement(By.id("allPageRadio")).click();// all page

		// driver.findElement(By.id("currentPageRadio")).click();
//driver.findElement(
	 driver.findElement(By.id("customPageRadio")).click();//custome page sign
Thread.sleep(2000);
driver.findElement(By.id("range-field")).sendKeys("2,3");

		Thread.sleep(3000);
		driver.findElement(By.id("electronicModeRadio")).click();// choosing
		// electronic sign
		driver.findElement(By.id("signaturePadBtn")).click();// click to sign
		driver.findElement(By.xpath("//*[@id=\"nav-home-tab\"]")).click();// pop window open
//
		driver.findElement(By.name("selectedFont")).click();// selecting font
		driver.findElement(By.id("adoptUploadBtn")).click();// apply button
//driver.findElement(By.id("aadhaarModeRadio")).click();// Aadhar signing
//driver.findElement(By.id("otpSignModeRadio")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scroll(0,1000)");
		Thread.sleep(3000);
		// driver.findElement(By.id("generateOtpBtn")).click();
		driver.findElement(By.xpath("//*[@id=\"submitBtn\"]/button/span")).click();// submit buuton
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[4]/button/span")).click();

//		System.out.println("document signed");
		Thread.sleep(5000);

//		driver.findElement(By.id("completeSigningBtn")).click();// Completesign
//		Thread.sleep(3000);
//		driver.navigate().to(uaturl4);
//		Thread.sleep(3000);
//		WebElement afdetails = driver
//				.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div[2]/div/div[2]"));
//		String Acc = afdetails.getText();
//		System.out.println("Account details before signing : " + Acc);
//		
//		System.out.println("Complete signing Is tested");

	}

	private static String uaturl1 = "https://uat.docuexec.com/download/tokenSignDownload";
//private static String uaturl1="https://docuexec.com/download/tokenSignDownload";
//private static String uaturl1="https://10.10.20.60:6656/download/tokenSignDownload";
	public static String download = uaturl1;
	private static String uaturl3 = "https://uat.docuexec.com/inbox";
//private static String uaturl3="https://docuexec.com/inbox";
//private static String uaturl3="https://10.10.20.60:6656/inbox";
	public static String Inbox = uaturl3;

	private static String uaturl4 = "https://uat.docuexec.com/accountInfo";
//private static String uaturl4="https://docuexec.com/accountInfo";
//private static String uaturl4="https://10.10.20.60:6656/accountInfo";
	public static String accountInfo = uaturl4;

	@Test
	public void Completesign() throws Exception {
		Signing();
		Thread.sleep(3000);
//		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[4]/button/span")).click();
//		System.out.println("moves to priview page");
		Thread.sleep(8000);
		 
		WebElement Complete = driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div[1]/button[1]"));
		Complete.click();// Completesign
		Thread.sleep(2000);
		String surl = driver.getCurrentUrl();
		String page = download;/// document preview page.
		if (page.equals(surl)) {
			System.out.println("electronic sign done  successfully");
		} else {
			System.out.println("error");
		}
		Thread.sleep(3000);
		driver.get(Inbox);
		Thread.sleep(3000);
		String Status = driver.findElement(By.xpath(
				"//*[@id=\"defaultBackGround\"]/main/div[2]/div/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[5]/span"))
				.getText();
		System.out.println(Status);
		driver.findElement(By.xpath(
				"//*[@id=\"defaultBackGround\"]/main/div[2]/div/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[5]/span"))
				.isDisplayed();
		driver.navigate().to(accountInfo);
		Thread.sleep(3000);
		String wallet = driver.findElement(By.xpath("//*[@id=\"subscribedplans\"]/div/div[2]")).getText();
		System.out.println(wallet);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/ul[2]/li/a/h6")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/ul[2]/li/div/button[2]")).click();
		driver.getCurrentUrl();
		driver.getTitle();
		System.out.println("Complete signing Is tested");
//		driver.close();
		// driver.quit();
	}
	public void Comments()throws Exception{
		WebElement Comments =driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div/button"));
		Comments.click();
		
		
		WebElement in_cmnts= driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/textarea"));
		in_cmnts.sendKeys("Its  for testing purpose");
		  
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div/input")).click();
		
		
		WebElement OK_Button= driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/button"));
		OK_Button.click();
		
	}
	@Test

	public void Cancel_preview() throws Exception {
		Openingapp();
		Thread.sleep(3000);
		WebElement details = driver
				.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div[2]/div/div[2]"));
		String acc = details.getText();
		System.out.println("Account details before signing : " + acc);
		Robot robot = new Robot();

		Thread.sleep(5000);
		driver.manage().window().maximize();
		WebElement signup = driver.findElement(By.linkText("Sign Document"));
		signup.click();
		// driver.get("https://uat.docuexec.com/docUpload");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"pdf-container1\"]/section/div/div/div/div/span[3]/input")).click();
		// uploading document by controlling my keyboard
		Thread.sleep(5000);

		StringSelection string = new StringSelection("D:\\Pdf for testing\\test.pdf");

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
				.findElement(By.xpath("//*[@id=\"markerDisplayInfo\"]"));// dragAnddrop
		Actions builder = new Actions(driver);
		int x = moving.getLocation().getX();
		int y = moving.getLocation().getY();
		builder.dragAndDropBy(moving, x + 70, y + 90).perform();

		Thread.sleep(3000);
//		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div/div[2]/div/div[3]/button"))
//				.click();
		Thread.sleep(3000);
		Comments();
		driver.findElement(By.id("firstPageRadio")).click();// click on page first
		// apge signature

		driver.findElement(By.id("currentPageRadio")).click();

		Thread.sleep(3000);
		driver.findElement(By.id("electronicModeRadio")).click();// choosing
		// electronic sign
		driver.findElement(By.id("signaturePadBtn")).click();// click to sign
		driver.findElement(By.xpath("//*[@id=\"nav-home-tab\"]")).click();// pop window open
//
		driver.findElement(By.name("selectedFont")).click();// selecting font
		driver.findElement(By.id("adoptUploadBtn")).click();// apply button

		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scroll(0,1000)");
		Thread.sleep(3000);
		// driver.findElement(By.id("generateOtpBtn")).click();
		driver.findElement(By.xpath("//*[@id=\"submitBtn\"]/button/span")).click();// submit buuton
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[4]/button/span")).click();
//		System.out.println("document signed");
		Thread.sleep(5000);
//		 driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[4]/button/span")).click();
		System.out.println("moves to priview page");
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div[1]/button[2]")).click();// cancel
																												// and
																												// prieview
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/button[1]")).click();
		System.out.println("sign has been re-intiated");
		Thread.sleep(3000);
		WebElement moving1 = driver.findElement(By.xpath("//*[@id=\"markerDisplayInfo\"]"));
		Actions builder1 = new Actions(driver);
		int x1 = moving1.getLocation().getX();
		int y1 = moving1.getLocation().getY();
		builder1.dragAndDropBy(moving1, x1 + 70, y1 + 90).perform();

		driver.findElement(By.id("firstPageRadio")).click();// click on page all apge signature
		Thread.sleep(10000);
		driver.findElement(By.id("electronicModeRadio")).click();// choosing electronic sign
		driver.findElement(By.id("signaturePadBtn")).click();// click to sign
		driver.findElement(By.xpath("//*[@id=\"nav-home-tab\"]")).click();// pop window open

		driver.findElement(By.name("selectedFont")).click();// selecting font
		driver.findElement(By.id("adoptUploadBtn")).click();// apply button
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"submitBtn\"]/button/span")).click();// submit buuton
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[4]/button/span")).click();
		Thread.sleep(5000);

		System.out.println("electronic sign done  successfully");
		Thread.sleep(5000);

		driver.findElement(By.id("completeSigningBtn")).click();// Completesign
		Thread.sleep(3000);
		driver.navigate().to(uaturl4);
		Thread.sleep(3000);
		WebElement afdetails = driver
				.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div[2]/div/div[2]"));
		String Acc = afdetails.getText();
		System.out.println("Account details after signing : " + Acc);
		System.out.println("Discard and sign Is tested");
	//	driver.close();
	}

	@Test
	public void Cancelsigning() throws Exception {
		Openingapp();
		Thread.sleep(3000);
		WebElement details = driver
				.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div[2]/div/div[2]"));
		String acc = details.getText();
		System.out.println("Account details before signing : " + acc);
		Robot robot = new Robot();

		Thread.sleep(5000);
		driver.manage().window().maximize();
		WebElement signup = driver.findElement(By.linkText("Sign Document"));
		signup.click();
		// driver.get("https://uat.docuexec.com/docUpload");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"pdf-container1\"]/section/div/div/div/div/span[3]/input")).click();
		// uploading document by controlling my keyboard
		Thread.sleep(5000);

		StringSelection string = new StringSelection("D:\\Pdf for testing\\test.pdf");

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
				.findElement(By.xpath("//*[@id=\"markerDisplayInfo\"]"));// dragAnddrop
		Actions builder = new Actions(driver);
		int x = moving.getLocation().getX();
		int y = moving.getLocation().getY();
		builder.dragAndDropBy(moving, x + 70, y + 90).perform();

		Thread.sleep(3000);
		Comments();
//		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div/div[2]/div/div[3]/button"))
//				.click();
		Thread.sleep(3000);
		driver.findElement(By.id("firstPageRadio")).click();// click on page first
		// apge signature

//		driver.findElement(By.id("lastPageRadio")).click();
		driver.findElement(By.id("allPageRadio")).click();// all page


		Thread.sleep(3000);
		driver.findElement(By.id("electronicModeRadio")).click();// choosing
		// electronic sign
		driver.findElement(By.id("signaturePadBtn")).click();// click to sign
		driver.findElement(By.xpath("//*[@id=\"nav-home-tab\"]")).click();// pop window open
//
		driver.findElement(By.name("selectedFont")).click();// selecting font
		driver.findElement(By.id("adoptUploadBtn")).click();// apply button

		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scroll(0,1000)");
		Thread.sleep(3000);
		// driver.findElement(By.id("generateOtpBtn")).click();
		driver.findElement(By.xpath("//*[@id=\"submitBtn\"]/button/span")).click();// submit buuton
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[4]/button/span")).click();

//		System.out.println("document signed");
		Thread.sleep(5000);
	
//		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[4]/button/span")).click();
//		System.out.println("moves to priview page");
		Thread.sleep(5000);
		driver.findElement(By.id("cancelSigningBtn")).click();// cancel signing
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div[2]/button[1]")).click();
		System.out.println("sign canceled");
		driver.close();

	}

	@Test
	public void Alert() throws Exception {
		Openingapp();
		Robot robot = new Robot();

		Thread.sleep(5000);
		WebElement signup = driver.findElement(By.linkText("Sign Document"));
		signup.click();
		driver.get("https://uat.docuexec.com/docUpload");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"pdf-container1\"]/section/div/div/div/div/span[3]/input")).click();// uploading
																													// document
																													// by
																													// controlling
																													// my
																													// keyboard
		Thread.sleep(5000);

		StringSelection string = new StringSelection("C:\\Users\\sysadmin\\Desktop\\Pdf for testing\\test.pdf");

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

		driver.findElement(By.xpath("//*[@id=\"next-button\"]/span")).click();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"submitBtn\"]/button")).click();// submit button
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath(" /html/body/div[2]/div/div/div/div/button")).isDisplayed()
				+ ":popup displayed");
		driver.findElement(By.xpath(" /html/body/div[2]/div/div/div/div/button")).click();
		driver.close();

	}

}
