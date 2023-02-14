package com.demo.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage extends BasePage{
	
	WebDriver driver;
	
	public Homepage(WebDriver driver) {
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
		
		
		public boolean isRegisterLinkDisplayed()
		{
			return driver.findElement(registerLink).isDisplayed();
		}
		
		public boolean isloginLinkDisplayed()
		{
			return driver.findElement(loginlink).isDisplayed();
		}
//		public void clickLoginLink() {
//			//click(loginlink);
//		}
		//public void clickLogo() {
  	//(logo);
	//}
//		
//		public void clickRegisterLink() {
//		click(registerLink);
//		}
		public void clickLogo(){
			
		driver.findElement(logo).click();	
		}
}
