package com.demo.base;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class BasePage {
	
   
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	
	
	static {
		prop = new Properties();
		// to read the file
		try {
			fis = new FileInputStream("C:\\SeleniumAutomation\\TestAutomation\\uitestautomationmaven1\\src\\main\\resources\\configs\\data.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(prop);

	}

	@BeforeTest
	public static void setUp() {
		// create an instance for Chrome Driver
		driver = new ChromeDriver();
		// Navigate to site url
		driver.get(prop.getProperty("prodenvurl"));
		// Maximize the Browser
		driver.manage().window().maximize();
	}
	
	public static String getTitle() {
		return driver.getCurrentUrl();
	}
	
}
