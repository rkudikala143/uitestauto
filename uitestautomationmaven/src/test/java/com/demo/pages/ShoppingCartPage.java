package com.demo.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.demo.base.BasePage;
public class ShoppingCartPage {
	WebDriver driver;
	public ShoppingCartPage(WebDriver driver) {

		this.driver = driver;
	}
	/*
	 * Case 42
	 */

// shopping cart link path
	By shoppingCartLink = By.xpath("//*[@id=\"topcartlink\"]/a/span[1]");
	By cart = By.xpath("/html/body/div[4]/div[1]/div[4]/div/div[1]/ul/li[1]/a");
	By address = By.xpath("/html/body/div[4]/div[1]/div[4]/div/div[1]/ul/li[2]/a");
	By shipping = By.xpath("/html/body/div[4]/div[1]/div[4]/div/div[1]/ul/li[3]/a");
	By payment = By.xpath("/html/body/div[4]/div[1]/div[4]/div/div[1]/ul/li[4]/a");
	By confirm = By.xpath("/html/body/div[4]/div[1]/div[4]/div/div[1]/ul/li[5]/a");
	By complete = By.xpath("/html/body/div[4]/div[1]/div[4]/div/div[1]/ul/li[6]/a");
	// object name created
	String shpCartLink = "Shopping Cart";
	String shpCart = "Cart";
	String shpAddress = "Address";
	String shpShipping = "Shipping";
	String shpPayment = "Payment";
	String shpConfirm = "Confirm";
	String shpComplete = "Complete";

	// display link
	public boolean isShoppingCartLinkDisplayed() {
		return driver.findElement(shoppingCartLink).isDisplayed();
		}
	// click on shopping cart link
	
	
	public boolean shoppingCartisDisplayed() {
		return driver.findElement(cart).isDisplayed();
	}
	public boolean shoppingAddressisDisplayed() {
		return driver.findElement(address).isDisplayed();
	}
	public boolean shoppingShippingisDisplayed() {
		return driver.findElement(shipping).isDisplayed();
	}
	public boolean shoppingPaymentisDisplayed() {
		return driver.findElement(payment).isDisplayed();
	}
	public boolean shoppingConfirmisDisplayed() {
		return driver.findElement(confirm).isDisplayed();
	}
	public boolean shoppingCompleteisDisplayed() {
		return driver.findElement(complete).isDisplayed();
	}
	public void clickShoppingCartLink() {
		BasePage.click(shoppingCartLink, shpCartLink);
	}

	/*
	 * Case 43
	 */

	//adding item to cart
		By booksLink = By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[1]/a");
		By clickanItem = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[3]/div/div[2]/h2/a");
		By shoppingCart1 = By.xpath("//*[@id=\"topcartlink\"]/a/span[2]");
		By addCart = By.id("add-to-cart-button-45");
		By quantity = By.cssSelector("a.ico-cart span.cart-qty");
		//By qtyValue = By.id("itemquantity2996944").s
		//find the element in selenium webdriver
		//By quantityValue = By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr/td[5]/input");
		//xpath("//*[@id=\"topcartlink\"]/a/span[2]");
		// object name created
		String clickBookLink = "Books Link Click";
		String clickOnItem = "Item Select";
		String qty = "Quantity Displayed";
		String addToCart = "Item Added To Cart";
		String shpCart1 = "Shopping Cart1";
		// click on book link
		public void clickOnBooksLink() {
			BasePage.click(booksLink, clickBookLink);
		}
		public void clickAnItem() {
			BasePage.click(clickanItem, clickOnItem);
		}
		public void clickOnAddCart() {
			BasePage.click(addCart, addToCart);
		}
		
		
//		public boolean isQtyIsDisplayed() {
//			return driver.findElement(quantity).isDisplayed();
//			
//		}
		public String isQtyIsDisplayed() {
		return driver.findElement(quantity).getText();
	
		
//			  try {
//		;	    driver.findElement(quantity);
//			    System.out.println(quantity);
//			    return true;
//			  } catch (Exception e) {
//				  e.printStackTrace();
//			    return false;
//			  }
//			
//			}
//		public void getQty() {
//		
//			WebElement qty = driver.findElement(quantity);
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			String value = (String) js.executeScript("return arguments[0].value", qty);
//			System.out.println("value of the product: " + value);
//
//		
//		}
	/*	public void getQuantity() {
			WebElement qty = driver.findElement(quantityValue);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String value = (String) js.executeScript("return document.getElementById('add-to-cart').value");
			System.out.println("The value of the add-to-cart button is: " + value);
		}
*/
}
}