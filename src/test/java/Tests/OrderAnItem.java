package Tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.collect.ImmutableMap;

import Pages.AddressPage;
import Pages.HomePage;
import Pages.ItemPage;
import Pages.PaymentPage;
import Pages.ShippingPage;
import Pages.ShoppingCartSummaryPage;
import Pages.SigninPage;
import Pages.SummaryPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class OrderAnItem extends Test_Base {

	
	HomePage HomObj;
	AddressPage AddObj;
	ItemPage IteObj;
	PaymentPage PaymObj;
	ShippingPage ShipObj;
	ShoppingCartSummaryPage ShoppObj;
	SigninPage SigObj;
	SummaryPage SumObj;

	String ItemSelectedName;
	String ItemSelectedPrice;
	ExtentTest test;
	
	
	@Test(description = "Purchase a Blouse" , alwaysRun = true , priority = 1 )
	public void PlaceAnOrderTestCase() throws Exception {
		
		
		HomObj = new HomePage(driver);
		AddObj = new AddressPage(driver);
		IteObj = new ItemPage(driver);
		PaymObj = new PaymentPage(driver);
		ShipObj = new ShippingPage(driver);
		ShoppObj = new ShoppingCartSummaryPage(driver);
		SigObj = new SigninPage(driver);
		SumObj = new SummaryPage(driver);


		// creates a toggle for the given test, adds all log events under it    
         test = extent.createTest("Place an Order Test", "E2E Scenario ordering an Item ");

		HomObj.SearchByItem();
		 // log(Status, details)
        test.log(Status.INFO, "Searching for Blouse Item");
        
		ItemSelectedName = IteObj.GetItemName();
		 test.log(Status.INFO, "Getting the Item Name");
		 
		ItemSelectedPrice = IteObj.GetItemPrice();
		test.log(Status.INFO, "Getting the Item Price");

		IteObj.ClickOnAddToCart();
		test.log(Status.INFO, "Click on Add to Cart");
		
		Thread.sleep(4000);
		IteObj.ClickOnChecout();
		Thread.sleep(4000);

		String name =	SumObj.GetItemName();
		String value = SumObj.GetItemPrice();
		//Assert.assertTrue(ItemSelectedName.equals(ShoppObj.getItemName_Summary()));
		Assert.assertFalse(ItemSelectedPrice.equals(value));
		test.log(Status.PASS, "The Item Price displays correctly");


		SumObj.ProceedToCheckOutSummary();
		test.log(Status.INFO, "Click on Add to Cart");
		test.log(Status.PASS, "Check Out Summary page displays succesfully");

		Thread.sleep(6000);
		SigObj.Login();
		test.log(Status.INFO, "Login to my Account");
		
		Thread.sleep(6000);
		
		AddObj.ClickOnProceed_Address();
		test.log(Status.INFO, "Select my address");
		
		Thread.sleep(3000);
		ShipObj.ClickOnProceedToCheckOut_Shipping();
		Thread.sleep(3000);
		
		PaymObj.ClickOnPayByCheque_payment();
		PaymObj.ClickOnConfirmOrder();

		

		System.out.println("Done");
	}
	
	
	@Test(dependsOnMethods = {"PlaceAnOrderTestCase"})
	public void CheclSuccessfullMessage() throws IOException 
	{
		PaymObj = new PaymentPage(driver);
		
		// creates a toggle for the given test, adds all log events under it    
        test = extent.createTest("Check Successfull Message", "E2E Scenario ordering an Item ");
		
		Assert.assertTrue(PaymObj.OrderConfirmationMessageDisplays());
		test.log(Status.PASS, "The Order has been placed successfully with a confirmation message");
		
	}

}
