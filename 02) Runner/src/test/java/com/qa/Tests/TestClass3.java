package com.qa.Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestClass3 {

	@Test
	public void printFive() {
		System.out.println(5);
		assertEquals("Two not equal to two", 2, 2);
	}
	
	@Test
	public void printSix() {
		System.out.println(6);
		assertEquals("Two not equal to three", 2, 3);
	}
	
}
