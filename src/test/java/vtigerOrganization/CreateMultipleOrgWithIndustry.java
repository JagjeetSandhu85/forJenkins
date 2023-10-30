package vtigerOrganization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInformationPage;
import objectRepository.OrganizationsPage;

public class CreateMultipleOrgWithIndustry {
	JavaUtility jUtil = new JavaUtility();
	ExcelFileUtility eUtil = new ExcelFileUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	PropertyFileUtility pUtil = new PropertyFileUtility();
	
	@Test(dataProvider = "getData")
	public void createMultipleOrg(String ORG , String INDUSTRYNAME) throws Throwable
	{
	WebDriver driver = null;
	String BROWSER = pUtil.readDataFromPropertyFile("browser");
	String URL = pUtil.readDataFromPropertyFile("url");
	String USERNAME = pUtil.readDataFromPropertyFile("username");
	String PASSWORD = pUtil.readDataFromPropertyFile("password");
	
	String ORGNAME = ORG+jUtil.getRandomNumber();
	// Step 2: Launch the Browser // Run Time Polymorphism - driver
			if (BROWSER.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				System.out.println(BROWSER + " launched");
			} else if (BROWSER.equalsIgnoreCase("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				System.out.println(BROWSER + " launched");
			} else if (BROWSER.equalsIgnoreCase("Edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				System.out.println(BROWSER + " launched");
			} else {
				System.out.println("Invalid Browser Name");
			}

			wUtil.maximizeWindow(driver);
			wUtil.waitForPageLoad(driver);

			// Step 2: Load the Application
			driver.get(URL);

			// Step 3: Login to Application
			LoginPage lp = new LoginPage(driver);
			lp.loginPage(USERNAME, PASSWORD);

			// Step 4: navigate to organization link
			HomePage hp = new HomePage(driver);
			hp.clickOnOrganizationLink();

			// Step 5: Click on create Organization look up Image
			OrganizationsPage op = new OrganizationsPage(driver);
			op.clickOnOrgLookUpImg();

			// Step 6; Click on create organiztion and with indusrty
			CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
			cnop.createNewOrganization(ORGNAME, INDUSTRYNAME);
			wUtil.captureScreenShot(driver, INDUSTRYNAME);

			// Step 7: Validate
			OrganizationInformationPage oip = new OrganizationInformationPage(driver);
			String orgHeader = oip.getHeaderText();

			if (orgHeader.contains(ORGNAME)) {
				System.out.println(orgHeader);
				System.out.println("PASS");
			} else {
				System.out.println("FAIL");
			}

			// Step 8: Logout
			hp.logoutofApp(driver);

	
	}
	@DataProvider
	public Object[][] getData() throws Throwable
	{
	return	eUtil.readMultipleData("MultipleOrganizations");
	}
	

}
