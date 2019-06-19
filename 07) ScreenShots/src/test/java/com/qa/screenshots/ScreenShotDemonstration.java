package com.qa.screenshots;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.pages.GithubPage;

public class ScreenShotDemonstration {

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
	public void screenshot() throws IOException {
		driver.manage().window().maximize();
		driver.get(GithubPage.URL);
		
		TakesScreenshot screenshotDriver = ((TakesScreenshot) driver);
		File screenshot = screenshotDriver.getScreenshotAs(OutputType.FILE);
		
		FileInputStream screenshotStream = new FileInputStream(screenshot);
		FileOutputStream outputStream = new FileOutputStream("src/test/resources/myScreenshot.png");
		
		byte[] bytes = new byte[128];
		
		while(screenshotStream.read(bytes) != -1) {
			outputStream.write(bytes);
		}
		
		screenshotStream.close();
		outputStream.close();
	}
	
}
