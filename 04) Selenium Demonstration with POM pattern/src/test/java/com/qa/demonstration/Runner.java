package com.qa.demonstration;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.pages.BingLandingPage;
import com.qa.pages.BingSearchPage;

public class Runner {

	WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "../chromedriver");
		driver = new ChromeDriver();
	}

	@After
	public void teardown() {
		driver.quit();
	}

	@Test
	public void testy2() throws InterruptedException {
		String arg = "Trees";
		
		driver.manage().window().maximize();
		driver.get(BingLandingPage.URL);
		
		BingLandingPage laPage = new BingLandingPage(driver);
		
		laPage.search(arg);
		
		BingSearchPage sePage = new BingSearchPage(driver);
		
		String searched = sePage.searchedText();
		
		assertEquals( arg, searched);
	}

}
