package Tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseSteps;
import Managers.DataManager;
import Utilities.ReusableFunctions;

public class DemoWebShopUserLogin extends BaseSteps {

	DataManager dataManager;
	FileInputStream fs;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	ReusableFunctions library = new ReusableFunctions();

	public DemoWebShopUserLogin() throws IOException {
		dataManager = new DataManager();
		try {
			fs = new FileInputStream(dataManager.excelfilepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		workbook = new XSSFWorkbook(fs);
		sheet = workbook.getSheet("Login");

	}

	@Test(dataProvider = "getLoginTestData")
	public void verify_UserRegistration(HashMap<String, String> input) {
		basesteps.runtime.driver.get(basesteps.runtime.readData.readConfigProperty("webUrl"));
		basesteps.pages.getWShomepage().clickWSHomePage_LoginButton();
		basesteps.pages.getWSLoginPage().verifyLoginPage_WelcomeMessage();
		basesteps.pages.getWSLoginPage().enterEmail(input.get("Email"));
		basesteps.pages.getWSLoginPage().enterPassword(input.get("Password"));
		basesteps.pages.getWSLoginPage().submitLogin();
		basesteps.pages.getWSLoginPage().verifyLoggedInUserInformation(input.get("Email"));
		basesteps.pages.getWShomepage().clickWSHomePage_LogoutButton();
		basesteps.pages.getWShomepage().verifyLogoutIsSuccess();

	}

	@DataProvider
	public Object[][] getLoginTestData() {
		return library.getTestData(sheet);
	}

}
