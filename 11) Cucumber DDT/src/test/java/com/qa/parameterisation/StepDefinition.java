package com.qa.parameterisation;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.pages.TextIdentiferPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {
	
	WebDriver driver;
	TextIdentiferPage textIdentiferPage;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "../chromedriver");
		driver = new ChromeDriver();
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
	}

	@Given("^I am on the text Identifier Website$")
	public void i_am_on_the_text_Identifier_Website()  {
		driver.get(TextIdentiferPage.URL);
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1) {
		textIdentiferPage = new TextIdentiferPage(driver);
		textIdentiferPage.search(arg1);
	}

	@Then("^The Cat Option should light up$")
	public void the_Cat_Option_should_light_up() {
		assertTrue(textIdentiferPage.catChecked());
	}

	@Then("^The Dog Option should light up$")
	public void the_Dog_Option_should_light_up() {
		assertTrue(textIdentiferPage.dogChecked());
	}

	@Then("^The Other Option should light up$")
	public void the_Other_Option_should_light_up() {
		assertTrue(textIdentiferPage.otherChecked());
	}
}
