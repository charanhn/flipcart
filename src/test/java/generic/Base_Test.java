package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class Base_Test implements Auto_const{
	
	static
	{
		
		System.setProperty(GECKO_KEY,GECKO_VALUE);	
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	
	public void openAppln()
	{
		
		 driver=new FirefoxDriver();
		driver.get("https://www.flipkart.com/");
	}
	
	@AfterMethod
	public void closeAppln()
	{
		driver.quit();
	}

}
