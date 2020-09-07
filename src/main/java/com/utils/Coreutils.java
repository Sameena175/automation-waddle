package com.utils;

import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class Coreutils {
	
	protected static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	
	public static String testDataFile;
	String fileWithPath ;
	public static Logger logger;
	
	ReadConfigFile readCon = new ReadConfigFile();
	@BeforeClass	
	public void preSetup() throws IOException {
		
		
		String browserName = readCon.getBrowserName();
		System.out.println("*********"+browserName);
		String chromeDriverPath = readCon.getChromeDriverPath();
		String geckoDriverPath = readCon.getgeckoDriverPath();
		String applicationURL = readCon.getAppURL();
		
		logger = Logger.getLogger("FlightBooking-SeleniumProject");
		PropertyConfigurator.configure("Log4j.properties");
		
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./ExtentReport/AutomationExecutionReport.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Application Under Test - ", "Flight Booking System");
		extent.setSystemInfo("User Name", "Sameena");
		extent.setSystemInfo("Browser",browserName );
		extent.setSystemInfo("Operating System","Windows10" );
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("start-maximized");
	        /*options.addArguments("--ignore-certificate-errors");
	        options.addArguments("--disable-popup-blocking");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);*/
			
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		//	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);			
			
		}
			
		else if(browserName.equalsIgnoreCase("Mozilla")) {
			System.setProperty("webdriver.gecko.driver", geckoDriverPath);
			driver=new FirefoxDriver();
			driver.manage().window().maximize();		
			
			
		}
		
	}
	@AfterClass
	public void tearDown() {//(ITestResult Result) {
		/*if(Result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, " Test case is Passed -"+Result.getTestName());
		}else if(Result.getStatus()==ITestResult.FAILURE) {
			takescreenshot();
			test.log(Status.FAIL, " Test case is Failed -"+Result.getTestName());
		}*/
		extent.flush();
		driver.close();
		driver.quit();
	}
	
	public void takescreenshot() {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File("./Screenshots/Screen.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("the Screenshot is taken");
	}
	
	
	

}
