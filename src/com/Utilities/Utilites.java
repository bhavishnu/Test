package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilites {
	
	public WebDriver driver;
	public static int i,j,rowcount;
	public static String uname,pwd;
	static XSSFRow row;
	static XSSFWorkbook wb;
	static XSSFSheet sh1;
	static String Excel = "C:\\Automation\\Appian Automation\\Test Documents\\Testdata.xlsx";
	static String PassSnapShots = "C:\\Users\\satheeshnair\\Desktop\\infocampus\\Selenium Source Code\\AppianJ&J\\testdata\\passedsnaps\\passedsnaps";
	static String FailedSnapShops="C:\\Users\\satheeshnair\\Desktop\\infocampus\\Selenium Source Code\\AppianJ&J\\testdata\\failedsnaps\\failedsnaps";
	
	
	
	public Utilites(WebDriver driver) 
	{
		this.driver = driver;
	}
	public static void readexcel(int sheetnum, int row, int column) throws Exception
	{
		FileInputStream fis = new FileInputStream(Excel);
		wb = new XSSFWorkbook(fis);
		sh1=wb.getSheetAt(sheetnum);
		
		rowcount = sh1.getLastRowNum();
			
		uname = sh1.getRow(row).getCell(column).getStringCellValue();
		//System.out.println(uname);
		pwd = sh1.getRow(row).getCell(column).getStringCellValue();
		 
//		System.out.println(uname);
//		System.out.println(pwd +"Is the password");
		
	}
	public void passsnaps(WebDriver driver) throws Exception
	{
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(PassSnapShots + timestamp()+".jpg");
		FileUtils.copyFile(scr,dest);
	}
	public void failsnaps(WebDriver driver) throws Exception
	{
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(FailedSnapShops + timestamp()+".jpg");
		FileUtils.copyFile(scr,dest);
	}
	public static String timestamp() 
	{
	    return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new java.util.Date());
	}

//	public static void main(String[] args) throws Exception 
//	{
//		Utilites.readexcel();
//	}
}
