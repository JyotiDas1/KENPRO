package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TaskPage;
import com.crm.qa.util.TestUtil;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.DealsPage;

public class HomePageTest extends TestBase {
	LoginPage loginobj;
	HomePage homeobj;
    TestUtil testutil;
    ContactPage contactPage;
    DealsPage dealsPage;  
    TaskPage taskPage;
    
    
	 public HomePageTest() {
		super();
	}
	
	 //TestCases should be separated -- independent with each other
	 //Before each  test cases -- launch the browser and login
	 //@test -- execute test case
	 //After each test case -- close the browser
	
	@BeforeMethod
	public HomePage setup() {
		initialization();
		testutil= new TestUtil();
		contactPage =new ContactPage();
		dealsPage=new DealsPage();
		taskPage=new TaskPage();
		loginobj =new LoginPage();
		homeobj= loginobj.login(prop.getProperty("username"), prop.getProperty("password"));
        
		return homeobj;
	}
	@Test(priority=1)
	public void verifyHomePageTitle() {
	  String homepageTitle=	homeobj.validateHomepageTitle();
	// System.out.println(homepageTitle);
     Assert.assertEquals(homepageTitle, "#1 Free CRM software in the cloud for sales and service");
			 
	}
	@Test(priority=2)
	public void verifyUserNameLabel() {
	testutil.SwitchToFrame();
	Assert.assertTrue(homeobj.verifyUserNameLabel());
	}
	@Test(priority=3)
	public void clickoncontactLink() {

		contactPage=homeobj.clickoncontactLink();
		System.out.println("Clicked on contact Link");

	}
	
	@Test(priority=4)
	public void clickondealLink() {
		testutil.SwitchToFrame();

		dealsPage=homeobj.clickondealLink();
		System.out.println("Clicked on deal Link");
		
	}
	@Test(priority=5)
	public void clickontaskLink() {
		testutil.SwitchToFrame();

		taskPage=homeobj.clickontaskLink();
		System.out.println("Clicked on task Link");

	}
	@AfterMethod
	public void teardown() {
	driver.quit();
		
	}
}
