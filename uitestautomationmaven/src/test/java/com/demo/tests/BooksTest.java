package com.demo.tests;

import org.testng.Assert;
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

	// 1
	@Test(enabled = true, priority = 0)
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

	// 2
	@Test(enabled = true, priority = 1)
	public void Verify_user_able_to_click_the_books_menu_and_it_contain_the_sort_by_display_per_page_and_view_as_drop_down_bar() {
		try {
			homePage = new HomePage(driver);
			booksPage = new BooksPage(driver);
			testlog = reports.createTest(
					"Verify_user_able_to_click_the_books_menu_and_it_contain_the_sort_by_display_per_page_and_view_as_drop_down_bar");
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

	// 3
	@Test(enabled = true, priority = 2)
	public void verfy_user_able_to_click_on_books_menu() {
		homePage = new HomePage(driver);
		booksPage = new BooksPage(driver);
		testlog = reports.createTest("verfy_user_able_to_click_on_books_menu");
		testLogPass("verify the home Page title : " + getPageTitle());
		assertEqual("Demo Web Shop", getPageTitle());
		testLogPass("Books menu displyed");
		booksPage.isBooksMenuDisplayed();
		testLogPass("Click on books menu");
		booksPage.clickOnBooks();
		homePage.clickLogo();
	}

	// 4
	@Test(enabled = true, priority = 3)
	public void Verify_user_able_to_see_the_position_as_default_option_in_the_sort_by_drop_down_button() {
		try {
			homePage = new HomePage(driver);
			booksPage = new BooksPage(driver);
			testlog = reports.createTest(
					"Verify_user_able_to_see_the_position_as_default_option_in_the_sort_by_drop_down_button");
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

	// 5
	@Test(enabled = true, priority = 4)
	public void verify_following_req_fields_in_the_display_dropdown_button_on_BooksPage() throws InterruptedException {
		homePage = new HomePage(driver);
		booksPage = new BooksPage(driver);
		testlog = reports.createTest("verify_following_req_fields_in_the_display_dropdown_button_on_BooksPage");
		assertEqual(homePage.getTitle(), "Demo Web Shop");
		Assert.assertTrue(booksPage.isBooksMenuDisplayed());
		booksPage.moveToBooksMenu();
		booksPage.clickOnBooks();
		booksPage.isDisplayOptDisplayed();
		booksPage.clickOnDisplayDD();
		booksPage.is4displayed();
		booksPage.is8displayed();
		booksPage.is12displayed();
		Thread.sleep(3000);
		testLogPass("Click on Logo");
		homePage.clickLogo();
	}

	// 6
	@Test(enabled = true, priority = 5)
	public void verfy_user_able_to_see_the_filter_on_bookspage() throws InterruptedException {
		homePage = new HomePage(driver);
		booksPage = new BooksPage(driver);
		testlog = reports.createTest("verfy_user_able_to_see_the_filter_on_bookspage");
		testLogPass("verify the home Page title : " + getPageTitle());
		assertEqual("Demo Web Shop", getPageTitle());
		testLogPass("Books menu displyed");
		booksPage.isBooksMenuDisplayed();
		testLogPass("Click on books menu");
		booksPage.clickOnBooks();
		booksPage.isFilterDisplayed();
		Thread.sleep(3000);
		testLogPass("Click on Logo");
		homePage.clickLogo();
	}

	// 7
	@Test(enabled = true, priority = 6)
	public void verify_following_req_fields_in_the_viewAs_dropdown_button_on_BooksPage() throws InterruptedException {
		homePage = new HomePage(driver);
		booksPage = new BooksPage(driver);
		testlog = reports.createTest("verify_following_req_fields_in_the_viewAs_dropdown_button_on_BooksPage");
		assertEqual(homePage.getTitle(), "Demo Web Shop");
		Assert.assertTrue(booksPage.isBooksMenuDisplayed());
		booksPage.moveToBooksMenu();
		booksPage.clickOnBooks();
		booksPage.isViewAsDisplayed();
		booksPage.clickOnViewAsDD();
		booksPage.isGriddisplayed();
		booksPage.isListdisplayed();
		Thread.sleep(3000);
		testLogPass("Click on Logo");
		homePage.clickLogo();
	}

	// 8
	@Test(enabled = true, priority = 7)
	public void verfy_user_able_to_click_the_under_25_filter_on_bookspage() throws InterruptedException {
		homePage = new HomePage(driver);
		booksPage = new BooksPage(driver);
		testlog = reports.createTest("verfy_user_able_to_click_the_under_25_filter_on_bookspage");
		testLogPass("verify the home Page title : " + getPageTitle());
		assertEqual("Demo Web Shop", getPageTitle());
		testLogPass("Books menu displyed");
		booksPage.isBooksMenuDisplayed();
		testLogPass("Click on books menu");
		booksPage.clickOnBooks();
		booksPage.isFilterDisplayed();
		booksPage.clickOnUnder25();
		booksPage.isRemoveFilterDisplayed();
		Thread.sleep(3000);
		testLogPass("Click on Logo");
		homePage.clickLogo();
	}

	// 9
	@Test(enabled = true, priority = 8)
	public void verfy_user_able_to_click_the_25_50_filter_on_bookspage() throws InterruptedException {
		homePage = new HomePage(driver);
		booksPage = new BooksPage(driver);
		testlog = reports.createTest("verfy_user_able_to_click_the_25_50_filter_on_bookspage");
		testLogPass("verify the home Page title : " + getPageTitle());
		assertEqual("Demo Web Shop", getPageTitle());
		testLogPass("Books menu displyed");
		booksPage.isBooksMenuDisplayed();
		testLogPass("Click on books menu");
		booksPage.clickOnBooks();
		booksPage.isFilterDisplayed();
		booksPage.clickOnFilter25_50();
		booksPage.isRemoveFilterDisplayed();
		Thread.sleep(3000);
		testLogPass("Click on Logo");
		homePage.clickLogo();
	}

	// 10
	@Test(enabled = true, priority = 9)
	public void verfy_user_able_to_click_the_over_50_filter_on_bookspage() throws InterruptedException {
		homePage = new HomePage(driver);
		booksPage = new BooksPage(driver);
		testlog = reports.createTest("verfy_user_able_to_click_the_over_50_filter_on_bookspage");
		testLogPass("verify the home Page title : " + getPageTitle());
		assertEqual("Demo Web Shop", getPageTitle());
		testLogPass("Books menu displyed");
		booksPage.isBooksMenuDisplayed();
		testLogPass("Click on books menu");
		booksPage.clickOnBooks();
		booksPage.isFilterDisplayed();
		booksPage.clickOnOver_50();
		booksPage.isRemoveFilterDisplayed();
		Thread.sleep(3000);
		testLogPass("Click on Logo");
		homePage.clickLogo();
	}
	// 11

	@Test(enabled = true, priority = 10)
	public void verify_user_able_to_click_on_List_button_on_viewAs_dropdown_button_on_BooksPage() {
		homePage = new HomePage(driver);
		booksPage = new BooksPage(driver);
		testlog = reports.createTest("verify_user_able_to_click_on_List_button_on_viewAs_dropdown_button_on_BooksPage");
		assertEqual(homePage.getTitle(), "Demo Web Shop");
		Assert.assertTrue(booksPage.isBooksMenuDisplayed());
		booksPage.moveToBooksMenu();
		booksPage.clickOnBooks();
		booksPage.isViewAsDisplayed();
		booksPage.clickOnViewAsDD();
		booksPage.isListdisplayed();
		booksPage.clickOnList();
		testLogPass("Click on Logo");
		homePage.clickLogo();
	}

	// 12
	@Test(enabled = true, priority = 11)
	public void verify_user_able_to_click_on_Grid_button_on_viewAs_dropdown_button_on_BooksPage() {
		homePage = new HomePage(driver);
		booksPage = new BooksPage(driver);
		testlog = reports.createTest("verify_user_able_to_click_on_Grid_button_on_viewAs_dropdown_button_on_BooksPage");
		assertEqual(homePage.getTitle(), "Demo Web Shop");
		Assert.assertTrue(booksPage.isBooksMenuDisplayed());
		booksPage.moveToBooksMenu();
		booksPage.clickOnBooks();
		booksPage.isViewAsDisplayed();
		booksPage.clickOnViewAsDD();
		booksPage.isGriddisplayed();
		booksPage.clickOnGrid();
		testLogPass("Click on Logo");
		homePage.clickLogo();
	}

	// 13
	@Test(enabled = true, priority = 12)
	public void verify_user_able_to_click_on_4_button_on_display_dropdown_button_on_BooksPage()
			throws InterruptedException {
		homePage = new HomePage(driver);
		booksPage = new BooksPage(driver);
		testlog = reports.createTest("verify_user_able_to_click_on_4_button_on_display_dropdown_button_on_BooksPage");
		assertEqual(homePage.getTitle(), "Demo Web Shop");
		Assert.assertTrue(booksPage.isBooksMenuDisplayed());
		booksPage.moveToBooksMenu();
		booksPage.clickOnBooks();
		booksPage.isDisplayOptDisplayed();
		booksPage.clickOnDisplayDD();
		booksPage.is4displayed();
		booksPage.clickOnFour();
		Thread.sleep(3000);
		testLogPass("Click on Logo");
		homePage.clickLogo();
	}

	// 14
	@Test(enabled = true, priority = 13)
	public void verify_user_able_to_click_on_8_button_on_display_dropdown_button_on_BooksPage()
			throws InterruptedException {
		homePage = new HomePage(driver);
		booksPage = new BooksPage(driver);
		testlog = reports.createTest("verify_user_able_to_click_on_8_button_on_display_dropdown_button_on_BooksPage");
		assertEqual(homePage.getTitle(), "Demo Web Shop");
		Assert.assertTrue(booksPage.isBooksMenuDisplayed());
		booksPage.moveToBooksMenu();
		booksPage.clickOnBooks();
		booksPage.isDisplayOptDisplayed();
		booksPage.clickOnDisplayDD();
		booksPage.is8displayed();
		booksPage.clickOnEight();
		Thread.sleep(3000);
		testLogPass("Click on Logo");
		homePage.clickLogo();
	}

	// 15
	@Test(enabled = true, priority = 14)
	public void verify_user_able_to_click_on_12_button_on_display_dropdown_button_on_BooksPage()
			throws InterruptedException {
		homePage = new HomePage(driver);
		booksPage = new BooksPage(driver);
		testlog = reports.createTest("verify_user_able_to_click_on_12_button_on_display_dropdown_button_on_BooksPage");
		assertEqual(homePage.getTitle(), "Demo Web Shop");
		Assert.assertTrue(booksPage.isBooksMenuDisplayed());
		booksPage.moveToBooksMenu();
		booksPage.clickOnBooks();
		booksPage.isDisplayOptDisplayed();
		booksPage.clickOnDisplayDD();
		booksPage.is12displayed();
		booksPage.clickOntwelve();
		Thread.sleep(3000);
		testLogPass("Click on Logo");
		homePage.clickLogo();
	}

	// 16
	@Test(enabled = true, priority = 15)
	public void verify_user_able_to_select_a_book_on_the_BooksPage() throws InterruptedException {
		homePage = new HomePage(driver);
		booksPage = new BooksPage(driver);
		testlog = reports.createTest("verify_user_able_to_select_a_book_on_the_BooksPage");
		assertEqual(homePage.getTitle(), "Demo Web Shop");
		Assert.assertTrue(booksPage.isBooksMenuDisplayed());
		booksPage.moveToBooksMenu();
		booksPage.clickOnBooks();
		booksPage.selectABook();
		testLogPass("Click on Logo");
		homePage.clickLogo();
	}

	// 17
	@Test(enabled = true, priority = 16)
	public void verify_user_able_to_ClickOnAdd_to_cart_button_on_the_BooksPage() throws InterruptedException {
		homePage = new HomePage(driver);
		booksPage = new BooksPage(driver);
		testlog = reports.createTest("verify_user_able_to_ClickOnAdd_to_cart_button_on_the_BooksPage");
		assertEqual(homePage.getTitle(), "Demo Web Shop");
		Assert.assertTrue(booksPage.isBooksMenuDisplayed());
		booksPage.moveToBooksMenu();
		booksPage.clickOnBooks();
		booksPage.selectABook();
		booksPage.clickOnAddToCart();
		Thread.sleep(2000);
		testLogPass("Click on Logo");
		homePage.clickLogo();
	}

	// 18
	@Test(enabled = true, priority = 17)
	public void verify_user_able_to_See_the_discription_of_the_book_while_clicks_on_it() throws InterruptedException {
		homePage = new HomePage(driver);
		booksPage = new BooksPage(driver);
		testlog = reports.createTest("verify_user_able_to_See_the_discription_of_the_book_while_clicks_on_it");
		assertEqual(homePage.getTitle(), "Demo Web Shop");
		Assert.assertTrue(booksPage.isBooksMenuDisplayed());
		booksPage.moveToBooksMenu();
		booksPage.clickOnBooks();
		booksPage.selectABook();
		booksPage.isBookDiscriptionDisplayed();
		Thread.sleep(2000);
		testLogPass("Click on Logo");
		homePage.clickLogo();
	}

	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}
}