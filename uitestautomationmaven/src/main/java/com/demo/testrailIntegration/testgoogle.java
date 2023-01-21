package com.demo.testrailIntegration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.base.BasePage;

public class testgoogle extends BasePage{


    WebDriver driver;
    
    @Test(description = "Verify that Title appearing on the webpage is as expected. TC_ID=C120254")
    public void verifyTitle() throws Exception {
        driver= new FirefoxDriver();
        driver.get("https://www.google.co.in");
        String actualTilte = driver.getTitle();
        if (actualTilte.contains("Google")) {
            Assert.assertTrue(actualTilte.contains("Google"));
            addResultForTestCase("8", TEST_CASE_PASSED_STATUS, "");
        }
else{
		testgoogle.addResultForTestCase("8", TEST_CASE_FAILED_STATUS, "");
	}
        driver.quit();
    }


   

}