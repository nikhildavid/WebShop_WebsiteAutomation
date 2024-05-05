package Tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseSteps;
import Managers.DataManager;

public class DemoWebShopRegistration extends BaseSteps {

	DataManager dataManager;
	FileInputStream fs;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	List<HashMap<String, String>> registrationDetailsAll;
	HashMap<String, String> registrationDetails;


	public DemoWebShopRegistration() throws IOException {
		dataManager = new DataManager();
		try {
			fs = new FileInputStream(dataManager.excelfilepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		workbook = new XSSFWorkbook(fs);
		sheet = workbook.getSheet("Registration");

	}

	@Test(testName = "User Registration", dataProvider = "getRegistrationTestData")
	public void verify_UserRegistration(HashMap<String, String> input) {
		basesteps.runtime.driver.get(basesteps.runtime.readData.readConfigProperty("webUrl"));
		basesteps.pages.getWShomepage().clickWSHomePage_RegisterButton();
		basesteps.pages.getWSRegistrationPage().verifyRegistrationPage_Title("Register");
		basesteps.pages.getWSRegistrationPage().selectGender(input.get("Gender"));
		basesteps.pages.getWSRegistrationPage().enterFirstName(input.get("First Name"));
		basesteps.pages.getWSRegistrationPage().enterLastName(input.get("Last Name"));
		basesteps.pages.getWSRegistrationPage().enterEmail(input.get("Email"));
		basesteps.pages.getWSRegistrationPage().enterPassword(input.get("Password"));
		basesteps.pages.getWSRegistrationPage().confirmPassword(input.get("Password"));
		basesteps.pages.getWSRegistrationPage().clickRegisterButton();
		basesteps.pages.getWSRegistrationPage().verifyRegistrationSuccessMessage("Your registration completed");
		basesteps.pages.getWSRegistrationPage().clickContinueButton();
		basesteps.pages.getWShomepage().verifyHomePageContent();
		basesteps.pages.getWShomepage().clickWSHomePage_LogoutButton();
		basesteps.pages.getWShomepage().verifyLogoutIsSuccess();

	}

	@DataProvider
	public Object[][] getRegistrationTestData() {

		registrationDetailsAll = new ArrayList<HashMap<String, String>>();
		int col = sheet.getRow(1).getLastCellNum();
		for (int i = 1; i < sheet.getLastRowNum(); i++) {
			registrationDetails = new HashMap<String, String>();
			for (int c = 0; c < col; c++) {
				try {
					String registrationDetailHeader = dataManager.retriveExcelCellValue(sheet, 0, c);
					String registrationDetail = dataManager.retriveExcelCellValue(sheet, i, c);
					registrationDetails.put(registrationDetailHeader, registrationDetail);

				} catch (IOException e) {

					e.printStackTrace();
				}
			}
			registrationDetailsAll.add(registrationDetails);
		}
		Object[][] results = new Object[registrationDetailsAll.size()][1];
		int index = 0;
		for (HashMap<String, String> temp : registrationDetailsAll) {
			results[index++] = new Object[] { temp };
		}
		return results;
	}

}
