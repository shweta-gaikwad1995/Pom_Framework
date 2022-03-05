package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;

import com.crm.qa.pages.HomePage1;

import com.crm.qa.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import com.qa.AllureReportListener.TestAllureListener;
import com.relevantcodes.extentreports.LogStatus;

@Listeners({TestAllureListener.class})
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
	
	@Test(priority=1, description = "verifying login page title test")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: Verify login page title test on Login Page")
	@Story("Story Name: To check login page title")
	public void loginPageTitleTest(){
		extentTest = extent.startTest("BhimanTitleTest");
		String title = loginPage.validateLoginPageTitle();
		
		Assert.assertEquals(title, "Bhiman Admin Login page");
		LOG.info("Title of page");
		
	}
	
	
	@Test(priority=2,enabled=true)
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description: Verify login page e")
	@Story("Story Name: To check login ")
	public void loginTest() throws IOException{
		
		extentTest = extent.startTest("BhimanTest");
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		LOG.info("Landing on HomePage");
	}
	

	
	
	
	
}
