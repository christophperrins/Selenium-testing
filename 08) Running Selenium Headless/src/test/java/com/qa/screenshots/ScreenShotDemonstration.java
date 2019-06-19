package com.qa.screenshots;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.qa.pages.GithubPage;

public class ScreenShotDemonstration {

	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "../chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		driver = new ChromeDriver(options);
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
		FileOutputStream outputStream = new FileOutputStream("src/test/resources/github.png");
		
		byte[] bytes = new byte[128];
		
		while(screenshotStream.read(bytes) != -1) {
			outputStream.write(bytes);
		}
		
		screenshotStream.close();
		outputStream.close();
	}
	
}
