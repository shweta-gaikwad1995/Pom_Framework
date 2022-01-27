package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AddBank;
import com.crm.qa.pages.BanksPage;
import com.crm.qa.pages.HomePage1;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class AddBankTest extends TestBase{

	
	LoginPage loginPage;
	HomePage1 homePage;
	BanksPage bankspage;
	AddBank addbank;
	String sheetName = "addbank";
	Logger LOG = Logger.getLogger(AddBankTest.class);
	public AddBankTest() throws IOException{
		super();
	}
	

	@BeforeMethod
	public void setUp() throws Exception{
		initialization();	
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		bankspage=new BanksPage();
		bankspage=homePage.MastersTab();
		addbank=new AddBank();
		this.driver = TestBase.driver;
	}
	/*
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=1, dataProvider="getCRMTestData")
	public void enterbankdetails(String bankname,String accountholder,String accountno,String accountype,String ifsc_code,String micr_code) throws IOException
	{
		addbank=bankspage.addBankBtn();
		bankspage=addbank.addbankdetail(bankname, accountholder, accountno, accountype,ifsc_code,micr_code);
		
	}
	*/
	
	@Test
	public void enterbankdetails()
	{
		
	}
}
