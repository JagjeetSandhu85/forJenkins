package genericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementationClass implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"---test script execution started-----");
		
		//create a test script recognise each @test 
		 test = report.createTest(testScriptName);
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"---Passed-----");
		
		//log on success
		test.log(Status.PASS, testScriptName+"---pass-----");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"---failed-----");
		
		//execution failed reason
		System.out.println(result.getThrowable());
		
		//log for failure
		test.log(Status.FAIL, testScriptName+"---fail----");
		test.log(Status.INFO, result.getThrowable());
		
		//ScreenShot
		String screenShotName = testScriptName + new JavaUtility().getSystemDate(); 
		
		WebDriverUtility w = new WebDriverUtility();
		try {
			String path = w.captureScreenShot(BaseClass.sdriver, screenShotName);
			test.addScreenCaptureFromPath(path);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"---skipped-----");
		
		//exception failure
		System.out.println(result.getThrowable());
		
		//log for skip
		test.log(Status.SKIP, testScriptName+"---skiped---");
		test.log(Status.INFO, result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("---Execution start-----");
		//basic report configuration//Report 18-10-2023-16-17-30.html
		ExtentSparkReporter html = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDate()+".html");
		html.config().setTheme(Theme.DARK);
		html.config().setDocumentTitle("Execution Report");
		html.config().setReportName("Vtiger execution Report");
		
		
		ExtentReports report = new ExtentReports();
		report.attachReporter(html);
		report.setSystemInfo("Base Browser", "FireFox");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Reporter Name", "Sandhu");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("---Execution fineshed-----");
		//report generation
		report.flush();
		
	}
	

}
