package com.demo.tests;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.zeromq.ZStar.Set;

import com.demo.base.BasePage;

public class BrowserTabsHandle extends BasePage {
	@BeforeSuite
	public void invoke() {
		setUp("https://demoqa.com/browser-windows");
	}

	@Test
	public void handleTabs() throws InterruptedException {

		// Click on Button tab
		driver.findElement(By.id("tabButton")).click();
		// Now driver is in parent page
		// how to switch to new tab
//		String currentHandle= driver.getWindowHandle();
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());// tabs2 object has mutiple tabs
		// switching to 2nd tab
		driver.switchTo().window(tabs2.get(1));

		// opening the URL saved.
		WebElement ele = driver.findElement(By.id("sampleHeading"));
		System.out.println(ele.getText());
		// switching to 1st tab
		driver.switchTo().window(tabs2.get(0));
  // verifyingf the logo
		boolean status = driver.findElement(By.xpath("//*[@id=\"app\"]/header/a/img")).isDisplayed();
		System.out.println(status);
		assertTrue(status);
	}

}
