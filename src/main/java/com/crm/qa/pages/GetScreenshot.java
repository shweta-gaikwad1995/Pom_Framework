package com.crm.qa.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class GetScreenshot extends TestBase{

	public GetScreenshot() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		this.driver = TestBase.driver;
	}

	
	 public static String capture(String screenshotName) throws IOException {
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        String dest = System.getProperty("user.dir") + "/Listenerscreenshots/" + screenshotName + System.currentTimeMillis() + ".png";
	        File destination = new File(dest);
	        FileUtils.copyFile(source, destination);
	 
	        return dest;
	    }
}