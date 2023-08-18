package Testing;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Signing_Seal {

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
		WebElement upload = driver
				.findElement(By.cssSelector("#pdf-container1 > section > div > div > div > div > span:nth-child(6) > input"));
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
		Thread.sleep(5000);
		WebElement moving = driver
				.findElement(By.xpath("//*[@id=\"markerDisplayInfo\"]"));// dragAnddrop
		Thread.sleep(3000);
		Actions builder = new Actions(driver);
		int x = moving.getLocation().getX();
		int y = moving.getLocation().getY();
		builder.dragAndDropBy(moving, x + 70, y + 90).perform();
		System.out.println("marker moved");
		Thread.sleep(3000);
	}
	public void Seal_postion() throws Exception {
		Upload();
		Thread.sleep(3000);

		for (int i = 1; i <= 5; i++) {
			WebElement Addseals = driver.findElement(By.xpath("//*[@id=\"signaturePage\"]"));
			Addseals.click();

		}

		Thread.sleep(3000);
		WebElement Seal1 = driver.findElement(By.cssSelector("#draggable5"));
		Seal1.click();// dragAnddrop
		Thread.sleep(5000);
		Actions builder = new Actions(driver);
		int x = Seal1.getLocation().getX();
		String loc = "" + x;
		System.out.println(loc);

		System.out.println();
		int y = Seal1.getLocation().getY();
		String loc1 = "" + y;
		System.out.println(loc1);
		builder.dragAndDropBy(Seal1, x + 365, y - 165).perform();
		System.out.println("marker1 moved");

		// builder.dragAndDropBy(Seal1, x + 356, y -165).perform();//default

		Thread.sleep(3000);

		WebElement seals2 = driver.findElement(By.cssSelector("#draggable4"));
		seals2.click();
		Thread.sleep(3000);
		Actions builder1 = new Actions(driver);
		int x1 = seals2.getLocation().getX();
		int y1 = seals2.getLocation().getY();
		builder1.dragAndDropBy(seals2, x1 - 365, y1 + 330).perform();
		System.out.println("marker 2 moved");

		WebElement seals3 = driver.findElement(By.cssSelector("#draggable3"));
		seals3.click();
		Thread.sleep(3000);
		Actions builder2 = new Actions(driver);
		int x2 = seals3.getLocation().getX();
		int y2 = seals3.getLocation().getY();
		builder2.dragAndDropBy(seals3, x2 + 365, y2 + 330).perform();
		System.out.println("marker 3 moved");

		WebElement seals4 = driver.findElement(By.cssSelector("#draggable2"));
		seals4.click();
		Thread.sleep(3000);
		Actions builder3 = new Actions(driver);
		int x3 = seals4.getLocation().getX();
		int y3 = seals4.getLocation().getY();
		builder3.dragAndDropBy(seals4, x3 - 51, y3 + 38).perform();
		System.out.println("marker 4 moved");
//	

		WebElement seals5 = driver.findElement(By.cssSelector("#draggable1"));
		seals5.click();
		Thread.sleep(3000);
		Actions builder4 = new Actions(driver);
		int x5 = seals5.getLocation().getX();
		int y5 = seals5.getLocation().getY();
		builder4.dragAndDropBy(seals5, x5 - 330, y5 - 170).perform();
		System.out.println("marker 5 moved");
//
//		WebElement Submit = driver
//				.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[4]/div/div[2]/div[6]/button/span"));
//		Submit.click();

	}
	@Test
	public void Firstpage() throws Exception {
		Upload();
		Thread.sleep(3000);
		driver.findElement(By.id("firstPageRadio")).click();
		WebElement n = driver.findElement(By.xpath("//*[@id=\"outer-most-div\"]/div/div[1]/div/div/div[2]/div[1]/div/img"));
		n.click();
		Thread.sleep(3000);
		WebElement f=driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[4]/div/div[1]/div/div/div[1]/div/div/div[1]/div[1]/div/img"));
		f.click();
//		Thread.sleep(3000);
//		WebElement Addseals = driver.findElement(By.xpath("//*[@id=\"signaturePage\"]"));
//		Addseals.click();
//
//		WebElement seals5 = driver.findElement(By.cssSelector("#draggable1"));
//		seals5.click();
//		Thread.sleep(3000);
//		Actions builder4 = new Actions(driver);
//		int x5 = seals5.getLocation().getX();
//		int y5 = seals5.getLocation().getY();
//		builder4.dragAndDropBy(seals5, x5, y5).perform();
//		System.out.println("marker 5 moved");
//		Thread.sleep(3000);
//
//		WebElement seals6 = driver.findElement(By.cssSelector("#draggable1"));
//		seals6.click();
//		Actions builder5 = new Actions(driver);
//		int x6 = seals6.getLocation().getX();
//		String loc = "" + x6;
//		System.out.println("default X axis :" + loc);
//		int y6 = seals6.getLocation().getY();
//		String loc1 = "" + y6;
//		System.out.println("default y axis :" + loc1);
//		builder5.dragAndDropBy(seals5, x6 - 700, y6 - 200).perform();
//
////
//		Thread.sleep(2000);
//		System.out.println("taking the location");
//
//		WebElement seals7 = driver.findElement(By.cssSelector("#draggable1"));
//		seals7.click();
//
//		Actions builder6 = new Actions(driver);
//		int x7 = seals7.getLocation().getX();
//		String loc2 = "" + x7;
//		System.out.println("2nd location  of X:" + loc2);
//		int y7 = seals7.getLocation().getY();
//		String loc3 = "" + y7;
//		System.out.println("2nd loactaion of y :" + loc3);
//		builder6.dragAndDropBy(seals7, 0, -100).perform();
//
////		Actions builder7 = new Actions(driver);		
////		int x8 = seals7.getLocation().getX();
////		String loc4 = "" + x8;
////		System.out.println(" location  of X:" + loc4);
////		int y8 = seals7.getLocation().getY();
////		String loc5 = "" + y8;
////		System.out.println("y axis" + loc5);
//
		System.out.println("seal placed");
		driver.findElement(By.id("electronicModeRadio")).click();// choosing

		Thread.sleep(3000);
//		JavascriptExecutor js = (JavascriptExecutor) driver;

//		js.executeScript("window.scroll(0,1000)");
		Thread.sleep(5000);
		// driver.findElement(By.id("generateOtpBtn")).click();
		WebElement Submit = driver
				.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[4]/div/div[2]/div[6]/button/span"));
		Submit.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[4]/button/span")).click();

//		Thread.sleep(3000);
////		WebElement button = driver
////				.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div[1]/button[1]"));
////		button.click();
//		WebElement complete = driver
//				.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div[1]/button[1]"));// Completesign
//		complete.click();
//		Thread.sleep(5000);
//		driver.navigate().to(uaturl4);
//		Thread.sleep(5000);
//		WebElement afdetails = driver
//				.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div[2]/div/div[2]"));
//		String Acc = afdetails.getText();
//		System.out.println("Account details before signing : " + Acc);
//		System.out.println("first page  signed  sucessfully");
//		Thread.sleep(5000);
	}
	
	
	public void Allpage() throws Exception {
		Upload();

		Thread.sleep(3000);
		driver.findElement(By.id("allPage")).click();// all page
		Thread.sleep(3000);
		WebElement Addseals = driver.findElement(By.xpath("//*[@id=\"signaturePage\"]"));
		Addseals.click();
//		WebElement page2=driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[4]/div/div[1]/div/div/div[1]/div/div/div[2]"));
//		page2.click();
//		
		Thread.sleep(3000);
		WebElement Seal1 = driver.findElement(By.cssSelector("#draggable1"));
		Seal1.click();// dragAnddrop

		Thread.sleep(3000);

		Actions builder = new Actions(driver);
		int x = Seal1.getLocation().getX();
		String loc = "" + x;
		System.out.println("default X axis :" + loc);
		int y = Seal1.getLocation().getY();
		String loc1 = "" + y;
		System.out.println("default y axis :" + loc1);
		builder.dragAndDropBy(Seal1, x + 70, y + 85).perform();
		Thread.sleep(3000);
		System.out.println("Seal placed");
		Thread.sleep(2000);
		WebElement Msg_check = driver.findElement(By.xpath("/html/body/div[2]/div/div/div"));
		Msg_check.isDisplayed();
		String message = Msg_check.getText();
		System.out.println(message);
		Thread.sleep(2000);

		WebElement Apply = driver
				.findElement(By.cssSelector("#react-confirm-alert > div > div > div > div > button.confirmBtn"));
		Apply.click();

		WebElement seals6 = driver.findElement(By.cssSelector("#draggable1"));
		seals6.click();
		Actions builder5 = new Actions(driver);
		int x6 = seals6.getLocation().getX();
		String loc2 = "" + x6;
		System.out.println(" X axis :" + loc2);
		int y6 = seals6.getLocation().getY();
		String loc3 = "" + y6;
		System.out.println(" y axis :" + loc3);
		builder5.dragAndDropBy(seals6, 0, -100).perform();
		Thread.sleep(3000);

		Thread.sleep(2000);

		WebElement Apply2 = driver
				.findElement(By.cssSelector("#react-confirm-alert > div > div > div > div > button.confirmBtn"));
		Apply2.click();

		WebElement seals7 = driver.findElement(By.cssSelector("#draggable1"));
		seals7.click();

		Actions builder6 = new Actions(driver);
		int x7 = seals7.getLocation().getX();
		String loc4 = "" + x7;
		System.out.println("2nd location  of X:" + loc4);
		int y7 = seals7.getLocation().getY();
		String loc5 = "" + y7;
		System.out.println("2nd location of y :" + loc5);
		builder6.dragAndDropBy(seals7, 0, -100).perform();
		WebElement Apply3 = driver
				.findElement(By.cssSelector("#react-confirm-alert > div > div > div > div > button.confirmBtn"));
		Apply3.click();

//		JavascriptExecutor js = (JavascriptExecutor) driver;
//
//		js.executeScript("window.scroll(0,1000)");
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
				.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[4]/div/div[2]/div[6]/button/span"));
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

	public void Custompage() throws Exception {
		Upload();
		Thread.sleep(3000);
		driver.findElement(By.id("customPage")).click();// custome page sign
		Thread.sleep(2000);
		driver.findElement(By.id("range-fieldIdAdd")).sendKeys("1,2");

		WebElement Addseals = driver.findElement(By.xpath("//*[@id=\"signaturePage\"]"));
		Addseals.click();

		WebElement Seal1 = driver.findElement(By.xpath(
				"/html/body/div/div/div/main/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/div/div/div/div[1]/div[2]/div"));
		Seal1.click();// dragAnddrop

		Thread.sleep(3000);

		Actions builder = new Actions(driver);
		int x = Seal1.getLocation().getX();
		String loc = "" + x;
		System.out.println("default X axis :" + loc);
		int y = Seal1.getLocation().getY();
		String loc1 = "" + y;
		System.out.println("default y axis :" + loc1);
		builder.dragAndDropBy(Seal1, x + 70, y + 85).perform();
		Thread.sleep(3000);
		System.out.println("Seal placed");
		Thread.sleep(2000);
		WebElement Msg_check = driver.findElement(By.xpath("/html/body/div[2]/div/div/div"));
		Msg_check.isDisplayed();
		String message = Msg_check.getText();
		System.out.println(message);
		Thread.sleep(2000);
		WebElement Apply = driver.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button[1]"));
		Apply.click();
		Thread.sleep(3000);

		WebElement seals6 = driver.findElement(By.cssSelector("#draggable1"));
		seals6.click();
		Actions builder5 = new Actions(driver);
		int x6 = seals6.getLocation().getX();
		String loc2 = "" + x6;
		System.out.println(" X axis :" + loc2);
		int y6 = seals6.getLocation().getY();
		String loc3 = "" + y6;
		System.out.println(" y axis :" + loc3);
		builder5.dragAndDropBy(seals6, 0, -100).perform();
		Thread.sleep(3000);

		Thread.sleep(2000);

		WebElement Apply2 = driver
				.findElement(By.cssSelector("#react-confirm-alert > div > div > div > div > button.confirmBtn"));
		Apply2.click();

		WebElement seals7 = driver.findElement(By.cssSelector("#draggable1"));
		seals7.click();

		Actions builder6 = new Actions(driver);
		int x7 = seals7.getLocation().getX();
		String loc4 = "" + x7;
		System.out.println("2nd location  of X:" + loc4);
		int y7 = seals7.getLocation().getY();
		String loc5 = "" + y7;
		System.out.println("2nd location of y :" + loc5);
		builder6.dragAndDropBy(seals7, 0, -100).perform();
		WebElement Apply3 = driver
				.findElement(By.cssSelector("#react-confirm-alert > div > div > div > div > button.confirmBtn"));
		Apply3.click();

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
				.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[4]/div/div[2]/div[6]/button/span"));
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
