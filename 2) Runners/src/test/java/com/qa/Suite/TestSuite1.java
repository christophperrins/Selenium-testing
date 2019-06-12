package com.qa.Suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.qa.Tests.TestClass1;
import com.qa.Tests.TestClass2;

@RunWith(Suite.class)
@SuiteClasses({TestClass1.class, TestClass2.class})
public class TestSuite1 {

}
