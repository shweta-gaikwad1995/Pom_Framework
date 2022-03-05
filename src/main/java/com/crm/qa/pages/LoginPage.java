package com.crm.qa.pages;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

import io.qameta.allure.Step;

public class LoginPage  extends TestBase{
	
	//PageFactory OR
	
			@FindBy(xpath="//input[@id='username']")
			WebElement username;
			
			@FindBy(xpath="//input[@id='password']")
			WebElement password;
			
			@FindBy(xpath="//button[normalize-space()='Login']")
			WebElement loginBtn;
	
	
			
			private By xpathMsg =By.xpath("//div[@id='flash']");

			
			
			//Initializing the Page Objects:
		public LoginPage()throws IOException{
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		
		@Step("getting login page title step....")
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		@Step("login with username: {0} and password: {1} step...")
		public HomePage1 login(String un, String pwd) throws IOException{
			username.sendKeys(un);
			password.sendKeys(pwd);
			//loginBtn.click();
			    	JavascriptExecutor js = (JavascriptExecutor)driver;
			    	js.executeScript("arguments[0].click();", loginBtn);
			    	
			return new HomePage1();
		}
		
	
}
