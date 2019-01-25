package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
//import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
//import com.crm.qa.pages.TaskPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase{

	LoginPage loginobj;
	HomePage homeobj;
    TestUtil testutil;
    ContactPage contactPage;
       
    
	 public ContactPageTest() {
		super();
	}
	
		@BeforeMethod
		public void setup() {
			initialization();
			testutil= new TestUtil();
			contactPage =new ContactPage();
			//dealsPage=new DealsPage();
			//taskPage=new TaskPage();
			loginobj =new LoginPage();
			homeobj= loginobj.login(prop.getProperty("username"), prop.getProperty("password"));
			testutil.SwitchToFrame();

			contactPage=homeobj.clickoncontactLink();


		}
		
		@Test(priority=1)
		public void verifyContactPageLabel() {
			
			Assert.assertTrue(contactPage.verifyContactsLabel(),"Contact label is missing in contact page");
			System.out.println("Verified contacts label");
			
		}
		@Test(priority=2)
		public void selectContactsTest() {
			
			contactPage.selectContactsByName("Amrit Mishra");
		}
		@Test(priority=3)
		public void selectmultipleContactsTest() {
			
			contactPage.selectContactsByName("Amrit Mishra");
			contactPage.selectContactsByName("Jyoti Prava");
		}
		
		
		@AfterMethod
		public void teardown() {
		driver.quit();
			
		}
	
}
