package com.ebay.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.ebay.qa.util.TestUtil;




public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;


	public TestBase() {
	
		try {
		FileInputStream f= new FileInputStream("/Users/hiralvaghela/Desktop/Selenium/Selenium_Workspace/EbayTest/src/main/java/com/ebay/qa/config/config.properties");
		prop = new Properties();
		prop.load(f);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		
		String  browserName = prop.getProperty("browser");

		if(browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/hiralvaghela/Desktop/Selenium/SeleniumJars/geckodriver");
			driver = new FirefoxDriver();
		}else {
			System.setProperty("webdriver.chrome.driver", "/Users/hiralvaghela/Desktop/Selenium/SeleniumJars/chromedriver");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		
	
		driver.get(prop.getProperty("url"));
		
		
		
		
	}

}
