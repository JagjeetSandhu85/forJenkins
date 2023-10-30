package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReTryAnalyserPractice {
	@Test(retryAnalyzer = genericUtilities.RetryImplementation.class)
	public void retryAnalyzerPractice()
	{	
		Assert.fail();
		System.out.println("Hi");
	}

}
