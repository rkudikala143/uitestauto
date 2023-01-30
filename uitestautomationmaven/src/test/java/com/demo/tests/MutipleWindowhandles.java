package com.demo.tests;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.demo.base.BasePage;

public class MutipleWindowhandles extends BasePage{

	public static String parentwin ;
	@BeforeSuite
	public void invoke() {
		setUp("https://demoqa.com/browser-windows");
	}
	
	@Test
	public void handleMultipleBrowserWin() {
		
		driver.findElement(By.id("windowButton")).click();
		
		parentwin = driver.getWindowHandle();
		Set<String> win = driver.getWindowHandles();
		Iterator<String> it = win.iterator();
		while (it.hasNext()) {
			String ChildWindow = it.next();
			  if (!parentwin.equalsIgnoreCase(ChildWindow)) {
	              driver.switchTo().window(ChildWindow);
	          	WebElement ele = driver.findElement(By.id("sampleHeading"));
	    		System.out.println(ele.getText());
	    		driver.close();
	    		driver.switchTo().window(parentwin);
			  }
		}
		
	}
}
