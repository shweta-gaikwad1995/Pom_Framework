package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage  extends TestBase{
	
	//PageFactory OR
	
			@FindBy(xpath="//input[@id='username']")
			WebElement username;
			
			@FindBy(xpath="//input[@id='password']")
			WebElement password;
			
			@FindBy(xpath="//button[normalize-space()='Login']")
			WebElement loginBtn;
	
	//Initializing the Page Objects:
		public LoginPage()throws IOException{
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		public HomePage1 login(String un, String pwd) throws IOException{
			username.sendKeys(un);
			password.sendKeys(pwd);
			//loginBtn.click();
			    	JavascriptExecutor js = (JavascriptExecutor)driver;
			    	js.executeScript("arguments[0].click();", loginBtn);
			    	
			return new HomePage1();
		}
	
}
