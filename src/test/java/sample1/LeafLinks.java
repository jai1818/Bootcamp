package sample1;

import java.util.List;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafLinks {

	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		driver.navigate().to("https://www.leafground.com/link.xhtml");
//		driver.findElement(By.xpath("//*[@id=\"j_idt87\"]/div/div[1]/div[1]/div/div/a")).click();
		
		WebElement findElement = driver.findElement(By.linkText("Find the URL without clicking me."));
		String attribute = findElement.getAttribute("href");
		System.out.println(attribute);
		
		List<WebElement> ee = driver.findElements(By.xpath("//*[starts-with(@href, '/')]"));
		int size = ee.size();
		System.out.println(size);
		
		for (WebElement webElement : ee) {
			System.out.println(webElement.getAttribute("href"));
		}
	}

}
