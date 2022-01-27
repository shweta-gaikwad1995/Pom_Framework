package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebTextbox;

public class BanksPage extends TestBase{
	public static long WebDriverWait;
	
	@FindBy(css="#add_btn")
	WebElement addBankBtn;
	
	
	@CacheLookup
	@FindBy(xpath="//input[@id='bank_name']")
public  WebElement SearchInputTxtBox;
	
	
	
	
	
	
	
	

	

			//Initializing the Page Objects:
			public BanksPage()throws IOException{
				PageFactory.initElements(driver, this);
				this.driver = TestBase.driver;
			}
			
			
			
			/*
			 * https://github.com/anilpandeykiet/POM_HYBRID_FRAMEOWRK/blob/master
			 * /TestModule/mercuryflighttests/FlightReservation_LoginTests.java
			 */
		
			public void enterdetail()
			{
				WebTextbox.sendTextToWebInput(SearchInputTxtBox, "shweta");
			}
			
			
			
			
			
			public AddBank addBankBtn() throws IOException
			{
				TestUtil testutil=new TestUtil();
				 new WebDriverWait(driver, 2000).until(ExpectedConditions.visibilityOf(addBankBtn));
				addBankBtn.click();
				return new AddBank();
				
			}
			
			
}
