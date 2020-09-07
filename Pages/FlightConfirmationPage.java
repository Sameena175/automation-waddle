package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightConfirmationPage extends PageBase{

	public FlightConfirmationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//*[contains(text(),'Thank you for')]")
    private WebElement confirmMessage;
	
	public boolean verifyConfirmPageLoad() {
		if(confirmMessage.isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}

}
