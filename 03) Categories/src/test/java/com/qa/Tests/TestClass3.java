package com.qa.Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.qa.Categories.CategoryOne;
import com.qa.Categories.CategoryTwo;

@Category(CategoryTwo.class)
public class TestClass3 {

	@Test
	public void printFive() {
		System.out.println(5);
		assertEquals("Two not equal to two", 2, 2);
	}
	
	@Test
	@Category(CategoryOne.class)
	public void printSix() {
		System.out.println(6);
		assertEquals("Two not equal to three", 2, 3);
	}
	
}
