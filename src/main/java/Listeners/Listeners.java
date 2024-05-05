package Listeners;



import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Managers.ExtentManager;
import Runtime.RunTimeEnvironment;
import Utilities.ReusableFunctions;




public class Listeners implements ITestListener{

	WebDriver driver;
	ExtentTest test ;
	//ThreadLocal<ExtentTest> threadsafeTest = new ThreadLocal<ExtentTest>();
	
//	public Listeners(RunTimeEnvironment runtime) {
//	this.driver = runtime.driver;
//	this.test=runtime.test;
//	}
	//public Listeners(WebDriver driver, ExtentTest test) {
	//	super(driver, test);
		// TODO Auto-generated constructor stub
	//}
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestStart(result);
	//	test = extent.createTest(result.getMethod().getMethodName());
		//threadsafeTest.set(test); //unique thread id is set for the 'test' (each java execution will have its own unique thread id)
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestSuccess(result);
		//threadsafeTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
//		ITestListener.super.onTestFailure(result);
		//fail the test with the failure reason	
	//	threadsafeTest.get().log(Status.FAIL, "Test Failed");
		//threadsafeTest.get().fail(result.getThrowable()); //to get the test object of exact Test method
		
		//take screenshot, and attach it to the report
		
//		try {
//			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver")
//					.get(result.getInstance());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		String screenshotPath = null;
//		try {
//			screenshotPath = takeScreenshot(result.getMethod().getMethodName(), driver);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		threadsafeTest.get().addScreenCaptureFromPath(screenshotPath, result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
//		ITestListener.super.onFinish(context);
//		extent.flush();
	}

}
