package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.Base_Page;

public class HomePage extends Base_Page {
	
	public HomePage(WebDriver driver) {
		super(driver);
	
	}
	
	//Declaration
	
	@FindBy(xpath = "//input[@class='_2zrpKA' and @type ='text']")
	private WebElement email;

	
	@FindBy(xpath = "//input[@type ='password']")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit' and .='Login']")
	private WebElement login;
	
	@FindBy(xpath = "//input[@class='LM6RPg']")
	private WebElement searchtext;
	
	@FindBy(xpath = "//button[@class='vh79eN']")
	private WebElement searchbutton;

	@FindBy(xpath = "(//div[@class='_3wU53n'])[1]")
	private WebElement searchedProductClick;
	
	// Utilization
	public void enterEmail() {
		PassData(email, "charanhn07@gmail.com");
	}
	
	public void enterpassword()
	{
		PassData(password,"sapient123");
	}
	
	public void submitButton() {
		clickLink(login);
	}
	
	public void toverifytitle()
	{
		verifyTitle("Online");
	}
	public void entersearch() {
		PassData(searchtext,"samsung j2");
	}
	
	public void clickSearchButton() {
			clickLink(searchbutton);	
		
	}
	
	public void clickSearchedProductClick() {
		clickLink(searchedProductClick);	
	
}
	
}
