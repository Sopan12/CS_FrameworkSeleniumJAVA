package com.mystore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {
	//1.create object of webdriver
	
	WebDriver ldriver; //local driver
	
	//Constructor
	public indexPage(WebDriver rdriver)//remote driver
	{
		ldriver = rdriver; //initialization
		
		PageFactory.initElements(rdriver, this);
	}
	
	
	//Identify WebElements
	
	@FindBy(linkText="Sign in")
	WebElement signin;
	
	@FindBy(xpath="(//a[text()='T-shirts'])[2]")
	WebElement tshirtMenu;
	
	
	//identify action on webelement
	
	public void clickOnSignIn()
	{
		signin.click();
	}
	
	
	public String getPageTitle()
	{
		return(ldriver.getTitle());
	}
	
	public void clickOnTShirtMenu()
	{
		tshirtMenu.click();
	}
	
	

}
