package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demo.base.BasePage;

public class ForgotPasswordPage {

	WebDriver driver;

	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
	}

	By h1 = By.cssSelector("div.page-title h1");

	public void verifyHeader(String string) {
		// TODO Auto-generated method stub
//		BasePage.getText(h1);
	}
}
