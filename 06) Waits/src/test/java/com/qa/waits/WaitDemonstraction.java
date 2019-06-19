package com.qa.waits;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.pages.TestingSite;

public class WaitDemonstraction {

	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "../chromedriver");
		driver = new ChromeDriver();
	}

	@After
	public void teardown() throws InterruptedException {
		driver.close();
	}
	
	@Test
	public void waitTest() {
		driver.manage().window().maximize();
		driver.get(TestingSite.URL);
		
		TestingSite site = new TestingSite(driver);
		
		String quoteText = site.getQuoteText();
		
		assertEquals("Surprise element not found", "Surprise!", quoteText);
		
	}
}
