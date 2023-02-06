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

	@Test(enabled=false,description = "Verify if that user able to see Register link in landing page and login page")
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

	@Test(enabled=false)
	public void Verify_if_that_user_able_to_redirect_to_register_page_up_on_click() throws IOException, APIException {
		try {
			homePage = new HomePage(driver);
			loginPage = new LoginPage(driver);
			registerPage = new RegisterPage(driver);
			testlog = reports.createTest("Verify_if_that_user_able_to_redirect_to_register_page_up_on_click");
			String homePageTitle = homePage.getTitle();
			assertEqual(homePageTitle, "Demo Web Shop");
			assertTrue(homePage.isRegisterLinkDisplayed());
			homePage.clickRegisterLink();
			String registerTitle = registerPage.getTitle();
			assertEqual(registerTitle, "Demo Web Shop. Registr");
			homePage.clickLogo();
			// addResultForTestCase("2", 1, "");
		} catch (AssertionError e) {
			System.out.println("=============Jumping to catch block==========");
			// addResultForTestCase("2", 5, e.getMessage());
			testlog.log(Status.FAIL, e.getMessage());
		}
	}

	@Test(enabled=false)
	public void Verify_user_enter_invalid_email_system_throw_the_error_msg() throws IOException, APIException {
		try {
			homePage = new HomePage(driver);
			loginPage = new LoginPage(driver);
			registerPage = new RegisterPage(driver);
			testlog = reports.createTest("Verify_user_enter_invalid_email_system_throw_the_error_msg");
			String homePageTitle = homePage.getTitle();
			assertEqual(homePageTitle, "Demo Web Shop");
			assertTrue(homePage.isRegisterLinkDisplayed());
			homePage.clickRegisterLink();
			String registerTitle = registerPage.getTitle();
			assertEqual(registerTitle, "Demo Web Shop. Register");
			registerPage.enterEmailAddress(prop.getProperty("email_1"));
			registerPage.clickOnRegisterbtn();
			registerPage.emailErrorMessage();
			String errorEmailMsg = driver
					.findElement(By.xpath(
							"/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[2]/div[2]/div[4]/span[2]/span"))
					.getText();
			Assert.assertEquals(errorEmailMsg, "Wrong email");
			homePage.clickLogo();
			// addResultForTestCase("7", 1, "Register test Pass");
		} catch (AssertionError e) {
			System.out.println("=============Jumping to catch block==========");
			// addResultForTestCase("7", 5, e.getMessage());
			testlog.log(Status.FAIL, e.getMessage());
		}
	}

	@Test(enabled=false)
	public void Verify_system_allow_to_enter_AZ_and_az_into_FirstName_and_LastName_field()
			throws IOException, APIException {
		try {
			homePage = new HomePage(driver);
			loginPage = new LoginPage(driver);
			registerPage = new RegisterPage(driver);
			testlog = reports.createTest("Verify_system_allow_to_enter_AZ_and_az_into_FirstName_and_LastName_field");
			String homePageTitle = homePage.getTitle();

			assertEqual(homePageTitle, "Demo Web Shop");

			assertTrue(homePage.isRegisterLinkDisplayed());
			homePage.clickRegisterLink();
			String registerTitle = registerPage.getTitle();
			assertEqual(registerTitle, "Demo Web Shop. Register");
			registerPage.enterFirstName(prop.getProperty("firstName"));
			registerPage.enterLastName(prop.getProperty("lastName"));
			homePage.clickLogo();
			// addResultForTestCase("8", 1, "Register test Pass");
		} catch (AssertionError e) {
			System.out.println("=============Jumping to catch block==========");
			// addResultForTestCase("8", 5, e.getMessage());
			testlog.log(Status.FAIL, e.getMessage());
		}
	}

	@Test(enabled=false)
	public void Verify_System_allows_to_enter_1uppercase_or_1_lowercase() throws IOException, APIException {
		try {
			homePage = new HomePage(driver);
			loginPage = new LoginPage(driver);
			registerPage = new RegisterPage(driver);
			testlog = reports.createTest("Verify_System_allows_to_enter_1uppercase_or_1_lowercase");
			String homePageTitle = homePage.getTitle();
			testlog.log(Status.PASS, "Verifying the Home Page Title :" + homePageTitle);
			assertEqual(homePageTitle, "Demo Web Shop");
			testLogPass("Verifying the Register link displayed in Home page: " + homePage.isRegisterLinkDisplayed());
			assertTrue(homePage.isRegisterLinkDisplayed());

			homePage.clickRegisterLink();
			String registerTitle = registerPage.getTitle();
			assertEqual(registerTitle, "Demo Web Shop. Register");
			registerPage.enterPassword(prop.getProperty("Password"));
			homePage.clickLogo();
			// addResultForTestCase("9", 1, "Register test Pass");
		} catch (AssertionError e) {
			System.out.println("=============Jumping to catch block==========");
			// addResultForTestCase("9", 5, e.getMessage());
			testlog.log(Status.FAIL, e.getMessage());
		}
	}

	@Test(enabled=false)
	public void Verify_system_allow_to_enter_password_min_length_should_be_6_characters()
			throws IOException, APIException {
		try {
			homePage = new HomePage(driver);
			loginPage = new LoginPage(driver);
			registerPage = new RegisterPage(driver);
			testlog = reports.createTest("Verify_system_allow_to_enter_password_min_length_should_be_6_characters");
			String homePageTitle = homePage.getTitle();

			assertEqual(homePageTitle, "Demo Web Shop");
			testLogPass("Verifying the Register link displayed in Home page: " + homePage.isRegisterLinkDisplayed());
			assertTrue(homePage.isRegisterLinkDisplayed());

			homePage.clickRegisterLink();
			String registerTitle = registerPage.getTitle();
			assertEqual(registerTitle, "Demo Web Shop. Register");
			registerPage.enterPassword(prop.getProperty("Password_1"));
			testLogPass("Password allows min 6 characters ");
			registerPage.clickOnRegisterbtn();
			String errorPassMsg = driver
					.findElement(By.xpath(
							"/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[3]/div[2]/div[1]/span[2]/span"))
					.getText();
			Assert.assertEquals(errorPassMsg, "The password should have at least 6 characters.");
			homePage.clickLogo();
			// addResultForTestCase("10", 1, "Register test Pass");
		} catch (AssertionError e) {
			System.out.println("=============Jumping to catch block==========");
			// addResultForTestCase("10", 5, e.getMessage());
			testlog.log(Status.FAIL, e.getMessage());
		}
	}

	@DataProvider(name = "registervalid")
	public Object[][] validUser() {
		return new Object[][] { { "FirstName1", "LastName1", "emailadddres11@gmail.com", "testpass" },
				{ "FirstName2", "LastName2", "emailadddres31@gmail.com", "testpass" },
				{ "FirstName3", "LastName3", "emailadddres41@gmail.com", "testpass" } };
	}

	@Test(dataProvider = "registervalid")
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

}