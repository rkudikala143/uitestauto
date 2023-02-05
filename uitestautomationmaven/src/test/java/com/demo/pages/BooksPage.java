package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.demo.base.BasePage;

public class BooksPage {
	WebDriver driver;

	public BooksPage(WebDriver driver) {
		this.driver = driver;
	}

	By booksMenu = By.cssSelector("ul.top-menu li a");
	By sortBy = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[1]/div[2]/span");
	By position = By.xpath("//*[@id='products-orderby']/option[1]");

	By display = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[1]/div[3]/span[1]");
	By dispalyDD = By.xpath("//*[@id=\"products-pagesize\"]");
	By four = By.xpath("//*[@id=\"products-pagesize\"]/option[1]");
	By eight = By.xpath("//*[@id=\"products-pagesize\"]/option[2]");
	By twelve = By.xpath("//*[@id=\"products-pagesize\"]/option[3]");

	By viewAs = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[1]/div[1]/span");
	By viewAsDD = By.xpath("//*[@id=\"products-viewmode\"]");
	By grid = By.xpath("//*[@id=\"products-viewmode\"]/option[1]");
	By list = By.xpath("//*[@id=\"products-viewmode\"]/option[2]");

	By selectBook = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[1]/a/img");
	By addToCart = By.xpath("//*[@id=\"add-to-cart-button-13\"]");
	By bookDiscription = By.xpath("//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[2]");

	By filter = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[2]/div");
	By under25 = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[2]/div/div[2]/ul/li[1]/a");
	By filter_25_50 = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[2]/div/div[2]/ul/li[2]/a");
	By over_50 = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[2]/div/div[2]/ul/li[3]/a");
	By removefilter = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[2]/div/div[2]/div[2]/a");

	String booksbtn = "click on books menu";

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

	public boolean isPositionOptDisplayed() {
		return driver.findElement(position).isDisplayed();
	}

	public void clickOnDisplayDD() {
		driver.findElement(dispalyDD).click();
	}

	public boolean is4displayed() {
		return driver.findElement(four).isDisplayed();
	}

	public boolean is8displayed() {
		return driver.findElement(eight).isDisplayed();
	}

	public boolean is12displayed() {
		return driver.findElement(twelve).isDisplayed();
	}

	public void moveToBooksMenu() {
		WebElement bookMenu = driver.findElement(booksMenu);
		Actions act = new Actions(driver);
		act.moveToElement(bookMenu).build().perform();
	}

	public boolean isViewAsDisplayed() {
		return driver.findElement(viewAs).isDisplayed();
	}

	public void clickOnViewAsDD() {
		driver.findElement(viewAsDD).click();
	}

	public boolean isGriddisplayed() {
		return driver.findElement(grid).isDisplayed();
	}

	public boolean isListdisplayed() {
		return driver.findElement(list).isDisplayed();
	}

	public void clickOnList() {
		driver.findElement(list).click();
	}

	public void clickOnGrid() {
		driver.findElement(grid).click();
	}

	public void clickOnFour() {
		driver.findElement(four).click();
	}

	public void clickOnEight() {
		driver.findElement(eight).click();
	}

	public void clickOntwelve() {
		driver.findElement(twelve).click();
	}

	public void selectABook() {
		driver.findElement(selectBook).click();
	}

	public void clickOnAddToCart() {
		driver.findElement(addToCart).click();
	}

	public boolean isBookDiscriptionDisplayed() {
		return driver.findElement(bookDiscription).isDisplayed();
	}

	public boolean isFilterDisplayed() {
		return driver.findElement(filter).isDisplayed();
	}

	public void clickOnUnder25() {
		driver.findElement(under25).click();
	}

	public void clickOnFilter25_50() {
		driver.findElement(filter_25_50).click();
	}

	public void clickOnOver_50() {
		driver.findElement(over_50).click();
	}

	public boolean isRemoveFilterDisplayed() {
		return driver.findElement(removefilter).isDisplayed();
	}

}