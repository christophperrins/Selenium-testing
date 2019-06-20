# 1. Automated Testing
## 1.1. Contents
- [2. Suites](#2-suites)
- [3. Runner](#3-runner)
- [4. Categories](#4-categories)
- [5. Selenium Demonstration with Page Object Model](#5-selenium-demonstration-with-page-object-model)
- [6. Actions](#6-actions)
- [7. Waits](#7-waits)
- [8. Screenshots](#8-screenshots)
- [9. Headless](#9-headless)
- [10. JavaScript with selenium](#10-javascript-with-selenium)
- [11. Cucumber](#11-cucumber)
- [12. Cucumber DDT](#12-cucumber-ddt)
- [13. JUnit DDT](#13-junit-ddt)
- [14. Surefire reports](#14-surefire-reports)
---

[Back to Top](#11-contents)
# 2. Suites
A suite is a group of test classes.
The test classes will run in the order of they array.

Suites are part of the junit.runner package.

---
[Back to Top](#11-contents)
# 3. Runner
Junit has multiple runners - i.e. ways to **run** test classes.

A main method can be invoked in the src/test folder structure.

This main method can be run and from within it have it logically choose which test classes to run, and what to log at runtime.

---
[Back to Top](#11-contents)
# 4. Categories
Some tests can be quick, and others slow. Some will be safety critical, business critical or minor. With categories it is possible to make regression testing easier by running all the tagged tests.

---
[Back to Top](#11-contents)
# 5. Selenium Demonstration with Page Object Model
No not the pom.xml, the Page Object Model (POM) in this case refers to a design pattern to make tests more maintainable.

---
[Back to Top](#11-contents)
# 6. Actions
Actions are used to run multiple actions, possibly linked actions, all in one go.

Actions can be useful when testing drop-down menus, or it can be useful to test mouse movements in general, double clicks, right clicks (aka context click) etc.

---
[Back to Top](#11-contents)
# 7. Waits
Waits are needed for dynamically appearing elements.
An element might appear after 30 seconds (such as a feedback for the website - something we don't want to appear instantly). We want to have automated tests to run against these forms. However by default if the element isn't instantly available, an exception will be thrown. Two waits are shown here, implicit and explicit waits. 

---
[Back to Top](#11-contents)
# 8. Screenshots
If there is an error on the page, you might want to see what the visual message is. We can save these images and later put them inside test documents, logs or reports.

---
[Back to Top](#11-contents)
# 9. Headless
Whats headless? Well look at the other examples, when the tests run, it loads up a browser on your screen, does a bunch of super quick actions, then closes it. This is incredibly annoying - it makes the computer unusable for other items as there are a bunch of windows popping up and closing. Making it headless simply means, we don't see these windows.

---
[Back to Top](#11-contents)
# 10. JavaScript with selenium
This can be tricky. If your website is complex, where lots of items depend on each other - this can make it hard to test with selenium alone! It might mean our tests won't actually be testing a small unit, but be dependant on a large collection. If this is not what we want, we can change how the website is displayed, or grab information from the website with JavaScript.

BE CAREFUL! By changing the website via JavaScript- you might be changing the functionality. If you are then testing that functionality, you might not get realistic results.

---
[Back to Top](#11-contents)
# 11. Cucumber
Behaviour Driven Development integrates well with Agile teams. Tests can be grouped for a feature, and when those tests pass, Continuous integration can pass the feature and increment the story points done.

The feature file contains arguments which are passed through - the gherkin parser will look for numbers and "strings" in the feature file, and if it finds one will pass it into the method it creates.

---
[Back to Top](#11-contents)
# 12. Cucumber DDT
There are two ways we can use Data Driven Testing.
We can use it as "<Key>" and <Key>. 

"<Key>" will send in the values inside the table in as a string. The method will treat them all as a String, and run the same method on all strings.

<Key> will create a different method for each piece of unique data in the table.

---
[Back to Top](#11-contents)
# 13. JUnit DDT
JUnit also has its own Data Driven Testing capabilities built into the framework. It uses the @Parameterisation tag. 

The first thing you need to do is feed it a 2-dimentional array of data, each array of data will be sent through to a matching constructor, which can then have global variables set for it. - This is done with excel.

The next thing you need to do is create an input and output stream so that we can read from then write to the excel file. We read from the excel file so that we can load in the values, and manipulate the cell values, then we write out the file so that it is saved. 

---
[Back to Top](#11-contents)
# 14. Surefire reports
This is a very simple test report creation tool. Others exist however this is easy to get up and running.

Copy the extra dependancies and run the commands

`mvn site`

`mvn surefire-report:report`

Every class which ends or begins with "Test" will be executed and have its @Tests run.

Check inside the target/site folder and you should see the report in there.



