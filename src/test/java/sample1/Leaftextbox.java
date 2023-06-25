package sample1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Leaftextbox {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.navigate().to("https://www.leafground.com/input.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("j_idt88:name")).sendKeys("Jayaprakash");
		driver.findElement(By.id("j_idt88:j_idt91")).sendKeys("India");
		
		WebElement disabled = driver.findElement(By.id("j_idt88:j_idt93"));
		boolean answer = disabled.isEnabled();
		System.out.println(answer);
		
		driver.findElement(By.id("j_idt88:j_idt95")).clear();
		
		WebElement retrive = driver.findElement(By.id("j_idt88:j_idt97"));
		String attribute = retrive.getAttribute("value");
		System.out.println(attribute);
		
		WebElement email = driver.findElement(By.id("j_idt88:j_idt99"));
		email.sendKeys("iamjai1818@gmail.com" + Keys.TAB + "My name is jay");
		
		Thread.sleep(1000);
		
		WebElement enter = driver.findElement(By.xpath("//*[@id=\"j_idt106:thisform:age\"]"));
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].value='';", enter);
	        js.executeScript("arguments[0].dispatchEvent(new Event('change'));", enter);

        
		String text = driver.findElement(By.xpath("//*[@id=\"j_idt106:thisform:j_idt110_error-detail\"]")).getText();
		System.out.println(text);
		
		//own assignment
		/*
		 * String s="testleaf"; char[] ca = s.toCharArray();
		 * 
		 * System.out.println(ca.length); for (int i = ca.length-1; i>=0; i--) {
		 * System.out.println(ca[i]); }
		 */
		

	
	
	
	
	
	
	
	
	
	
	
	}

}
