package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementation implements IRetryAnalyzer{
	int count = 0;
	int retryCount =3;
	public boolean retry(ITestResult result) {
		//0<1 1<2 2<3 3<3no 
		while(count<retryCount)
			{
			count++;// 1  2  3
			return true;// retry retry retry
		}
		return false; // stop retrying
	}

}
