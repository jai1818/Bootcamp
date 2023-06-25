package org.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	
	public void BaseClass() {
		WebDriver driver= new ChromeDriver();
		driver.navigate().to("https://login.salesforce.com/");
		driver.navigate().to("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		driver.manage().window().maximize();
		
	}
	public static void main(String[] args) {

		
		BaseClass b= new BaseClass();
		b.BaseClass();
		
		
		
	}

}
