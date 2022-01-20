package com.crm.qa.pages;



import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;


public class HomePage1 extends TestBase{
	
	public static long WebDriverWait;
	

	//Initializing the Page Objects:
			public HomePage1()throws IOException{
				PageFactory.initElements(driver, this);
			}
			

			

			@FindBy(xpath="//body/div[3]/nav[1]/ul[1]/li[2]/a[1]")
			WebElement MastersTab;
			
			@FindBy(xpath="//a[starts-with(text(),'Banks ')]")
			WebElement BanksLink;
			
			
			
			
			//Actions:
			public String validateHomePageTitle(){
				return driver.getTitle();
			}
			
			
			public BanksPage MastersTab() throws IOException
			{
				Actions action=new Actions(driver);
				 new WebDriverWait(driver, 2000).until(ExpectedConditions.visibilityOf(MastersTab));
				action.moveToElement(MastersTab).build().perform();
				BanksLink.click();
				return new BanksPage();
				
				
				
			}
			
			
}
