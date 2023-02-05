package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElectronicsPage {

	WebDriver driver;

	public ElectronicsPage(WebDriver driver) {

		this.driver = driver;
	}

	By electronicLink = By.xpath("//html/body/div[4]/div[1]/div[2]/ul[1]/li[3]/a");
	By electronicMenu = By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[3]/a");
	By camera = By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[3]/ul/li[1]/a");
	By sortBy = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[1]/div[2]/span");
	By sortByDd = By.id("products-orderby");
	By a_z = By.xpath("//*[@id=\"products-orderby\"]/option[2]");
	By position = By.xpath("//*[@id=\"products-orderby\"]/option[1]");
	By z_a = By.xpath("//*[@id=\"products-orderby\"]/option[3]");
	By l_h = By.xpath("//*[@id=\"products-orderby\"]/option[4]");
	By h_l = By.xpath("//*[@id=\"products-orderby\"]/option[5]");
	By createdon = By.xpath("//*[@id=\"products-orderby\"]/option[6]");
	By display = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[1]/div[3]/span[1]");
	By dispalyDD = By.xpath("//*[@id=\"products-pagesize\"]");
	By four = By.xpath("//*[@id=\"products-pagesize\"]/option[1]");
	By eight = By.xpath("//*[@id=\"products-pagesize\"]/option[2]");
	By twelve = By.xpath("//*[@id=\"products-pagesize\"]/option[3]");
	By viewAs = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[1]/div[1]/span");
	By viewAsDD = By.xpath("//*[@id=\"products-viewmode\"]");
	By grid = By.xpath("//*[@id=\"products-viewmode\"]/option[1]");
	By list = By.xpath("//*[@id=\"products-viewmode\"]/option[2]");
	By phone = By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[3]/ul/li[2]/a");

	String eleLink = "Electronics Link";
	String eleMenu = "Electronics Menu";

	public boolean isElectronicsLinkDisplayed() {
		return driver.findElement(electronicLink).isDisplayed();
	}

	public boolean isElectronicsMenuDisplayed() {
		return driver.findElement(electronicMenu).isDisplayed();
	}

	public void clickOnElectronicLink() {
		driver.findElement(electronicLink).click();
	}

	public void moveToEleMenu() {
		WebElement elecMenu = driver.findElement(electronicMenu);
		Actions act = new Actions(driver);
		act.moveToElement(elecMenu).build().perform();
	}

	public boolean isCameraDisplayed() {
		return driver.findElement(camera).isDisplayed();
	}

	public boolean isPhoneDisplayed() {
		return driver.findElement(phone).isDisplayed();
	}

	public void clickOnCamera() {
		WebElement cam = driver.findElement(camera);
		Actions act = new Actions(driver);
		act.moveToElement(cam).build().perform();
		act.click().perform();
	}

	public boolean isSortByDisplayed() {
		return driver.findElement(sortBy).isDisplayed();
	}

	public void clickOnSortByDD() {
		driver.findElement(sortByDd).click();
	}

	public boolean ispositiondisplayed() {
		return driver.findElement(position).isDisplayed();
	}

	public boolean isA_Zdisplayed() {
		return driver.findElement(a_z).isDisplayed();
	}

	public boolean isZ_Adisplayed() {
		return driver.findElement(z_a).isDisplayed();
	}

	public boolean isL_Hdisplayed() {
		return driver.findElement(l_h).isDisplayed();
	}

	public boolean isH_Ldisplayed() {
		return driver.findElement(h_l).isDisplayed();
	}

	public boolean isCreatedOndisplayed() {
		return driver.findElement(createdon).isDisplayed();
	}

	public boolean isDisplayDisplayed() {
		return driver.findElement(display).isDisplayed();
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

	public void clickOnPhone() {
		WebElement phn = driver.findElement(phone);
		Actions act = new Actions(driver);
		act.moveToElement(phn).build().perform();
		act.click().perform();
	}
}
