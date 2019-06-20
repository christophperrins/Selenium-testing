package com.qa.parameterisation;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.pages.AddAUserPage;
import com.qa.pages.LoginPage;

@RunWith(Parameterized.class)
public class ExcelTest {

	@Parameters
	public static Collection<Object[]> data() throws IOException {
		FileInputStream file = new FileInputStream("src/test/resources/DemoSiteDDT.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		Object[][] ob = new Object[sheet.getPhysicalNumberOfRows() - 1][4];

//		Reading
		for (int rowNum = 1; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {
			ob[rowNum - 1][0] = sheet.getRow(rowNum).getCell(0).getStringCellValue();
			ob[rowNum - 1][1] = sheet.getRow(rowNum).getCell(1).getStringCellValue();
			ob[rowNum - 1][2] = sheet.getRow(rowNum).getCell(2).getStringCellValue();
			ob[rowNum - 1][3] = rowNum;
		}
		workbook.close();
		return Arrays.asList(ob);

	}

	private String username;
	private String password;
	private String expected;
	private int rowNum;
	
	private WebDriver driver;

	public ExcelTest(String username, String password, String expected, int rowNum) {
		this.username = username;
		this.password = password;
		this.expected = expected;
		this.rowNum = rowNum;
	}

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "../chromedriver");
		driver = new ChromeDriver();
	}

	@After
	public void teardown() {
		driver.quit();
	}

	@Test
	public void login() throws IOException {
		// Selenium
		driver.get(AddAUserPage.URL);

		AddAUserPage addAUserPage = PageFactory.initElements(driver, AddAUserPage.class);
		addAUserPage.addUser(username, password);

		driver.get(LoginPage.URL);
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.loginUser(username, password);
		loginPage.loginAttemptText(); // return to me **Successful** or **Fai l**

		// Writing
		FileInputStream file = new FileInputStream("src/test/resources/DemoSiteDDT.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		XSSFRow row = sheet.getRow(rowNum);
		XSSFCell cell;
		cell = row.getCell(3);
		if (cell == null) {
			cell = row.createCell(3);
		}
		cell.setCellValue(loginPage.loginAttemptText()); 
		
		// Testing
		cell = row.getCell(4);
		if (cell == null) {
			cell = row.createCell(4);
		}
		
		try {
			assertEquals("Login not successful", expected, loginPage.loginAttemptText());
			cell.setCellValue("PASS");
		} catch (AssertionError e) {
			cell.setCellValue("FAIL");
			Assert.fail();
		} finally {
			FileOutputStream fileOut = new FileOutputStream("src/test/resources/DemoSiteDDT.xlsx");
			
			workbook.write(fileOut);
			fileOut.flush();
			fileOut.close();

			workbook.close();
			file.close();
		}

	}
}
