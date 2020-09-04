package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressPage {


	WebDriver driver;
	Extractor ex;
	
	public AddressPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void ClickOnProceed_Address() throws Exception {
		
		ex = new Extractor();
		
		WebElement CheckOutafterSign = driver.findElement(By.name(ex.Locaters(4, 0)));
		CheckOutafterSign.click();
		
		
	}
}
