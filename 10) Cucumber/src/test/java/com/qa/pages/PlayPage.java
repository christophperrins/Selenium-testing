package com.qa.pages;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlayPage {

	@FindBy(id = "guessBox")
	private WebElement guessingBox;

	@FindBy(id = "progress")
	private WebElement progressBar;

	@FindBy(id = "hangman")
	private WebElement hangman;
	
	@FindBy(id = "message")
	private WebElement message;

	private WebDriver driver;

	public PlayPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public long letterCount() {
		String progress = progressBar.getText();
		String[] chars = progress.split("");
		long length = Arrays.stream(chars).filter(character -> !character.equals(" ")).count();
		return length;
	}
	
	public String getImage() {
		return hangman.getAttribute("src");
	}
	
	public boolean isLetterDisplayed(String letter) {
		String progressText = progressBar.getText();
		for (int i = 0; i < progressText.length(); i++) {
			if (progressText.substring(i, i+1).equals(letter)) {
				return true;
			}
		}
		return false;
	}
	
	
	public void guessLetter(String character) {
		guessingBox.sendKeys(character);
		guessingBox.submit();
	}
	
	public String getMessage() {
		return message.getText();
	}

}
