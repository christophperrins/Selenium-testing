package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	public static final String URL = "file://" + System.getProperty("user.dir")+"/src/main/resources/index.html";
	
	@FindBy(id = "inputBox")
	private WebElement inputWordBox;
	
	private WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void startGameWith(String input) {
		inputWordBox.sendKeys(input);
		inputWordBox.submit();
	}
}
