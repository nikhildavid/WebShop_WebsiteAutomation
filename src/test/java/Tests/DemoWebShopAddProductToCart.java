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

public class DemoWebShopAddProductToCart extends BaseSteps {

	DataManager dataManager;
	FileInputStream fs;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	ReusableFunctions library = new ReusableFunctions();

	public DemoWebShopAddProductToCart() throws IOException {
		dataManager = new DataManager();
		try {
			fs = new FileInputStream(dataManager.excelfilepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		workbook = new XSSFWorkbook(fs);
		sheet = workbook.getSheet("AddToCart");

	}

	@Test(testName = "Add to Cart", dataProvider = "getProductTestData")
	public void verify_AddToCart(HashMap<String, String> input) {
		String email = basesteps.runtime.readData.readConfigProperty("loginUserName");
		String password = basesteps.runtime.readData.readConfigProperty("loginPassword");
		basesteps.runtime.driver.get(basesteps.runtime.readData.readConfigProperty("webUrl"));
		basesteps.pages.getWShomepage().clickWSHomePage_LoginButton();
		basesteps.pages.getWSLoginPage().verifyLoginPage_WelcomeMessage();
		basesteps.pages.getWSLoginPage().enterEmail(email);
		basesteps.pages.getWSLoginPage().enterPassword(password);
		basesteps.pages.getWSLoginPage().submitLogin();
		basesteps.pages.getWSLoginPage().verifyLoggedInUserInformation(email);
		basesteps.pages.getWShomepage().clickwSHomePage_CategoryLink(input.get("Category"));
		basesteps.pages.getWSAddToCart().addToCart(input.get("Item Description"));
		basesteps.pages.getWSAddToCart().verifyProductAddedToCartMessage();
		basesteps.pages.getWShomepage().clickWSHomePage_ShoppingCartButton();
		basesteps.pages.getWShomepage().clickWSHomePage_LogoutButton();
		basesteps.pages.getWShomepage().verifyLogoutIsSuccess();

	}

	@DataProvider
	public Object[][] getProductTestData() {
		return library.getTestData(sheet);

	}
}
