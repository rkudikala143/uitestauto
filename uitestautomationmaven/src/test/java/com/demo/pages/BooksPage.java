package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.demo.base.BasePage;

public class BooksPage {
	WebDriver driver;

	public BooksPage(WebDriver driver) {
		this.driver = driver;
	}

	By booksMenu=By.cssSelector("ul.top-menu li a");
	By sortBy= By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[1]/div[2]/span");
	By display = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[1]/div[3]/span[1]");
	By viewAs=By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[1]/div[1]/span");
	By position = By.xpath("//*[@id='products-orderby']/option[1]");

	String booksbtn="click on books menu";
	
	
	public boolean isBooksMenuDisplayed() {
		return driver.findElement(booksMenu).isDisplayed();
	}
	public boolean books() {
		return driver.findElement(booksMenu).isDisplayed();
	}
	public void clickOnBooks() {
		BasePage.click(booksMenu, booksbtn);
	}
	public boolean isSortByDisplayed() {
	   return driver.findElement(sortBy).isDisplayed();
	}

	public boolean isDisplayOptDisplayed() {
		return driver.findElement(display).isDisplayed();
	}
	public boolean isViewAsDisplayed() {
		return driver.findElement(viewAs).isDisplayed();
	}
	public boolean isPositionOptDisplayed() {
		return driver.findElement(position).isDisplayed();
	}
}