package com.demo.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage  {
	WebDriver driver;
	
	
	public Homepage(WebDriver driver) {
		this.driver = driver;
	}

	By logo = By.cssSelector("div.header-logo a img");
	
	
	public void clickLogo() {
		BasePage.click(logo);
	}
}
