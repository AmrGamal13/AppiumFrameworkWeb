package tryappium.tryappiumnew;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.naming.directory.DirContext;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestMobileWeb {


	public static AppiumDriver<WebElement> driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities des = new DesiredCapabilities ();
		ChromeOptions opt = new ChromeOptions();
		//opt.setExperimentalOption("w3c", false);
		des.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));

		des.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		des.setCapability("chromedriverExecutable", "Users/adelmostafa/Downloads/chromedriverNew");
		des.setCapability("deviceName", "HUAWEI Mate 10 lite");
		des.setCapability("udid", "FFY5T18116015518");
		des.setCapability("platformName", "Android");
		des.setCapability("platformVersion", "8.0.0");

		URL url = new URL ("http://127.0.0.1:4723/wd/hub");

		driver = new AppiumDriver<WebElement>(url,des);

		driver.get("http://automationpractice.com/index.php?");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("Mobile web started ..... ");

		WebElement x = driver.findElement(By.id("search_query_top"));
		x.sendKeys("blouse");

		WebElement searchbttn = driver.findElement(By.name("submit_search"));
		searchbttn.click();

		Thread.sleep(3000);

		WebElement itemnameelement = driver.findElement(By.cssSelector("#center_column > ul > li > div > div.right-block > h5 > a"));
		String itemname = itemnameelement.getText();

		WebElement ItemPriceEle = driver.findElement(By.cssSelector("#center_column > ul > li > div > div.right-block > div.content_price > span"));
		String itemprice = ItemPriceEle.getText();

		Thread.sleep(3000);

		WebElement addToCartBttn = driver.findElement(By.cssSelector("a.button.ajax_add_to_cart_button.btn.btn-default"));
		addToCartBttn.click();

		WebElement ProceedToCheckOutEl = driver.findElement(By.cssSelector("a.btn.btn-default.button.button-medium"));
		ProceedToCheckOutEl.click();

		//shopping cart  summary


		WebElement namesummaryel = driver.findElement(By.xpath("//*[@id=\"product_2_7_0_0\"]/td[2]/p/a"));
		String namesummary	= namesummaryel.getText();

		WebElement pricesummaryel = driver.findElement(By.xpath("//*[@id=\"product_price_2_7_0\"]/span"));
		String pricesummary	= pricesummaryel.getText();

		WebElement proceedtoCheckoutBttnsummary = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]"));
		proceedtoCheckoutBttnsummary.click();



		WebElement UsNameTxt = driver.findElement(By.id("email"));
		UsNameTxt.sendKeys("adgamal@eg.ibm.com");

		WebElement PassTxt = driver.findElement(By.id("passwd"));
		PassTxt.sendKeys("adelgamal");

		WebElement signin  = driver.findElement(By.id("SubmitLogin"));
		signin.click();
		
		WebElement CheckOutafterSign = driver.findElement(By.name("processAddress"));
		CheckOutafterSign.click();
		
		
		WebElement Terms = driver.findElement(By.id("cgv"));
		Terms.click();
		
		
		WebElement CheckOutAfterCarrier = driver.findElement(By.name("processCarrier"));
		CheckOutAfterCarrier.click();
		
		WebElement PayByChecque = driver.findElement(By.cssSelector("a.cheque"));
		PayByChecque.click();
		
		WebElement confirmOrder = driver.findElement(By.cssSelector("button.button.btn.btn-default.button-medium"));
		confirmOrder.click();
		
		//div.box.order-confirmation  ---- order confirmation
	}

}
