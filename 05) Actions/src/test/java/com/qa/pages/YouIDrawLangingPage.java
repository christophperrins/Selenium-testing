package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YouIDrawLangingPage {

	public static final String URL = "https://www.youidraw.com/apps/painter/";

	@FindBy(id = "catch")
	private WebElement canvas;
	
	private WebDriver driver;
	
	public YouIDrawLangingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void repositionMouse() {
		Actions actions = new Actions(driver);
		actions.moveToElement(canvas)
			.moveByOffset(-(canvas.getSize().getWidth()/2), -(canvas.getSize().getHeight()/2))
			.moveByOffset(100, 100)
			.perform();
	}
	
	public void writeC() {
		Actions actions = new Actions(driver);
		double magnitude = 10;
		actions.clickAndHold();
		for (int angle = 0; angle <= 180; angle+=10) {
			double radians = (double) angle/180 * Math.PI;
			actions.moveByOffset((int) -(Math.cos(radians)*magnitude) ,(int) (Math.sin(radians)*magnitude));
		}
		actions.release().moveByOffset(50, -100).perform();		
	}
	
	public void writeH() {
		Actions actions = new Actions(driver);
		actions.clickAndHold()
			.moveByOffset(0, 100)
			.moveByOffset(0, -50)
			.moveByOffset(50, 0)
			.moveByOffset(0, 50)
			.release()
			.moveByOffset(50, -100)
			.perform();
	}
	
	public void writeR() {
		Actions actions = new Actions(driver);
		actions.moveByOffset(0, 50)
			.clickAndHold()
			.moveByOffset(0, 50)
			.moveByOffset(0, -50)
			.moveByOffset(50, 0)
			.release()
			.moveByOffset(50, -50)
			.perform();
	}
	
	public void writeI() {
		Actions actions = new Actions(driver);
		actions.moveByOffset(0, 50)
			.clickAndHold()
			.moveByOffset(0, 50)
			.release()
			.moveByOffset(50, -100)
			.perform();
	}
	
	public void writeS() {
		Actions actions = new Actions(driver);
		actions.moveByOffset(50, 50)
			.clickAndHold()
			.moveByOffset(-50, 0)
			.moveByOffset(0, 25)
			.moveByOffset(50, 0)
			.moveByOffset(0, 25)
			.moveByOffset(-50, 0)
			.release()
			.moveByOffset(50, -100)
			.perform();
	}
	 
}
