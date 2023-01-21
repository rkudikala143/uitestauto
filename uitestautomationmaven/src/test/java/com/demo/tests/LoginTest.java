package com.demo.tests;

import java.io.IOException;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.demo.base.BasePage;
import com.demo.base.Homepage;
import com.demo.pages.ForgotPasswordPage;
import com.demo.pages.LoginPage;
import com.demo.testrailIntegration.APIException;

public class LoginTest extends BasePage {
  Homepage homePage;
	LoginPage loginPage;
	ForgotPasswordPage forgotPasswordPage;
	@BeforeSuite
	public void invoke() {
		setUp();
	}
	/*
	 * All Login Page Scenarios or cases to be automated
	 */
	@Test (priority = 0)
	public void verifyLoginFunctionalityWithValidData() throws IOException, APIException {
		try {
			loginPage = new LoginPage(driver);
			//verify the title of the home page
			testlog = reports.createTest("verifyLoginFunctionalityWithValidData");
			testlog.log(Status.PASS, "Click on Login link");
			loginPage.clickLoginLink();
			//verify the login page title
			testlog.log(Status.PASS, "Enter Email address : "+ prop.getProperty("email"));
			loginPage.enterEmailAddress(prop.getProperty("email"));
			testlog.log(Status.PASS, "Enter Password : "+ prop.getProperty("password"));
			loginPage.enterPassword(prop.getProperty("password"));
			testlog.log(Status.PASS, "Click on Login button");
			loginPage.clickLoginButton();
			loginPage.clickLogout();
		  //  addResultForTestCase("42", TEST_CASE_PASSED_STATUS, "");
		} catch (AssertionError e) {
			testlog.log(Status.FAIL, e.getMessage());
		//	addResultForTestCase("8", TEST_CASE_FAILED_STATUS, "");
		}
	}
	
	@Test(priority = 1)
	public void verify_user_should_also_have_access_to_the_Forgot_Passwordfrom_the_login_page_to_reset_the_password() {
	try {
		homePage = new Homepage(driver);
		loginPage = new LoginPage(driver);
		forgotPasswordPage = new ForgotPasswordPage(driver);
		
		//verify the title of the home page
		testlog = reports.createTest("verify_user_should_also_have_access_to_the_Forgot_Passwordfrom_the_login_page_to_reset_the_password");
		testLogPass("verify the home Page title : "+ getTitle());
		assertEqual("Demo Web Shop", getTitle());
		testLogPass("Click on Login link");
		loginPage.clickLoginLink();
		testLogPass("verify Login Page Title : "+ getTitle());
		assertEqual(getTitle(), "Demo Web Shop. Login");
		testLogPass( "Click on Forgot Password link");
		loginPage.clickForgotPasswordLink();
		testLogPass("Verify Forgot Password Page Title : " + getTitle());
		Assert.assertEquals(getTitle(), "Demo Web Shop. Password Recovery");
		testLogPass( "Verify Forgot Password Page Header : Password recovery");
		forgotPasswordPage.verifyHeader("Password recovery");
		homePage.clickLogo();
	} catch (Exception e) {
	      testLogFail(e.getMessage());
	      e.printStackTrace();
	}
	}
	
	@AfterSuite
	public void closeBrowser() {
		reports.flush();
		tearDown();
	}
}
