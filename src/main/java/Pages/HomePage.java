package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	WebDriver driver;

	Extractor ex ;
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void SearchByItem() throws Exception {
		ex = new Extractor();
		
		WebElement SearchTxt = driver.findElement(By.id(ex.Locaters(0, 0)));
		SearchTxt.sendKeys("blouse");
		
		WebElement searchbttn = driver.findElement(By.name(ex.Locaters(0, 1)));
		searchbttn.click();
	}
}
