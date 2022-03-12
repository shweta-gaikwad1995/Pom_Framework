package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.beust.jcommander.converters.PathConverter;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static Logger logger;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	
	
	
	
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	
	
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
				
			WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(); 
		
			}
		
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_wait, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
	
	}

		public String getScreenshot() {
			File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
			File destination = new File(path);
			try {
				FileUtils.copyFile(src, destination);
			} catch (IOException e) {
				System.out.println("Capture Failed " + e.getMessage());
			}
			return path;
			
			
		}




		public static WebDriver getDriver() {
			return tdriver.get();
		}
		

//=======================Exetent report		
	
		
		
		@BeforeTest
		public void setExtent(){
			extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
			extent.addSystemInfo("Host Name", "Shweta Window");
			extent.addSystemInfo("User Name", "Bhiman Estate");
			extent.addSystemInfo("Environment", "QA");
			//extent.loadConfig(new File(System.getProperty("user.dir")+"src\\test\\resources\\extent-config.xml"));
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));	
		
		}
		
		
		
		
		
		@AfterTest
		public void endReport(){
			extent.flush();
			extent.close();
		}
	
		public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			// after execution, you could see a folder "FailedTestsScreenshots"
			// under src folder
			String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
					+ ".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			return destination;
		}
		
	
		@AfterMethod
		public void tearDown(ITestResult result) throws IOException{
			
			if(result.getStatus()==ITestResult.FAILURE){
				extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
				extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
				
				String screenshotPath = TestBase.getScreenshot(driver, result.getName());
				extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
				//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
			}
			else if(result.getStatus()==ITestResult.SKIP){
				extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
			}
			else if(result.getStatus()==ITestResult.SUCCESS){
				extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

			}
			
			
			extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
			driver.quit();
		}
		
	
}
