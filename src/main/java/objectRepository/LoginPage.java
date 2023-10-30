package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//Rule1 Make seprate Class
	
		//Rule 2 Declaration
		
		@FindBy(name = "user_name")
		private WebElement userNameEdt;
		
		@FindBy(name = "user_password")
		private WebElement passwordEdt;
		
		@FindBy(id = "submitButton")
		private WebElement loginBtn;
		
		// Rule 3 initalization
		
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements( driver, this);
		}

		public WebElement getUserNameEdt() {
			return userNameEdt;
		}

		public WebElement getPasswordEdt() {
			return passwordEdt;
		}

		public WebElement getLoginBtn() {
			return loginBtn;
		}
		//Rule 4 Bussiness Library
		public void loginPage(String USERNAME, String PASSWORD )
		{
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
		
		}
		
}
