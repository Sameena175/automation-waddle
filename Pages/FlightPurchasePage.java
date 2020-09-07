package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class FlightPurchasePage extends PageBase{

	public FlightPurchasePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//*[contains(text(),'Your flight from TLV')]")
    private WebElement purchasePageLink;
	
	@FindBy(xpath = "//*[@id='inputName']")
    private WebElement nameText;
	
	@FindBy(xpath = "//*[@id='address']")
    private WebElement addressText;
	
	@FindBy(xpath = "//*[@id='city']")
    private WebElement cityText;
	
	@FindBy(xpath = "//*[@id='state']")
    private WebElement stateText;
	
	@FindBy(xpath = "//*[@id='zipCode']")
    private WebElement zipCode;
	
	@FindBy(xpath = "//*[@id='cardType']")
    private WebElement carrdType;
	
	@FindBy(xpath = "//*[@id='nameOnCard']")
    private WebElement nameOnCard;
	
	@FindBy(xpath = "//input[@value='Purchase Flight']")
    private WebElement purchaseButton;
	
		
	
	public boolean verifyPurchasePageLoad() {
		if(purchasePageLink.isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
	
	public void submituserDetails() {
		nameText.sendKeys("Karen Van");
		addressText.sendKeys("Welligton,CP");
		cityText.sendKeys("cape");
		stateText.sendKeys("MH");
		zipCode.sendKeys("2020");
		
		 
		Select dropdown = new Select(carrdType); 
		dropdown.selectByVisibleText("American Express");   
		
		nameOnCard.sendKeys("Karen");
		
	}
		
	 public FlightConfirmationPage navigateFlightsConfirmPage() {
		 purchaseButton.click();
	        return new FlightConfirmationPage(driver);
	    }

	

}
