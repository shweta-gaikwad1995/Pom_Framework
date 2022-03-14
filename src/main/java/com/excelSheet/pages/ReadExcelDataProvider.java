package com.excelSheet.pages;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import com.crm.qa.base.TestBase;

public class ReadExcelDataProvider extends TestBase{
	

	public WebDriverWait wait;
	
	public ReadExcelDataProvider() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		this.driver = TestBase.driver;
	}

	//Locators
		private By byEmail = By.xpath("//input[@id='username']");
		private By byPassword = By.xpath("//input[@id='password']");
	private By byClick=By.xpath("//button[@type='submit']");
		
	
	 
		
		
		public BhimanHomePage enterLoginData (String uname,String pswd) throws IOException
		{
			driver.findElement(byEmail).sendKeys(uname);
			driver.findElement(byPassword).sendKeys(pswd);
			driver.findElement(byClick).click();
			return new BhimanHomePage();
		}
		
		
	
		  public static Object[][] readExceldata(String filePath, String sheetName) throws InvalidFormatException, IOException {
	            FileInputStream file= new FileInputStream(filePath);
	            XSSFWorkbook wb = new XSSFWorkbook(file);
	            XSSFSheet sheet = wb.getSheet(sheetName);
	            int rowCount = sheet.getLastRowNum();
	            int column = sheet.getRow(0).getLastCellNum();
	            Object[][] data = new Object[rowCount][column];
	            for (int i = 1; i <= rowCount; i++) {
	                XSSFRow row = sheet.getRow(i);
	                for (int j = 0; j < column; j++) {
	                    XSSFCell cell = row.getCell(j);
	                    DataFormatter formatter = new DataFormatter();
	                    String val = formatter.formatCellValue(cell);
	                    data[i - 1][j] = val;
	                }
	            }

	            return data;
	        }
		
		
		
		
}
