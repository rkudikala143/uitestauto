package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	// webElements or Objects

	By loginLink = By.className("ico-login");
	By emailtxt = By.id("Email");
	By passtxt = By.id("Password");
	By loginbtn = By.cssSelector("input.button-1.login-button");
	By Logoutbtn = By.className("ico-logout");

	
	//webMethods for page objects
	
	public void clickLoginLink() {
		driver.findElement(loginLink).click();
	}
	
	public void enterEmailAddress(String email) {
		driver.findElement(emailtxt).sendKeys(email);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passtxt).sendKeys(password);
	}
	public void clickLoginButton() {
		driver.findElement(loginbtn).submit();
	}
	public void clickLogoutButton() {
		driver.findElement(Logoutbtn).click();
	}

}	

