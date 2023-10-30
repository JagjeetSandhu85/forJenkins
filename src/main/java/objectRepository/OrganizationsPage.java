package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	@FindBy(xpath ="//img[@alt='Create Organization...']")
	private WebElement orgLookUpImg;
	
	
	public WebElement getOrgLookUpImg() {
		return orgLookUpImg;
	}

	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickOnOrgLookUpImg()
	{
		orgLookUpImg.click();
	}

}
