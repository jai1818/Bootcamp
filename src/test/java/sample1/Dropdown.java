package sample1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {
	
	public static void selectValueFromDropdown(WebElement element,String value) {
		Select s=new Select(element);
		s.selectByVisibleText(value);
		
	}
	

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.facebook.com/");
		driver.findElement(By.linkText("Create new account")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys("dsddsd");
		WebElement day = driver.findElement(By.xpath("//*[@id='day']"));
		WebElement month = driver.findElement(By.xpath("//*[@id='month']"));
		WebElement year = driver.findElement(By.xpath("//*[@id='year']"));
	
		String dob="6-Dec-1995";
		String[] split = dob.split("-");
		System.out.println(split[0]);
		System.out.println(dob);
		
		selectValueFromDropdown(day, split[0]);
		selectValueFromDropdown(month, split[1]);
		selectValueFromDropdown(year, split[2]);
		
//		Select s1=new Select(day);
//		s1.selectByVisibleText("6");
//		
//		Select s2=new Select(month);
//		s2.selectByIndex(11);
//		
//		Select s3=new Select(year);
//		s3.selectByVisibleText("1994");
		
		
	}

}
