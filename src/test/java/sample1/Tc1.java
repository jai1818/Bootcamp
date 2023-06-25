package sample1;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc1 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://way2automation.com/way2auto_jquery/index.php");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("name")).sendKeys("Jayaprakash");
		driver.findElement(By.name("phone")).sendKeys("7010081999");
		driver.findElement(By.name("email")).sendKeys("ijai@gmail.com");
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"load_form\"]/fieldset[4]/select"));
		Select select=new Select(dropdown);
		List<WebElement> options = select.getOptions();
		System.out.println(options.size());
		
		driver.findElement(By.xpath("//option[@value='Japan']")).click();
		
		
//		for (int i = 0; i < options.size(); i++) {
//			String text = options.get(i).getText();
//			System.out.println(text);
//			System.out.println(options.get(i).getAttribute("value"));
//		}
		
	}

}
