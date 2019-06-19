package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CookieClicker {
	
	public static final String URL = "https://orteil.dashnet.org/cookieclicker/";

	@FindBy(id = "bigCookie")
	private WebElement bigCookie;
	
	@FindBys({
		@FindBy(className = "product")
	})
	private List<WebElement> allProducts;
	
	private WebDriver driver;
	
	public CookieClicker(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void start() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(bigCookie));
	}
	
	public void addMoney(String money) {
		((JavascriptExecutor) driver).executeScript("Game.Earn("+money+")");
	}
	
	public void clickAllProducts() {
		for (WebElement element: allProducts) {
			element.click();
		}
	}
	
	
	
	
	
}
