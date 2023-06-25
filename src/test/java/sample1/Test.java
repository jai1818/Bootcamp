package sample1;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {
	WebDriver driver;

	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.leafground.com/dashboard.xhtml");
		driver.findElement(By.xpath("//*[@id=\"menuform:j_idt40\"]/a/i[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"menuform:m_dropdown\"]/a")).click();
		
		WebElement favUIauto = driver.findElement(By.xpath("//*[@class='ui-selectonemenu']"));
		
		Select select =new Select(favUIauto);
		select.selectByVisibleText("Selenium");
		List<WebElement> options = select.getOptions();
		for (WebElement webElement : options) {
			System.out.println(webElement.getText());
		}
		
		//to select country
		WebElement drop2 = driver.findElement(By.xpath("//select[@id='j_idt87:country_input']"));
		Actions action= new Actions(driver);
		action.click(drop2).perform();
		Select select2 =new Select(drop2);
		select2.selectByVisibleText("India");
		
		//to select city
//		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(10000);
		 WebElement drop3 = driver.findElement(By.xpath("//*[@id=\"j_idt87:city_input\"]"));
//		 driver.findElement(By.xpath("//*[@id=\"j_idt87:city_2\"]")).click();
		 drop3.click();
		 Select select3=new Select(drop3);
		 select3.selectByVisibleText("Bengaluru");
		
		driver.findElement(By.xpath("//*[@id=\"j_idt87:lang_label\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"j_idt87:lang_2\"]")).click();
		
		
		
	}
}
