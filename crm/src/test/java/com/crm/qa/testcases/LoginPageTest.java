package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginobj;
	HomePage homeobj;

	 public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		
				initialization();
				
				loginobj =new LoginPage();
	
		}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginobj.validateLoginPageTitle();
		
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
		System.out.println(title);
	}
	@Test(priority = 2)
	public void getCurrentURL() {
		String currentURL = loginobj.getcurrentURL();
		System.out.println("Current URL is"+currentURL );
	}
	@Test(priority = 3)
	public void crmlogoTest() {
		Boolean flag = loginobj.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 4)
	public void loginTest() {
		homeobj = loginobj.login(prop.getProperty("username"), prop.getProperty("password"));

	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
