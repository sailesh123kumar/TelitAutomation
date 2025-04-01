package com.ui.testpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BrowserUtility;

public class LogIn2Test {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		BrowserUtility2 browserUtility = new BrowserUtility2(driver);
		
		browserUtility.maximizeWindow();
		browserUtility.goToWebsite("https://www.automationpractice.pl/index.php?");
		
		
		By signInLocator = By.xpath("//a[contains(text(),'Sign in')]");
		browserUtility.clickOn(signInLocator);
		
		By emailLocator = By.id("email");
		browserUtility.enterText(emailLocator, "sailesh.kumar@yahoo.com");
		
		By passwordLocator = By.id("passwd");
		browserUtility.enterText(passwordLocator, "password");
		
		By submitButtonLocator = By.id("SubmitLogin");
		browserUtility.clickOn(submitButtonLocator);
		
	}
	
}
