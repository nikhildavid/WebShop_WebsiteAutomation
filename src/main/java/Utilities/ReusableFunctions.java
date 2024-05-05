package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class ReusableFunctions {

	WebDriver driver;
	WebDriverWait wait;
	Select drop;
	ExtentTest test;
	FileInputStream fs;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	Row row;
	Cell cell;

	public ReusableFunctions(WebDriver driver, ExtentTest test) {

		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		this.test = test;

	}

	public ReusableFunctions() {

	}
	
	/*****************************************************************************************
	 * Description : To click given web element
	 * Arguments : WebElement, Element Info 
	 * Return Value : NA
	 * Author : Nikhil David
	 *****************************************************************************************/

	public void clickElement(WebElement e, String ElementInfo) {

		waitunitlElementVisible(e, ElementInfo).click();
		test.info("Clicked the element: " + ElementInfo);
	}
	
	
	/*****************************************************************************************
	 * Description : To click on a web element in a list of elements with similar locators.
	 * Arguments : WebElement, Element Info 
	 * Return Value : NA
	 * Author : Nikhil David
	 *****************************************************************************************/

	public void clickElementList(String Xpath, String ElementInfo) {
WebElement e = driver.findElement(By.xpath(String.format(Xpath, ElementInfo)));
		waitunitlElementVisible(e, ElementInfo).click();
		
		String screenshotfolderpath = System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"Screenshot";
		String screenshotfilepath = screenshotfolderpath + "FullScreenshot.png";
	Shutterbug.shootPage(driver,Capture.FULL).withName("FullScreenshot").save(screenshotfolderpath);
		test.info("Clicked the element: " + ElementInfo, MediaEntityBuilder.createScreenCaptureFromPath(screenshotfilepath, ElementInfo).build());

	}

	/*****************************************************************************************
	 * Description : To write text in to a  web element
	 * Arguments : WebElement, Element Info, Input text 
	 * Return Value : NA
	 * Author : Nikhil David
	 *****************************************************************************************/
	
	public void writeText(WebElement e, String ElementInfo, String text) {
		waitunitlElementVisible(e, ElementInfo).sendKeys(text);

		test.info("Entered value in: " + ElementInfo);
	}

	
	/*****************************************************************************************
	 * Description : To get text from a web element
	 * Arguments : WebElement, Element Info 
	 * Return Value : String
	 * Author : Nikhil David
	 *****************************************************************************************/
	
	public String readText(WebElement e, String ElementInfo) {
		waitunitlElementVisible(e, ElementInfo);
		test.info("Retrieved text from: " + ElementInfo);
		return e.getText();

	}
	
	
	/*****************************************************************************************
	 * Description : To get text from a web element in a list of elements with similar locators.
	 * Arguments : WebElement, Element Info 
	 * Return Value : String
	 * Author : Nikhil David
	 *****************************************************************************************/
	
	public String readTextElementList(String Xpath, String ElementInfo) {
		WebElement e = driver.findElement(By.xpath(String.format(Xpath, ElementInfo)));
		waitunitlElementVisible(e, ElementInfo);
		test.info("Retrieved text from: " + ElementInfo);
		return e.getText();

	}
	
	
	


	/*****************************************************************************************
	 * Description : To wait until given web element is visible
	 * Arguments : WebElement, Element Info 
	 * Return Value : WebElement
	 * Author : Nikhil David
	 *****************************************************************************************/
	
	public WebElement waitunitlElementVisible(WebElement e, String ElementInfo) {
		test.info("Waiting for element: " + ElementInfo);
		wait.until(ExpectedConditions.visibilityOf(e));
		test.info(ElementInfo, MediaEntityBuilder
				.createScreenCaptureFromBase64String(takeScreenShot(driver), "Screenshot").build());
		return e;

	}

	
	/*****************************************************************************************
	 * Description : To generate timestamp in 'MM-dd-yyyy' format
	 * Arguments : WebElement, Element Info 
	 * Return Value : NA
	 * Author : Nikhil David
	 *****************************************************************************************/
	
	public String generateTimestamp() {

		return (new SimpleDateFormat("MM-dd-yyyy-hhmmss").format(new java.util.Date()));
	}

	
	/*****************************************************************************************
	 * Description : To take a screenshot
	 * Arguments : WebDriver instance 
	 * Return Value : String
	 * Author : Nikhil David
	 *****************************************************************************************/
	
	public String takeScreenShot(WebDriver driver) {

		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}

	/*****************************************************************************************
	 * Description : To validate given two strings are same
	 * Arguments : String1, String2 
	 * Return Value : NA
	 * Author : Nikhil David
	 *****************************************************************************************/
	
	public void AssertStringsEqual_True(String s1, String s2) {
		Assert.assertTrue(s1.equals(s2));
		test.info("Verification is successfull");
	}

	/*****************************************************************************************
	 * Description : To verify given web element is displayed
	 * Arguments : WebElement, Element Info 
	 * Return Value : NA
	 * Author : Nikhil David
	 *****************************************************************************************/
	
	public void verifyElement_isDisplayed(WebElement e, String ElementInfo) {
		waitunitlElementVisible(e, ElementInfo);
		Assert.assertTrue(e.isDisplayed());
	}

	/*****************************************************************************************
	 * Description : To convert given date in format 'yyyy-MM-dd' to 'dd-MM-yyyy'
	 * Arguments : String 
	 * Return Value : String
	 * Author : Nikhil David
	 *****************************************************************************************/
	
	public String foramtDate_yyyyMMdd_to_ddMMyyyy(String dateAsString) {
		DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat targetFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try {
			date = originalFormat.parse(dateAsString);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return targetFormat.format(date);
	}

	/*****************************************************************************************
	 * Description : To select option from a dropdown element using value
	 * Arguments : WebElement, Value to be selected
	 * Return Value : NA
	 * Author : Nikhil David
	 *****************************************************************************************/
	
	
	
	public void selectDropDownByValue(WebElement e, String value) {
		waitunitlElementVisible(e, "");
		Select typeDropMenu = new Select(e);
		typeDropMenu.selectByValue(value);
	}
	
	/*****************************************************************************************
	 * Description : To convert excel data in to Object[][]
	 * Arguments : XSSFSheet
	 * Return Value : Object[][]
	 * Author : Nikhil David
	 *****************************************************************************************/
	
	public Object[][] getTestData(XSSFSheet sheet) {
		List<HashMap<String, String>> DetailsAll;
		HashMap<String, String> Details;

		DetailsAll = new ArrayList<HashMap<String, String>>();
		int col = sheet.getRow(1).getLastCellNum();
		for (int i = 1; i < sheet.getLastRowNum(); i++) {
			Details = new HashMap<String, String>();
			for (int c = 0; c < col; c++) {
				try {
					String DetailsHeader = retriveExcelCellValue(sheet, 0, c);
					
					String Detail = retriveExcelCellValue(sheet, i, c);
					
					Details.put(DetailsHeader, Detail);

				} catch (IOException e) {

					e.printStackTrace();
				}
			}
			DetailsAll.add(Details);
		}
		Object[][] results = new Object[DetailsAll.size()][1];
		int index = 0;
		for (HashMap<String, String> temp : DetailsAll) {
			results[index++] = new Object[] { temp };
		}
		return results;
	}

	/*****************************************************************************************
	 * Description : To fetch cell value from Excel sheet
	 * Arguments : WebElement, Value to be selected
	 * Return Value : NA
	 * Author : Nikhil David
	 *****************************************************************************************/
	
	

	
	public String retriveExcelCellValue(XSSFSheet sheet, int r,int c) throws IOException {

		String s = sheet.getRow(r).getCell(c).toString();
		return s;

	}
}
