package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BingLandingPage {
	
	public static final String URL = "http://www.bing.com";
	
	@FindBy(name = "q")
	private WebElement searchbar;
	
	private WebDriver driver;
	
	public BingLandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void search(String searchText) {
		searchbar.sendKeys(searchText);
		searchbar.submit();
	}
	
	
}
