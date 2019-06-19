package com.qa.actions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.pages.YouIDrawLangingPage;


public class LetterTest {

	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "../chromedriver");
		driver = new ChromeDriver();
	}

	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
	
	@Test
	public void testy() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get(YouIDrawLangingPage.URL);
		
		YouIDrawLangingPage drawPage = new YouIDrawLangingPage(driver);
		drawPage.repositionMouse();
		drawPage.writeC();
		drawPage.writeH();
		drawPage.writeR();
		drawPage.writeI();
		drawPage.writeS();
		
	}
	
}
