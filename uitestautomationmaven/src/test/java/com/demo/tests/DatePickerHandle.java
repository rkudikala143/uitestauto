package com.demo.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.demo.base.BasePage;

public class DatePickerHandle extends BasePage {

	@BeforeSuite
	public void invoke() {
		setUp("	https://demoqa.com/date-picker");
	}
	
	@Test
	public void chooseDate() {
		selectDate("1980", "June", "25");
	}
	
	public void selectDate(String year, String month, String day) {
		// click on Date field
		driver.findElement(By.id("datePickerMonthYearInput")).click();;
		
		WebElement datefield = driver.findElement(By.xpath("//*[@class='react-datepicker__month-container']"));
		Actions act = new Actions(driver);
		act.moveToElement(datefield).build().perform();
		
		// Webelement fro year
		WebElement yeardrp = driver.findElement(By.className("react-datepicker__year-select"));
		Select sel = new Select(yeardrp);
		sel.selectByVisibleText(year);
		
		// Month selection
		WebElement monthdrp = driver.findElement(By.className("react-datepicker__month-select"));
		Select sel1 = new Select(monthdrp);
		sel1.selectByVisibleText(month);
		
		
		// find the list of element
		
		List<WebElement> li = driver.findElements(By.xpath("//*[@class='react-datepicker__week']/div"));
		for (int i = 0; i < li.size(); i++) {
			if (li.get(i).getText().contains(day)) {
				li.get(i).click();
				break;
			}
		}
	}

}
