package practice;

import org.testng.annotations.Test;

public class TestNgPracticeTest {

	@Test
	public void createCustomer() //failed
	{
		//Assert.fail();
		System.out.println("create");
	}
	@Test(dependsOnMethods = "createCustomer")
	public void modifyCustomer() 
	{
		System.out.println("modify");
	}
	@Test
	public void deleteCustomer()
	{
		System.out.println("delete");
	}


}
