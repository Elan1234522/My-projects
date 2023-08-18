package Testing;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Template_Feature {
	static WebDriver driver;

//	private static String testurl = "https://uat.docuexec.com/login";
//	 private static String testurl="http://10.10.20.60:6656/login";
	 private static String testurl = "https://docuexec.com/login";
	public static String Login = testurl;

//	private static String uaturl1 = "https://uat.docuexec.com/download/tokenSignDownload";
	 private static String
	 uaturl1="https://docuexec.com/download/tokenSignDownload";
	 
	// private static String uaturl1="https://10.10.20.60:6656/download/tokenSignDownload";
	public static String download = uaturl1;
//	private static String uaturl3 = "https://uat.docuexec.com/inbox";
	private static String uaturl3="https://docuexec.com/inbox";
	// private static String uaturl3="https://10.10.20.60:6656/inbox";
	public static String Inbox = uaturl3;

//	private static String uaturl4 = "https://uat.docuexec.com/accountInfo";
	 private static String uaturl4="https://docuexec.com/accountInfo";
	// private static String uaturl4="https://10.10.20.60:6656/accountInfo";
	public static String accountInfo = uaturl4;

	public static WebDriver driverOP() throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		return driver;
	}

	@Test
	public static void Template_upload() throws Exception {
		driver = driverOP();
		driver.get(testurl);

		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("9901947380");
		driver.findElement(By.id("myPassword")).click();
		driver.findElement(By.id("myPassword")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("myPassword")).sendKeys("Jsignadmin@123");
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(3000);
		driver.manage().window().maximize();

		driver.findElement(By.linkText("Upload Template")).click();
		Thread.sleep(3000);
		WebElement upload = driver.findElement(
				By.xpath("/html/body/div/div/div/main/div[2]/div[2]/div[1]/div[2]/div/div/div/span[3]/input"));
		upload.click();

		StringSelection string = new StringSelection(
				"C:\\Users\\sysadmin\\Downloads\\To Whomsoever It May Concern.html");

		Thread.sleep(3000);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(string, null);
		Thread.sleep(3000);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(2000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);

		WebElement Proceed = driver
				.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div[2]/div[2]/button/span"));
		Proceed.click();

		Thread.sleep(3000);
		driver.findElement(By.id("templateName")).click();
		driver.findElement(By.id("templateName")).clear();
		driver.findElement(By.id("templateName")).sendKeys("Testing Agreement");
		driver.findElement(By.id("templateCode")).click();
		driver.findElement(By.id("templateCode")).clear();
		driver.findElement(By.id("templateCode")).sendKeys("TEMP0002");
		driver.findElement(By.id("templateDescp")).click();
		driver.findElement(By.id("templateDescp")).clear();
		driver.findElement(By.id("templateDescp")).sendKeys("For Testing");
		driver.findElement(By.id("group")).click();

		new Select(driver.findElement(By.id("group"))).selectByVisibleText("Agreement Templates");

		Thread.sleep(3000);
		driver.findElement(By.id("subGroup")).click();
		driver.findElement(By.id("subGroup")).sendKeys("concern1");

		driver.findElement(By.xpath(
				"//div[@id='defaultBackGround']/main/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/form/div/div[2]/div/button"))
				.click();
		driver.findElement(By.id("datelabel")).clear();
		driver.findElement(By.id("datelabel")).sendKeys("Date");
		driver.findElement(By.id("dateplaceHolder")).click();
		driver.findElement(By.id("dateplaceHolder")).clear();
		driver.findElement(By.id("dateplaceHolder")).sendKeys("Enter the date");
		driver.findElement(By.id("dateinputDescription")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("dateinputDescription")).clear();
		driver.findElement(By.id("dateinputDescription")).sendKeys("DATE");
		driver.findElement(By.id("datedataType")).click();
		new Select(driver.findElement(By.id("datedataType"))).selectByVisibleText("date");
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]"))
				.click();
		driver.findElement(By.xpath(
				"//div[@id='defaultBackGround']/main/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/form/div[2]/div[2]/div/button"))
				.click();
		driver.findElement(By.id("namelabel")).clear();
		driver.findElement(By.id("namelabel")).sendKeys("Employee Name");
		driver.findElement(By.id("nameplaceHolder")).click();
		driver.findElement(By.id("nameplaceHolder")).clear();
		driver.findElement(By.id("nameplaceHolder")).sendKeys("Enter the name");
		driver.findElement(By.id("nameinputDescription")).click();
		driver.findElement(By.id("nameinputDescription")).clear();
		driver.findElement(By.id("nameinputDescription")).sendKeys("Employee name");
		driver.findElement(By.id("namedataType")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("nameminLength")).click();
		driver.findElement(By.id("nameminLength")).clear();
		driver.findElement(By.id("nameminLength")).sendKeys("1");
		driver.findElement(By.id("namemaxLength")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("namemaxLength")).clear();
		driver.findElement(By.id("namemaxLength")).sendKeys("10");
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]"))
				.click();
		driver.findElement(By.xpath(
				"//div[@id='defaultBackGround']/main/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/form/div[3]/div[2]/div/button"))
				.click();
		driver.findElement(By.id("agelabel")).clear();
		driver.findElement(By.id("agelabel")).sendKeys("AGE");
		driver.findElement(By.id("ageplaceHolder")).click();
		driver.findElement(By.id("ageplaceHolder")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("ageplaceHolder")).clear();
		driver.findElement(By.id("ageplaceHolder")).sendKeys("Employee Age");
		driver.findElement(By.id("ageinputDescription")).click();
		driver.findElement(By.id("ageinputDescription")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("ageinputDescription")).sendKeys("Age");
		Thread.sleep(3000);
		driver.findElement(By.id("agedataType")).click();
		new Select(driver.findElement(By.id("agedataType"))).selectByVisibleText("text");
		driver.findElement(By.id("ageminLength")).click();
		driver.findElement(By.id("ageminLength")).clear();
		driver.findElement(By.id("ageminLength")).sendKeys("1");
		driver.findElement(By.id("agemaxLength")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("agemaxLength")).clear();
		driver.findElement(By.id("agemaxLength")).sendKeys("2");
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]"))
				.click();
		driver.findElement(By.xpath(
				"//div[@id='defaultBackGround']/main/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/form/div[4]/div[2]/div/button"))
				.click();
		driver.findElement(By.id("addresslabel")).clear();
		driver.findElement(By.id("addresslabel")).sendKeys("Address");
		driver.findElement(By.id("addressplaceHolder")).click();
		driver.findElement(By.id("addressplaceHolder")).click();
		driver.findElement(By.id("addressplaceHolder")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("addressplaceHolder")).sendKeys("Enter the address");
		driver.findElement(By.id("addressinputDescription")).click();
		driver.findElement(By.id("addressinputDescription")).clear();
		driver.findElement(By.id("addressinputDescription")).sendKeys("Address");
		driver.findElement(By.id("addressminLength")).click();
		driver.findElement(By.id("addressminLength")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("addressminLength")).sendKeys("1");
		driver.findElement(By.id("addressmaxLength")).click();
		driver.findElement(By.id("addressmaxLength")).clear();
		driver.findElement(By.id("addressmaxLength")).sendKeys("30");
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]"))
				.click();
		driver.findElement(By.xpath(
				"//div[@id='defaultBackGround']/main/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/form/div[5]/div[2]/div/button"))
				.click();
		driver.findElement(By.id("bankNamelabel")).clear();
		driver.findElement(By.id("bankNamelabel")).sendKeys("Bank");
		driver.findElement(By.id("bankNameplaceHolder")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("bankNameplaceHolder")).clear();
		driver.findElement(By.id("bankNameplaceHolder")).sendKeys("Name of the Bank");
		driver.findElement(By.id("bankNameinputDescription")).click();
		driver.findElement(By.id("bankNameinputDescription")).click();
		driver.findElement(By.id("bankNameinputDescription")).clear();
		driver.findElement(By.id("bankNameinputDescription")).sendKeys("Bank name");
		driver.findElement(By.id("bankNamedataType")).click();
		driver.findElement(By.id("bankNameminLength")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("bankNameminLength")).clear();
		driver.findElement(By.id("bankNameminLength")).sendKeys("1");
		driver.findElement(By.id("bankNamemaxLength")).click();
		driver.findElement(By.id("bankNamemaxLength")).clear();
		driver.findElement(By.id("bankNamemaxLength")).sendKeys("10");
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]"))
				.click();
		driver.findElement(By.xpath(
				"//div[@id='defaultBackGround']/main/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/form/div[6]/div[2]/div/button"))
				.click();
		driver.findElement(By.id("bankAddresslabel")).clear();
		driver.findElement(By.id("bankAddresslabel")).sendKeys("Bank Address");
		driver.findElement(By.id("bankAddressplaceHolder")).click();
		driver.findElement(By.id("bankAddressplaceHolder")).clear();
		driver.findElement(By.id("bankAddressplaceHolder")).sendKeys("Bank Address");
		driver.findElement(By.id("bankAddressinputDescription")).click();
		driver.findElement(By.id("bankAddressinputDescription")).clear();
		driver.findElement(By.id("bankAddressinputDescription")).sendKeys("Bank address");
		driver.findElement(By.id("bankAddressdataType")).click();
		driver.findElement(By.id("bankAddressminLength")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("bankAddressminLength")).clear();
		driver.findElement(By.id("bankAddressminLength")).sendKeys("1");
		driver.findElement(By.id("bankAddressmaxLength")).click();
		driver.findElement(By.id("bankAddressmaxLength")).clear();
		driver.findElement(By.id("bankAddressmaxLength")).sendKeys("30");
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]"))
				.click();
		driver.findElement(By.xpath(
				"//div[@id='defaultBackGround']/main/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/form/div[7]/div[2]/div/button"))
				.click();
		driver.findElement(By.id("bankBranchlabel")).clear();
		driver.findElement(By.id("bankBranchlabel")).sendKeys("Bank Branch");
		driver.findElement(By.id("bankBranchplaceHolder")).click();
		driver.findElement(By.id("bankBranchplaceHolder")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("bankBranchplaceHolder")).sendKeys("Enter the Branch");
		driver.findElement(By.id("bankBranchinputDescription")).click();
		driver.findElement(By.id("bankBranchinputDescription")).clear();
		driver.findElement(By.id("bankBranchinputDescription")).sendKeys("Bank branch");
		driver.findElement(By.id("bankBranchdataType")).click();
		driver.findElement(By.id("bankBranchminLength")).click();
		driver.findElement(By.id("bankBranchminLength")).clear();
		driver.findElement(By.id("bankBranchminLength")).sendKeys("1");
		driver.findElement(By.id("bankBranchmaxLength")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("bankBranchmaxLength")).clear();
		driver.findElement(By.id("bankBranchmaxLength")).sendKeys("10");
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]"))
				.click();
		driver.findElement(By.xpath(
				"//div[@id='defaultBackGround']/main/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/form/div[8]/div[2]/div/button"))
				.click();
		driver.findElement(By.id("mobileNumberlabel")).clear();
		driver.findElement(By.id("mobileNumberlabel")).sendKeys("Mobile");
		driver.findElement(By.id("mobileNumberplaceHolder")).click();
		driver.findElement(By.id("mobileNumberplaceHolder")).clear();
		driver.findElement(By.id("mobileNumberplaceHolder")).sendKeys("Enter the number here");
		driver.findElement(By.id("mobileNumberinputDescription")).click();
		driver.findElement(By.id("mobileNumberinputDescription")).clear();
		driver.findElement(By.id("mobileNumberinputDescription")).sendKeys("Mobile number");
		driver.findElement(By.id("mobileNumberdataType")).click();
		new Select(driver.findElement(By.id("mobileNumberdataType"))).selectByVisibleText("text");
		driver.findElement(By.id("mobileNumberminLength")).click();
		driver.findElement(By.id("mobileNumberplaceHolder")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("mobileNumberplaceHolder")).click();
		// ERROR: Caught exception [ERROR: Unsupported command [doubleClick |
		// id=mobileNumberplaceHolder | ]]
		driver.findElement(By.id("mobileNumberplaceHolder")).clear();
		driver.findElement(By.id("mobileNumberplaceHolder")).sendKeys("Enter number here");
		driver.findElement(By.id("mobileNumberminLength")).click();
		driver.findElement(By.id("mobileNumberminLength")).click();
		driver.findElement(By.id("mobileNumberminLength")).clear();
		driver.findElement(By.id("mobileNumberminLength")).sendKeys("1");
		driver.findElement(By.id("mobileNumbermaxLength")).click();
		driver.findElement(By.id("mobileNumbermaxLength")).clear();
		driver.findElement(By.id("mobileNumbermaxLength")).sendKeys("10");
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]"))
				.click();
		driver.findElement(By.xpath(
				"//div[@id='defaultBackGround']/main/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/form/div[9]/div[2]/div/button"))
				.click();
		driver.findElement(By.id("emailIdlabel")).clear();
		driver.findElement(By.id("emailIdlabel")).sendKeys("Email Id");
		driver.findElement(By.id("emailIdplaceHolder")).click();
		driver.findElement(By.id("emailIdplaceHolder")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("emailIdplaceHolder")).sendKeys("Enter the email Id");
		driver.findElement(By.id("emailIdinputDescription")).click();
		driver.findElement(By.id("emailIdinputDescription")).clear();
		driver.findElement(By.id("emailIdinputDescription")).sendKeys("Email Id");
		driver.findElement(By.id("emailIddataType")).click();
		new Select(driver.findElement(By.id("emailIddataType"))).selectByVisibleText("text");
		driver.findElement(By.id("emailIddataType")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("emailIdplaceHolder")).click();
		driver.findElement(By.id("emailIdplaceHolder")).clear();
		driver.findElement(By.id("emailIdplaceHolder")).sendKeys("Enter the email");
		driver.findElement(By.id("emailIdminLength")).click();
		driver.findElement(By.id("emailIddataType")).click();
		new Select(driver.findElement(By.id("emailIddataType"))).selectByVisibleText("text");
		driver.findElement(By.id("emailIdplaceHolder")).click();
		driver.findElement(By.id("emailIdplaceHolder")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("emailIdplaceHolder")).sendKeys("Enter the email");
		driver.findElement(By.id("emailIdminLength")).click();
		driver.findElement(By.id("emailIdminLength")).clear();
		driver.findElement(By.id("emailIdminLength")).sendKeys("1");
		driver.findElement(By.id("emailIdmaxLength")).click();
		driver.findElement(By.id("emailIdmaxLength")).clear();
		driver.findElement(By.id("emailIdmaxLength")).sendKeys("30");
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]"))
				.click();
		driver.findElement(By.xpath(
				"//div[@id='defaultBackGround']/main/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/form/div[10]/div[2]/div/button"))
				.click();
		driver.findElement(By.id("postaladdresslabel")).clear();
		driver.findElement(By.id("postaladdresslabel")).sendKeys("Post");
		driver.findElement(By.id("postaladdressplaceHolder")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("postaladdressplaceHolder")).clear();
		driver.findElement(By.id("postaladdressplaceHolder")).sendKeys("Enter The postaladdress");
		driver.findElement(By.id("postaladdressinputDescription")).click();
		driver.findElement(By.id("postaladdressinputDescription")).click();
		driver.findElement(By.id("postaladdressinputDescription")).clear();
		driver.findElement(By.id("postaladdressinputDescription")).sendKeys("postal address");
		driver.findElement(By.id("postaladdressdataType")).click();
		driver.findElement(By.id("postaladdressminLength")).click();
		driver.findElement(By.id("postaladdressminLength")).clear();
		driver.findElement(By.id("postaladdressminLength")).sendKeys("1");
		Thread.sleep(3000);
		driver.findElement(By.id("postaladdressmaxLength")).click();
		driver.findElement(By.id("postaladdressmaxLength")).clear();
		driver.findElement(By.id("postaladdressmaxLength")).sendKeys("10");
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]"))
				.click();
		driver.findElement(By.xpath(
				"//div[@id='defaultBackGround']/main/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/form/div[11]/div[2]/div/button"))
				.click();
		driver.findElement(By.id("pinCodelabel")).clear();
		driver.findElement(By.id("pinCodelabel")).sendKeys("PINCODE");
		driver.findElement(By.id("pinCodeplaceHolder")).click();
		driver.findElement(By.id("pinCodeplaceHolder")).clear();
		driver.findElement(By.id("pinCodeplaceHolder")).sendKeys("Enter the Pincode");
		driver.findElement(By.id("pinCodeinputDescription")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("pinCodeinputDescription")).clear();
		driver.findElement(By.id("pinCodeinputDescription")).sendKeys("Pincode");
		driver.findElement(By.id("pinCodedataType")).click();
		new Select(driver.findElement(By.id("pinCodedataType"))).selectByVisibleText("text");
		driver.findElement(By.id("pinCodeminLength")).click();
		driver.findElement(By.id("pinCodeminLength")).clear();
		driver.findElement(By.id("pinCodeminLength")).sendKeys("1");
		driver.findElement(By.id("pinCodemaxLength")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("pinCodemaxLength")).clear();
		driver.findElement(By.id("pinCodemaxLength")).sendKeys("10");
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]"))
				.click();
		driver.findElement(By.xpath("//div[@id='defaultBackGround']/main/div[2]/div[2]/div/div[2]/div/div[3]/button"))
				.click();
		Thread.sleep(3000);

		driver.findElement(
				By.xpath("//div[@id='defaultBackGround']/main/div[2]/div[3]/div/div[3]/div[2]/div[4]/div[5]/span"))
				.click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@id='defaultBackGround']/main/div[2]/div[2]/div/button[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='react-confirm-alert']/div/div/div/div/button")).click();
		// Approve();

	}

	@Test
	public static void Approve() throws Exception {
		Thread.sleep(3000);
		driver = driverOP();
		driver.get(testurl);

		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("9901947380");
		driver.findElement(By.id("myPassword")).click();
		driver.findElement(By.id("myPassword")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("myPassword")).sendKeys("Jsignadmin@123");
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Approve Template")).click();
		driver.get("https://uat.docuexec.com/getTempToApprove");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.findElement(
				By.xpath("/html/body/div/div/div/main/div[2]/div[2]/div/div/div[2]/div[1]/div/div[7]/button")).click();
		driver.get("https://uat.docuexec.com/viewTemplate");
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//div[@id='defaultBackGround']/main/div[2]/div[3]/div[2]/div/div/div/div[2]/div/button"))
				.click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]"))
				.click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//div[@id='defaultBackGround']/main/div[2]/div[3]/div[2]/div/div/div[2]/div[2]/div/button"))
				.click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]"))
				.click();
		driver.findElement(
				By.xpath("//div[@id='defaultBackGround']/main/div[2]/div[3]/div[2]/div/div/div[3]/div[2]/div/button"))
				.click();
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]"))
				.click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//div[@id='defaultBackGround']/main/div[2]/div[3]/div[2]/div/div/div[4]/div[2]/div/button"))
				.click();
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]"))
				.click();
		driver.findElement(
				By.xpath("//div[@id='defaultBackGround']/main/div[2]/div[3]/div[2]/div/div/div[5]/div[2]/div/button"))
				.click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]"))
				.click();
		driver.findElement(
				By.xpath("//div[@id='defaultBackGround']/main/div[2]/div[3]/div[2]/div/div/div[6]/div[2]/div/button"))
				.click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]"))
				.click();
		driver.findElement(
				By.xpath("//div[@id='defaultBackGround']/main/div[2]/div[3]/div[2]/div/div/div[7]/div[2]/div/button"))
				.click();
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]"))
				.click();
		driver.findElement(
				By.xpath("//div[@id='defaultBackGround']/main/div[2]/div[3]/div[2]/div/div/div[7]/div[2]/div/button"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Char Max Length:'])[1]/following::button[1]"))
				.click();
		driver.findElement(
				By.xpath("//div[@id='defaultBackGround']/main/div[2]/div[3]/div[2]/div/div/div[8]/div[2]/div/button"))
				.click();
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]"))
				.click();
		driver.findElement(
				By.xpath("//div[@id='defaultBackGround']/main/div[2]/div[3]/div[2]/div/div/div[9]/div[2]/div/button"))
				.click();
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]"))
				.click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//div[@id='defaultBackGround']/main/div[2]/div[3]/div[2]/div/div/div[10]/div[2]/div/button"))
				.click();
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]"))
				.click();
		driver.findElement(
				By.xpath("//div[@id='defaultBackGround']/main/div[2]/div[3]/div[2]/div/div/div[11]/div[2]/div/button"))
				.click();
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='defaultBackGround']/main/div[2]/div[2]/div[3]/button")).click();
		driver.findElement(By.id("commentFromRejAdmin")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("commentFromRejAdmin")).clear();
		driver.findElement(By.id("commentFromRejAdmin")).sendKeys("Testing purpose");
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]"))
				.click();
		driver.findElement(By.xpath("//div[@id='react-confirm-alert']/div/div/div/div/button")).click();
		driver.get("https://uat.docuexec.com/getTempToApprove");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='react-confirm-alert']/div/div/div/div/button")).click();
	}

	@Test
	public void Template_Sign() throws Exception {

		driver = driverOP();
		driver.get(testurl);
		Thread.sleep(3000);
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("9940783459");
		driver.findElement(By.id("myPassword")).clear();
		driver.findElement(By.id("myPassword")).sendKeys("Test@1234");
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(3000);
		driver.get("https://uat.docuexec.com/accountInfo");
		driver.findElement(By.linkText("Templates")).click();
		driver.get("https://uat.docuexec.com/templates");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@id='panel1a-header']/div/p/b")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#panel1a-content > div > p > div:nth-child(2)")).click();
		Thread.sleep(3000);
//		driver.get("https://uat.docuexec.com/template");

		driver.findElement(By.id("date1")).click();
		driver.findElement(By.id("date1")).clear();
		driver.findElement(By.id("date1")).sendKeys("2023-07-12");
		driver.findElement(By.id("name1")).click();
		driver.findElement(By.id("name1")).clear();
		driver.findElement(By.id("name1")).sendKeys("Elango");
		Thread.sleep(3000);
		driver.findElement(By.id("age1")).click();
		driver.findElement(By.id("age1")).clear();
		driver.findElement(By.id("age1")).sendKeys("24");
		Thread.sleep(3000);
		driver.findElement(By.id("address1")).click();
		driver.findElement(By.id("address1")).clear();
		driver.findElement(By.id("address1")).sendKeys("Shiva's Pg");
		Thread.sleep(3000);
		driver.findElement(By.id("bankName1")).click();
		driver.findElement(By.id("bankName1")).clear();
		driver.findElement(By.id("bankName1")).sendKeys("IOB");
		driver.findElement(By.id("bankAddress1")).click();
		driver.findElement(By.id("bankAddress1")).clear();
		driver.findElement(By.id("bankAddress1")).sendKeys("Sahakar nagar");
		driver.findElement(By.id("bankBranch1")).click();
		driver.findElement(By.id("bankBranch1")).clear();
		driver.findElement(By.id("bankBranch1")).sendKeys("Sahakar");
		Thread.sleep(3000);
		driver.findElement(By.id("mobileNumber1")).click();
		driver.findElement(By.id("mobileNumber1")).clear();
		driver.findElement(By.id("mobileNumber1")).sendKeys("9940783459");
		driver.findElement(By.id("emailId1")).click();
		driver.findElement(By.id("emailId1")).click();
		driver.findElement(By.id("emailId1")).clear();
		driver.findElement(By.id("emailId1")).sendKeys("elangoharish12@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.id("postaladdress1")).click();
		driver.findElement(By.id("postaladdress1")).clear();
		driver.findElement(By.id("postaladdress1")).sendKeys("12345678900000");
		Thread.sleep(3000);
		driver.findElement(By.id("pinCode1")).click();
		driver.findElement(By.id("pinCode1")).clear();
		driver.findElement(By.id("pinCode1")).sendKeys("9876543211111");
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//div[@id='defaultBackGround']/main/div[2]/div[3]/div[2]/div/div/form/div[12]/button"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='defaultBackGround']/main/div[2]/div[2]/div/div[2]/button")).click();
//		Electronic_sign Sign = new Electronic_sign();
//		Sign.Signing();

		Thread.sleep(3000);
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
				.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[3]/div/div[2]/div[6]/button/span"));
		Submit.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[4]/button/span")).click();
		Thread.sleep(3000);

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
	}

	@Test
	public void BC_reg() throws Exception {

		driver = driverOP();
		driver.get(testurl);
		Thread.sleep(3000);
		Thread.sleep(3000);
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("9606314568");
		driver.findElement(By.id("myPassword")).clear();
		driver.findElement(By.id("myPassword")).sendKeys("Test@123");
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(3000);
		driver.manage().window().maximize();

//		driver.get("https://uat.docuexec.com/accountInfo");

		driver.findElement(By.linkText("Templates")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div/div[1]/div[1]")).click();
		Thread.sleep(4000);
		WebElement Bc_reg = driver.findElement(By
				.xpath("/html/body/div/div/div/main/div[2]/div/div[2]/div/div[2]/div/div/div/div/p/div[1]/button"));
		Bc_reg.click();
		Thread.sleep(3000);
//		driver.get("https://uat.docuexec.com/template");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.id("name1")).click();
		driver.findElement(By.id("name1")).clear();
		driver.findElement(By.id("name1")).sendKeys("Elango");
		driver.findElement(By.id("date1")).click();
		driver.findElement(By.id("date1")).clear();

		driver.findElement(By.id("date1")).clear();
		Thread.sleep(3000);
	
		driver.findElement(By.id("date1")).clear();
		driver.findElement(By.id("date1")).sendKeys("1998-12-03");
		driver.findElement(By.id("RelationPersonName1")).click();
		driver.findElement(By.id("RelationPersonName1")).clear();
		driver.findElement(By.id("RelationPersonName1")).sendKeys("None");
		driver.findElement(By.id("additional1")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("additional1")).clear();
		driver.findElement(By.id("additional1")).sendKeys("None");
		driver.findElement(By.id("housename1")).click();
		driver.findElement(By.id("housename1")).clear();
		driver.findElement(By.id("housename1")).sendKeys("House name");
		driver.findElement(By.id("NumberAndStreet1")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("NumberAndStreet1")).clear();
		driver.findElement(By.id("NumberAndStreet1")).sendKeys("Number");
		driver.findElement(By.id("Village_Ward1")).click();
		driver.findElement(By.id("Village_Ward1")).clear();
		driver.findElement(By.id("Village_Ward1")).sendKeys("0001");
		driver.findElement(By.id("Taluk1")).click();
		driver.findElement(By.id("Taluk1")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("Taluk1")).sendKeys("01");
		driver.findElement(By.id("District1")).click();
		driver.findElement(By.id("District1")).clear();
		driver.findElement(By.id("District1")).sendKeys("Erode");
		driver.findElement(By.id("state1")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("state1")).clear();
		driver.findElement(By.id("state1")).sendKeys("Tamilnadu");
		driver.findElement(By.id("PIN1")).click();
		driver.findElement(By.id("PIN1")).clear();
		driver.findElement(By.id("PIN1")).sendKeys("638012");
		driver.findElement(By.id("phno1")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("phno1")).clear();
		driver.findElement(By.id("phno1")).sendKeys("9940783459");
		driver.findElement(By.id("Office1")).click();
		driver.findElement(By.id("Office1")).clear();
		driver.findElement(By.id("Office1")).sendKeys("6380695905");
		Thread.sleep(3000);
		driver.findElement(By.id("Mobile1")).click();
		driver.findElement(By.id("Mobile1")).clear();
		driver.findElement(By.id("Mobile1")).sendKeys("987654321");
		Thread.sleep(3000);
		driver.findElement(By.id("WhatsApp1")).click();
		driver.findElement(By.id("WhatsApp1")).clear();
		driver.findElement(By.id("WhatsApp1")).sendKeys("6380695905");
		driver.findElement(By.id("Aadhaar1")).click();
		driver.findElement(By.id("Aadhaar1")).clear();
		driver.findElement(By.id("Aadhaar1")).sendKeys("888720611922");
		Thread.sleep(3000);
		driver.findElement(By.id("Aadhaar1")).click();
		driver.findElement(By.id("pan1")).click();
		driver.findElement(By.id("pan1")).clear();
		driver.findElement(By.id("pan1")).sendKeys("AEGPE6181G");
		Thread.sleep(3000);
		driver.findElement(By.id("others1")).click();
		driver.findElement(By.id("others1")).clear();
		driver.findElement(By.id("others1")).sendKeys("others");
		driver.findElement(By.id("vehicleNumber1")).click();
		driver.findElement(By.id("vehicleNumber1")).clear();
		driver.findElement(By.id("vehicleNumber1")).sendKeys("TN64P001");
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,1000)");

		System.out.println("moved ");
		driver.findElement(By.id("SHGname1")).click();
		driver.findElement(By.id("SHGname1")).clear();
		driver.findElement(By.id("SHGname1")).sendKeys("SHg name");
		driver.findElement(By.id("membershipNO1")).click();
		driver.findElement(By.id("membershipNO1")).clear();
		driver.findElement(By.id("membershipNO1")).sendKeys("00021");
		driver.findElement(By.id("socialActivity1")).click();
		driver.findElement(By.id("socialActivity1")).clear();
		driver.findElement(By.id("socialActivity1")).sendKeys("Nothing");
		driver.findElement(By.id("1otherLanguage1")).click();
		driver.findElement(By.id("1otherLanguage1")).clear();
		driver.findElement(By.id("1otherLanguage1")).sendKeys("English");
		driver.findElement(By.id("2otherLanguage1")).click();
		driver.findElement(By.id("2otherLanguage1")).clear();
		driver.findElement(By.id("2otherLanguage1")).sendKeys("Tamil");
		driver.findElement(By.id("occupation1")).click();
		driver.findElement(By.id("occupation1")).clear();
		driver.findElement(By.id("occupation1")).sendKeys("Business man");
		driver.findElement(By.id("buisnessName1")).click();
		driver.findElement(By.id("buisnessName1")).clear();
		driver.findElement(By.id("buisnessName1")).sendKeys("Business");
		driver.findElement(By.id("buisnessNumber1")).click();
		driver.findElement(By.id("buisnessNumber1")).clear();
		driver.findElement(By.id("buisnessNumber1")).sendKeys("987654321");
		Thread.sleep(3000);
		driver.findElement(By.id("buisnessVillage1")).click();
		driver.findElement(By.id("buisnessVillage1")).clear();
		driver.findElement(By.id("buisnessVillage1")).sendKeys("Erode");
		driver.findElement(By.id("buisnessTaluk1")).click();
		driver.findElement(By.id("buisnessTaluk1")).clear();
		driver.findElement(By.id("buisnessTaluk1")).sendKeys("Erode");
		driver.findElement(By.id("buisnessDistrict1")).click();
		driver.findElement(By.id("buisnessDistrict1")).clear();
		driver.findElement(By.id("buisnessDistrict1")).sendKeys("Erode");
		driver.findElement(By.id("buisnessState1")).click();
		driver.findElement(By.id("buisnessState1")).clear();
		driver.findElement(By.id("buisnessState1")).sendKeys("Tamilnadu");
		Thread.sleep(3000);
		driver.findElement(By.id("buisnessPIN1")).click();
		driver.findElement(By.id("buisnessPIN1")).clear();
		driver.findElement(By.id("buisnessPIN1")).sendKeys("876543");
		Thread.sleep(3000);
		driver.findElement(By.id("noOfyears1")).click();
		driver.findElement(By.id("noOfyears1")).clear();
		driver.findElement(By.id("noOfyears1")).sendKeys("2");
		driver.findElement(By.id("width1")).click();
		driver.findElement(By.id("width1")).clear();
		driver.findElement(By.id("width1")).sendKeys("600");
		driver.findElement(By.id("height1")).click();
		driver.findElement(By.id("width1")).click();
		driver.findElement(By.id("width1")).clear();
		driver.findElement(By.id("width1")).sendKeys("60");
		driver.findElement(By.id("height1")).click();
		driver.findElement(By.id("height1")).clear();
		driver.findElement(By.id("height1")).sendKeys("550");
		Thread.sleep(3000);
		driver.findElement(By.id("infrastructure1")).click();
		driver.findElement(By.id("infrastructure1")).clear();
		driver.findElement(By.id("infrastructure1")).sendKeys("Infracstructure");
		driver.findElement(By.id("income1")).click();
		driver.findElement(By.id("income1")).clear();
		driver.findElement(By.id("income1")).sendKeys("10");
		driver.findElement(By.id("customers1")).click();
		driver.findElement(By.id("customers1")).clear();
		driver.findElement(By.id("customers1")).sendKeys("90");
		driver.findElement(By.id("noofvillages1")).click();
		driver.findElement(By.id("noofvillages1")).clear();
		driver.findElement(By.id("noofvillages1")).sendKeys("30");
		driver.findElement(By.id("namesofvillages1")).click();
		driver.findElement(By.id("namesofvillages1")).clear();
		driver.findElement(By.id("namesofvillages1")).sendKeys("33");
		driver.findElement(By.id("nameOrganization1")).click();
		driver.findElement(By.id("nameOrganization1")).clear();
		driver.findElement(By.id("nameOrganization1")).sendKeys("Integra");
		Thread.sleep(3000);
		driver.findElement(By.id("serviceProvider1")).click();
		driver.findElement(By.id("serviceProvider1")).clear();
		driver.findElement(By.id("serviceProvider1")).sendKeys("IMS");
		driver.findElement(By.id("fromDate1")).click();
		driver.findElement(By.id("fromDate1")).clear();
		driver.findElement(By.id("fromDate1")).sendKeys("2023-07-19");
		driver.findElement(By.id("toDate1")).click();
		driver.findElement(By.id("toDate1")).clear();
		driver.findElement(By.id("toDate1")).sendKeys("2023-06-30");
		driver.findElement(By.id("branchName1")).click();
		driver.findElement(By.id("branchName1")).clear();
		driver.findElement(By.id("branchName1")).sendKeys("Test");
		driver.findElement(By.id("accNo1")).click();
		driver.findElement(By.id("accNo1")).clear();
		driver.findElement(By.id("accNo1")).sendKeys("9876543211");
		Thread.sleep(3000);
		driver.findElement(By.id("bcId1")).click();
		driver.findElement(By.id("bcId1")).clear();
		driver.findElement(By.id("bcId1")).sendKeys("2112");
		driver.findElement(By.id("bcName1")).click();
		driver.findElement(By.id("bcName1")).clear();
		driver.findElement(By.id("bcName1")).sendKeys("elango");
		driver.findElement(By.id("bcNumber1")).click();
		driver.findElement(By.id("bcNumber1")).clear();
		driver.findElement(By.id("bcNumber1")).sendKeys("123");
		driver.findElement(By.id("bcVillage1")).click();
		driver.findElement(By.id("bcVillage1")).clear();
		driver.findElement(By.id("bcVillage1")).sendKeys("Thindal");
		Thread.sleep(3000);
		driver.findElement(By.id("bcTaluk1")).click();
		driver.findElement(By.id("bcTaluk1")).clear();
		driver.findElement(By.id("bcTaluk1")).sendKeys("Thindal");
		driver.findElement(By.id("bcDistrict1")).click();
		driver.findElement(By.id("bcDistrict1")).clear();
		driver.findElement(By.id("bcDistrict1")).sendKeys("Erode");
		Thread.sleep(3000);
		driver.findElement(By.id("bcState1")).click();
		driver.findElement(By.id("bcState1")).clear();
		driver.findElement(By.id("bcState1")).sendKeys("Tamilnadu");
		driver.findElement(By.id("bcPIN1")).click();
		driver.findElement(By.id("bcPIN1")).clear();
		driver.findElement(By.id("bcPIN1")).sendKeys("98765312");
		Thread.sleep(3000);
		driver.findElement(By.id("noOfYearsss1")).click();
		driver.findElement(By.id("noOfYearsss1")).clear();
		driver.findElement(By.id("noOfYearsss1")).sendKeys("2");
		driver.findElement(By.id("bcInfra1")).click();
		driver.findElement(By.id("bcInfra1")).clear();
		driver.findElement(By.id("bcInfra1")).sendKeys("Bc infracstructure");
		Thread.sleep(3000);
		driver.findElement(By.id("Hardware1")).click();
		driver.findElement(By.id("Hardware1")).clear();
		driver.findElement(By.id("Hardware1")).sendKeys("Hardware");
		driver.findElement(By.id("deposit1")).click();
		driver.findElement(By.id("deposit1")).clear();
		driver.findElement(By.id("deposit1")).sendKeys("100");
		Thread.sleep(3000);
		driver.findElement(By.name("Transactions")).click();
		driver.findElement(By.name("Transactions")).clear();
		driver.findElement(By.name("Transactions")).sendKeys("12");
		driver.findElement(By.id("Customers11")).click();
		driver.findElement(By.id("Earnings11")).click();
		driver.findElement(By.id("Earnings11")).clear();
		driver.findElement(By.id("Earnings11")).sendKeys("12");
		Thread.sleep(3000);
		driver.findElement(By.id("award21")).click();
		driver.findElement(By.id("award21")).clear();
		driver.findElement(By.id("award21")).sendKeys("12");
		driver.findElement(By.id("registersmaintained11")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("registersmaintained11")).clear();
		driver.findElement(By.id("registersmaintained11")).sendKeys("111");
		driver.findElement(By.id("registersmaintained21")).click();
		driver.findElement(By.id("registersmaintained21")).clear();
		driver.findElement(By.id("registersmaintained21")).sendKeys("11");
		Thread.sleep(3000);
		driver.findElement(By.id("registersmaintained61")).click();
		driver.findElement(By.id("registersmaintained61")).clear();
		driver.findElement(By.id("registersmaintained61")).sendKeys("222");
		driver.findElement(By.id("issue31")).click();
		driver.findElement(By.id("issue31")).clear();
		driver.findElement(By.id("issue31")).sendKeys("issues");
		Thread.sleep(3000);
		driver.findElement(By.id("ProposedbcName1")).click();
		driver.findElement(By.id("ProposedbcName1")).clear();
		driver.findElement(By.id("ProposedbcName1")).sendKeys("1");
		driver.findElement(By.id("ProposedbcNumber1")).click();
		driver.findElement(By.id("ProposedbcNumber1")).clear();
		driver.findElement(By.id("ProposedbcNumber1")).sendKeys("123");
		driver.findElement(By.id("ProposedbcDistrict1")).click();
		driver.findElement(By.id("ProposedbcDistrict1")).clear();
		driver.findElement(By.id("ProposedbcDistrict1")).sendKeys("1234");
		Thread.sleep(3000);
		driver.findElement(By.id("ownerrelationship1")).click();
		driver.findElement(By.id("ownerrelationship1")).clear();
		driver.findElement(By.id("ownerrelationship1")).sendKeys("134");
		driver.findElement(By.id("Laptopdescription1")).click();
		driver.findElement(By.id("Laptopdescription1")).clear();
		driver.findElement(By.id("Laptopdescription1")).sendKeys("none");
		Thread.sleep(3000);
		driver.findElement(By.id("Printerescription1")).click();
		driver.findElement(By.id("Printerescription1")).clear();
		driver.findElement(By.id("Printerescription1")).sendKeys("123");
		driver.findElement(By.id("Working1")).click();
		driver.findElement(By.id("Working1")).clear();
		driver.findElement(By.id("Working1")).sendKeys("yes");
		Thread.sleep(3000);
		driver.findElement(By.id("locations11")).click();
		driver.findElement(By.id("locations11")).clear();
		driver.findElement(By.id("locations11")).sendKeys("loacation");
		driver.findElement(By.id("noOfCustomers1")).click();
		driver.findElement(By.id("noOfCustomers1")).clear();
		driver.findElement(By.id("noOfCustomers1")).sendKeys("12");
		Thread.sleep(3000);
		driver.findElement(By.id("IIBF1")).click();
		driver.findElement(By.id("IIBF1")).clear();
		driver.findElement(By.id("IIBF1")).sendKeys("12");
		driver.findElement(By.id("ref1Address1")).click();
		driver.findElement(By.id("ref1Address1")).clear();
		driver.findElement(By.id("ref1Address1")).sendKeys("12");
		Thread.sleep(3000);
		driver.findElement(By.id("SignatureOfApplicant1")).click();
		driver.findElement(By.id("SignatureOfApplicant1")).clear();
		driver.findElement(By.id("SignatureOfApplicant1")).sendKeys("8");
		driver.findElement(By.id("NAME1")).click();
		driver.findElement(By.id("NAME1")).clear();
		driver.findElement(By.id("NAME1")).sendKeys("Elango");
		driver.findElement(By.id("PLACE1")).click();
		driver.findElement(By.id("PLACE1")).clear();
		driver.findElement(By.id("PLACE1")).sendKeys("Tamilnadu");
		Thread.sleep(3000);
		driver.findElement(By.id("ADDRESS1")).click();
		driver.findElement(By.id("ADDRESS1")).clear();
		driver.findElement(By.id("ADDRESS1")).sendKeys("address here");
		Thread.sleep(3000);
		
//		WebElement Upload1=driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div[3]/div[2]/div/div/form/div[138]/div/div[1]/div[2]/input"));
//		Upload1.click();
//		StringSelection string = new StringSelection(
//				"D:\\Pdf for testing\\income tax.pdf");
//
//		Thread.sleep(3000);
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(string, null);
//		Thread.sleep(3000);
//
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_V);
//
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		robot.keyRelease(KeyEvent.VK_V);
//		Thread.sleep(2000);
//
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//		Thread.sleep(2000);
//
//
//		WebElement proceed= driver.findElement(By.xpath("//div[@id='defaultBackGround']/main/div[2]/div[3]/div[2]/div/div/form/div[139]/button"));
//		proceed.click();
		
	}

}
