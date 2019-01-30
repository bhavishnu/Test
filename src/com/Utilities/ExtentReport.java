package com.Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport 
{
	public  ExtentHtmlReporter htmlreporter;
	public  ExtentReports extent;
	public ExtentTest test;
	
	public WebDriver driver;
	
	public ExtentReport(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	@BeforeSuite
	public void startreport()
	{
		// initialize the HtmlReporter
		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport.html");
		
		//initialize ExtentReports and attach the HtmlReporter
		extent = new ExtentReports(); 
		extent.attachReporter(htmlreporter);
		
		//configuration items to change the look and feel
        //add content, manage tests etc
		htmlreporter.config().setChartVisibilityOnOpen(true);
	    htmlreporter.config().setDocumentTitle("GenerateTestReport");
	    htmlreporter.config().setReportName("Test Report");
	    htmlreporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
	    htmlreporter.config().setTheme(Theme.STANDARD);
	}
	@AfterTest
	 public void getResult(ITestResult result) {
	        if(result.getStatus() == ITestResult.FAILURE) {
	            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
	            test.fail(result.getThrowable());
	        }
	        else if(result.getStatus() == ITestResult.SUCCESS) {
	            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
	        }
	        else {
	            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
	            test.skip(result.getThrowable());
	        }
	    }
		@AfterSuite
	    public void tearDown() {
	    	//to write or update test information to reporter
	    	
	        extent.flush();
	    }

}
