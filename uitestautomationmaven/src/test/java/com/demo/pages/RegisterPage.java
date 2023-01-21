package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
	
		this.driver = driver;
	}
	
	public String getTitle(){
		return driver.getTitle();
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	/* 
	 * WebElements - Page Objects
	 * 
	 */
	
	By registerLink = By.className("ico-register");
	
	
	public boolean isRegisterLinkDisplayed(){
		return driver.findElement(registerLink).isDisplayed();
	}
}
