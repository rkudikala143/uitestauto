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

	public LoginPage(WebDriver driver)
    {
		this.driver = driver;
	}

	// common methods, getTitle, getCurrentCUrl
	/*
	 * get Title of the currentPage
	 */
	public String getTitle() 
	{
		return driver.getTitle();
	}

	/*
	 * get Current Url of the Page
	 */

	public String getCurrentPageUrl()
	{
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
    
     By emptyloginerror=By.xpath("//*[@class='validation-summary-errors']");
	/*
	 * Page Methods for Page Objects
	 */
   
   /*
    * Page object Names
    */
   
 String loginLink =" Click Login link";
 String emailadd  ="Enter Email address";
 String pass = "Enter Password";
 String loginbutton = "Click Login button";
 String forgotPasslink ="Click on Forgot Password link";
 String logoutLink = "Click Logout Link";
 
	public void clickLoginLink()
	{
		BasePage.waitForElement(loginlink);
		BasePage.click(loginlink, loginLink);
	}

	public void enterEmailAddress(String email)
	{
		BasePage.waitForElement(emailtxt);
		BasePage.type(emailtxt, email,emailadd);
	}

	public void enterPassword(String password)
	{
		BasePage.type(passtxt, password, pass);
	}

	public void clickLoginButton() 
	{
		BasePage.submit(loginbtn, loginbutton);
	}
	
	public boolean isRegisterLinkDisplayed()
	{
		return driver.findElement(registerLink).isDisplayed();
	}
	
	public void clickForgotPasswordLink()
	{
		BasePage.click(forgotpasswordlink, forgotPasslink);
	}

	public void clickLogout()
	{
		BasePage.waitForElement(logoutlink);
		BasePage.click(logoutlink, logoutLink);
	}
	
	public boolean isEmailDisplayed() {
		   return driver.findElement(emailtxt).isDisplayed();
		}
	
	public boolean ispasswordDisplayed() {
		   return driver.findElement(passtxt).isDisplayed();
		}
	
	public boolean isloginbtnDisplayed() {
		   return driver.findElement(loginbtn).isDisplayed();
		}

	public boolean isforgotpasswordDisplayed() {
		   return driver.findElement(forgotpasswordlink).isDisplayed();
		}
	public void emptyloginerrormsg() 
	{
		driver.findElement(emptyloginerror);
	}
}
