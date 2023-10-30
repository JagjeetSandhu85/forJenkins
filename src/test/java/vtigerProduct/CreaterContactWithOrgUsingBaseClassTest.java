package vtigerProduct;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.ContactsInformationPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInformationPage;
import objectRepository.OrganizationsPage;

public class CreaterContactWithOrgUsingBaseClassTest extends BaseClass {
	@Test(groups = "ReggressionSuite")
	public void createContactWithOrgTest() throws Throwable {

		String ORGNAME = eUtil.readDataFromExcelFile("Products", 7, 3) + jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcelFile("Products", 7, 2);

		// Step 4: click to organization link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();

		// Step 5: Click on create Organization look up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnOrgLookUpImg();
		Thread.sleep(3000);

		// Step 6; Click on create organiztion
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);

		// Step 7: Validate FOR ORGANIZATION
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String orgHeader = oip.getHeaderText();
		Assert.assertTrue(orgHeader.contains(ORGNAME));

		System.out.println(orgHeader);

		// step 8 NAvigate to contact
		hp.clickOnContactLink();

		// Step 9 Click on createLookUp img
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();

		// Step 10 create contact with mandatory field
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(driver, LASTNAME, ORGNAME);

		// Step 11: Validate for Organization
		ContactsInformationPage cip = new ContactsInformationPage(driver);
		String ContactHeader = cip.getHeaderText();
		Assert.assertTrue(ContactHeader.contains(LASTNAME));

		System.out.println(ContactHeader);
		System.out.println("Organization created Successfully");

	}

}
