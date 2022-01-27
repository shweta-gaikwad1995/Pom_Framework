package com.crm.qa.util;

import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class WebTextbox {

	
	
	
	public static void sendTextToWebInput(WebElement element, String textToEnter) {
		try {
			if (element != null) {
				element.sendKeys(textToEnter);
				//logger.log(LogStatus.INFO, "Text '" + textToEnter + "' successfully entered in the text box");
			}
		} catch (Exception e) {
			//logger.log(LogStatus.ERROR,"Failed to enter text '" + textToEnter + "' in the text box</br>" + e.getStackTrace().toString());
			e.printStackTrace();;
		}
	}
	
	public static void sendTextToWebInput(WebElement element, String textToEnter, ExtentTest logger) {
		try {
			if (element != null) {
				element.sendKeys(textToEnter);
				//logger.log(LogStatus.INFO, "Text '" + textToEnter + "' successfully entered in the text box");
			}
		} catch (Exception e) {
			//logger.log(LogStatus.ERROR,"Failed to enter text '" + textToEnter + "' in the text box</br>" + e.getStackTrace().toString());
			e.printStackTrace();;
		}
	}
	
	public static void clearWebInput(WebElement element) {
		element.clear();
	}
	
}
