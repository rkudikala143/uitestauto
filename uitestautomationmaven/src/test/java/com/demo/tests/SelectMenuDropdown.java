package com.demo.tests;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.demo.base.BasePage;

public class SelectMenuDropdown extends BasePage{

	

	@BeforeSuite
	public void invoke() {
		setUp("https://www.spicejet.com/");
	}
	
	@Test
	public void handleMenuDropdown() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@data-testid='to-testID-origin']")).click();
		Thread.sleep(2000);
		
//		WebElement ele = driver.findElement(By.xpath("css-1dbjc4n r-knv0ih r-1k1q3bj r-ql8eny r-1dqxon3"));
		Actions act = new Actions(driver);
//		act.moveToElement(ele).build().perform();
//		
		List<WebElement> li = driver.findElements(By.xpath("//*[@class='css-1dbjc4n r-knv0ih r-1k1q3bj r-ql8eny r-1dqxon3']/div/div/div/div"));
		for (int i = 0; i < li.size(); i++) {
			WebElement ele1 = li.get(i);
			act.moveToElement(ele1).build().perform();
			String destinations = li.get(i).getText();
			System.out.println(destinations);
			if (destinations.contains("Aurangabad")) {
				li.get(i).click();
				break;
			}
		}
		
		
	}
}
