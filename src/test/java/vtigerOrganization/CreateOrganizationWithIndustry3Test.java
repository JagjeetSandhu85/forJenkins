package vtigerOrganization;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInformationPage;
import objectRepository.OrganizationsPage;

public class CreateOrganizationWithIndustry3Test extends BaseClass{
	@Test
	public void createOrgWithIndustry() throws Throwable {
		
		String ORGNAME = eUtil.readDataFromExcelFile("Organization", 4, 2) + jUtil.getRandomNumber();
		String INDUSTRYNAME = eUtil.readDataFromExcelFile("Organization", 4, 3);

		
		// Step 4: navigate to organization link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();

		// Step 5: Click on create Organization look up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnOrgLookUpImg();

		// Step 6; Click on create organiztion and with indusrty
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME, INDUSTRYNAME);

		// Step 7: Validate
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String orgHeader = oip.getHeaderText();

		Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println(orgHeader);

	}

}
