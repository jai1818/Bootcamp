package org.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class EditAccounts extends BaseClass{
	
	@Test
	public void edit() throws InterruptedException {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		Thread.sleep(1000);
		driver.findElement(By.className("slds-icon-waffle")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'View All')]"))).click();
		

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Manage your sales process with accounts, leads, opportunities, and more')]"))).click();
		//driver.findElement(By.xpath("//*[contains(text(),'Manage your sales process with accounts, leads, opportunities, and more')]")).click();
		JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
	//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='navItem slds-context-bar__item slds-shrink-none']//span[contains(text(),'Accounts')]"))).click();
		jsExecutor2.executeScript("arguments[0].click();",wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='navItem slds-context-bar__item slds-shrink-none']//span[contains(text(),'Accounts')]"))));
		
		
		
		
		
		
		
		
	}


}
