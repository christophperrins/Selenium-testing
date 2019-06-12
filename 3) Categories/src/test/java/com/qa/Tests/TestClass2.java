package com.qa.Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.qa.Categories.CategoryOne;
import com.qa.Categories.CategoryTwo;

public class TestClass2 {

	@Test
	@Category(CategoryOne.class)
	public void printThree() {
		System.out.println(3);
		assertEquals("Two not equal to two", 2, 2);
	}
	
	@Test
	@Category(CategoryTwo.class)
	public void printFour() {
		System.out.println(4);
		assertEquals("Two not equal to three", 2, 3);
	}
	
}
