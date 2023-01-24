package com.demo.tests;






import java.io.IOException;


import org.openqa.selenium.By;
import org.testng.Assert;

import org.testng.annotations.Test;

import com.demo.base.BasePage;
import com.demo.pages.LoginPage;



public class LoginTest extends BasePage {

	public void invoke() {
		setUp();
	}
	
	LoginPage loginpage;
		
	@Test (priority =1)
	public void verfiyLoginFunctionalityWithValidCred() throws IOException, Exception{
	try{
		loginpage = new LoginPage(driver);
		loginpage.clickLoginLink();
		String loginTitle = loginpage.getTitle();
		Assert.assertEquals(loginTitle, "Demo Web Shop. Login");
		loginpage.enterEmailAddress(prop.getProperty("email"));
		loginpage.enterPassword(prop.getProperty("password"));
		loginpage.clickLoginButton();
		loginpage.clickLogoutButton();

	}catch(Exception e) {
		e.printStackTrace();
	}
}	
	@Test(priority =0)
	public void verfiyLoginFunctionalityWithValidCred1() {
		try {
		loginpage = new LoginPage(driver);
		loginpage.clickLoginLink();
		loginpage.enterEmailAddress(prop.getProperty("email1"));
		loginpage.enterPassword(prop.getProperty("password1"));
		loginpage.clickLoginButton();
		String Errormessage = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[1]/div/ul/li")).getText();
		Assert.assertEquals(Errormessage, "The credentials provided are incorrect");
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
  }
}
