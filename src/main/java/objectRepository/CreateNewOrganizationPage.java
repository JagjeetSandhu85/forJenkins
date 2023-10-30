package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {

	@FindBy(name = "accountname")
	private WebElement orgName;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropdown;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	
	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropdown() {
		return typeDropdown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createNewOrganization(String ORGNAME)
	{
		orgName.sendKeys(ORGNAME);
		saveBtn.click();
	}
	
	public void createNewOrganization(String ORGNAME,String INDUSTRY )
	{
		orgName.sendKeys(ORGNAME);
		handleDropDown(industryDropDown, INDUSTRY);
		saveBtn.click();
	}
	public void createNewOrganization(String ORGNAME,String INDUSTRY ,String INDUSTRYTYPE)
	{
		orgName.sendKeys(ORGNAME);
		handleDropDown(industryDropDown,INDUSTRY);
		handleDropDown(industryDropDown, INDUSTRYTYPE);
		saveBtn.click();
	}
}
