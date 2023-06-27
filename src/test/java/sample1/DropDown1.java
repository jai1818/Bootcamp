package sample1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown1 {

	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		driver.navigate().to("http://leaftaps.com/crmsfa/control/myHomeMain");
		driver.findElement(null)
		driver.findElement(By.id("ext-gen603")).click();
		
		WebElement industry = driver.findElement(By.name("industryEnumId"));
		
		Select indselect= new Select(industry);
		indselect.selectByVisibleText("Insurance");
	}

}
