package Tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Test_Base {

	public static AppiumDriver<WebElement> driver;

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;

	@BeforeSuite
	public void StartDriver() throws MalformedURLException {


		htmlReporter = new ExtentHtmlReporter("extent.html"); 
		String OsType = "Android";

		// create ExtentReports and attach reporter(s) 
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		DesiredCapabilities des = new DesiredCapabilities ();

		if (OsType.equalsIgnoreCase("Android")) 
		{ 
			//ChromeOptions opt = new ChromeOptions(); 
			//opt.setExperimentalOption("w3c", false);
			//des.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));

			//des.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
			//des.setCapability("chromedriverExecutable", "/Users/adelmostafa/Downloads/chromedriverNew");
			des.setCapability("deviceName", "HUAWEI Mate 10 lite");
			des.setCapability("udid", "FFY5T18116015518");
			des.setCapability("platformName", "Android");
			des.setCapability("platformVersion", "8.0.0");
			des.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.swvl.customer");
			des.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.swvl.customer.features.LaunchScreenActivity");
			//des.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "io.swvl.customer.features.*");
			//des.setCapability(AndroidMobileCapabilityType.APP_WAIT_DURATION, 10000);

			URL url = new URL ("http://127.0.0.1:4723/wd/hub");

			driver = new AppiumDriver<WebElement>(url,des); 
			
			//for Mobile app
			//File app = new File("/Users/adelmostafa/Documents/TestMobileAPPAndroid/App/selendroid-test-app-0.17.0.apk");
			//caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		}

		else { 
			des.setCapability("platformName", "iOS");
			des.setCapability("platformVersion", "13.3"); 
			des.setCapability("deviceName","iPhone 8"); 
			des.setCapability(CapabilityType.BROWSER_NAME, "safari");
			des.setCapability("udid", "459D7303-E034-4666-892C-A29E5EBEE255");

			URL url = new URL("http://127.0.0.1:4723/wd/hub");

			driver = new AppiumDriver<WebElement>(url ,des); }

		//driver.get("http://automationpractice.com/index.php?");

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("Mobile web started ..... ");

	}


	@AfterSuite
	public void closeDriver() {

		driver.quit();

		extent.flush();
	}
}
