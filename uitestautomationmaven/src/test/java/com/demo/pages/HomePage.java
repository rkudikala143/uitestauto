package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demo.base.BasePage;
public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
	this.driver = driver;
	}
	// common methods, getTitle, getCurrentCUrl
		/*
		 * get Title of the currentPage
		 */
		public String getTitle() {
			return driver.getTitle();
		}

		/*
		 * get Current Url of the Page
		 */

		public String getCurrentPageUrl() {
			return driver.getCurrentUrl();
		}
		By loginlink = By.className("ico-login");
		By registerLink = By.className("ico-register");
		By logo = By.cssSelector("div.header-logo a img");
		By logout = By.className("ico-logout");
		
		
		
		/*
		 * Name of your objects
		 */
		String logoutlink = "Click on Logout link";
		String registerlink = "Click Register link";
		String logolink="Click on logo";
		public boolean isRegisterLinkDisplayed(){
			return driver.findElement(registerLink).isDisplayed();
		}
		public void clickLoginLink() {
		//	BasePage.click(loginlink);
		}
		public void clickLogo() {
			BasePage.click(logo, logolink);
		}
		
		public void clickRegisterLink() {
		BasePage.click(registerLink, registerlink);
			
		}
		
		public void clickLogout() {
			BasePage.click(logout, logoutlink);
		}
}