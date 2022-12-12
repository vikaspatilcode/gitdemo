package com.practice;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
	
	//What is log? : capturing info/activities at the time of program execution. 
		// types of logs:
			//1. info
			//2. warn
			//3. debug
			//4. fatal
			
		//how to generate the logs? : use Apache log4j API (log4j jar)
		//How it works? : it reads log 4j configuration from log4j.properties file
		//where to create: create inside resources folder
	
	public static WebDriver driver;
	Logger log=Logger.getLogger(LoginTest.class);

	@BeforeMethod
	public void initialize() {
		log.info("****************************** Starting test cases execution  ************************");
		System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://classic.freecrm.com/index.html");
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		log.info("********************** loginPageTitleTest execution started  ****************");
		String title = driver.getTitle();
		System.out.println("title" + title);
		Assert.assertEquals(title,
				"CRMPRO - CRM software for customer relationship management, sales, and support.");
		log.info("********************** loginPageTitleTest execution end here  ****************");
		log.debug("log.debug() method executed here");
		log.error("log.error() method executed here");
		log.warn("log.warn() method executed here");
		log.fatal("log.fatal() method executed here");
		
	}

	@AfterMethod
	public void tearDown() {
		log.info("****************************** end test cases execution  ************************");
		driver.quit();
	}
}
