package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInformationPage {
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactHeaderText;
	
	public ContactsInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getContactHeaderText() {
		return contactHeaderText;
	}
	
	public String getHeaderText()
	{
		return contactHeaderText.getText();
	}

}
