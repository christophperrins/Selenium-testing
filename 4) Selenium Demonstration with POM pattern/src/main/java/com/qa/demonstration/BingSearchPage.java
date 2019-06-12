package com.qa.demonstration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BingSearchPage {
	
	@FindBy(id = "sb_form_q232")
	private WebElement searchBar;
	
	public String searchedText() {
		return searchBar.getAttribute("value");
	}
	
}
