package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;


import com.crm.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static Logger logger;
	
	
	
	public TestBase() throws IOException{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/qa"
					+ "/crm/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFound");
		}
	}
		
		public static void initialization() throws Exception {
			String browserName = prop.getProperty("browser");
			
			if(browserName.equals("chrome")){
				//System.setProperty("webdriver.chrome.driver", "/Users/naveenkhunteta/Downloads/chromedriver");	
			WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(); 
		
			}
		
			
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_wait, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
	}
		
		//Generics
		public <TPage extends TestBase>TPage getInstance(Class<TPage> pageClass) 
		{
			try {
				return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null; 
			}
			
			
		}

}
