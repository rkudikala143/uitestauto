package com.demo.tests;

import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.demo.base.BasePage;
import com.demo.pages.LoginPage;
import com.demo.testrailIntegration.APIException;

public class LoginTest extends BasePage {

	LoginPage loginPage;
	@BeforeSuite
	public void invoke() {
		setUp();
	}
	/*
	 * All Login Page Scenarios or cases to be automated
	 */
	@Test
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
		    addResultForTestCase("42", TEST_CASE_PASSED_STATUS, "");
		} catch (AssertionError e) {
			testlog.log(Status.FAIL, e.getMessage());
			addResultForTestCase("8", TEST_CASE_FAILED_STATUS, "");
		}
	}
	
	
	@AfterSuite
	public void closeBrowser() {
		reports.flush();
		tearDown();
	}
}
