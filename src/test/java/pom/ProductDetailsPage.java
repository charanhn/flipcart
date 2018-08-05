package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.Base_Page;

public class ProductDetailsPage extends Base_Page {
	
	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	
	}
	
	//Declaration
	
	@FindBy(xpath = "//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")
	private WebElement addtocart;

	

	
	// Utilization
	
	public void toaddtocart()
	{
		clickLink(addtocart);
	}
	
	
	}
	
