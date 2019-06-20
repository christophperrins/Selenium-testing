package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

public static final String URL = "http://thedemosite.co.uk/login.php";
	
	@FindBy(name = "username")
	private WebElement username;
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(name = "FormsButton2")
	private WebElement button;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center")
	private WebElement loginAttempt;
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void loginUser(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		button.click();
	}
	
	public String loginAttemptText() {
		return loginAttempt.getText();
	}
	
}
