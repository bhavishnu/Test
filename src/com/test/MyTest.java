package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.testng.annotations.Test;


import com.pages.CreateRequest;
import com.pages.Login;
import com.relevantcodes.extentreports.ExtentTest;
import com.Utilities.ExtentReport;
import com.Utilities.Utilites;





public class MyTest extends TestBase {
	Login login; //Initialize class
	
	CreateRequest createreq;
	
	
	ExtentReport report;
	ExtentTest test;
	Utilites utilities;
	
	
	@Test(priority=0)
	public void testcase() throws Exception
	{
		
		driver.get(url);
		
		login = new Login(driver);//initialize objectl
		createreq= new CreateRequest(driver);
		
		login.username(0,1,0);	//sheet num, row , column
		login.password(0,1,1); //sheet num, row , column
		login.login();
		Thread.sleep(5000);
		createreq.clikoncreaterequest();
		createreq.clikonclient();
		Thread.sleep(10000);
		createreq.selectsalescoverage();
		createreq.selectclienttrader();
		createreq.selectproduct();
		
		
	}
	

}
