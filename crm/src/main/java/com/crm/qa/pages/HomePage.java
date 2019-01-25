package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	
	@FindBy(xpath="//td[contains(text(),'User: Shaikh Ahmed')]")
	WebElement userNamelbl;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement ContactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
    WebElement newContactLink;	
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement DealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement TasksLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public String validateHomepageTitle() {
		
		return driver.getTitle();
		
	}
	public boolean verifyUserNameLabel() {
		
		return userNamelbl.isDisplayed();
	}
	public ContactPage clickoncontactLink() {
		
		ContactsLink.click();
		return new ContactPage();
	}
	public DealsPage clickondealLink() {
		DealsLink.click();
		return new DealsPage();
	}
	public TaskPage clickontaskLink() {
		TasksLink.click();
		return new TaskPage();
	}
	public void clickOnNewContactLink() {
		Actions action =new Actions(driver);
		action.moveToElement(ContactsLink).build().perform();
		newContactLink.click();
		
	}
    
}
