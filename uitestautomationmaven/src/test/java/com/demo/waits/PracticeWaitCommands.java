package com.demo.waits;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeWaitCommands {

	public static WebDriver driver;

	public static void main(String[] args) {

		// Create a new instance of the Firefox driver

        driver = new ChromeDriver();

        // Put an Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Launch the URL

        driver.get("https://demoqa.com/alerts");

        // Click on the Button "Timing Alert"

        driver.findElement(By.id("alertButton")).click();

        System.out.println("Timer JavaScript Alert is triggered but it is not yet opened");

        // Create new WebDriver wait

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for Alert to be present

        Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());

        System.out.println("Either Pop Up is displayed or it is Timed Out");

        // Accept the Alert

        myAlert.accept();

        System.out.println("Alert Accepted");

        // Close the main window

        driver.close();

	}

}