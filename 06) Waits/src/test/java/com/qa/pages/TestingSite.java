package com.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestingSite {

	public static final String URL = "https://christophperrins.github.io/TestingSite/";
	
	@FindBy(id = "quote")
	private WebElement quote;
	
	WebDriver driver;
	
	public TestingSite(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getQuoteText() {
		//implicit wait - is applied to all elements
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//explicit wait - applied to this element
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(quote));
		return quote.getText();
	}
}
