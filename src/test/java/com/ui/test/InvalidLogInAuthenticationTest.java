package com.ui.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class InvalidLogInAuthenticationTest extends BaseTest {
	
	
	private static final String INVALID_USERNAME ="sailesh@gmail.com";
	private static final String INVALID_PASSWORD ="pass123";
	
	@Test(description = "Verify Error Message is thrown on when we use the invalid credentials" , groups = {"e2e" , "sanity"})
	public void InvalidLogInCredsTest() {
		assertEquals(homePage.goToLogInPage().doLogInWithInvalidCreds(INVALID_USERNAME, INVALID_PASSWORD).getErrorMessage(),"Authentication failed.");
	}
	
	
	
	
	
	

}
