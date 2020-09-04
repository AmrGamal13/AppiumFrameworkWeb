package tryappium.tryappiumnew;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestCalcuApp {


	static AppiumDriver<MobileElement> driver;

	public static void main(String[] args) throws MalformedURLException {
		runAppium();
	}


	public static void runAppium() throws MalformedURLException 
	{

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "HUAWEI P30 lite");
		cap.setCapability("udid", "FFY5T18116015518");

		cap.setCapability("platformName","Android");

		cap.setCapability("platformVersion", "8.0.0");
		cap.setCapability("appPackage","com.huawei.compass");
		cap.setCapability("appActivity","com.huawei.compass.MainActivity");

		URL url = new URL ("http://127.0.0.1:4723/wd/hub");

		driver = new AppiumDriver<MobileElement>(url ,cap); 

		System.out.println("application started ....");

	}
}
