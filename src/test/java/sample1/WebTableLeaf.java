package sample1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableLeaf {

	public static void main(String[] args) {

		
		WebDriver driver= new ChromeDriver();
		
		driver.navigate().to("https://www.leafground.com/grid.xhtml");
		
		driver.findElement(By.xpath("//td[contains(text(),'Black Watch')]/parent::tr//td[@class='ui-selection-column']")).click();
		
	
	}

}
