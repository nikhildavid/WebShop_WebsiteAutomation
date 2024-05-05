package Managers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	public static final ExtentReports extentReports = new ExtentReports();

	public synchronized static ExtentReports createExtentReports() {
		String path = System.getProperty("user.dir") + "\\reports\\WebShop_Test Execution Report.html";
		System.out.println(path);
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Daily Test Execution Report");
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Application", "Web Shop");
		extentReports.setSystemInfo("Environment", "QA2");
		extentReports.setSystemInfo("Build Version", "2.0");
		extentReports.setSystemInfo("Tester", "Nikhil David");
		return extentReports;
	}
}