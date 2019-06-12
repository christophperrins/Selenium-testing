package com.qa.Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestClass2 {

	@Test
	public void printThree() {
		System.out.println(3);
		assertEquals("Two not equal to two", 2, 2);
	}
	
	@Test
	public void printFour() {
		System.out.println(4);
		assertEquals("Two not equal to three", 2, 3);
	}
	
}
