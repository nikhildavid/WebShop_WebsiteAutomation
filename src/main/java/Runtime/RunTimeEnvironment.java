package Runtime;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Managers.BrowserManager;
import Managers.DataManager;
import Managers.ExtentTestManager;
import Utilities.ReusableFunctions;

public class RunTimeEnvironment {

	BrowserManager B = new BrowserManager();
	public WebDriver driver;
	String TestCaseName;
	public ExtentTest test;
	public ExtentReports extent;
	public DataManager readData;
	public ReusableFunctions library;

	public RunTimeEnvironment(String Browser, String TestCaseName) {

		this.driver = B.getDriver(Browser);
		this.TestCaseName = TestCaseName;
		ExtentTestManager.startTest(TestCaseName, "TestDesc");
		test = ExtentTestManager.getTest();
		readData = new DataManager();
		library = new ReusableFunctions(driver, test);

	}

}
