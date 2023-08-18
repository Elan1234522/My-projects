package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Inbox {

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
	public static String Inbox = uaturl3;
	
	private static String uaturl4 = "https://uat.docuexec.com/accountInfo";
	// private static String uaturl4="https://docuexec.com/accountInfo";
	// private static String uaturl4="https://10.10.20.60:6656/accountInfo";
	public static String accountInfo = uaturl4;
	
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
	public void Delete() throws Exception {
		Launchapp();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get(Inbox);
		Thread.sleep(3000);
		WebElement del_but = driver.findElement(By.xpath("//*[@id=\"deleteIconColor\"]"));
		del_but.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div[2]/button[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button")).click();
		System.out.println("Document deleted");
driver.close();
	}

	@Test
	public void View() throws Exception {
		Launchapp();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get(Inbox);
		Thread.sleep(4000);
		WebElement View_button = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/main/div[2]/div/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[8]/div/button"));
		View_button.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"viewBtn\"]")).click();
		System.out.println("View Functionality tested");
	}

	@Test
	public void Inbox_sign() throws Exception {
		Launchapp();
		WebElement details = driver
				.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div[2]/div/div[2]"));
		String acc = details.getText();
		System.out.println("Account details before signing : " + acc);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get(Inbox);
		Thread.sleep(4000);
		WebElement Sign_but = driver.findElement(By.xpath(
				"//*[@id=\"defaultBackGround\"]/main/div[2]/div/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[7]/div/button[3]/span[1]"));
		Sign_but.click();
		Thread.sleep(3000);
		WebElement moving = driver.findElement(By.xpath("//*[@id=\"markerDisplayInfo\"]"));
		Actions builder = new Actions(driver);
		int x = moving.getLocation().getX();
		int y = moving.getLocation().getY();
		builder.dragAndDropBy(moving, x + 338, y + 187).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"submitBtn\"]/button/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[4]/button/span")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("completeSigningBtn")).click();// Completesign
		Thread.sleep(3000);
		driver.navigate().to(uaturl4);
		Thread.sleep(3000);
		WebElement afdetails = driver
				.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div[2]/div/div[2]"));
		String Acc = afdetails.getText();
		System.out.println("Account details before signing : " + Acc);
	}
}
