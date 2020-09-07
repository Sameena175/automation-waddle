package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightSearchPage extends PageBase{
	WebDriver driver;
	
	public FlightSearchPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}	

    @FindBy(xpath = "//input[@value='Find Flights']")
    private WebElement findButton;
    
    
    public SearchResultPage searchForTheFlights() {
        findButton.click();
        return new SearchResultPage(driver);
    }

}
