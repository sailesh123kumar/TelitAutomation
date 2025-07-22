package com.ui.test;
import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

import static com.constants.Browser.*;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Test Method
 * 1.Test Script small
 * 2.You cannot have conditional statement , loop , try/catch in test method
 * 3.Reduce the use of local variable
 * 4.Atleast one assertion
 */
@Listeners(com.ui.listener.TestListener.class)
public class LogInPageTest extends BaseTest {
	
	
	@Test(description = "Verify Valid User is able to login into the application" , groups = {"e2e" , "sanity"})
	public void logInPageTest() {
		assertEquals(homePage.goToLogInPage().doLogInWith("sailesh.kumar@yahoo.com", "password").getUserName(), "Sailesh kumar");
	}
	
	
	
	@Test(description = "Verify Valid User is able to login into the application" , groups = {"e2e" , "sanity"},dataProviderClass = com.ui.dataprovider.LogInDataProvider.class , dataProvider = "logInJSONTestData")
	public void logInPageJSONTest(User user) {
		assertEquals(homePage.goToLogInPage().doLogInWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Sailesh kumar");
	}
	
	
	@Test(description = "Verify Valid User is able to login into the application" , groups = {"e2e" , "sanity"},dataProviderClass = com.ui.dataprovider.LogInDataProvider.class , dataProvider = "logInCSVTestData",retryAnalyzer = com.ui.listener.MyRetryAnalyzer.class,enabled = false)
	public void logInPageCSVTest(User user) {
		assertEquals(homePage.goToLogInPage().doLogInWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Sailesh kumar");
	}
	
	
	@Test(enabled = false , description = "Verify Valid User is able to login into the application" , groups = {"e2e" , "sanity"},dataProviderClass = com.ui.dataprovider.LogInDataProvider.class , dataProvider = "logInExcelTestData")
	public void logInPageExcelTest(User user) {
		assertEquals(homePage.goToLogInPage().doLogInWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Sailesh kumar");
	}

}
