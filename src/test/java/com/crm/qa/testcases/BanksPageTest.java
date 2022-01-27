package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AddBank;
import com.crm.qa.pages.BanksPage;
import com.crm.qa.pages.HomePage1;
import com.crm.qa.pages.LoginPage;

public class BanksPageTest extends TestBase{
	LoginPage loginPage;
	HomePage1 homePage;
	BanksPage bankspage;
	AddBank addbank;

	
	public BanksPageTest() throws IOException{
		super();
		this.driver = TestBase.driver;
	}
	

	@BeforeMethod
	public void setUp() throws Exception{
		initialization();	
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		bankspage=new BanksPage();
		bankspage=homePage.MastersTab();
		addbank=new AddBank();
	}
	
	
	@Test(priority=1)
	public void addbankBtnTest() throws IOException
	{
		addbank=bankspage.addBankBtn();
		bankspage.enterdetail();
		
	}
}
