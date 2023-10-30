package vtigerOrganization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.HomePage;
import objectRepository.OrganizationsPage;

public class CreateOrganizationWithIndustryAndType4Test extends BaseClass {
	@Test
	public void createOrgWithIndustryAndType() throws Throwable {
		

		String ORGNAME = eUtil.readDataFromExcelFile("Organization", 4, 2) + jUtil.getRandomNumber();
		String INDUSTRYNAME = eUtil.readDataFromExcelFile("Organization", 4, 3);
		String INDUSTRYTYPE = eUtil.readDataFromExcelFile("Organization", 7, 4);

		// Step 4: navigate to organization link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();

		// Step 5: Click on create Organization look up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnOrgLookUpImg();

		// Step 6; Click on create organiztion and with indusrty with type
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME);
		WebElement INDUSTRY = driver.findElement(By.xpath("//select[@name='industry']"));
		Select sel = new Select(INDUSTRY);
		sel.selectByVisibleText(INDUSTRYNAME);
		WebElement TYPE = driver.findElement(By.xpath("//select[@name='accounttype']"));
		Select type = new Select(TYPE);
		type.selectByVisibleText(INDUSTRYTYPE);
		// Step 7: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		// Step 8: Validate
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		
			System.out.println(orgHeader);
		}

}
