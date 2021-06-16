package com.vtiger.genericlibrary;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.vtiger.elementrepositary.HomePage;
import com.vtiger.elementrepositary.LoginPage;

public class BaseClass {
	public DataUtility du = new DataUtility();
	public WebDriver driver ;
	public static WebDriver extraDriver ;
	public WebDriverCommonUtils common = new WebDriverCommonUtils();
	
	@BeforeClass(alwaysRun = true)
	public void configBC() throws IOException {
		System.out.println("------------browser launched-------------");
		
		if(du.getDataFromProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", IAutoConstants.CHROME_SERVER);
			driver = new ChromeDriver();
		}else if(du.getDataFromProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", IAutoConstants.FIRFOX_SERVER);
			driver = new FirefoxDriver();
		}
		extraDriver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
//	@Parameters("browser")
//	@BeforeClass
//	public void configBC(String browser) throws IOException {
//		System.out.println("------------browser launched-------------");
//		
//		if(browser.equals("chrome")) {
//			driver = new ChromeDriver();
//		}else if(browser.equals("firefox")) {
//			driver = new FirefoxDriver();
//		}
//		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//	}
	@BeforeMethod(alwaysRun = true)
	public void configBM() throws IOException {
		System.out.println("--------------Login to App--------------");
		driver.get(du.getDataFromProperty("url"));
		
		LoginPage lp = new LoginPage(driver);
		
		lp.getUsernameTB().sendKeys(du.getDataFromProperty("username"));
		lp.getPasswordTB().sendKeys(du.getDataFromProperty("password"));
		lp.getLoginBtn().click();
		
	}
	@AfterMethod(alwaysRun = true)
	public void configAM() {
		System.out.println("---------------Logout from App-------------");
		HomePage hp = new HomePage(driver);
		common.moveMousePointer(hp.getSignOutDD());
		hp.getSignOutLink().click();
	}
	@AfterClass(alwaysRun = true)
	public void configAC() {
		System.out.println("--------------Browser Closed--------------");
		driver.quit();
	}
}









