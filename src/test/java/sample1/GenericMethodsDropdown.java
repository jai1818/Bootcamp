package sample1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericMethodsDropdown {
	
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
			
			String month_Xpath="//*[@id='month']";
			String day_Xpath="//*[@id='day']";
			String year_Xpath="//*[@id='year']";
			
			driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys("dsddsd");
			WebElement day = driver.findElement(By.xpath(day_Xpath));
			WebElement month = driver.findElement(By.xpath(month_Xpath));
			WebElement year = driver.findElement(By.xpath(year_Xpath));
		
			String dob="6-Dec-1995";
			String[] split = dob.split("-");
			System.out.println(split[0]);
			System.out.println(dob);
			
			selectValueFromDropdown(day, split[0]);
			selectValueFromDropdown(month, split[1]);
			selectValueFromDropdown(year, split[2]);
	}

}
