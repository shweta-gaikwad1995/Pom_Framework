
package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebTextbox;


public class AddBank extends TestBase{

	AddBank addbank;
	
	
	@CacheLookup
	@FindBy(xpath="//input[@id='bank_name']")
	WebElement bankname1;
	
	
	@CacheLookup
	@FindBy(xpath="//input[@id='account_name']")
	WebElement accountname1;
	
	@CacheLookup
	@FindBy(xpath="//input[@id='account_no']")
	WebElement accountno1;
	
	@CacheLookup
	@FindBy(xpath="//input[@id='ifsc_code']")
	WebElement ifsc;
	
	@FindBy(xpath="//input[@id='micr_code']")
	WebElement micr;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement submit;
	
	@FindBy(xpath="//button[normalize-space()='OK']")
	WebElement okBtn;
	
	
	//Initializing the Page Objects:
	public AddBank()throws IOException{
		PageFactory.initElements(driver, this);
		this.driver = TestBase.driver;
	}
	

	
	
	
	
	public BanksPage addbankdetail(String bankn,String accname,String accno,String acctype,String ifscco,String micr1) throws IOException
	{
		bankname1.sendKeys(bankn);
		accountname1.sendKeys(accname);
		accountno1.sendKeys(accno);
		Select select = new Select(driver.findElement(By.name("bank_account_type")));
		select.selectByVisibleText(acctype);
		ifsc.sendKeys(ifscco);
		micr.sendKeys(micr1);
		submit.click();
		TestUtil testutil=new TestUtil();
		 new WebDriverWait(driver, 2000).until(ExpectedConditions.elementToBeClickable(okBtn)).click();;
		okBtn.click();
		return new BanksPage();
	}
	
	
	



}