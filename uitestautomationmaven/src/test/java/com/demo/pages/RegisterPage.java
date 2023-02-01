package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.demo.base.BasePage;

public class RegisterPage {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {

		this.driver = driver;
	}

	public String getTitle() {
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
	By emailtxt = By.id("Email");
	By registerbtn = By.id("register-button");
	By emailErrorMsg = By
			.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[2]/div[2]/div[4]/span[2]/span");
	By fristNametxt = By.id("FirstName");
	By lastNametxt = By.id("LastName");
	By passTxt = By.id("Password");
	By confirmpasstxt = By.id("ConfirmPassword");
	By genderMale = By.name("Gender");
	By registerResult = By.className("result");

	/*
	 * Name of Page Object
	 */
	String registerlnk = "Register Link";
	String emailaddress = "Enter Email Address";
	String password = "Enter Password";
	String firstName = "Enter First Name";
	String lastName = "Enter LastName";
	String registerbutton = "Click Register Button";
	String genderMalerd = "Select Gender Male";
	String confirmpass = "Enter Confirm Password";
	String registerresults = "Successfull Registration Message";

	public boolean isRegisterLinkDisplayed() {
		return driver.findElement(registerLink).isDisplayed();
	}

	public void enterEmailAddress(String email) {
		BasePage.type(emailtxt, email, emailaddress);
	}

	public void clickOnRegisterbtn() {
		BasePage.click(registerbtn, registerbutton);
	}

	public void emailErrorMessage() {
		driver.findElement(emailErrorMsg);
	}

	public void enterFirstName(String fname) {
		BasePage.type(fristNametxt, fname, firstName);
	}

	public void enterLastName(String lname) {
		BasePage.type(lastNametxt, lname, lastName);
	}

	public void enterPassword(String pass) {
		BasePage.type(passTxt, pass, password);
	}

	public void selectGender(String string) {
		BasePage.click(genderMale, string);

	}

	public void enterConfirmPass(String confirmpas) {
		BasePage.type(confirmpasstxt, confirmpas, confirmpass);

	}

	public String isRegisterSuccessfullMessageDisplayed() {
		return BasePage.getText(registerResult, registerresults);
	}
}