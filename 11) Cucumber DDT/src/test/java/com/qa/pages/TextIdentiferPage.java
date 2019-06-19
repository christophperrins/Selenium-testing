package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextIdentiferPage {

	public static final String URL = "file://" + System.getProperty("user.dir")+"/src/main/resources/index.html";

	
	@FindBy(id = "dogCheck")
	private WebElement dogCheck;
	
	@FindBy(id = "catCheck")
	private WebElement catCheck;
	
	@FindBy(id = "otherCheck")
	private WebElement otherCheck;
	
	@FindBy(id = "classifiedText")
	private WebElement classifiedText;
	
	@FindBy(id = "textToClassify")
	private WebElement textToClassify;
	
	WebDriver driver;
	
	public TextIdentiferPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void search(String searchText) {
		textToClassify.sendKeys(searchText);
		textToClassify.submit();
	}
	
	public boolean catChecked() {
		if(catCheck.getText().equals("x")) {
			return true;
		}
		return false;
	}
	
	public boolean dogChecked() {
		if(dogCheck.getText().equals("x")) {
			return true;
		}
		return false;
	}
	
	public boolean otherChecked() {
		if(otherCheck.getText().equals("x")) {
			return true;
		}
		return false;
	}
	
}
