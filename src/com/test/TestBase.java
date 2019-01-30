package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	protected WebDriver driver;
	protected String url;
	
	
	@BeforeSuite
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhavishnumishra\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		url=readconfig("url");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	public String readconfig(String s) {
		String str=null;
		try {
			
			File f=new File("C:\\Automation\\Appian Automation\\Test Documents\\Configuration.Properties");
			FileInputStream fin = new FileInputStream(f);
			Properties prop= new Properties();
			prop.load(fin);
			str=prop.getProperty(s);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
		
	}
	
//	@AfterSuite
//	public void teardown() throws InterruptedException
//	{
//		Thread.sleep(3000);
//		driver.quit();
//	}

}
