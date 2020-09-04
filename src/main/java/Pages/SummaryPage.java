package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SummaryPage {
	
	WebDriver driver;
	Extractor ex;
	
	String ItemName;
	String ItemPrice;
	
	public SummaryPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public String GetItemName() throws Exception {
		ex = new Extractor();
		
		//WebElement name = driver.findElement(By.className(ex.Locaters(2, 0)));
		WebElement name =driver.findElement(By.xpath("//a[contains(@href,'color-black')]"));
		ItemName = name.getText();
		
		return ItemName;
		
	}
	
	public String GetItemPrice() throws Exception {
		
		ex = new Extractor();
		//WebElement price = driver.findElement(By.className(ex.Locaters(2, 1)));
		WebElement price = driver.findElement(By.xpath("//span[@id='total_price']"));
		ItemPrice =	price.getText();
		
		return ItemPrice;
	}
	
	
	public void ProceedToCheckOutSummary() {
		WebElement proceedtoCheckoutBttnsummary = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]"));
		proceedtoCheckoutBttnsummary.click();
	}
}
