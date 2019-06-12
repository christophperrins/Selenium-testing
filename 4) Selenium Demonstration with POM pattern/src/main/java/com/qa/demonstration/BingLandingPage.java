package com.qa.demonstration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BingLandingPage {

	
	@FindBy(name = "q")
	private WebElement searchbar;
	
	public void search(String searchText) {
		searchbar.sendKeys(searchText);
		searchbar.submit();
	}
	
	
}
