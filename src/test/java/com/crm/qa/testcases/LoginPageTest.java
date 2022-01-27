package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;

import com.crm.qa.pages.HomePage1;

import com.crm.qa.pages.LoginPage;


public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage1 homePage;
	Logger LOG = Logger.getLogger(LoginPageTest.class);
	
	public LoginPageTest() throws IOException{
		super();
	}
	
	
	
	
	@BeforeMethod
	public void setUp() throws Exception{
		initialization();	
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		
		Assert.assertEquals(title, "Bhiman Admin Login page");
		LOG.info("Title of page");
		
	}
	
	
	@Test(priority=2)
	public void loginTest() throws IOException{
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		LOG.info("Landing on HomePage");
	}
	
	/*
	@Test(priority=3)
	public void doLoginTest()
	{
		HomePage2 homePage=page.getInstance(LoginPage1.class).doLogin("9876543211", "admin");
	String headerHome=homePage.getHomePageHeader();
	}*/
}
