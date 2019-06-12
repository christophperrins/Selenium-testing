package com.qa.demonstration;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class Runner {

	WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/home/chris/Desktop/chromedriver");
		driver = new ChromeDriver();
	}

	@After
	public void teardown() {
		driver.quit();
	}

	@Test
	public void testy2() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("http://www.bing.com");
		
		BingLandingPage laPage =
				PageFactory.initElements(
						driver, BingLandingPage.class);
		
		laPage.search("Trees");
		
		BingSearchPage sePage = 
				PageFactory.initElements(
						driver, BingSearchPage.class);
		
		String searched = sePage.searchedText();
		
		assertEquals("Trees", searched);
	}

}
