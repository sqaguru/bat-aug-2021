package orangehrm.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class Base {
	protected WebDriver driver = null;

	@BeforeGroups("SANITY_TEST")
	public void beforeGroups() {
		System.out.println("$$$$$ Running test group $$$$$");
	}

	@AfterGroups("SANITY_TEST")
	public void afterGroups() {
		System.out.println("$$$$$ Completed test group $$$$$");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("$$$$$ Running test suite $$$$$");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("$$$$$ Completed test suite $$$$$");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("===== Running test tag from xml =====");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("===== Completed test tag from xml =====");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("#### Running test class ####");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("#### Test class completed ####");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("**** Running test method ****");

		System.setProperty("webdriver.chrome.driver",
				"D:\\sqa-guru\\demo-workspace-feb21_mvn\\orangehrm-automation\\src\\test\\resources\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://www.orangehrm.com/");

	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
		System.out.println("**** test method completed ****");
	}

	@DataProvider(name = "googleSearchUsingExcel")
	public Object[] getExcelData() throws FileNotFoundException, IOException {

		HSSFWorkbook workbook = new HSSFWorkbook(
				new FileInputStream("D:\\sqa-guru\\sel-bat-feb21\\sel-bat-feb21\\resources\\testdata\\testdata.xls"));

		HSSFSheet sheet = workbook.getSheet("testdata");

		int totalRows = sheet.getPhysicalNumberOfRows();

		System.out.println("totalRows: " + totalRows);

		Object[] object = new Object[totalRows - 1];

		int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();

		System.out.println("totalColumns: " + totalColumns);

		for (int rowCounter = 1; rowCounter < totalRows; rowCounter++) {
			HSSFRow rowHeader = sheet.getRow(0);
			HSSFRow row = sheet.getRow(rowCounter);
			Map<String, String> map = new HashMap<String, String>();
			for (int colCounter = 0; colCounter < totalColumns; colCounter++) {
				HSSFCell cellHeader = rowHeader.getCell(colCounter);
				HSSFCell cell = row.getCell(colCounter);

				String dataHeader = cellHeader.getStringCellValue();
				String data = cell.getStringCellValue();

				System.out.println(dataHeader);
				System.out.println(data);

				map.put(dataHeader, data);

				System.out.println("data: " + data);
			}
			object[rowCounter - 1] = map;
		}
		return object;

	}
}
