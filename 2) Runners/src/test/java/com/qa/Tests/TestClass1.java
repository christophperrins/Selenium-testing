package com.qa.Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestClass1 {

	
	@Test
	public void printOne() {
		System.out.println(1);
		assertEquals("Two not equal to two", 2, 2);
	}
	
	@Test
	public void printTwo() {
		System.out.println(2);
		assertEquals("Two not equal to three", 2, 3);
	}
	
}
