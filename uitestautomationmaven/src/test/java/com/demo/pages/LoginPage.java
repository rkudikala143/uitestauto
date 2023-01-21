package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demo.base.BasePage;

/*
 * Author: Srinivas Rapelli
 */
public class LoginPage {

	// create constructor
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// common methods, getTitle, getCurrentCUrl
	/*
	 * get Title of the currentPage
	 */
	public String getTitle() {
		return driver.getTitle();
	}

	/*
	 * get Current Url of the Page
	 */

	public String getCurrentPageUrl() {
		return driver.getCurrentUrl();
	}

	/*
	 * Page Objects creation
	 */
	By registerLink = By.className("ico-register");
	By loginlink = By.className("ico-login");
	By emailtxt = By.id("Email");
	By passtxt = By.id("Password");
	By loginbtn = By.cssSelector("input.button-1.login-button");
   By forgotpasswordlink = By.cssSelector("span.forgot-password a");
   By logoutlink = By.className("ico-logout");
	/*
	 * Page Methods for Page Objects
	 */

	public void clickLoginLink() {
		BasePage.click(loginlink);
	}

	public void enterEmailAddress(String email) {
		BasePage.type(emailtxt, email);
	}

	public void enterPassword(String password) {
		BasePage.type(passtxt, password);
	}

	public void clickLoginButton() {
		BasePage.submit(loginbtn);
	}
	public boolean isRegisterLinkDisplayed(){
		return driver.findElement(registerLink).isDisplayed();
	}
	
	public void clickForgotPasswordLink() {
		BasePage.click(forgotpasswordlink);
	}

	public void clickLogout() {
		// TODO Auto-generated method stub
		BasePage.click(logoutlink);
	}
}
