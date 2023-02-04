package com.demo.tests;



import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.demo.base.BasePage;
import com.demo.pages.BooksPage;
import com.demo.pages.HomePage;

public class BooksTest extends BasePage {
	BasePage basePage;
	HomePage homePage;
	BooksPage booksPage;
	
	@BeforeSuite
	public void invokeBrowser() {
		setUp();
	}
	@Test(enabled = true,priority = 0)
	public void Verify_user_able_to_see_the_books_menu_in_the_dashboard_page() {
		try {
			homePage = new HomePage(driver);
			booksPage = new BooksPage(driver);
			testlog = reports.createTest("Verify_user_able_to_see_the_books_menu_in_the_dashboard_page");
			testLogPass("verify the home Page title : " + getPageTitle());
			assertEqual("Demo Web Shop", getPageTitle());
			testLogPass("Books menu displyed");
			booksPage.isBooksMenuDisplayed();
			homePage.clickLogo();
		} catch (AssertionError e) {
			e.printStackTrace();
		}
	}
	@Test (enabled=true,priority = 1)
	public void Verify_user_able_to_click_the_books_menu_and_it_contain_the_sort_by_display_per_page_and_view_as_drop_down_bar() {
		try {
			homePage = new HomePage(driver);
			booksPage = new BooksPage(driver);
			testlog = reports.createTest("Verify_user_able_to_click_the_books_menu_and_it_contain_the_sort_by_display_per_page_and_view_as_drop_down_bar");
			testLogPass("verify the home Page title : " + getPageTitle());
			assertEqual("Demo Web Shop", getPageTitle());
			booksPage.isBooksMenuDisplayed();
			testLogPass("Click on books menu");
            booksPage.clickOnBooks();
			testLogPass("navigates to books page");
			booksPage.isSortByDisplayed();
			 booksPage.isDisplayOptDisplayed();
			 booksPage.isViewAsDisplayed();
			 homePage.clickLogo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test (enabled=true,priority = 2)
	public void Verify_user_able_to_see_the_position_as_default_option_in_the_sort_by_drop_down_button() {
	try {
		homePage = new HomePage(driver);
		booksPage = new BooksPage(driver);
		testlog = reports.createTest("Verify_user_able_to_click_the_books_menu_and_it_contain_the_sort_by_display_per_page_and_view_as_drop_down_bar");
		testLogPass("verify the home Page title : " + getPageTitle());
		assertEqual("Demo Web Shop", getPageTitle());
		testLogPass("Books menu displyed");
		booksPage.isBooksMenuDisplayed();
		testLogPass("Click on books menu");
		 booksPage.clickOnBooks();
		testLogPass("navigates to books page");
		booksPage.isSortByDisplayed();
		booksPage.isPositionOptDisplayed();
		homePage.clickLogo();
		} catch (AssertionError e) {
			e.printStackTrace();
		}
	}
	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}

	
}