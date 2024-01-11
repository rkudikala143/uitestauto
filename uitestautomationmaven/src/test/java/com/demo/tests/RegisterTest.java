package com.demo.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.demo.base.BasePage;
import com.demo.pages.HomePage;
import com.demo.pages.LoginPage;
import com.demo.pages.RegisterPage;
import com.demo.testrailIntegration.APIException;

/*
 * Ramya Kumari
 */
public class RegisterTest extends BasePage {
	HomePage homePage;
	LoginPage loginPage;
	RegisterPage registerPage;
	@BeforeSuite
	public void invokeBrowser() {
		setUp("https://demowebshop.tricentis.com/");
	}

	@Test(priority = 0,enabled=true,description = "Verify if that user able to see Register link in landing page and login page")
	public void Verify_if_that_user_able_to_see_Register_link_in_landing_page_and_login_page()
			throws IOException, APIException {
		try {
			homePage = new HomePage(driver);
			loginPage = new LoginPage(driver);
			testlog = reports
					.createTest("Verify_if_that_user_able_to_see_Register_link_in_landing_page_and_login_page");
			assertEqual(homePage.getTitle(), "Demo Web Shop");
			Assert.assertTrue(homePage.isRegisterLinkDisplayed());
			homePage.clickLoginLink();
			String loginTitle = loginPage.getTitle();
			assertEqual(loginTitle, "Demo Web Shop. Login");
			assertTrue(homePage.isRegisterLinkDisplayed());
			testLogPass("Click on Logo");
			homePage.clickLogo();
			// addResultForTestCase("1", 1, "");
		} catch (Exception e) {
			// addResultForTestCase("1", 5, e.getMessage());
			testLogFail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test(priority = 1,enabled=true,description = "Verify_if_that_user_able_to_redirect_to_register_page_up_on_click")
	public void Verify_if_that_user_able_to_redirect_to_register_page_up_on_click() throws IOException, APIException {
		try {
			homePage = new HomePage(driver);
			loginPage = new LoginPage(driver);
			registerPage = new RegisterPage(driver);
			testlog = reports.createTest("Verify_if_that_user_able_to_redirect_to_register_page_up_on_click");
			assertEqual(driver.getTitle(), "Demo Web Shop");
			homePage.clickRegisterLink();
			assertEqual(getPageTitle(), "Demo Web Shop. Register");
			homePage.clickLogo();
			// addResultForTestCase("2", 1, "");
		} catch (AssertionError e) {
			System.out.println("=============Jumping to catch block==========");
			// addResultForTestCase("2", 5, e.getMessage());
			testlog.log(Status.FAIL, e.getMessage());
		}
	}
	@DataProvider(name = "Email")
	public Object[][] InvalidEmail() {
		return new Object[][] { { "RAMYAkumari@gmail" }};
		}

	@Test(priority = 2,enabled=true,dataProvider = "Email",description = "Verify_user_enter_invalid_email_system_throw_the_error_msg")
	public void Verify_user_enter_invalid_email_system_throw_the_error_msg(String email) throws IOException, APIException {
		try {
			homePage = new HomePage(driver);
			loginPage = new LoginPage(driver);
			registerPage = new RegisterPage(driver);
			testlog = reports.createTest("Verify_user_enter_invalid_email_system_throw_the_error_msg");
			assertEqual(driver.getTitle(), "Demo Web Shop");
			homePage.clickRegisterLink();
			assertEqual(getPageTitle(), "Demo Web Shop. Register");
			registerPage.enterEmailAddress(email);
			registerPage.clickOnRegisterbtn();
			assertEqual(registerPage.isEmailErrorMessageDisplayed(), "Wrong email");
			homePage.clickLogo();
			// addResultForTestCase("7", 1, "Register test Pass");
		} catch (AssertionError e) {
			System.out.println("=============Jumping to catch block==========");
			// addResultForTestCase("7", 5, e.getMessage());
			testlog.log(Status.FAIL, e.getMessage());
		}
	}

	@DataProvider(name = "A-Z")
	public Object[][] FnameLname() {
		return new Object[][] { { "RAMYAkumari","ramyaKUMARI" }};
		}
	
	@Test(priority = 3,enabled=true,dataProvider = "A-Z",description = "Verify_system_allow_to_enter_AZ_and_az_into_FirstName_and_LastName_field")
	public void Verify_system_allow_to_enter_AZ_and_az_into_FirstName_and_LastName_field(String fname,String lname)
			throws IOException, APIException {
		try {
			homePage = new HomePage(driver);
			loginPage = new LoginPage(driver);
			registerPage = new RegisterPage(driver);
			testlog = reports.createTest("verifyIfUserAbleToRegisterToAppWithValidData");
			assertEqual(driver.getTitle(), "Demo Web Shop");
			homePage.clickRegisterLink();
			assertEqual(getPageTitle(), "Demo Web Shop. Register");
			registerPage.enterFirstName(fname);
			registerPage.enterLastName(lname);
			homePage.clickLogo();
			// addResultForTestCase("8", 1, "Register test Pass");
		} catch (AssertionError e) {
			System.out.println("=============Jumping to catch block==========");
			// addResultForTestCase("8", 5, e.getMessage());
			testlog.log(Status.FAIL, e.getMessage());
		}
	}

	@DataProvider(name = "passUl")
	public Object[][] UpperLower() {
		return new Object[][] { { "PASSword" }};
		}
	@Test(priority = 4,enabled=true,dataProvider="passUl",description = "Verify_System_allows_to_enter_1uppercase_or_1_lowercase_in_password")
	public void Verify_System_allows_to_enter_1uppercase_or_1_lowercase_in_password(String pass) throws IOException, APIException {
		try {
			homePage = new HomePage(driver);
			loginPage = new LoginPage(driver);
			registerPage = new RegisterPage(driver);
			testlog = reports.createTest("Verify_System_allows_to_enter_1uppercase_or_1_lowercase_in_password");
			assertEqual(driver.getTitle(), "Demo Web Shop");
			homePage.clickRegisterLink();
			assertEqual(getPageTitle(), "Demo Web Shop. Register");
			registerPage.enterPassword(pass);
			homePage.clickLogo();
			// addResultForTestCase("9", 1, "Register test Pass");
		} catch (AssertionError e) {
			System.out.println("=============Jumping to catch block==========");
			// addResultForTestCase("9", 5, e.getMessage());
			testlog.log(Status.FAIL, e.getMessage());
		}
	}

	@DataProvider(name = "passErr")
	public Object[][] errorMsg() {
		return new Object[][] { { "First" }};
		}
	@Test(priority = 5,dataProvider = "passErr",enabled=true,description = "Verify_system_allow_to_enter_password_min_length_should_be_6_characters")
	public void Verify_system_allow_to_enter_password_min_length_should_be_6_characters(String pass)
			throws IOException, APIException {
		try {
			homePage = new HomePage(driver);
			loginPage = new LoginPage(driver);
			registerPage = new RegisterPage(driver);
			testlog = reports.createTest(" Verify_system_allow_to_enter_password_min_length_should_be_6_characters");
			assertEqual(driver.getTitle(), "Demo Web Shop");
			homePage.clickRegisterLink();
			assertEqual(getPageTitle(), "Demo Web Shop. Register");
			registerPage.enterPassword(pass);
			registerPage.clickOnRegisterbtn();
			assertEqual(registerPage.isPasswordErrorMessageDisplayed(), "The password should have at least 6 characters.");
			homePage.clickLogo();
		} catch (AssertionError e) {
			// addResultForTestCase("10", 5, e.getMessage());
			testlog.log(Status.FAIL, e.getMessage());
		}
	}

	@DataProvider(name = "registervalid")
	public Object[][] validUser() {
		return new Object[][] { { "FirstName1", "LastName1", "emailadddres1@gmail.com", "testpass" },
				{ "FirstName2", "LastName2", "emailadddres3@gmail.com", "testpass" },
				{ "FirstName3", "LastName3", "emailadddres4@gmail.com", "testpass" } };
	}

	@Test(dataProvider = "registervalid",enabled=false)
	public void verifyIfUserAbleToRegisterToAppWithValidData(String fname, String lname, String email, String pass) {
		try {
			homePage = new HomePage(driver);
			loginPage = new LoginPage(driver);
			registerPage = new RegisterPage(driver);
			testlog = reports.createTest("verifyIfUserAbleToRegisterToAppWithValidData");
			assertEqual(driver.getTitle(), "Demo Web Shop");
			homePage.clickRegisterLink();
			assertEqual(getPageTitle(), "Demo Web Shop. Register");
			registerPage.selectGender("Male");
			registerPage.enterFirstName(fname);
			registerPage.enterLastName(lname);
			registerPage.enterEmailAddress(email);
			registerPage.enterPassword(pass);
			registerPage.enterConfirmPass(pass);
			registerPage.clickOnRegisterbtn();
			assertEqual(registerPage.isRegisterSuccessfullMessageDisplayed(), "Your registration completed");
			homePage.clickLogout();
		} catch (AssertionError e) {
			testLogFail(e.getMessage());
		}
		
	}
	@AfterSuite
	public void closeBrowser() {
		driver.close();
	}
}
