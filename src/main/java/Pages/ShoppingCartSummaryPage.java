package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartSummaryPage {

	WebDriver driver;
	Extractor ex;
	
	String itemprice;
	String itemname;

	public ShoppingCartSummaryPage(WebDriver driver) {
		this.driver = driver;
	}


	public String GetItemPrice_Summary() throws Exception {
		ex = new Extractor();
		WebElement ItemPriceEle = driver.findElement(By.xpath(ex.Locaters(2, 0)));
		return itemprice = ItemPriceEle.getText();
	}


	public String getItemName_Summary() throws Exception {

		ex = new Extractor();
		WebElement itemnameelement = driver.findElement(By.xpath(ex.Locaters(2, 1)));
		return  itemname = itemnameelement.getText();
	}


	public void ClickOnCheckout_Summary() throws Exception {
		ex = new Extractor();
		WebElement proceedtoCheckoutBttnsummary = driver.findElement(By.xpath(ex.Locaters(2, 2)));
		proceedtoCheckoutBttnsummary.click();
	}
}
