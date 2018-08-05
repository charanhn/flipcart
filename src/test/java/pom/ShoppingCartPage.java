package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.Base_Page;

public class ShoppingCartPage extends Base_Page {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);

	}

	// Declaration

	@FindBy(xpath = "//span[.='Remove']")
	private WebElement removelink;


	@FindBy(xpath = "(//span[.='Empty Cart'])[2]")
	private WebElement emptycart;

	@FindBy(xpath = "//span[.='Your Shopping Cart is empty']")
	private WebElement emptycarttext;
	//
	// Utilization

	public void testremovelink() {
		isdisplayed(removelink);
	}

	public void testemptycart() {
		clickLink(removelink);
	}

	public void testemptycarttext() {
		clickLink(emptycarttext);
	}

}