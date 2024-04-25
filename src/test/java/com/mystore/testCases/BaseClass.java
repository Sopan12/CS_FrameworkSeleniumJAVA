package com.mystore.testCases;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.mystore.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
	String url = readconfig.getBaseUrl();
	String browser = readconfig.getBrowser();
	public String emailAddress = readconfig.getEmail() ;
	String password = readconfig.getPassword();
	
	

	public static WebDriver driver;

	public static Logger logger;




	@BeforeClass//bcoz every class chya adhi hi test run hoil
	public void setup()
	{
		switch(browser.toLowerCase())
		{
		case "chrome" : WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;

		case "firefox" : WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;

		case "msedge":WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		break;
		
		default:driver = null;
		break;

		}


		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);


		//For logging
		logger =LogManager.getLogger("MyStoreV1");


		//open url
		driver.get(url);//from readConfig
		logger.info("url is open");


	}



	@AfterClass
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}



	public void captureScreenShot(WebDriver driver, String testName) throws IOException
	{
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");
		FileUtils.copyFile(src, dest);
	}

	public String randomString()
	{
		String generatedstring  = RandomStringUtils.randomAlphabetic(10);
		return generatedstring;
	}

	public String randomNumeric()
	{
		String numbergenerated = RandomStringUtils.randomNumeric(10);
		return numbergenerated;
	}







}
