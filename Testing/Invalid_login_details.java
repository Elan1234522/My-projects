package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Invalid_login_details
{
	WebDriver driver;
	@Test
	public void details() throws Exception
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://uat.docuexec.com/login");


//		driver.get("https://docuexec.com/login");
		System.out.println("Browser launched");
	driver.findElement(By.name("username")).sendKeys("Elango");
	driver.findElement(By.id("myPassword")).sendKeys("Elango@123");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[3]/div[1]/button")).click();
	Thread.sleep(3000);
	String tittle= driver.getCurrentUrl();
	System.out.println(tittle);
	//System.out.println(driver.findElement(By.id("notification-wrapper")).isDisplayed());
}
}