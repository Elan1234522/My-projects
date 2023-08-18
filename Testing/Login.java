package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	WebDriver driver;

	public WebDriver driverOP() throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		return driver;
	}

	@Test
	public void launchapp() throws Exception {
		driver = driverOP();
		driver.get("https://uat.docuexec.com/login");
		System.out.println("Browser launched");
driver.close();
	}

	@Test

	public void Valid_data() throws Exception {
		launchapp();
		driver.get("https://uat.docuexec.com/login");
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("9940783459");
		driver.findElement(By.id("myPassword")).sendKeys("Test@1234");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[3]/div[1]/button")).click();
		Thread.sleep(3000);
		System.out.println("details are valid ");
		driver.close();
//		Scenario1();
//	
//		Scenario2();

		// Scenario3();

		// Scenario4();
	}

	@Test
	public void Scenario1() throws Exception {
		launchapp();
		System.out.println("Sce-1 login with fullname");
		driver.get("https://uat.docuexec.com/login");
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("Elango");
		driver.findElement(By.id("myPassword")).sendKeys("Test@1234");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[3]/div[1]/button")).click();
		Thread.sleep(3000);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String page1 = "DocuExec";
		if (page1.equals(url)) {
			System.out.println("Login successfully");
		} else {
			System.out.println("login failed");
		}
		driver.close();
	}

	@Test
	public void Scenario2() throws Exception {
		launchapp();
		System.out.println("Sce -2 login with valid  Email id");
		driver.get("https://uat.docuexec.com/login");
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("officemailuse2@gmail.com");
		driver.findElement(By.id("myPassword")).sendKeys("Test@1234");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[3]/div[1]/button")).click();
		Thread.sleep(3000);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String page1 = "DocuExec";
		if (page1.equals(url)) {
			System.out.println("Login successfully");
		} else {
			System.out.println("login failed");
		}
		driver.close();
	}

	@Test
	public void Scenario3() throws Exception {
		launchapp();
		System.out.println("Sce-3 upper case Email id");
		driver.get("https://uat.docuexec.com/login");
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("ELANGOHARISH12@GMAIL.COM ");
		driver.findElement(By.id("myPassword")).sendKeys("Test@1234");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[3]/div[1]/button")).click();
		Thread.sleep(3000);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String page1 = "DocuExec";
		if (page1.equals(url)) {
			System.out.println("Login successfully");
		} else {
			System.out.println("login failed");
		}
		driver.close();
	}

	@Test

	public void Scenario4() throws Exception {
		launchapp();
		System.out.println(" Sec -4  Invalid mobile number");
		driver.get("https://uat.docuexec.com/login");
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("12345678901");
		driver.findElement(By.id("myPassword")).sendKeys("Test@1234");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[3]/div[1]/button")).click();
		Thread.sleep(3000);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String page1 = "DocuExec";
		if (page1.equals(url)) {
			System.out.println("Login successfully");
		} else {
			System.out.println("login failed");
		}
		driver.close();
	}

	@Test
	public void Invalid_data() throws Exception {
		launchapp();
		System.out.println("Browser launched");
		driver.get("https://uat.docuexec.com/login");
		Thread.sleep(5000);
		driver.findElement(By.name("username")).sendKeys("Elango");
		driver.findElement(By.id("myPassword")).sendKeys("Elango@12345");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[3]/div[1]/button")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.id("notification-wrapper")).isDisplayed() + " : invalid details");
		driver.close();
	}

	public void Forgetpass() throws Exception {
		launchapp();
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[3]/div[2]/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"getOTPForm\"]/div[1]/input")).sendKeys("nandhu");
		driver.findElement(
				By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div[1]/div/form[2]/div[1]/div[2]/div/button"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.id("newPassword")).sendKeys("Elango@123456");
		driver.findElement(By.id("repassword")).sendKeys("Elango@123456");
		Thread.sleep(30000);
		driver.findElement(
				By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div[1]/div/form[2]/div[2]/div[4]/div/button[1]"))
				.click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div")).isDisplayed()
				+ " : pop displayed");

		driver.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div")).click();
		driver.quit();
	}

}
