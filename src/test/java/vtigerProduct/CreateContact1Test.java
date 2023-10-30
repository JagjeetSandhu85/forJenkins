package vtigerProduct;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.ContactsInformationPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;

public class CreateContact1Test extends BaseClass {

	@Test(groups = "smokeSuite")
	public void createContact() throws Throwable
	{
		String LASTNAME = eUtil.readDataFromExcelFile("Products", 1, 2) + jUtil.getRandomNumber();
		
		// Step 5: Navigate to Contacts LInk
		HomePage hp = new HomePage(driver);
		hp.clickOnContactLink();
		Reporter.log("Clicked on contacts link");
		
		// Step 6: Click on create conatct look up Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();
		Reporter.log("clicked on create contact lookup img");

		// Step 7: create conatct with mandatory fields
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME);
		Reporter.log("contact created successfully");
		
	//	Assert.fail();
		
		// Step 8: Validate
		ContactsInformationPage cip = new ContactsInformationPage(driver);
		String contactHeader = cip.getHeaderText();
		Reporter.log("header captured");

		
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		System.out.println(contactHeader);
		Reporter.log("header validated");

		}
	@Test
	public void demo()
	{
		System.out.println("demo");
	}


}
