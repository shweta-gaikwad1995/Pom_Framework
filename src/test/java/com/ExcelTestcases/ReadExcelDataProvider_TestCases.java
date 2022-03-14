package com.ExcelTestcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.crm.qa.base.TestBase;
import com.excelSheet.pages.ReadExcelDataProvider;
@Listeners(Listener_Demo.ListenerTest.class)	
public class ReadExcelDataProvider_TestCases extends TestBase{
	
		
	ReadExcelDataProvider readExcel;
	
	 private String filePath = "C:\\Users\\admin\\eclipse-workspace\\HybridFramework\\src\\main\\java\\com\\exceldata\\exceldata.xlsx";
	    private String sheetName = "InvalidLogin";


	public ReadExcelDataProvider_TestCases() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setUp() throws Exception{
		initialization();	
		readExcel=new ReadExcelDataProvider();
		
		  
	}
	
	 @DataProvider(name="readExcel")
	    public Object[][] readExcel() throws InvalidFormatException, IOException {
	        return readExcel.readExceldata(filePath, sheetName);
	    }
	
	// , dataProviderClass = ReadExcelDataProvider.class
	
	
	 @Test(dataProvider = "readExcel")
	public void ReadExcel(String userName	, String password) throws IOException
	{
		 extentTest = extent.startTest("ReadExcel_LoginData");
		 readExcel.enterLoginData(userName, password);
	}
	 
	 
	 
	 @Test(enabled=false)
	 public void BhimanTitleTest()
	 {
		String title= driver.getTitle();
	 }
	 
	 
}
