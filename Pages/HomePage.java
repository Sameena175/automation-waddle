package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends PageBase {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}	
	
	@FindBy(xpath = "//*[contains(text(),'Welcome')]")
    private WebElement homePageLink;
	
	public boolean verifyPageLoad() {
		if(homePageLink.isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
		
	 public FlightSearchPage navigateFlightsSearchPage() {
		 if(homePageLink.isDisplayed()) {
				System.out.println("HomePage Loaded Successfully");
			}	        
	        return new FlightSearchPage(driver);
	    }
}
