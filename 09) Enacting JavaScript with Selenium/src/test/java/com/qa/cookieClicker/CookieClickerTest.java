package com.qa.cookieClicker;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.pages.CookieClicker;

public class CookieClickerTest {

	private WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "../chromedriver");
		driver = new ChromeDriver();
	}

	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(10000);
		driver.close();
	}
	
	@Test
	public void endGameTest() throws IllegalArgumentException, IllegalAccessException {
		driver.manage().window().maximize();
		driver.get(CookieClicker.URL);
		
		CookieClicker cookieClicker = new CookieClicker(driver);
		cookieClicker.start();
		// The game products can't be clicked until money is added.
		// However a large amount of money might take time in the game.
		// We can get around this time delay by directly manipulating the money via javascript
		cookieClicker.addMoney("100000000000000000000000000000000000");
		cookieClicker.clickAllProducts();			
	}
}
