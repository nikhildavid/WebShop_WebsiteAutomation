package Tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestContext;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseSteps;
import Managers.DataManager;
import Managers.ExtentTestManager;

public class DemoWebShopCategories extends BaseSteps {


	DataManager dataManager;
	FileInputStream fs;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	ArrayList<String> categoryList;


	public DemoWebShopCategories() throws IOException {
		dataManager = new DataManager();
		try {
			fs = new FileInputStream(dataManager.excelfilepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		workbook = new XSSFWorkbook(fs);
	}

	@Test
	public void verify_CatagoryPages() {

		getTestDataFromExcel();
		basesteps.runtime.driver.get(basesteps.runtime.readData.readConfigProperty("webUrl"));

		for (String category : categoryList) {
			basesteps.pages.getWShomepage().clickwSHomePage_CategoryLink(category);
			basesteps.pages.getWShomepage().verifywSHomePage_CategoryTitle(category);
		}

	}

	public void getTestDataFromExcel() {
		categoryList = new ArrayList<String>();
		sheet = workbook.getSheet("Category");
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {

			try {
				String cat = dataManager.retriveExcelCellValue(sheet, i, 0);
				categoryList.add(cat);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

}
