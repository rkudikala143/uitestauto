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
   By successmsg = By.xpath("/html/body/div[4]/div[1]/div[4]/div[3]/div/div/div[2]/div[1]/h2");
   
   By emailOption = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[2]/label");
	By passwordOption = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[3]/label");
	By rememberMeOption=By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[4]/label");
	By forgotPassOption = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[4]/span/a");
	By loginButtonOption = By.cssSelector("input.button-1.login-button");
	
	
	/*
	 * Page Methods for Page Objects
	 */

	public void clickLoginLink() {
		BasePage.waitForElement(loginlink);
		BasePage.click(loginlink);
	}

	public void enterEmailAddress(String email) {
		BasePage.waitForElement(emailtxt);
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
		BasePage.waitForElement(logoutlink);
		BasePage.click(logoutlink);
	}
	public String isSuccessMsg(){
		return driver.findElement(successmsg).getText();
	}

	public boolean isForgotPasswordLinkDisplayed() {
		return driver.findElement(forgotpasswordlink).isDisplayed();
	}


	public boolean isEmailOptionDisplayed(){
		return driver.findElement(emailOption).isDisplayed();
	}
	
	public boolean isPasswordOptionDisplayed() {
		return driver.findElement(passwordOption).isDisplayed();
		
	}
	public boolean isRememberMeOptionDisplayed() {
		return driver.findElement(rememberMeOption).isDisplayed();
		
	}
	public boolean isForgotPasswordOptionDispalyed() {
		return driver.findElement(forgotPassOption).isDisplayed();
		
	}
	public boolean isLoginButtonDispalyed() {
		return driver.findElement(loginbtn).isDisplayed();
	}
	
	
}
