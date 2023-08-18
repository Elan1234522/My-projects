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

public class Intiate_signing {
	
	WebDriver driver;

	public void Openingapp() throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://docuexec.com/login");
		driver.findElement(By.name("username")).sendKeys("6380695905");
		driver.findElement(By.id("myPassword")).sendKeys("Test@1234");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[3]/div[1]/button")).click();
		Thread.sleep(3000);
		System.out.println("login successfully");
	}

	public void UploadDoc() throws Exception {
		Robot robot = new Robot();

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
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div[4]/button/span")).click();
		System.out.println("File uploaded");
	}
	//private static String Url_login="https://docuexec.com/login";
	private static String Url_login="https://uat.docuexec.com/login";
	//private static String Url_login="http://10.10.20.60:6656/login";
	String Loginurl =Url_login;


	private static String URL="https://uat.docuexec.com/docUpload";
	//private static String  Url1="https://docuexec.com/docUpload";
	//private static String URL="http://10.10.20.60:6656/login";

	String Doc_url=URL;
	
	public WebDriver driverIbj() throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		return driver;
	}
	
	public void Comments()throws Exception{
		
		WebElement in_cmnts= driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/div[1]/textarea"));
		in_cmnts.sendKeys("Its  for testing purpose");
		  
		Thread.sleep(3000);
	
	}
	
	@Test
	public void Singlesigner() throws Exception{

		 driver =driverIbj();

		driver.get(Url_login);
		driver.findElement(By.name("username")).sendKeys("9940783459");
		driver.findElement(By.id("myPassword")).sendKeys("Test@1234");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[3]/div[1]/button")).click();
		Thread.sleep(3000);
		System.out.println("login successfully");
		WebElement signup = driver.findElement(By.linkText("Sign Document"));
		signup.click();
		
		Thread.sleep(8000);
		driver.findElement(By.xpath("//*[@id=\"pdf-container1\"]/section/div/div/div/div/span[3]/input")).click();
		// driver.get("https://docuexec.com/docUpload");
		UploadDoc();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		 Comments();
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/input[1]")).click();

		driver.findElement(By.name("signerName")).sendKeys("Elango");
		driver.findElement(By.name("signerMobile")).sendKeys("6380695905");
		driver.findElement(By.id("mailfield")).sendKeys("elangos@integramicro.co.in");
		 driver.findElement(By.name("custDocName")).click();
		 driver.findElement(By.name("custDocName")).clear(); ///new feature
		 driver.findElement(By.name("custDocName")).sendKeys("same  page");
		 driver.findElement(By.id("next-button")).click();
		 Thread.sleep(3000);
		
		 
			Thread.sleep(3000);
			WebElement moving = driver.findElement(By.id("drag-item"));
			Actions builder = new Actions(driver);
			int x = moving.getLocation().getX();	
			int y = moving.getLocation().getY();
			builder.dragAndDropBy(moving, x + 40, y + 100).perform();
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div/div[2]/div[5]/button/span"))
					.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/button[1]")).click();
		
			System.out.println("Single signer intiation is done");	
		
	}
	
	
	
	
	@Test
	public void Firstpage() throws Exception {

		 driver =driverIbj();

		driver.get(Url_login);
		driver.findElement(By.name("username")).sendKeys("9940783459");
		driver.findElement(By.id("myPassword")).sendKeys("Test@1234");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[3]/div[1]/button")).click();
		Thread.sleep(3000);
		System.out.println("login successfully");
		WebElement signup = driver.findElement(By.linkText("Sign Document"));
		signup.click();
		
		Thread.sleep(8000);
		driver.findElement(By.xpath("//*[@id=\"pdf-container1\"]/section/div/div/div/div/span[3]/input")).click();
		// driver.get("https://docuexec.com/docUpload");
		UploadDoc();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/input[1]")).click();

		driver.findElement(By.name("signerName")).sendKeys("Elango");
		driver.findElement(By.name("signerMobile")).sendKeys("9940783459");
		driver.findElement(By.id("mailfield")).sendKeys("officemailuse2@gmail.com");
		 driver.findElement(By.name("custDocName")).click();
		 driver.findElement(By.name("custDocName")).clear(); ///new feature
		 driver.findElement(By.name("custDocName")).sendKeys("same  page");
		 Comments();
		 Thread.sleep(3000);
	WebElement Next_Sign=	driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/div[3]/button"));
	Next_Sign.click();

		Thread.sleep(3000);
		// Second person
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/div[3]/div/input[1]"))
				.sendKeys("electronic");
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/div[3]/div/input[2]"))
				.sendKeys("6380695905");
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/div[3]/div/input[3]"))
				.sendKeys("elangoharish12@gmail.com");
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/div[4]/button")).click();
		// Thirdperson
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/div[4]/div/input[1]"))
				.sendKeys("Harshi");
		 Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/div[4]/div/input[2]"))
				.sendKeys("6361579075");
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/div[4]/div/input[3]"))
				.sendKeys("harshithhv@integramicro.co.in");
	
		driver.findElement(By.id("next-button")).click();

		
		Firstadjustment();
		SecAdjustment();
		ThirdAdjustment();
		driver.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div[2]/button[1]")).click();
		System.out.println("First page sign done successfully");
	

	}

	public void Firstadjustment() throws Exception {
		Thread.sleep(9000);
		WebElement moving = driver.findElement(By.id("drag-item"));
		Actions builder = new Actions(driver);
		int x = moving.getLocation().getX();
		int y = moving.getLocation().getY();
		builder.dragAndDropBy(moving, x + 338, y + 187).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div/div[2]/div[6]/button/span"))
				.click();
	}

	public void SecAdjustment() throws Exception {
		Thread.sleep(5000);
		WebElement moving = driver.findElement(By.id("drag-item"));
		Actions builder = new Actions(driver);
		int x = moving.getLocation().getX();
		int y = moving.getLocation().getY();
		builder.dragAndDropBy(moving, x + 90, y + 120).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div/div[2]/div[6]/button/span"))
				.click();
	}

	public void ThirdAdjustment() throws Exception {
		Thread.sleep(5000);
		WebElement moving = driver.findElement(By.id("drag-item"));
		Actions builder = new Actions(driver);
		int x = moving.getLocation().getX();	
		int y = moving.getLocation().getY();
		builder.dragAndDropBy(moving, x + 40, y + 100).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div/div[2]/div[5]/button/span"))
				.click();
	}


private static String Url1="https://uat.docuexec.com/docUpload";
//private static String  Url1="https://docuexec.com/docUpload";
//private static String Url1="http://10.10.20.60:6656/docUpload";

String uploadurl=Url1;


	@Test
	public void Differentmodes() throws Exception {
		 driver =driverIbj();
		driver.get(Loginurl);
		driver.findElement(By.name("username")).sendKeys("9940783459");
		driver.findElement(By.id("myPassword")).sendKeys("Test@1234");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[3]/div[1]/button")).click();
		Thread.sleep(3000);
		System.out.println("login successfully");
		WebElement signup = driver.findElement(By.linkText("Sign Document"));
		signup.click();
		driver.get(uploadurl);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"pdf-container1\"]/section/div/div/div/div/span[3]/input")).click();

		//
		Robot robot = new Robot();

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
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div[4]/button/span")).click();
		System.out.println("File uploaded");
//		
		

		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/input[1]")).click();//enable sign order
		driver.findElement(By.name("signerName")).sendKeys("Aadhar signing");
		driver.findElement(By.name("signerMobile")).sendKeys("9940783459");
		driver.findElement(By.id("mailfield")).sendKeys("Elangosubramani12@gmail.com");
		 driver.findElement(By.name("custDocName")).click();
		 driver.findElement(By.name("custDocName")).clear(); ///new feature
		 driver.findElement(By.name("custDocName")).sendKeys("Different modes");
		 Comments();
		 Thread.sleep(3000);
	WebElement Next_Sign=	driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/div[3]/button"));
	Next_Sign.click();

		Thread.sleep(3000);
		// Second person
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/div[3]/div/input[1]"))
				.sendKeys("electronic");
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/div[3]/div/input[2]"))
				.sendKeys("6380695905");
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/div[3]/div/input[3]"))
				.sendKeys("elangoharish12@gmail.com");
//		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/div[4]/button")).click();
//		// Thirdperson
//		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/div[4]/div/input[1]"))
//				.sendKeys("Harshi");
//		 Thread.sleep(3000);
//		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/div[4]/div/input[2]"))
//				.sendKeys("6361579075");
//		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/div[4]/div/input[3]"))
//				.sendKeys("harshithhv@integramicro.co.in");
//		driver.findElement(By.xpath("//*[@id=\"defaultBackGround\"]/main/div[2]/div/form/div[5]/button")).click();
//		 Thread.sleep(3000);
//		 //fourth person
//		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/div[5]/div/input[1]"))
//				.sendKeys("Hem");
//		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/div[5]/div/input[2]"))
//				.sendKeys("9742500802");
//		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/div[5]/div/input[3]"))
//				.sendKeys("Hemagowda755@gmail.com");
//		Thread.sleep(3000);
		driver.findElement(By.id("next-button")).click();
//		Currentpage();
//		Custompage();
	     Lastpage();
		Allpage();
		driver.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div[2]/button[1]")).click();
		System.out.println("Different types of sign done successfully");
//		

	}	

	public void Currentpage() throws Exception {

		Thread.sleep(3000);
		driver.findElement(
				By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div/div[2]/div[3]/div[2]/div[1]/div[2]"))
				.click();// current page
		WebElement moving = driver.findElement(By.id("drag-item"));
		Actions builder = new Actions(driver);
		int x = moving.getLocation().getX();
		int y = moving.getLocation().getY();
		builder.dragAndDropBy(moving, x + 90, y + 90).perform();
		Thread.sleep(5000);
		
		
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div/div[2]/div[6]/button/span"))
				.click();
	}

	public void Custompage() throws Exception {
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div/div[2]/div[3]/div[2]/div[2]/div[1]/input"))
				.click();
		driver.findElement(By.xpath(
				"//*[@id=\"defaultBackGround\"]/main/div[2]/div/div[2]/div/div[2]/div[3]/div[2]/div[2]/div[2]/input"))
				.sendKeys("5,6,7,8");
		Thread.sleep(3000);
		WebElement moving = driver.findElement(By.id("drag-item"));
		Actions builder = new Actions(driver);
		int x = moving.getLocation().getX();
		int y = moving.getLocation().getY();
		builder.dragAndDropBy(moving, x + 50, y + 60).perform();
		Thread.sleep(3000);
		driver.findElement(By.id("aadhaarModeRadio")).click();// Aadhar signing
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"nextBtn\"]/span")).click();
	}

	public void Lastpage() throws Exception {
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div/div[2]/div[3]/div[2]/div[1]/div[3]/input"))
				.click();
		Thread.sleep(3000);
		WebElement moving = driver.findElement(By.id("drag-item"));
		Actions builder = new Actions(driver);
		int x = moving.getLocation().getX();
		int y = moving.getLocation().getY();
		builder.dragAndDropBy(moving, x + 40, y + 10).perform();
		Thread.sleep(3000);
		driver.findElement(By.id("electronicModeRadio")).click();
//		driver.findElement(
//				By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div/div[2]/div[5]/div[2]/div[2]/div[1]/input"))
//				.click();
		//driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div/div[2]/div[5]/button/span")).click();//Intiate signing

		//driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div/div[2]/div[6]/button/span"))
			//	.click();
	}

	public void Allpage() throws Exception {
		driver.findElement(
				By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div/div[2]/div[3]/div[2]/div[1]/div[4]/input"))
				.click();
		Thread.sleep(5000);
		WebElement moving = driver.findElement(By.id("drag-item"));

		Actions builder = new Actions(driver);
		int x = moving.getLocation().getX();
		int y = moving.getLocation().getY();
		builder.dragAndDropBy(moving, x + 40, y + 30).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div/div[2]/div[4]/div[2]/div[2]/div/input")).click();
		Thread.sleep(3000);
	driver.findElement(By.id("selfDscTokenModeRadio")).click();
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div/div[2]/div[5]/button/span"))
				.click();
	}
}
