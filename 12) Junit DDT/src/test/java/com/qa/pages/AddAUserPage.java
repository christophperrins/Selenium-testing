package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddAUserPage {

	public static final String URL = "http://thedemosite.co.uk/addauser.php";
	
	@FindBy(name = "username")
	private WebElement username;
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(name = "FormsButton2")
	private WebElement button;
	
	private WebDriver driver;
	
	public AddAUserPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void addUser(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		button.click();
	}
	
}
