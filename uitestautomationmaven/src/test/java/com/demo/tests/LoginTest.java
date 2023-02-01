package com.demo.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.demo.base.BasePage;
import com.demo.base.Homepage;
import com.demo.pages.ForgotPasswordPage;
import com.demo.pages.LoginPage;
import com.demo.testrailIntegration.APIException;

public class LoginTest extends BasePage {
	public static Homepage homePage;
	public static LoginPage loginPage;
	public static ForgotPasswordPage forgotPasswordPage;

	@BeforeSuite
	public void invoke() {
		setUp();
		homePage = new Homepage(driver);
		loginPage = new LoginPage(driver);
		forgotPasswordPage = new ForgotPasswordPage(driver);
	}

	/*
	 * All Login Page Scenarios or cases to be automated
	 */
	@Test(groups={"sanity","regression"})
	public void verifyLoginFunctionalityWithValidData() throws IOException, APIException, InterruptedException {
		try {
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
			// 1 sec
			loginPage.clickLogout();
			//addResultForTestCase("538", TEST_CASE_PASSED_STATUS, "");
		} catch (AssertionError e) {
			testlog.log(Status.FAIL, e.getMessage());
			//addResultForTestCase("538", TEST_CASE_FAILED_STATUS, "");
		}
	}
	@Test(groups={"smoke"})
	public void verify_user_should_also_have_access_to_the_Forgot_Passwordfrom_the_login_page_to_reset_the_password()
			throws IOException, APIException {
		try {

			// verify the title of the home page
			testlog = reports.createTest(
					"verify_user_should_also_have_access_to_the_Forgot_Passwordfrom_the_login_page_to_reset_the_password");
			testLogPass("verify the home Page title : " + homePage.getTitle());
			assertEqual("Demo Web Shop", homePage.getTitle());
			testLogPass("Click on Login link");
			loginPage.clickLoginLink();
			testLogPass("verify Login Page Title : " + homePage.getTitle());
			assertEqual(homePage.getTitle(), "Demo Web Shop. Login");
			testLogPass("Click on Forgot Password link");
			loginPage.clickForgotPasswordLink();
			testLogPass("Verify Forgot Password Page Title : " + homePage.getTitle());
			Assert.assertEquals(homePage.getTitle(), "Demo Web Shop. Password Recovery");
			testLogPass("Verify Forgot Password Page Header : Password recovery");
			forgotPasswordPage.verifyHeader("Password recovery");
			//homePage.clickLogo();
			//addResultForTestCase("540", TEST_CASE_PASSED_STATUS, "");
		} catch (Exception e) {
			testLogFail(e.getMessage());
		//	addResultForTestCase("540", TEST_CASE_FAILED_STATUS, "");
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void closeBrowser() {
		driver.close();
		reports.flush();
	}
}
