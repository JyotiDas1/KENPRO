package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class TaskPage extends TestBase {

	
	@FindBy(xpath = "//td[contains(text(),'Task')]")
	WebElement Tasklabel;
	
	public TaskPage() {
		
		 PageFactory.initElements(driver,this);
	}
     public boolean verifyTaskLabel() {
    	 return Tasklabel.isDisplayed();
     }
  
}
