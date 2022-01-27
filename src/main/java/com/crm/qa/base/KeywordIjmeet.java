package com.crm.qa.base;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class KeywordIjmeet extends TestBase{

	public KeywordIjmeet() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public static WebElement getWebElement(String locator,String locatorValue)
	{
		if(locator.equalsIgnoreCase("xpath"))
		{
			return driver.findElement(By.xpath(locatorValue));
		}
		else if(locator.equalsIgnoreCase("css"))
		{
			return driver.findElement(By.cssSelector(locatorValue));
		}
		else
		{
			System.out.println("invalid path");
		}
		return null;
		
	}
	
	
	public static void enterText(String locator,String text)
	{
		String[] parts=locator.split("##");
		getWebElement(parts[0], parts[1]).sendKeys(text);
	}
}
