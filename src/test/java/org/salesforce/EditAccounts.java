package org.salesforce;

import java.time.Duration;
import java.util.List;

import org.bouncycastle.pqc.jcajce.provider.rainbow.SignatureSpi.withSha224;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.invokers.AbstractParallelWorker.Arguments;

public class EditAccounts extends BaseClass{

	@Test
	public void edit() throws InterruptedException {

		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		Thread.sleep(1000);
		driver.findElement(By.className("slds-icon-waffle")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'View All')]"))).click();
		final String name="veera";

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


				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='branding-actions actionMenu']//a[contains(@title,'Edit')]"))).click();

				//to select type dropdown
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@field-label='Type']//div/button"))).click();
				driver.findElement(By.xpath("//div[@class='slds-listbox slds-listbox_vertical slds-dropdown slds-dropdown_fluid slds-dropdown_left slds-dropdown_length-with-icon-7']//span[contains(text(),'Technology Partner')]")).click();
				//to select industry dropdown
				driver.findElement(By.xpath("//*[@field-label='Industry']//div/button")).click();
				driver.findElement(By.xpath("//div[@class='slds-listbox slds-listbox_vertical slds-dropdown slds-dropdown_fluid slds-dropdown_left slds-dropdown_length-with-icon-7']//span[contains(text(),'Agriculture')]")).click();

				//billing address
				WebElement element = driver.findElement(By.xpath("//*[@field-label='Billing Address']//textarea"));
				element.sendKeys("sdfsdfsdfds");
				//shipping address
				driver.findElement(By.xpath("//*[@field-label='Shipping Address']//textarea")).sendKeys("dubai road");

				//set priority
				WebElement priority = driver.findElement(By.xpath("//*[contains(text(),'Customer Priority')]//following-sibling::div//div/div/button"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", priority);
				driver.findElement(By.xpath("//div[@role='listbox']//*[@data-value='Low']")).click();

				//set SLA
				driver.findElement(By.xpath("//*[contains(text(),'SLA')]//following-sibling::div//div/div/button")).click();
				driver.findElement(By.xpath("//div[@role='listbox']//*[@data-value='Silver']")).click();
				
				//set Active-yes
				driver.findElement(By.xpath("//label[contains(text(),'Active')]//following-sibling::div//div/div/button")).click();
				driver.findElement(By.xpath("//div[@role='listbox']//*[@data-value='Yes']")).click();
				
				//Set phone number
				driver.findElement(By.xpath("//input[@name='Phone']")).sendKeys("900222");
				//select upskill oppurtunity
				WebElement upskill = driver.findElement(By.xpath("//*[contains(text(),'Upsell Opportunity')]//following-sibling::div//div/div/button"));
				js.executeScript("arguments[0].click();", upskill);
				driver.findElement(By.xpath("//div[@role='listbox']//*[@data-value='No']")).click();
				//save
				driver.findElement(By.xpath("//*[@name=\"SaveEdit\"]")).click();	
				
				String actual = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@id,'toastDescription')]/span"))).getText();
				System.out.println(actual);
				String partialString =" was saved.";
				
				
				Assert.assertTrue(actual.contains(partialString), "Failed to edit");
				System.out.println("Edit is successful");
				
				break;
			}
		}





	}
}
