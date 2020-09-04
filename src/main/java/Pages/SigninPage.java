package Pages;

import javax.security.auth.login.LoginContext;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SigninPage {


	WebDriver driver;
	Extractor ex;
	
	public SigninPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void Login() throws Exception 
	{
		ex = new Extractor();
		
		WebElement UsNameTxt = driver.findElement(By.id(ex.Locaters(3, 0)));
		UsNameTxt.sendKeys("adgamal@eg.ibm.com");

		WebElement PassTxt = driver.findElement(By.id(ex.Locaters(3, 1)));
		PassTxt.sendKeys("adelgamal");

		WebElement signin  = driver.findElement(By.id(ex.Locaters(3, 2)));
		signin.click();
		
	}
}
