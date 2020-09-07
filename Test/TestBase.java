package com.Test;

import org.apache.log4j.varia.ReloadingPropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.Pages.FlightConfirmationPage;
import com.Pages.FlightPurchasePage;
import com.Pages.FlightSearchPage;
import com.Pages.HomePage;
import com.Pages.SearchResultPage;
import com.aventstack.extentreports.ExtentTest;
import com.utils.Coreutils;
import com.utils.ReadConfigFile;



public class TestBase extends Coreutils{	
	ReadConfigFile readco = new ReadConfigFile();
	ExtentTest logTest;
	
	/*@BeforeMethod
	public void setup() {
		try {
			preSetup();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	
	@Test
		public void launchHomePage() {	
		test = extent.createTest("LaunchHomePage");
		
		driver.get("https://blazedemo.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
			HomePage home = new HomePage(driver);
			if(home.verifyPageLoad()) {
				Assert.assertTrue(true, "HomePage Loaded Successfully");
				System.out.println("HomePage Loaded Successfully");
			}else {
				takescreenshot();
				Assert.assertFalse(false, "HomePage not Loaded Successfully");
				System.out.println("HomePage not Loaded Successfully");	
			}
			logger.info("Application Home page Launched successfully");
			
			FlightSearchPage searchPage = new FlightSearchPage(driver);
			searchPage.searchForTheFlights();
			
			SearchResultPage resultPage = new SearchResultPage(driver);
			if(resultPage.verifyReservePage()) {
				Assert.assertTrue(true, "Flight search result page Loaded Successfully");
				System.out.println("Flight search result page Loaded Successfully");
			}else {
				takescreenshot();
				Assert.assertFalse(false, "Flight search result page is not  Loaded Successfully");
				System.out.println("Flight search result page is  noy Loaded Successfully");	
			}		
			
			resultPage.purchaseFlights();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			logger.info("Choose button selected successfully");
			
			FlightPurchasePage purchasepage = new FlightPurchasePage(driver);
			if(purchasepage.verifyPurchasePageLoad()) {
				Assert.assertTrue(true, "Flight Purchase page Loaded Successfully");
				System.out.println("Flight Purchase page Loaded Successfully");
			}else {
				takescreenshot();
				Assert.assertFalse(false, "Flight Purchase page not Loaded Successfully");
				System.out.println("Flight Purchase page not Loaded Successfully");	
			}
			logger.info("Application Flight Purchase page Launched successfully");
			purchasepage.submituserDetails();
			purchasepage.navigateFlightsConfirmPage();
			
			
			FlightConfirmationPage confirmPage = new FlightConfirmationPage(driver);
					if(confirmPage.verifyConfirmPageLoad())	{
						Assert.assertTrue(true, "Flight Confirmation page Loaded Successfully");
						System.out.println("Flight Confirmation page Loaded Successfully");
					}else {
						takescreenshot();
						Assert.assertFalse(false, "Flight Confirmation page not Loaded Successfully");
						System.out.println("Flight Confirmation page not Loaded Successfully");	
					}
					
					
				}
				
			}
			
			
				
			
			
		
		
	
	/*@AfterMethod
	public void teardown() throws IOException {
		tearDown();
	}*/
	
	

