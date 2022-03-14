package com.ExcelTestcases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.excelSheet.pages.ReadGuru99ExcelFile;

public class ReadGuru99ExcelFile_TestCaseas {
	ReadGuru99ExcelFile objExcelFile;

	public ReadGuru99ExcelFile_TestCaseas() throws IOException {
		super();
		
	}

	

	
	@Test(priority=1)
	public void ReadExcelFile() throws IOException
	{
		 //Create an object of ReadGuru99ExcelFile class

	    ReadGuru99ExcelFile objExcelFile = new ReadGuru99ExcelFile();

	    //Prepare the path of excel file

	    String filePath = System.getProperty("user.dir")+"\\src\\main\\java\\com\\exceldata";

	    //Call read file method of the class to read data

	    objExcelFile.readExcel(filePath,"exceldata.xlsx","BankData");
	}
}
