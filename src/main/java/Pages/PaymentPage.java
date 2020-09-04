package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage {
	
	

	WebDriver driver;
	Extractor ex;
	
	public PaymentPage(WebDriver driver) 
	{
		
		this.driver = driver;
	}
	
	
	public void ClickOnPayByCheque_payment() throws Exception 
	{
		ex = new Extractor();
		WebElement PayByChecque = driver.findElement(By.cssSelector(ex.Locaters(6, 0)));
		PayByChecque.click();
		
	}

	
	public void ClickOnConfirmOrder() throws Exception 
	{
		ex = new Extractor();
		WebElement confirmOrder = driver.findElement(By.cssSelector(ex.Locaters(6, 1)));
		confirmOrder.click();
		
		
	}
	
	
	public boolean OrderConfirmationMessageDisplays() throws IOException {
		
		ex = new Extractor();
		WebElement ConfirmationMessage = driver.findElement(By.cssSelector("#center_column > p.alert.alert-success"));
		return ConfirmationMessage.isDisplayed();
	}
}
