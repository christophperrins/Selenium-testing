package com.qa.Runners;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.qa.Suite.TestSuite1;
import com.qa.Tests.TestClass3;

public class Runner {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestClass3.class, TestSuite1.class);
		
		if(result.wasSuccessful()) {
			System.out.println("Successful");
		} else {
			System.out.println("Test failures!:");
			for (Failure failure : result.getFailures()) {
				System.out.println(failure.getMessage());
			}
		}
	}
	
}
