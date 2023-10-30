package genericUtilities;

import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
		public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
		//This Method will wait for Page Load 
		public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

		public void waitforElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
		public void waitToBeElementToBeClickable(WebDriver driver , WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
		// this method handle dropdown using index
		//@param element 
		//@param index
		public void handleDropDown(WebElement element ,int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
		//this method will handle the dropdown using value
		//@param element 
		//@param value
		public void handleDropDown(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
		//this method will handle the dropdown using visible text
		//@param element 
		//@param visible text
		public void hndleDropDown(String visibleText,WebElement element)
		{
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
		}
		// this method will perform the mouserelated actions on a web element
		//@parameter driver  
		//@parameter element
		public void mouseHoverActions(WebDriver driver, WebElement element)
		{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
		}
		// this method will perform the right click action anywhere   on a web page
		// @param driver
		
		public void rightClickAction(WebDriver driver) {
			Actions act = new Actions(driver);
			act.contextClick().perform();
		}
		// this method will perform the right click action on a particular web element
		// @param driver
		// @param element
		
		public void rightClickAction(WebDriver driver, WebElement element) {
			Actions act = new Actions(driver);
			act.contextClick(element).perform();
		}
		
		// this method will perform the double click action on a particular web element
		//@parameter driver  
		//@parameter element
		
		public void doubleClickActions(WebElement element, WebDriver driver ) {
			Actions act = new Actions(driver);
			act.doubleClick(element).perform();
		}
		// this method will perform the drag and drop operation
		//@param driver
		//@param source
		//@param target
		
		public void dragAndDropActions(WebDriver driver,WebElement source , WebElement target) {
			Actions act = new Actions(driver);
			act.dragAndDrop(source, target).perform();
		}
		//// this method will move the cursor by offset and move
		// @param driver
		//@param x
		//@param y
		
		public void moveTheCursorAndClick(WebDriver driver ,int x , int y) {
			Actions act = new Actions(driver);
			act.moveByOffset(x, y).click().perform();
		}
		// this method will scroll down for 500 units
		//@param driver
		
		public void scrollAction(WebDriver driver) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.ScrollBy(0,500);", "");
		}
		// this method will scroll down until a particular web element
		//@param driver
		//@param element
		
		public void scrollAction (WebDriver driver ,WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
		}
		//this method accept the alert popup 
		// @param driver
		
		public void acceptAlert(WebDriver driver) {
			driver.switchTo().alert().accept();
		}
		//this method cancel the alert popup
		//@param driver
		
		public void dissmissAlert(WebDriver driver) {
			driver.switchTo().alert().dismiss();
		}
		//This method will get the alert text and return it to caller
		//@param driver
		
		public String getAlertText(WebDriver driver) {
			return driver.switchTo().alert().getText();
		}
		// this method will handle frame using index
		//@param driver
		//@param index
		
		public void handleFrame(WebDriver driver, int index) {
			driver.switchTo().frame(index);
		}
		// this method will handle frame using name or ID
		//@param driver
		//@param nameOrID
		
		public void handleFrame(WebDriver driver, String nameOrID) {
			driver.switchTo().frame(nameOrID);
		}
		// this method will handle frame using frame as element
		//@param driver
		//@param element
		
		public void handleFrame(WebDriver driver,WebElement element) {
			driver.switchTo().frame(element);
		}
		//
		//@param driver
		public void switchToDefaultContent(WebDriver driver) {
			driver.switchTo().defaultContent();
		}
		public void actionsMoveToElement(WebDriver driver, WebElement ele)
		{
			Actions act = new Actions(driver);
			act.moveToElement(ele);
		}
		
		//This method will help to switch the control from one window to another  
		//@param driver
		//@param partialWindowTitle
		public void switchToWindow(WebDriver driver, String partialWindowTitle) {
			//Step 1 capture all windows IDs
			Set<String> allWinIDs = driver.getWindowHandles();
			
			//Step2 Navigate through each window
			for(String id: allWinIDs) 
			{
				//Step3 Switch to each and compare the title
				String actTitle = driver.switchTo().window(id).getTitle();
				
				//Step4 compare the title with required
				if(actTitle.contains(partialWindowTitle))
				{
					break;
				}
			}
			}
			
			public String captureScreenShot(WebDriver driver , String screenshotName) throws Throwable {
				TakesScreenshot ts = (TakesScreenshot) driver;
				File src = ts.getScreenshotAs(OutputType.FILE);
				File dest = new File("./Screenshots/"+screenshotName+".png");
				Files.copy(src, dest);
				
				return dest.getAbsolutePath();// 
			}
}
