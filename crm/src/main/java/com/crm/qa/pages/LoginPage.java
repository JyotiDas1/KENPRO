package com.crm.qa.pages;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
public class LoginPage extends TestBase{

		//page Factory or Object repository
		
		@FindBy(name="username") 
		WebElement username;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(xpath="//input[@value= 'Login']")
		WebElement loginBtn;

		@FindBy(xpath="//font[@color='red']")
		WebElement signupBtn;
		
		@FindBy(xpath="//img[contains(@class,'img-responsive')]")
		WebElement crmLogo;
		
		
		
		//Intilizing the Page Object
		public LoginPage() {
			
			PageFactory.initElements(driver, this); //this :- all the variable(username,p/w,loginbtn,crmlogo) itilized to driver using this keyword
			
		}
		
		//Actions:
		public String validateLoginPageTitle() {
			
			return driver.getTitle();
	
		}
		public String getcurrentURL() {
			return driver.getCurrentUrl();
		}

		public boolean validateCRMImage() {
			return crmLogo.isDisplayed();
			
		}

	    public HomePage login(String un,String pwd) {
	    	
	    	username.sendKeys(un);
	    	password.sendKeys(pwd);
	    	//loginBtn.click();

	    	   JavascriptExecutor js=(JavascriptExecutor)driver;
	    	   js.executeScript("arguments[0].click();", loginBtn);
	    	return new HomePage(); 
	    
	    }


	}


