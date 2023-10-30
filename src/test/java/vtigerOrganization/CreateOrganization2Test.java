package vtigerOrganization;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInformationPage;
import objectRepository.OrganizationsPage;

public class CreateOrganization2Test extends BaseClass{
	@Test(groups = "SmokeSuite")
	public void createOrganizationTest() throws Throwable
	{

		String ORGNAME = eUtil.readDataFromExcelFile("Organization", 1, 2) + jUtil.getRandomNumber();

		// Step 4: navigate to organization link

		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();

		// Step 5: Click on create Organization look up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnOrgLookUpImg();
		Thread.sleep(3000);

		// Step 6; Click on create organiztion
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		Thread.sleep(2000);

		// Step 7: Validate
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String orgHeader = oip.getHeaderText();

		Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println(orgHeader);
	}


}
