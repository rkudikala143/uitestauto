package com.demo.tests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.demo.base.BasePage;
import com.demo.pages.HomePage;
import com.demo.pages.ShoppingCartPage;
public class ShoppingCartTest extends BasePage {
	
	HomePage homePage;
	ShoppingCartPage shoppingCartPage;
@BeforeSuite
	public void invokeBrowser() {
		setUp("https://demowebshop.tricentis.com/");
	}

@Test(enabled = true, priority = 0)
	public void verifyThatTheShoppingCartPAgeContainsAllTheNecessaryLinks() throws InterruptedException {
		try {
			homePage = new HomePage(driver);
			shoppingCartPage = new ShoppingCartPage(driver);
			testlog = reports.createTest("verifyThatTheShoppingCartPAgeContainsAllTheNecessaryLinks");
			assertTrue(shoppingCartPage.isShoppingCartLinkDisplayed());
			shoppingCartPage.clickShoppingCartLink();
			shoppingCartPage.shoppingCartisDisplayed();
			shoppingCartPage.shoppingAddressisDisplayed();
			shoppingCartPage.shoppingShippingisDisplayed();
			shoppingCartPage.shoppingPaymentisDisplayed();
			shoppingCartPage.shoppingConfirmisDisplayed();
			shoppingCartPage.shoppingCompleteisDisplayed();
			Thread.sleep(3000);
		    homePage.clickLogo();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

@Test(enabled = true,priority = 1)
	public void verifyIfTheUserAddASingleProductTotheCartAndOneIsDisplayedInTheCartIcon() throws InterruptedException {
	try {
		shoppingCartPage = new ShoppingCartPage(driver);
		testlog = reports.createTest("verifyIfTheUserAddASingleProductTotheCartAndOneIsDisplayedInTheCartIcon");
		assertTrue(shoppingCartPage.isShoppingCartLinkDisplayed());
		shoppingCartPage.clickOnBooksLink();
		shoppingCartPage.clickAnItem();
		shoppingCartPage.clickOnAddCart();
		Thread.sleep(3000);
		shoppingCartPage.clickShoppingCartLink();
		//assertTrue(shoppingCartPage.isShoppingCartLinkDisplayed());
		shoppingCartPage.isQtyIsDisplayed();
	//	shoppingCartPage.getQty();
		Thread.sleep(2000);
	//	shoppingCartPage.getQuantity();
	//	Thread.sleep(3000);
	    homePage.clickLogo();
	} catch (Exception e) {
		e.printStackTrace();
	}	
	
	}
@AfterSuite
public void closeBrowser() {
	driver.close();
	
}
	
}