package Testing;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.apache.velocity.tools.generic.ClassTool.Sub;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Electronic_sign {

	WebDriver driver;

	private static String testurl = "https://uat.docuexec.com/login";
	// private static String testurl="https://docuexec.com/login";
	// private static String testurl="http://10.10.20.60:6656/login";
	public static String Login = testurl;

	private static String uaturl1 = "https://uat.docuexec.com/download/tokenSignDownload";
	// private static String
	// uaturl1="https://docuexec.com/download/tokenSignDownload";
	// private static String
	// uaturl1="https://10.10.20.60:6656/download/tokenSignDownload";
	public static String download = uaturl1;
	private static String uaturl3 = "https://uat.docuexec.com/inbox";
	// private static String uaturl3="https://docuexec.com/inbox";
	// private static String uaturl3="https://10.10.20.60:6656/inbox";
	public static String Inbox = uaturl3;

	private static String uaturl4 = "https://uat.docuexec.com/accountInfo";
	// private static String uaturl4="https://docuexec.com/accountInfo";
	// private static String uaturl4="https://10.10.20.60:6656/accountInfo";
	public static String accountInfo = uaturl4;

	public WebDriver driverOP() throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		return driver;
	}

	public void Comments() throws Exception {
		WebElement Comments = driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div/button"));
		Comments.click();

		WebElement in_cmnts = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/textarea"));
		in_cmnts.sendKeys("Its  for testing purpose");

		Thread.sleep(3000);

		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div/input")).click();

		WebElement OK_Button = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/button"));
		OK_Button.click();

	}

	@Test
	public void Signing() throws Exception {
		driver = driverOP();
		driver.get(testurl);
		driver.findElement(By.name("username")).sendKeys("9940783459");
		driver.findElement(By.id("myPassword")).sendKeys("Test@1234");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[3]/div[1]/button")).click();

		Thread.sleep(3000);
		Upload();
		Thread.sleep(5000);
		WebElement seals = driver.findElement(By.cssSelector("#markerDisplayInfo"));
		seals.click();
		Thread.sleep(3000);
		Actions builder = new Actions(driver);
		int x1 = seals.getLocation().getX();
		int y1 = seals.getLocation().getY();
		builder.dragAndDropBy(seals, x1 + 70, y1 + 70).perform();
		System.out.println("marker 5 moved");
		Thread.sleep(3000);

		driver.findElement(By.id("electronicModeRadio")).click();// choosing

		Thread.sleep(3000);
		WebElement Submit = driver
				.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[4]/div/div[2]/div[6]/button/span"));
		Submit.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[4]/button/span")).click();
	}

	@Test
	public void Upload() throws Exception {
		driver = driverOP();
		driver.get(testurl);
		driver.findElement(By.name("username")).sendKeys("9940783459");
		driver.findElement(By.id("myPassword")).sendKeys("Test@1234");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[3]/div[1]/button")).click();

		Thread.sleep(3000);

		String url = driver.getTitle();
		String page1 = "DocuExec";
		if (page1.equals(url)) {
			System.out.println("Login successfully");
		} else {
			System.out.println("login failed");
		}
		Thread.sleep(3000);
		WebElement details = driver
				.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div[2]/div/div[2]"));
		String acc = details.getText();
		System.out.println("Account details before signing : " + acc);
		Robot robot = new Robot();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		WebElement signup = driver.findElement(By.linkText("Sign Document"));
		signup.click();
		// driver.get("https://uat.docuexec.com/docUpload");
		Thread.sleep(3000);
		WebElement upload = driver.findElement(
				By.xpath("//*[@id=\"pdf-container1\"]/section/div/div/div/div/span[3]/input"));
		upload.click();
		// uploading document by controlling my keyboard
		Thread.sleep(3000);

		StringSelection string = new StringSelection("D:\\Pdf for testing\\test.pdf");
//		StringSelection string = new StringSelection("D:\\Pdf for testing\\Terms.pdf");

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(string, null);
		Thread.sleep(3000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(2000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"next-button\"]/span")).click();// uploading document

		System.out.println("document uploaded");
		Thread.sleep(3000);
		WebElement moving = driver.findElement(By.cssSelector("#markerDisplayInfo"));// dragAnddrop
		Thread.sleep(3000);
		Actions builder = new Actions(driver);
		int x = moving.getLocation().getX();
		int y = moving.getLocation().getY();
		builder.dragAndDropBy(moving, x + 70, y + 90).perform();
		System.out.println("marker moved");
		Thread.sleep(3000);
	}

	@Test
	public void Firstpage() throws Exception {
		Upload();
		Thread.sleep(3000);
		driver.findElement(By.id("firstPageRadio")).click();
		WebElement n = driver
				.findElement(By.xpath("//*[@id=\"outer-most-div\"]/div/div[1]/div/div/div[2]/div[1]/div/img"));
		n.click();
		Thread.sleep(3000);
		WebElement f = driver.findElement(By.xpath(
				"/html/body/div/div/div/main/div[2]/div/div[4]/div/div[1]/div/div/div[1]/div/div/div[1]/div[1]/div/img"));
		f.click();

//
		System.out.println("seal placed");
		driver.findElement(By.id("electronicModeRadio")).click();// choosing

		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scroll(0,1000)");
		Thread.sleep(5000);
		// driver.findElement(By.id("generateOtpBtn")).click();
		WebElement Submit = driver
				.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[4]/div/div[2]/div[6]/button/span"));
		Submit.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[4]/button/span")).click();

//		Thread.sleep(3000);
		WebElement button = driver
				.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div[1]/button[1]"));
		button.click();
		WebElement complete = driver
				.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div[1]/button[1]"));// Completesign
		complete.click();
		Thread.sleep(5000);
		driver.navigate().to(uaturl4);
		Thread.sleep(5000);
		WebElement afdetails = driver
				.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div[2]/div/div[2]"));
		String Acc = afdetails.getText();
		System.out.println("Account details before signing : " + Acc);
		System.out.println("first page  signed  sucessfully");
		Thread.sleep(5000);
	}

	@Test
	public void Last_page() throws Exception {

		Upload();
		Thread.sleep(3000);
		driver.findElement(By.id("lastPageRadio")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scroll(0,1000)");
		Thread.sleep(5000);

		Thread.sleep(2000);
		System.out.println("taking the location");

		System.out.println("seal placed");
		driver.findElement(By.id("electronicModeRadio")).click();// choosing

		Thread.sleep(3000);

		js.executeScript("window.scroll(0,1000)");
		Thread.sleep(5000);
		// driver.findElement(By.id("generateOtpBtn")).click();
		WebElement Submit = driver
				.findElement(By.xpath("//*[@id=\"submitBtn\"]/button/span"));
		Submit.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[4]/button/span")).click();

		Thread.sleep(5000);

		WebElement complete = driver.findElement(By.cssSelector("#completeSigningBtn"));// Completesign
		complete.click();
		Thread.sleep(5000);
		driver.navigate().to(uaturl4);
		Thread.sleep(3000);
		WebElement afdetails = driver
				.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div[2]/div/div[2]"));
		String Acc = afdetails.getText();
		System.out.println("Account details before signing : " + Acc);
		System.out.println("last page  signed  sucessfully");
//		
	}

	@Test
	public void Allpage() throws Exception {
		Upload();

		Thread.sleep(3000);
		driver.findElement(By.id("allPageRadio")).click();// all page
		Thread.sleep(3000);

		// Seal_postion();
		driver.findElement(By.id("electronicModeRadio")).click();// choosing
		Thread.sleep(3000);

		// electronic sign
//		driver.findElement(By.id("signaturePadBtn")).click();// click to sign
//		driver.findElement(By.xpath("//*[@id=\"nav-home-tab\"]")).click();// pop window open
//
//		driver.findElement(By.name("selectedFont")).click();// selecting font
//		driver.findElement(By.id("adoptUploadBtn")).click();// apply button
		// driver.findElement(By.id("aadhaarModeRadio")).click();// Aadhar signing
		// driver.findElement(By.id("otpSignModeRadio")).click();
		WebElement Submit = driver
				.findElement(By.xpath("//*[@id=\"submitBtn\"]/button/span"));
		Submit.click();

		System.out.println("document signed");

		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[4]/button/span")).click();

		Thread.sleep(5000);

		WebElement complete = driver.findElement(By.cssSelector("#completeSigningBtn"));// Completesign
		complete.click();
		Thread.sleep(3000);
		driver.navigate().to(uaturl4);
		Thread.sleep(3000);
		WebElement afdetails = driver
				.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div[2]/div/div[2]"));
		String Acc = afdetails.getText();
		System.out.println("Account details before signing : " + Acc);
		System.out.println("All  page  signed  sucessfully");
//		driver.close();
	}

	@Test
	public void Custompage() throws Exception {
		Upload();
		Thread.sleep(3000);
		driver.findElement(By.id("customPageRadio")).click();// custome page sign
		Thread.sleep(2000);
		driver.findElement(By.id("range-field")).sendKeys("1,2");

	driver.findElement(By.id("electronicModeRadio")).click();// choosing
		driver.findElement(By.id("signaturePadBtn")).click();// click to sign
		driver.findElement(By.xpath("//*[@id=\"nav-home-tab\"]")).click();// pop window open

		driver.findElement(By.name("selectedFont")).click();// selecting font
		driver.findElement(By.id("adoptUploadBtn")).click();// apply button
		// driver.findElement(By.id("aadhaarModeRadio")).click();// Aadhar signing
		// driver.findElement(By.id("otpSignModeRadio")).click();
		Thread.sleep(3000);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//
//		js.executeScript("window.scroll(0,1000)");
		// driver.findElement(By.id("generateOtpBtn")).click();

		WebElement Submit = driver
				.findElement(By.xpath("//*[@id=\"submitBtn\"]/button/span"));
		Submit.click();

		System.out.println("document signed");

		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[4]/button/span")).click();

		Thread.sleep(5000);

		WebElement complete = driver.findElement(By.cssSelector("#completeSigningBtn"));// Completesign
		complete.click();
		Thread.sleep(3000);
		driver.navigate().to(uaturl4);
		Thread.sleep(3000);
		WebElement afdetails = driver
				.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div[2]/div/div[2]"));
		String Acc = afdetails.getText();
		System.out.println("Account details before signing : " + Acc);
		System.out.println("Custom  page  signed  sucessfully");
	}

}
