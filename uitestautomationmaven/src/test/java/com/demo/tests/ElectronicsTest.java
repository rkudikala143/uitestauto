package com.demo.tests;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.demo.base.BasePage;
import com.demo.pages.ElectronicsPage;
import com.demo.pages.HomePage;
public class ElectronicsTest extends BasePage {
	HomePage homePage;
	ElectronicsPage electronicsPage;
	@BeforeSuite
	public void invoke() {
		setUp();
	}
	// 1
	@Test(enabled = true,priority = 0)
	public void verify_user_able_to_see_the_electronics_menu_on_the_dashboard_page() throws InterruptedException {
		homePage = new HomePage(driver);
		electronicsPage = new ElectronicsPage(driver);
		testlog = reports.createTest("verify_user_able_to_see_the_electronics_menu_on_the_dashboard_page");
		assertEqual(homePage.getTitle(), "Demo Web Shop");
		Assert.assertTrue(electronicsPage.isElectronicsLinkDisplayed());
		Thread.sleep(3000);
		testLogPass("Click on Logo");
		homePage.clickLogo();
	}
	// 2
	@Test(enabled = true,priority = 1)
	public void verify_user_able_to_see_the_features_in_the_electronics_menu_dropdown() throws InterruptedException {
		homePage = new HomePage(driver);
		electronicsPage = new ElectronicsPage(driver);
		testlog = reports.createTest("verify_user_able_to_see_the_electronics_menu_on_the_dashboard_page");
		assertEqual(homePage.getTitle(), "Demo Web Shop");
		Assert.assertTrue(electronicsPage.isElectronicsLinkDisplayed());
		electronicsPage.clickOnElectronicLink();
		electronicsPage.isCameraDisplayed();
		electronicsPage.isPhoneDisplayed();
		Thread.sleep(3000);
		testLogPass("Click on Logo");
		homePage.clickLogo();
	}
	// 3
	@Test(enabled = true,priority =2)
	public void verify_user_able_to_see_camera_photo_page_when_click_on_the_cameraPhoto_link() {
		homePage = new HomePage(driver);
		electronicsPage = new ElectronicsPage(driver);
		testlog = reports.createTest("verify_user_able_to_see_camera_photo_page_when_click_on_the_cameraPhoto_link");
		assertEqual(homePage.getTitle(), "Demo Web Shop");
		Assert.assertTrue(electronicsPage.isElectronicsLinkDisplayed());
		electronicsPage.moveToEleMenu();
		electronicsPage.clickOnCamera();
		testLogPass("Click on Logo");
		homePage.clickLogo();
	}
	// 4
	@Test(enabled = true,priority = 3)
	public void verify_following_req_fields_in_the_sort_by_button_on_cameraPage() throws InterruptedException {
		homePage = new HomePage(driver);
		electronicsPage = new ElectronicsPage(driver);
		testlog = reports.createTest("verify_following_req_fields_in_the_sort_by_button_on_cameraPage");
		assertEqual(homePage.getTitle(), "Demo Web Shop");
		Assert.assertTrue(electronicsPage.isElectronicsLinkDisplayed());
		electronicsPage.moveToEleMenu();
		electronicsPage.clickOnCamera();
		electronicsPage.isSortByDisplayed();
		electronicsPage.clickOnSortByDD();
		electronicsPage.ispositiondisplayed();
		electronicsPage.isA_Zdisplayed();
		electronicsPage.isZ_Adisplayed();
		electronicsPage.isL_Hdisplayed();
		electronicsPage.isH_Ldisplayed();
		electronicsPage.isCreatedOndisplayed();
		Thread.sleep(3000);
		testLogPass("Click on Logo");
		homePage.clickLogo();
	}
	// 5
	@Test(enabled = true,priority = 4)
	public void verify_following_req_fields_in_the_display_dropdown_button_on_cameraPage() throws InterruptedException {
		homePage = new HomePage(driver);
		electronicsPage = new ElectronicsPage(driver);
		testlog = reports.createTest("verify_following_req_fields_in_the_sort_by_button_on_cameraPage");
		assertEqual(homePage.getTitle(), "Demo Web Shop");
		Assert.assertTrue(electronicsPage.isElectronicsLinkDisplayed());
		electronicsPage.moveToEleMenu();
		electronicsPage.clickOnCamera();
		electronicsPage.isDisplayDisplayed();
		electronicsPage.clickOnDisplayDD();
		electronicsPage.is4displayed();
		electronicsPage.is8displayed();
		electronicsPage.is12displayed();
		Thread.sleep(3000);
		testLogPass("Click on Logo");
		homePage.clickLogo();
	}
	// 6
	@Test(enabled = true,priority = 5)
	public void verify_following_req_fields_in_the_viewAs_dropdown_button_on_cameraPage() throws InterruptedException {
		homePage = new HomePage(driver);
		electronicsPage = new ElectronicsPage(driver);
		testlog = reports.createTest("verify_following_req_fields_in_the_viewAs_dropdown_button_on_cameraPage");
		assertEqual(homePage.getTitle(), "Demo Web Shop");
		Assert.assertTrue(electronicsPage.isElectronicsLinkDisplayed());
		electronicsPage.moveToEleMenu();
		electronicsPage.clickOnCamera();
		electronicsPage.isViewAsDisplayed();
		electronicsPage.clickOnViewAsDD();
		electronicsPage.isGriddisplayed();
		electronicsPage.isListdisplayed();
		Thread.sleep(3000);
		testLogPass("Click on Logo");
		homePage.clickLogo();
	}
	// 7
	@Test(enabled = true,priority = 6)
	public void verify_user_able_to_see_phone_page_when_click_on_the_Phone_link() {
		homePage = new HomePage(driver);
		electronicsPage = new ElectronicsPage(driver);
		testlog = reports.createTest("verify_user_able_to_see_phone_page_when_click_on_the_Phone_link");
		assertEqual(homePage.getTitle(), "Demo Web Shop");
		Assert.assertTrue(electronicsPage.isElectronicsLinkDisplayed());
		electronicsPage.moveToEleMenu();
		electronicsPage.clickOnPhone();
		testLogPass("Click on Logo");
		homePage.clickLogo();
	}
	// 8
	@Test(enabled = true,priority =7)
	public void verify_following_req_fields_in_the_display_dropdown_button_on_phonePage() throws InterruptedException {
		homePage = new HomePage(driver);
		electronicsPage = new ElectronicsPage(driver);
		testlog = reports.createTest("verify_following_req_fields_in_the_display_dropdown_button_on_phonePage");
		assertEqual(homePage.getTitle(), "Demo Web Shop");
		Assert.assertTrue(electronicsPage.isElectronicsLinkDisplayed());
		electronicsPage.moveToEleMenu();
		electronicsPage.clickOnPhone();
		electronicsPage.isDisplayDisplayed();
		electronicsPage.clickOnDisplayDD();
		electronicsPage.is4displayed();
		electronicsPage.is8displayed();
		electronicsPage.is12displayed();
		Thread.sleep(3000);
		testLogPass("Click on Logo");
		homePage.clickLogo();
	}
	// 9
	@Test(enabled = true,priority = 8)
	public void verify_following_req_fields_in_the_sort_by_button_on_PhonePage() throws InterruptedException {
		homePage = new HomePage(driver);
		electronicsPage = new ElectronicsPage(driver);
		testlog = reports.createTest("verify_following_req_fields_in_the_sort_by_button_on_PhonePage");
		assertEqual(homePage.getTitle(), "Demo Web Shop");
		Assert.assertTrue(electronicsPage.isElectronicsLinkDisplayed());
		electronicsPage.moveToEleMenu();
		electronicsPage.clickOnPhone();
		electronicsPage.isSortByDisplayed();
		electronicsPage.clickOnSortByDD();
		electronicsPage.ispositiondisplayed();
		electronicsPage.isA_Zdisplayed();
		electronicsPage.isZ_Adisplayed();
		electronicsPage.isL_Hdisplayed();
		electronicsPage.isH_Ldisplayed();
		electronicsPage.isCreatedOndisplayed();
		Thread.sleep(3000);
		testLogPass("Click on Logo");
		homePage.clickLogo();
	}
	// 10
	@Test(enabled = true,priority = 10)
	public void verify_following_req_fields_in_the_viewAs_dropdown_button_on_PhonePage() throws InterruptedException {
		homePage = new HomePage(driver);
		electronicsPage = new ElectronicsPage(driver);
		testlog = reports.createTest("verify_following_req_fields_in_the_viewAs_dropdown_button_on_PhonePage");
		assertEqual(homePage.getTitle(), "Demo Web Shop");
		Assert.assertTrue(electronicsPage.isElectronicsLinkDisplayed());
		electronicsPage.moveToEleMenu();
		electronicsPage.clickOnPhone();
		electronicsPage.isViewAsDisplayed();
		electronicsPage.clickOnViewAsDD();
		electronicsPage.isGriddisplayed();
		electronicsPage.isListdisplayed();
		Thread.sleep(3000);
		testLogPass("Click on Logo");
		homePage.clickLogo();
	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}

