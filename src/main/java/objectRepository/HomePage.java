package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText = "Organizations")
	private WebElement OrgLink ;
	
	@FindBy(linkText = "Products")
	private WebElement productLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOut;

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getOrgLink() {
		return OrgLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getLogoutImg() {
		return logoutImg;
	}

	public WebElement getSignOut() {
		return signOut;
	}
	
	public  HomePage(WebDriver driver)
	{
		PageFactory.initElements( driver, this);
	}
	
	public void clickOnOrganizationLink()
	{
		OrgLink.click();
	}
	public void clickOnContactLink()
	{
		contactLink.click();
	}
	public void clickOnProductsLink()
	{
		productLink.click();
	}
	
	public void logoutofApp(WebDriver driver) throws Throwable
	{
		mouseHoverActions(driver, logoutImg);
		Thread.sleep(2000);
		signOut.click();
		
	}

}
