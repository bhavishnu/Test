package com.pages;

import javax.swing.text.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Utilities.Utilites;

public class Login  extends Utilities {
	
	public WebDriver driver;
	


	static By username1 = By.xpath("//input[@id='un']");
	
	static By password = By.xpath("(//*[@id='pw'])");
	static By loginbtn = By.xpath("(//*[@class='btn primary'])[2]");
	static By error1 = By.xpath("//*[@id='loginForm']/div[1]");
	String error = "The username/password entered is invalid. Usernames and passwords are case sensitive.";
	//String s = driver.findElement(error1).getText();
	
	public Login(WebDriver driver) {
		this.driver = driver;
	}
	
	public void username(int a, int b, int c) throws Exception
	{
		Thread.sleep(3000);
		Utilites.readexcel(a,b,c);
		driver.findElement(username1).sendKeys(Utilites.uname);
	}
	
	public  void password(int sheetnum, int row, int column) throws Exception
	{
		Thread.sleep(2000);
		Utilites.readexcel(sheetnum,row,column);
		driver.findElement(password).sendKeys(Utilites.pwd);
	}

	public boolean login() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(loginbtn).click();
		if(error.equals("The username/password entered is invalid. Usernames and passwords are case sensitive."))
		{
			
			return false;
		}
		else 
		{
			return true;
		}
	}
	

}
