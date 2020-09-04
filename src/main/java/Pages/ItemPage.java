package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemPage {
	
	WebDriver driver;
	Extractor ex;
	
	String itemname;
	String itemprice;
	
	public ItemPage(WebDriver driver) {
		this.driver = driver;

	}

	public String GetItemName() throws Exception {
		
		ex = new Extractor();
		WebElement itemnameelement = driver.findElement(By.cssSelector(ex.Locaters(1, 0)));
		return  itemname = itemnameelement.getText();
	}
	
	
	public String GetItemPrice() throws Exception {
		ex = new Extractor();
		WebElement ItemPriceEle = driver.findElement(By.cssSelector(ex.Locaters(1, 1)));
		return itemprice = ItemPriceEle.getText();
	}
	
	
	public void ClickOnAddToCart() throws Exception {
		ex = new Extractor();
		WebElement addToCartBttn = driver.findElement(By.cssSelector(ex.Locaters(1, 2)));
		addToCartBttn.click();
	}

	
	public void ClickOnChecout() throws Exception {
		ex = new Extractor();
		
		WebElement ProceedToCheckOutEl = driver.findElement(By.cssSelector(ex.Locaters(1, 3)));
		ProceedToCheckOutEl.click();
	}
		

	}
	
