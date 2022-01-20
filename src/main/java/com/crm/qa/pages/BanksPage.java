package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class BanksPage extends TestBase{
	public static long WebDriverWait;
	
	@FindBy(css="#add_btn")
	WebElement addBankBtn;
	
	
	//Initializing the Page Objects:
			public BanksPage()throws IOException{
				PageFactory.initElements(driver, this);
			}
			
		
			
			public AddBank addBankBtn() throws IOException
			{
				TestUtil testutil=new TestUtil();
				 new WebDriverWait(driver, 2000).until(ExpectedConditions.visibilityOf(addBankBtn));
				addBankBtn.click();
				return new AddBank();
				
			}
			
			
}
