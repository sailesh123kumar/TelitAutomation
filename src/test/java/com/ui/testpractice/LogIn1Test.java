package com.ui.testpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogIn1Test {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.automationpractice.pl/index.php?");
		
		By signInLocator = By.xpath("//a[contains(text(),'Sign in')]");
		WebElement signInElement = driver.findElement(signInLocator);
		signInElement.click();
		
		By emailLocator = By.id("email");
		WebElement emaiElement = driver.findElement(emailLocator);
		emaiElement.sendKeys("sailesh.kumar@yahoo.com");
		
		By passwordLocator = By.id("passwd");
		WebElement passElement = driver.findElement(passwordLocator);
		passElement.sendKeys("password");
		
		By submitButtonLocator = By.id("SubmitLogin");
		WebElement submitButtonElement = driver.findElement(submitButtonLocator);
		submitButtonElement.click();
		
		
		/**
		 * 1.HardCoding
		 * 2.TestData Attached in the script
		 * 3.Duplicacy
		 * 4.NamingConvention
		 * 5.Exception Handling
		 * 6.Synchronization
		 * 7.Assertion
		 * 8.Abstraction
		 * 
		 * Your not supposed to use selenium methods directly in our code.We should create some custom/wrapper methods		
		 */
		
	}
	
}
