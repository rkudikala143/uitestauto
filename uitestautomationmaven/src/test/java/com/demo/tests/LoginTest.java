package com.demo.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.demo.base.BasePage;
import com.demo.pages.ForgotPasswordPage;
import com.demo.pages.HomePage;
import com.demo.pages.LoginPage;
import com.demo.testrailIntegration.APIException;

public class LoginTest extends BasePage {
	HomePage homePage;
	LoginPage loginPage;
	ForgotPasswordPage forgotPasswordPage;
	BasePage basePage;

	@BeforeSuite
	public void invoke() {
		setUp();
	}

	/*
	 * All Login Page Scenarios or cases to be automated
	 */
	@Test(priority = 0, enabled = false)
	public void verifyLoginFunctionalityWithValidData() throws IOException, APIException, InterruptedException {
		try {
			loginPage = new LoginPage(driver);
			// verify the title of the home page
			testlog = reports.createTest("verifyLoginFunctionalityWithValidData");
			testlog.log(Status.PASS, "Click on Login link");
			loginPage.clickLoginLink();
			// verify the login page title
			testlog.log(Status.PASS, "Enter Email address : " + prop.getProperty("email"));
			loginPage.enterEmailAddress(prop.getProperty("email"));
			testlog.log(Status.PASS, "Enter Password : " + prop.getProperty("password"));
			loginPage.enterPassword(prop.getProperty("password"));
			testlog.log(Status.PASS, "Click on Login button");
			loginPage.clickLoginButton();
			loginPage.clickLogout();
			homePage.clickLogo();
			// addResultForTestCase("538", TEST_CASE_PASSED_STATUS, "");
		} catch (AssertionError e) {
			testlog.log(Status.FAIL, e.getMessage());
			// addResultForTestCase("538", TEST_CASE_FAILED_STATUS, "");
		}
	}
	@Test(enabled = true, priority = 1)
	public void Verify_user_able_to_login_to_Xiim_by_using_Forgot_Password()
			throws IOException, APIException, InterruptedException {
		try {
			loginPage = new LoginPage(driver);
			basePage = new BasePage();
			homePage = new HomePage(driver);
			// verify the title of the home page
			testlog = reports.createTest("Verify_user_able_to_login_to_Xiim_by_using_Forgot_Password");
			testLogPass("verify the home Page title : " + getTitle());
			assertEqual("Demo Web Shop", getTitle());
			testLogPass("Click on Login link");
			loginPage.clickLoginLink();
			// verify the login page title
			testLogPass("Enter Email address : " + prop.getProperty("WrongEmail"));
			loginPage.enterEmailAddress(prop.getProperty("WrongEmail"));
			testLogPass("Click on Login button");
			loginPage.clickLoginButton();
			loginPage.isForgotPasswordLinkDisplayed();
			homePage.clickLogo();
			// addResultForTestCase("545", 1, "");
		} catch (AssertionError e) {
			testLogFail(e.getMessage());
			// addResultForTestCase("545", 5, e.getMessage());
		}
	}

	@Test(enabled = true, priority = 2)
	public void verifyUserAbleToSeeFollowingLinksIntheLoginPage() throws IOException, APIException {
		try {
			loginPage = new LoginPage(driver);
			homePage = new HomePage(driver); // verify the title of the home page
			testlog = reports.createTest("verifyUserAbleToSeeFollowingLinksIntheLoginPage");
			testLogPass("Click on Login link");
			loginPage.clickLoginLink(); // verify the login page title
			String loginTitle = loginPage.getTitle();
			testLogPass("Verify the Login Page Title : " + getTitle());
			assertEqual(getTitle(), "Demo Web Shop. Login"); // verify the links in the login page
			testLogPass("verify the links in the login page");
			assertTrue(loginPage.isRegisterLinkDisplayed());
			assertTrue(loginPage.isForgotPasswordLinkDisplayed());
			homePage.clickLogo();
			// addResultForTestCase("547", 1, "");
		} catch (Exception e) {
			testLogFail(e.getMessage());
			// addResultForTestCase("547", 5, e.getMessage());
		}
	}

	@Test(enabled = true, priority = 3)
	public void verifyIfUserAbleToSeeTheFollowingFieldsInTheLoginPage()
			throws IOException, APIException, InterruptedException {
		try {
			loginPage = new LoginPage(driver);
			// verify the title of the home page
			testlog = reports.createTest("verifyIfUserAbleToSeeTheFollowingFieldsInTheLoginPage");
			testLogPass("verify the home Page title : " + getTitle());
			assertEqual("Demo Web Shop", getTitle());
			testLogPass("Click on Login link");
			loginPage.clickLoginLink();
			// verify the login page title
			String loginTitle = loginPage.getTitle();
			testLogPass("Verify the Login Page Title : " + loginTitle);
			assertEqual(loginTitle, "Demo Web Shop. Login");
			// verify the fields in the login page
			testLogPass("verify the fields in the login page");
			loginPage.isEmailOptionDisplayed();
			loginPage.isPasswordOptionDisplayed();
			loginPage.isRememberMeOptionDisplayed();
			loginPage.isForgotPasswordOptionDispalyed();
			loginPage.isLoginButtonDispalyed();
			homePage.clickLogo();
			// addResultForTestCase("548", 1, "");
		} catch (AssertionError e) {
			testLogFail(e.getMessage());
			// addResultForTestCase("548", 5, e.getMessage());
		}
	}

	@Test(enabled = true, priority = 4)
	public void Verify_user_able_to_see_message_this_accounts_has_exceeded_the_login_attempts_and_has_been_locked()
			throws IOException, APIException, InterruptedException {
		try {
			for (int i = 1; i < 15; i++) {
				loginPage = new LoginPage(driver);
				basePage = new BasePage();
				homePage = new HomePage(driver);
				// verify the title of the home page
				testlog = reports.createTest(
						"Verify_user_able_to_see_message_this_accounts_has_exceeded_the_login_attempts_and_has_been_locked");
				String homePageTitle = homePage.getTitle();
				testLogPass("Verifying the Home Page Title :" + homePageTitle);
				Assert.assertEquals(homePageTitle, "Demo Web Shop");
				testLogPass("Click on Login link");
				loginPage.clickLoginLink(); // verify the login page title String loginTitle =
				loginPage.getTitle();
				testLogPass("Verify the Login Page Title :" + getTitle());
				assertEqual(getTitle(), "Demo Web Shop. Login");
				testLogPass("Enter Email address : " + prop.getProperty("email"));
				loginPage.enterEmailAddress(prop.getProperty("email"));
				testLogPass("Enter Password : " + prop.getProperty("wrongPass"));
				loginPage.enterPassword(prop.getProperty("wrongPass"));
				testLogPass("Click on Login button");
				loginPage.clickLoginButton();
				homePage.clickLogo();
			}
			// addResultForTestCase("545", 1, "");
		} catch (AssertionError e) {
			testLogFail(e.getMessage());
			// addResultForTestCase("545", 5, e.getMessage());
		}
	}
	
	@AfterSuite
	public void closeBrowser() {
		reports.flush();
		tearDown();
	}
}
