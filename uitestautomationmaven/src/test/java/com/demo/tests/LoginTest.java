package com.demo.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.demo.base.BasePage;
import com.demo.base.Homepage;
import com.demo.pages.ForgotPasswordPage;
import com.demo.pages.HomePage;
import com.demo.pages.LoginPage;
import com.demo.pages.RegisterPage;
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
	
	@Test(groups={"sanity","regression"},enabled=false)
	public void verifyLoginFunctionalityWithValidData() throws IOException, APIException, InterruptedException 
	{
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
	
	@Test(groups={"smoke"},enabled=false)
	public void verify_user_should_also_have_access_to_the_Forgot_Passwordfrom_the_login_page_to_reset_the_password()
			throws IOException, APIException 
	{
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

	/*@Test(dataProvider = "registervalid")
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
	}*/
	
	@Test(enabled=true,priority=0)
	public void verify_if_the_user_able_to_see_the_following_credentials_on_the_loginPage()
	{
		try {
			//email,password,forgot password ,login,register
			
			testlog = reports.createTest("verify_if_the_user_able_to_see_the_following_credentials_on_the_loginPage");
			assertEqual(driver.getTitle(), "Demo Web Shop");
			loginPage.clickLoginLink();
			testLogPass("Login fields are displayed");
			loginPage.isEmailDisplayed();
			loginPage.ispasswordDisplayed();
			loginPage.isloginbtnDisplayed();
			loginPage.isforgotpasswordDisplayed();
			loginPage.isRegisterLinkDisplayed();
			loginPage.clickLogout();
			homePage.clickLogo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(enabled=true,priority=1)
	public void  verify_that_user_able_to_see_the_login_link_on_the_dashboard_page() {
		try {
			testlog = reports.createTest("verify_that_user_able_to_see_the_login_link_on_the_dashboard_page");
			assertEqual(driver.getTitle(), "Demo Web Shop");
			testLogPass("Login link displayed on the dashboard");
			homePage.isloginLinkDisplayed();
			//loginPage.clickLogout();
			homePage.clickLogo();
		}catch (Exception e) {
			e.printStackTrace();}
		}
	
	@Test(enabled=true,priority=2)
	public void verify_that_when_the_user_clicked_on_login_link_the_login_page_should_display() {
		try {
			testlog = reports.createTest("verify_that_when_the_user_clicked_on_login_link_the_login_page_should_display");
			assertEqual(driver.getTitle(), "Demo Web Shop");
			loginPage.clickLoginLink();
			testLogPass("User is redirected to login page");
			assertEqual("Demo Web Shop. Login", getPageTitle());
			homePage.clickLogo();
			//loginPage.clickLogout();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(enabled=true,priority=3)
	public void verify_that_user_able_to_see_watermarks_in_the_required_fields_in_the_login_page() {
		try {
			testlog = reports.createTest("verify_that_user_able_to_see_watermarks_in_the_required_fields_in_the_login_page");
			assertEqual(driver.getTitle(), "Demo Web Shop");
			loginPage.clickLoginLink();
			testLogPass("Login fields are displayed");
			loginPage.isEmailDisplayed();
			loginPage.ispasswordDisplayed();
			//loginPage.clickLogout();
			homePage.clickLogo();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@DataProvider(name = "loginvalid")
	public Object[][] validUser() {
		return new Object[][] { {"emailadddres1@gmail.com", "testpass" },
				{  "emailadddres3@gmail.com", "testpass" },
				{ "emailadddres4@gmail.com", "testpass" } };
	}
	
	@Test(dataProvider = "loginvalid",enabled=true,priority=4)
	public void verify_that_user_able_to_enter_the_data_into_the_required_fields_in_login_page(String email,String password) 
	{
		try {
			loginPage = new LoginPage(driver);
			testlog = reports.createTest("verify_that_user_able_to_enter_the_data_into_the_required_fields_in_login_page");
			assertEqual(driver.getTitle(), "Demo Web Shop");
			loginPage.clickLoginLink();
			testLogPass("User is redirected to login page");
			assertEqual("Demo Web Shop. Login", getPageTitle());
			loginPage.enterEmailAddress(email);
			loginPage.enterPassword(password);
			homePage.clickLogo();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(enabled=true,priority=5)
	public void verify_that_user_able_to_login_without_entering_the_data_in_the_required_fields_in_login_page() {
		try {
			testlog = reports.createTest("verify_that_user_able_to_login_without_entering_the_data_in_the_required_fields_in_login_page");
			assertEqual(driver.getTitle(), "Demo Web Shop");
			loginPage.clickLoginLink();
			testLogPass("User is redirected to login page");
			assertEqual("Demo Web Shop. Login", getPageTitle());
			loginPage.clickLoginButton();
			loginPage.emptyloginerrormsg();
			homePage.clickLogo();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*@Test
	public void Verify_that_user_able_to_see_the_background_image_or_logo_of_the_company() {
		try {
			testlog = reports.createTest("Verify_that_user_able_to_see_the_background_image_or_logo_of_the_company");
			assertEqual(driver.getTitle(), "Demo Web Shop");
			
		}catch (AssertionError e) {
			testLogFail(e.getMessage());}
	}*/
	
	@AfterSuite
	public void closeBrowser() {
		driver.close();
		reports.flush();
	}
}
