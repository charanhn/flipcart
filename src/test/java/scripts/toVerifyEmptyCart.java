package scripts;

import java.util.Set;

import org.testng.annotations.Test;
import pom.ProductDetailsPage;
import pom.ShoppingCartPage;
import generic.Base_Test;
import pom.HomePage;

public class toVerifyEmptyCart extends Base_Test {

	@Test
	public void testToVerifyAddtoShoppingCart() {
		HomePage home = new HomePage(driver);
		home.enterEmail();
		home.enterpassword();
		home.submitButton();
		home.toverifytitle();
		home.entersearch();
		home.clickSearchButton();

		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window
		home.clickSearchedProductClick();

		// Switch to new window opened
		//Set<String> winHandle = driver.getWindowHandles();
		//driver.switchTo().window(winHandle);
		
		for (String winHandle : driver.getWindowHandles()) {
		driver.switchTo().window(winHandle);
		}

		// Perform the actions on new window
		ProductDetailsPage PDP = new ProductDetailsPage(driver);
		PDP.toaddtocart();

		ShoppingCartPage SCP = new ShoppingCartPage(driver);
		SCP.testremovelink();
		SCP.testemptycart();
		SCP.testemptycarttext();

		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

	}

}
