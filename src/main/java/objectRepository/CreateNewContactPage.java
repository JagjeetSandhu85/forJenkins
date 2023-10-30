package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {
	@FindBy(name = "lastname")
	private WebElement lastName;
	
	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getOrgLookUpImg() {
		return orgLookUpImg;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getOrgSearch() {
		return orgSearch;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	@FindBy(xpath = "(//img[@alt='Select'])[1]")
	private WebElement orgLookUpImg;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name = "search_text")
	private WebElement orgSearch;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	public CreateNewContactPage(WebDriver driver )
	{
		PageFactory.initElements(driver, this);
		}
	
public void createNewContact(String LASTNAME)
{
	lastName.sendKeys(LASTNAME);
	saveBtn.click();
}

//bussiness lip
//This method will create contact with organization
 public void createNewContact(WebDriver driver,String LASTNAME ,String ORGNAME)
 {
	 lastName.sendKeys(LASTNAME);
	 orgLookUpImg.click();
	 switchToWindow(driver, "Accounts");
	 orgSearch.sendKeys(ORGNAME);
	 searchBtn.click();
	 driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
	 switchToWindow(driver, "Contacts");
	 saveBtn.click();
	 
	 
 }

}
