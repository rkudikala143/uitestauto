package com.demo.waits;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.FluentWait;

import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FluentWaitExp {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");

		driver.manage().window().maximize();

		driver.findElement(By.name("q")).sendKeys("Selenium");

		Thread.sleep(2000);

		driver.findElement(By.name("btnK")).click();

		@SuppressWarnings({ "deprecation" })

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class)
				.ignoring(AssertionError.class).ignoring(NoAlertPresentException.class);

		WebElement element = (WebElement) wait.until(new Function<WebDriver, WebElement>() {

			@Override

			public WebElement apply(WebDriver arg0) {

				WebElement linkelement = driver.findElement(By.partialLinkText("Selenium testing tutorial"));

				if (linkelement.isEnabled()) {

					System.out.println("Element is Found");
				}

				return linkelement;
			}
		});

		element.click();

	}

}
