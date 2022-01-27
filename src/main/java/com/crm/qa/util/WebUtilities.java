package com.crm.qa.util;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class WebUtilities {
	public static boolean waitForElementToAppear(WebDriver driver, WebElement element) {
		boolean webElementPresence = false;
		try {
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).pollingEvery(2, TimeUnit.SECONDS)
					.withTimeout(60, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			fluentWait.until(ExpectedConditions.visibilityOf(element));
			if (element.isDisplayed()) {
				webElementPresence= true;
			}
		} catch (TimeoutException toe) {
			//logger.log(LogStatus.ERROR, "Timeout waiting for webelement to be present<br></br>" + toe.getStackTrace());
		} catch (Exception e) {
			//logger.log(LogStatus.ERROR, "Exception occured<br></br>" + e.getStackTrace());
		}
		return webElementPresence;
	}
}
