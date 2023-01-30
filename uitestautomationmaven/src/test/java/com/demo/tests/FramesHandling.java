package com.demo.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.demo.base.BasePage;

public class FramesHandling extends BasePage{
	
	@BeforeSuite
	public void invoke() {
		setUp("https://demoqa.com/frames");
	}
	
	
	
	@Test
	public void handleFrames() {
		int li =   driver.findElements(By.tagName("iframe")).size();
		System.out.println(li);  /// index basis frames - 0,1,2,3..
		
		//Find number iframes  in web page
		WebElement ele = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(ele);
		
		WebElement ele1 = driver.findElement(By.id("sampleHeading"));
		System.out.println(ele1.getText());
		
		// get the text of paragraph
		// come back from Frames
		
		driver.switchTo().defaultContent();
		WebElement para = driver.findElement(By.xpath("//*[@id='framesWrapper']/div"));
		System.out.println(para.getText());
		
	}
}
