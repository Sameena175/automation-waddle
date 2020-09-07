package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class UserRegistrationPage {
	
	WebDriver driver;
	
	public UserRegistrationPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	this.driver=driver;
	}
	
	//Using FindBy for locating elements	
	
	@FindBy(linkText = "Flights")
    private WebElement flightsPageLink;

   

}
