package generic;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public abstract class Base_Page {

	public WebDriver driver;

	public Base_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyTitle(String title) {
		WebDriverWait wait = new WebDriverWait(driver, 20);

		try {
			wait.until(ExpectedConditions.titleContains(title));
			Reporter.log("title is matching", true);

		} catch (Exception e) {
			Reporter.log("title is not matching", true);
			Assert.fail();
		}
	}

	public void PassData(WebElement tbox,String data)
	{
		tbox.sendKeys(data);
	}
	
	
	
	public void Screenshot(WebDriver driver, String path)
	{
		Date d =new Date();
		String s=d.toString();
		String date = s.replaceAll(":", "-");
		TakesScreenshot ts =  (TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst = new File (path+date+".jpg");
		
		try
		{
			FileUtils.copyFile(src, dst);
		}
		catch(Exception e)
		{
			Reporter.log("Copy failed", true);
		}
	}
	
	public void verifyElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 25);

		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("Text is present", true);
		} catch (Exception e) {
			Reporter.log("Text is not present", true);
			Assert.fail();
		}
	}

	public void dropDown(WebElement element, String text) {
		Select s = new Select(element);
		try {
			s.selectByVisibleText(text);
			Reporter.log("Dropdown value is selected", true);

		} catch (Exception e) {
			Reporter.log("Dropdown value is not selected", true);
			Assert.fail();
		}
	}

	public void mouseHoverAction(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);

		try {
			act.moveToElement(ele).perform();
			Reporter.log("Mouse hover is  selected", true);

		} catch (Exception e) {

			Reporter.log("Mouse hover is not  selected", true);
			Assert.fail();
		}
	}

	public void srollBarActions(WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		try {
			js.executeScript("window.scrollBy(" + x + "," + y + ")");
			Reporter.log("Scroll bar is successfull", true);
		} catch (Exception e) {
			Reporter.log("Mouse hover is not  selected", true);
			Assert.fail();
		}
	}

	public void clickLink(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try {

			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			Reporter.log("link click is successfull", true);
		} catch (Exception e) {
			Reporter.log("link click" + ele + " is not successfull", true);
			
		}
	}

	public void isdisplayed(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(ele));
		boolean displayed = ele.isDisplayed();
		if (displayed) {
			Reporter.log("Product is added to cart", true);
		} else {
			Reporter.log("Product is not added to cart", true);
		}
	}

	
	
}