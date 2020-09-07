package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends PageBase{
	
	public SearchResultPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	WebDriver driver;

    @FindBy(xpath = "//*[contains(text(),'Flights from')]")
    private WebElement searchResultPageText;
    
    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr[1]/td[1]/input")
    private WebElement chooseFlightLink;
    
    public boolean verifyReservePage() {
		if(searchResultPageText.isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
    
    public FlightPurchasePage purchaseFlights() {
    	chooseFlightLink.click();
        return new FlightPurchasePage(driver);
    }  
    
   

}
