package selenium;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class Signupobject {

	public static Properties prop = new Properties();
	public static WebDriver driver;

	@FindBy(id = "ap_customer_name")
	WebElement Fname;
	@FindBy(id = "ap_email")
	WebElement Email;
	@FindBy(id = "ap_password")
	WebElement password;
	@FindBy(id = "ap_password_check")
	WebElement passwordcheck;
	@FindBy(id = "continue")
	WebElement ok;
	@FindBy(linkText = "Start here.")
	WebElement StartHere;
	@FindBy(id = "nav-link-accountList")
	WebElement NavLinkAccLink;



	public Signupobject(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void typeFname(String name, String email, String pass, String checkpass) {
		Fname.sendKeys(name);
		Email.sendKeys(email);
		password.sendKeys(pass);
		passwordcheck.sendKeys(checkpass);
		ok.click();
	}
	public String Titlecheck () {
		String linkText = "Amazon.ca: Low Prices – Fast Shipping – Millions of Items";
		
	return linkText;
		
	}

	public void PomHello(String NLinkAcc, String lText) {
		NavLinkAccLink.sendKeys(NLinkAcc);
		StartHere.sendKeys(lText);
	}

	public void ScreenShot(WebDriver driver) throws IOException {
		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile, new File("D://screenshot.jpg"));
	}

	public Actions SendHello(WebDriver driver) {
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("nav-link-accountList")));
		driver.findElement(By.linkText("Start here.")).click();
		return action;
	}
	
	//BeforeTestbject
	public static  WebDriver Initalization(WebDriver driver,String browsername) {
		
		if(browsername.equals("chrome")) { 
			 System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			 driver=new ChromeDriver ();}
		
			 else if (browsername.equals("Firefox")) {
				System.setProperty("webdriver.gecko.driver","geckodriver.exe");
				driver = new FirefoxDriver(); }
		
			 else {
				 System.out.println("Browser not supported");
			 }
		
		

		driver.get("https://www.google.com/");
		driver.navigate().to("https://www.amazon.ca/");
		return driver;
	}

}
