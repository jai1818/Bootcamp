package sample1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafAlert {

	public static void main(String[] args) {

		WebDriver driver= new ChromeDriver();
		driver.navigate().to("https://www.leafground.com/alert.xhtml");
		
		WebElement simplealert = driver.findElement(By.id("j_idt88:j_idt91"));
		simplealert.click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		WebElement okay = driver.findElement(By.id("j_idt88:j_idt93"));
		okay.click();
		Alert alert2 = driver.switchTo().alert();
		alert2.dismiss();
		
		WebElement simple = driver.findElement(By.id("j_idt88:j_idt95"));
		simple.click();
		WebElement dial = driver.findElement(By.id("j_idt88:j_idt98"));
		dial.click();
		
		WebElement delete = driver.findElement(By.id("j_idt88:j_idt106"));
		delete.click();
		driver.findElement(By.id("j_idt88:j_idt108")).click();
		
		WebElement alertprompt = driver.findElement(By.id("j_idt88:j_idt104"));
		alertprompt.click();
		Alert alert3 = driver.switchTo().alert();
		alert3.sendKeys("Jayaprakash");
		alert3.accept();
	}

}
