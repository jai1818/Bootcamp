package org.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AccountCreation extends BaseClass  {

	@Test
	public void accountCreation() throws InterruptedException {

		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		Thread.sleep(1000);
		driver.findElement(By.className("slds-icon-waffle")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'View All')]"))).click();
		

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Manage your sales process with accounts, leads, opportunities, and more')]"))).click();
		//driver.findElement(By.xpath("//*[contains(text(),'Manage your sales process with accounts, leads, opportunities, and more')]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//one-app-nav-bar-item-root[7]//one-app-nav-bar-item-dropdown[1]//div[1]"))).click();

		Thread.sleep(2000);//It is not working without this thread -->pls clarify why -->tried to use explicit wait but no luck
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[text()='New Account']//ancestor::a")));


		String name="Jai";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Account Name']/following-sibling::div/input"))).sendKeys(name);
		//driver.findElement(By.xpath("//label[contains(text(),'Account Name')]/following::input[@id='input-205']")).sendKeys("Jayaprakash");
		//driver.findElement(By.xpath("//span[text()='Public']")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Ownership')]/following-sibling::div")).click();

		driver.findElement(By.xpath("//span[text()='Public']")).click();

		driver.findElement(By.xpath("//button[text()='Save']")).click();
			//Not able to fetch the message from toast										
		String text = driver.findElement(By.xpath("//div[contains(@class,'slds-theme--success slds-notify--toast')]")).getText();
		if (text.contains(name+"created")) {
		
		System.out.println("Account"+name+"was created");
		}else {
			System.out.println("Account creation failed");
		}


	}

}
