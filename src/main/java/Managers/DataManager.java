package Managers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.json.JSONObject;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataManager {

	Properties properties;
	JSONObject ownerDetails;
	JSONObject petDetails;
	String configfilepath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
			+ File.separator + "resources" + File.separator + "config.properties";
	public String excelfilepath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
			+ File.separator + "resources" + File.separator + "TestData.xlsx";
	String ownerDetailsPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
			+ File.separator + "resources" + File.separator + "OwnerDetails.json";
	String petDetailsPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
			+ File.separator + "resources" + File.separator + "PetDetails.json";
	String ownerDetailsFileContent;
	String petDetailsFileContent;
	String sheetName = "TestData";
	FileInputStream fs;
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	public DataManager() {

		try {
			properties = new Properties();
			FileReader reader = new FileReader(configfilepath);
			properties.load(reader);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public String readConfigProperty(String Prop) {

		return properties.getProperty(Prop);
	}

	public String retriveExcelCellValue(XSSFSheet sheet, int r, int c) throws IOException {

		String s = sheet.getRow(r).getCell(c).toString();
		return s;

	}
}
