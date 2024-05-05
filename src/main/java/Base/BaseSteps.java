package Base;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import Listeners.Listeners;
import Managers.ExtentTestManager;
import Runtime.RunTimeEnvironment;
import pages.PageObjectManager;

public class BaseSteps {
	
	public RunTimeEnvironment runtime;
	public PageObjectManager pages;
	public String TestCaseName;
	public BaseSteps basesteps;
	public Listeners L;
	
	Properties prop = new Properties();
	String browserName;
	


	public void initialiseRunTime(String TestName){
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
			prop.load(fis);
			browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		runtime= new RunTimeEnvironment(browserName, TestName);
		
		pages=new PageObjectManager(runtime);
//		L = new Listeners(runtime);
		
			
	}
	
	@BeforeMethod
	public void startTest(final ITestContext testContext) {
		basesteps = new BaseSteps();
		TestCaseName = testContext.getName();
		basesteps.initialiseRunTime(TestCaseName);

	}
	
	@AfterMethod
	public void teardown(ITestResult result) {
	ExtentTestManager.iffailed(result);
		basesteps.runtime.driver.close();

	}

	@AfterSuite
	public void r() {
		basesteps.runtime.driver.quit();
		
		ExtentTestManager.endTest();
	}

}
