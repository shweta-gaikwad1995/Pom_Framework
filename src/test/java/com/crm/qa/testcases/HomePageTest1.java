package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.BanksPage;
import com.crm.qa.pages.HomePage1;
import com.crm.qa.pages.LoginPage;

@Listeners(Listener_Demo.ListenerTest.class)	
public class HomePageTest1 extends TestBase{
	LoginPage loginPage;
	HomePage1 homePage;
	BanksPage bankspage;

	
	public HomePageTest1() throws IOException{
		super();
	}
	

	@BeforeMethod
	public void setUp() throws Exception{
		initialization();	
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
	}
	
	@Test(priority=1)
	public void validatetitlehome()
	{
		extentTest = extent.startTest("BhimanHomeTitleTest");
		String title = homePage.validateHomePageTitle();
	}
	
	@Test(priority=2)
	public void MastersTabHover() throws IOException
	{
		extentTest = extent.startTest("MastersTab");
		bankspage=homePage.MastersTab();
	}
	
}
