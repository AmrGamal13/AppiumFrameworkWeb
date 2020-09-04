package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShippingPage {

	

	WebDriver driver;
	Extractor ex;

	public ShippingPage(WebDriver driver) 
	{
		
		this.driver = driver;
	}
	
	
	public void ClickOnProceedToCheckOut_Shipping() throws Exception 
	{
		
		ex = new Extractor();
		WebElement Terms = driver.findElement(By.id(ex.Locaters(5, 0)));
		Terms.click();
		
		
		WebElement CheckOutAfterCarrier = driver.findElement(By.name(ex.Locaters(5, 1)));
		CheckOutAfterCarrier.click();
	}
}
