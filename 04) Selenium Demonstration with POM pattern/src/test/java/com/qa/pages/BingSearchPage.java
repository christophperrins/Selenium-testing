package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BingSearchPage {

	@FindBy(id = "sb_form_q")
	private WebElement searchBar;

	private WebDriver driver;

	public BingSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String searchedText() {
		return searchBar.getAttribute("value");
	}

}
