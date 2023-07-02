package org.salesforce;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountDeletion extends BaseClass{
	
	
	@Test
	public void accountDeletion() throws InterruptedException {
		
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		Thread.sleep(1000);
		driver.findElement(By.className("slds-icon-waffle")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'View All')]"))).click();
		final String name="Jai";

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Manage your sales process with accounts, leads, opportunities, and more')]"))).click();
		//driver.findElement(By.xpath("//*[contains(text(),'Manage your sales process with accounts, leads, opportunities, and more')]")).click();
		JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='navItem slds-context-bar__item slds-shrink-none']//span[contains(text(),'Accounts')]"))).click();
		jsExecutor2.executeScript("arguments[0].click();",wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='navItem slds-context-bar__item slds-shrink-none']//span[contains(text(),'Accounts')]"))));

		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@name='Account-search-input']")).sendKeys(name+Keys.ENTER);
		//List<WebElement> names = driver.findElements(By.xpath("//table[contains(@class,'slds-table forceRecordLayout')]//tbody"));
		List<WebElement> names = driver.findElements(By.xpath("//div[@class='scroller actionBarPlugin']//tbody/tr/th"));


		for (WebElement namee : names) {

			if (namee.getText().equalsIgnoreCase(name)) {
				driver.findElement(By.xpath("//*[@role=\"tooltip\"]/div[text()]")).click();

				Thread.sleep(1000);
				WebElement ele = driver.findElement(By.xpath("//a[contains(@class,'slds-button slds-button--icon-x-small')]"));
				ele.click();

				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='uiMenuItem']//a[@title='Delete']"))).click();
			//	driver.findElement(By.xpath("//li[@class='uiMenuItem']//a[@title=\"Delete\"]")).click();
		
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Delete']"))).click();
				//driver.findElement(By.xpath("//button[@title='Delete']")).click();
		
				String text =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@id,'toastDescription')]/span"))).getText();
				System.out.println(text);
				String expec="was deleted.";
				Assert.assertTrue(text.contains(expec), "failed to delete");
				System.out.println("Deleted successfully");
		break;
		}
	}

}}
