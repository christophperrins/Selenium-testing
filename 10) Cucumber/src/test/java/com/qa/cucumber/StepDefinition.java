package com.qa.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.pages.LandingPage;
import com.qa.pages.PlayPage;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {

	WebDriver driver;
	LandingPage landingPage;
	PlayPage playPage;

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
	
	@Given("^User is on Hangman Page$")
	public void user_is_on_Hangman_Page() throws Throwable {
		driver.get(LandingPage.URL);
	}

	@When("^User submits word$")
	public void user_submits_word() throws Throwable {
		landingPage = new LandingPage(driver);
		landingPage.startGameWith("Hangman");
	}

	@Then("^Underscores displayed on the screen with the same length of word entered$")
	public void underscores_displayed_on_the_screen_with_the_same_length_of_word_entered() throws Throwable {
		playPage = new PlayPage(driver);
		int letterCount = (int) playPage.letterCount();
		assertEquals(7, letterCount);
	}

	@Given("^Word is entered into the game$")
	public void word_is_entered_into_the_game() throws Throwable {
		landingPage = new LandingPage(driver);
		landingPage.startGameWith("Hangman");
	}

	@When("^User submits an correct letter$")
	public void user_submits_an_correct_letter() throws Throwable {
		playPage = new PlayPage(driver);
		playPage.guessLetter("H");
	}

	@Then("^letter is displayed on the screen$")
	public void letter_is_displayed_on_the_screen() throws Throwable {
		assertTrue(playPage.isLetterDisplayed("H"));
	}

	@When("^User submits an incorrect letter$")
	public void user_submits_an_incorrect_letter() throws Throwable {
		playPage = new PlayPage(driver);
		playPage.guessLetter("z");
	}

	@Then("^next hangman image gets shown$")
	public void image_of_hangmanbase_gets_shown() throws Throwable {
		assertEquals("file:///home/chris/Desktop/Automated_Testing/10)%20Cucumber/src/main/resources/image1.png", playPage.getImage());
	}

	@Then("^Message displayed Game over$")
	public void message_displayed_Game_over() throws Throwable {
		assertEquals("Game Over!", playPage.getMessage());
	}

	@When("^I guess all letters$")
	public void i_guess_all_letters() throws Throwable {
		playPage = new PlayPage(driver);
		playPage.guessLetter("H");
		playPage.guessLetter("a");
		playPage.guessLetter("n");
		playPage.guessLetter("g");
		playPage.guessLetter("m");
	}

	@Then("^Message displayed Win$")
	public void message_displayed_Win() throws Throwable {
		assertEquals("Win!", playPage.getMessage());
	}

}
