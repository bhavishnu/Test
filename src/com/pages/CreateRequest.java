package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CreateRequest {
	public WebDriver driver;
	
	public CreateRequest(WebDriver driver) {
		this.driver = driver;
	}
	static By createrequestbtn= By.xpath("//*[@id=\"appian-body\"]/div/div/div/div/div[4]/div[1]/div/div/div/div[2]/div/p/span[2]/span/strong");
	static By clientname=By.xpath("//*[@id=\"appian-body\"]/div/div/div/div/div/div[2]/div/div[1]/div/div/div/div/div/div[1]/div/div/div[2]/div/div[2]/div/div[2]/div/div/input");
	static By clienttraderdropdown=By.id("b1b65d7547c5475042bc0c0ad11c95e8_value");
	static By clienttradergrid=By.xpath("//*[@id=\"appian-body\"]/div/div/div/div/div/div[2]/div/div[1]/div/div/div/div/div/div[2]/div[1]/div/div/div/div/div[3]/div[2]/div/div/table/tbody/tr/td/div/p");
	static By assetclass=By.xpath("//*[@id=\"appian-body\"]/div/div/div/div/div/div[2]/div/div[2]/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/div[1]/div/div/div/div[2]/div/p");
	static By producttype=By.xpath("//*[@id=\"appian-body\"]/div/div/div/div/div/div[2]/div/div[2]/div/div/div/div/div/div/div/div[1]/div[2]/div[2]/div[1]/div/div/div/div[2]/div/p");
	
	static By productname=By.xpath("//*[@id=\"appian-body\"]/div/div/div/div/div/div[2]/div/div[2]/div/div/div/div/div/div/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div/p/span/span/strong");
	static By documentationradiobtn=By.xpath("//*[@id=\"appian-body\"]/div/div/div/div/div/div[2]/div/div[6]/div[3]/div/div[2]/div/div[1]/div/div[2]/div/div[1]/label");
	
	static By submitbtn=By.xpath("//*[@id=\"appian-body\"]/div/div/div/div/div/div[3]/div/div/div/div/div[2]/div/div[2]/button");
	static By coveragecheckbox=By.xpath("//*[@id=\"appian-body\"]/div/div/div/div/div/div[2]/div/div[1]/div/div/div/div/div/div[2]/div[2]/div[2]/div/div/div/div[3]/div[1]/div[2]/div/div[3]/div/div[2]/div/div/div/label\r\n" + 
			"");
	static By primarycoverage=By.xpath("//*[@id=\"appian-body\"]/div/div/div/div/div/div[2]/div/div[1]/div/div/div/div/div/div[2]/div[2]/div[2]/div/div/div/div[3]/div[1]/div[2]/div/div[2]/div/div[2]/div/div/input");
	
	
	
	public void clikoncreaterequest()
	{
		driver.findElement(createrequestbtn).click();
	}
	
	public void clikonclient() throws InterruptedException
	{
		WebElement el=driver.findElement(clientname);
		el.sendKeys("FBR Capital Markets Intl Ltd" );
		Thread.sleep(3000);
		el.sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);
		
	}
	
	public void selectclienttrader() throws InterruptedException {
		

	Thread.sleep(5000);
	
	WebElement el=driver.findElement(clienttraderdropdown);
	el.click();
	Thread.sleep(5000);
	Actions act= new Actions(driver);
	act.moveToElement(el);
	el.sendKeys(Keys.ARROW_DOWN);
	el.sendKeys(Keys.ENTER);
	Thread.sleep(5000);
	driver.findElement(clienttradergrid).click();

		
	}
	
	public void selectproduct() throws InterruptedException {
		
		driver.findElement(assetclass).click();
		driver.findElement(producttype).click();
		driver.findElement(productname).click();
		driver.findElement(documentationradiobtn).click();
		Thread.sleep(5000);
		driver.findElement(submitbtn).click();
		
	}
	
	public void selectsalescoverage() throws InterruptedException {
		
		driver.findElement(coveragecheckbox).click();
		Thread.sleep(5000);
		WebElement el=driver.findElement(primarycoverage);
		Actions act= new Actions(driver);
		act.moveToElement(el);
		act.click();
		act.perform();
		el.sendKeys("trang");
		Thread.sleep(5000);
		el.sendKeys(Keys.ARROW_DOWN);
		el.sendKeys(Keys.ENTER);
		
		
	}

}




//1. click 
//driver.findElement(By.xpath("//strong[contains(text(),'Client Trader')]/../ancestor::div[contains(@class,'SideBySideItem---minimize')]/following-sibling::div//div[@role='listbox']")).click();
//2. aria-activedescendant : criteria
//// loop: 
//	 for (int i = 0; i < 5; i++) {
//		 
//		 String value = driver.findElement(By.xpath("//strong[contains(text(),'Client Trader')]/../ancestor::div[contains(@class,'SideBySideItem---minimize')]/following-sibling::div//div[@role='listbox' and contains(@aria-activedescendant,'_list_"+i+"')]/span/span[text()='"+dropdownValue+"']")).getText();
//			if(value.equalsIgnoreCase(dropdownValue)) {
//				driver.findElement(By.xpath("//strong[contains(text(),'Client Trader')]/../ancestor::div[contains(@class,'SideBySideItem---minimize')]/following-sibling::div//div[@role='listbox' and contains(@aria-activedescendant,'_list_')]/span/span[text()='"+dropdownValue+"']")).click();
//				break;
//			}
//	}

//driver.findElement(By.xpath("//strong[contains(text(),'Client Trader')]/../ancestor::div[contains(@class,'SideBySideItem---minimize')]/following-sibling::div//div[@role='listbox']/span[text()='"+dropdownValue+"']")).click();
	
		
		//driver.findElement(By.xpath("//*[@id=\"b1b65d7547c5475042bc0c0ad11c95e8_value\"]/span[1]/span"));

//build.MoveToElement(FindElement(By.Id("ext-gen33"))).MoveByOffset(124, 0).Click().Build().Perform();

//String dropdownValue = "Mark Brewer";



		/* List<WebElement> options = driver.findElements(By.cssSelector("div.MultipleDropdownWidget---dropdown_value MultipleDropdownWidget---inSideBySideItem>span>span"));
		 System.out.println("size "+options.size());
		 for(WebElement element : options){
		 if(element.getText().equals(dropdownValue)){
		     element.click();
		 }
		 }*/