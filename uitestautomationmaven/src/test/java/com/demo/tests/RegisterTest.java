package com.demo.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.demo.base.BasePage;
import com.demo.pages.HomePage;
import com.demo.pages.LoginPage;
import com.demo.pages.RegisterPage;
import com.demo.testrailIntegration.APIException;

/*
 * Ramesh Kudikala
 */
public class RegisterTest extends BasePage {
	HomePage homePage;
	LoginPage loginPage;
  RegisterPage registerPage;
	@BeforeSuite
	public void invokeBrowser() {
		setUp();
	}

	@Test(enabled = true)
	public void Verify_if_that_user_able_to_see_Register_link_in_landing_page_and_login_page() throws IOException, APIException {
		try {
			homePage = new HomePage(driver);
			loginPage = new LoginPage(driver);
			testlog = reports.createTest("Verify_if_that_user_able_to_see_Register_link_in_landing_page_and_login_page");
			testLogPass("Verifying the Home Page Title :" +getTitle());
			assertEqual(getTitle(), "Demo Web Shop");
			testLogPass("Verifying the Register link displayed in Home page: " +homePage.isRegisterLinkDisplayed() );
			Assert.assertTrue(homePage.isRegisterLinkDisplayed());
			testLogPass("Click on Login Link");
			homePage.clickLoginLink();
			String loginTitle = loginPage.getTitle();
			testLogPass("Verify the Login Page Title : " +loginTitle );
			assertEqual(loginTitle, "Demo Web Shop. Login");
			assertTrue(homePage.isRegisterLinkDisplayed());
			testLogPass("Verifying the Register link displayed in Login Page : " +homePage.isRegisterLinkDisplayed() );
			testLogPass("Click on Logo");
			homePage.clickLogo();
		//	addResultForTestCase("18", 1, "Register test Pass");
		} catch (Exception e) {
		//	addResultForTestCase("18", 5, e.getMessage());
			testLogFail(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test(enabled = false)
	public void Verify_if_that_user_able_to_redirect_to_register_page_up_on_click() throws IOException, APIException{
		try {
			homePage = new HomePage(driver);
			loginPage = new LoginPage(driver);
			registerPage = new RegisterPage(driver);
			testlog = reports.createTest("Verify_if_that_user_able_to_redirect_to_register_page_up_on_click");
			String homePageTitle = homePage.getTitle();
			testlog.log(Status.PASS, "Verifying the Home Page Title :" +homePageTitle);
			Assert.assertEquals(homePageTitle, "Demo Web Shop");
			testlog.log(Status.PASS, "Verifying the Register link displayed in Home page: " +homePage.isRegisterLinkDisplayed() );
			Assert.assertTrue(homePage.isRegisterLinkDisplayed());
			testlog.log(Status.PASS, "Click on Register Link");
			homePage.clickRegisterLink();
			String registerTitle =registerPage.getTitle();
			Assert.assertEquals(registerTitle, "Demo Web Shop. Registr");
			homePage.clickLogo();
			addResultForTestCase("19", 1, "Register test Pass");
		} catch (AssertionError e) {
			System.out.println("=============Jumping to catch block==========");
			addResultForTestCase("19", 5, e.getMessage());
			testlog.log(Status.FAIL, e.getMessage());
		}
	}
	
	@AfterSuite
	public void closeBrowser() {
		reports.flush();
		tearDown();
	}

}
