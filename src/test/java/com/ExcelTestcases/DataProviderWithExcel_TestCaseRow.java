package com.ExcelTestcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.DataProvider;





public class DataProviderWithExcel_TestCaseRow {

	
	
	
	WebDriver driver;

    @BeforeMethod

    public void beforeMethod() throws Exception {

    	WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://103.50.162.196/testing/user-login.php");	 

	}

@Test(dataProvider="Authentication")

public void Registration_data(String sUserName,String sPassword)throws  Exception{

   // driver.findElement(By.xpath(".//*[@id='account']/a")).click();

    driver.findElement(By.xpath("//input[@id='username']")).sendKeys(sUserName);

	System.out.println(sUserName);

    driver.findElement(By.xpath("//input[@id='password']")).sendKeys(sPassword);

	System.out.println(sPassword);

    driver.findElement(By.xpath("//button[@type='submit']")).click();

    System.out.println(" Login Successfully, now it is the time to Log Off buddy.");

   // driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();

	}

@DataProvider

public Object[][] Authentication() throws Exception{

     Object[][] testObjArray = ExcelUtils.getTableArray("C://Users//admin//eclipse-workspace//HybridFramework//src//main//java//com//exceldata//exceldata.xlsx","LoginData", 1);

     return (testObjArray);

	}

/*
@AfterMethod

public void afterMethod() {

	    driver.close();

	}
	
*/	
	
}
