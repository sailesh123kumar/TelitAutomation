package com.utility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.AccountPage;
import com.ui.test.BaseTest;

@Listeners(com.ui.listener.TestListener.class)
public class SearchProductTest extends BaseTest {
	
	private AccountPage myAccountPage;
	
	@BeforeMethod
	public void setUp() {
		myAccountPage = homePage.goToLogInPage().doLogInWith("sailesh.kumar@yahoo.com", "password");
	}

	@Test(description = "verify user is able to search for a product and it displayed product matches with the search key")
	public void verifyPoductSearchtest() {
		String searchResultPageTitle = myAccountPage.searchForAProduct("Printed Summer Dress").searchResultPageTitle();
		System.out.println(searchResultPageTitle);
	}

}
