package com.ui.test;
import com.ui.pages.HomePage;
import static com.constants.Browser.*;

public class LogInPageTest {
	
	public static void main(String[] args) {
		
		HomePage homePage= new HomePage(CHROME);
		String userName = homePage.goToLogInPage().doLogInWith("sailesh.kumar@yahoo.com", "password").getUserName();
		System.out.println(userName);
		
	}

}
