package com.mystore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccount {
	
	//1.create object of webdriver
	WebDriver ldriver;
	
	//Constructor
	public myAccount(WebDriver rdriver)
	{
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	//Identify WebElements
	
	@FindBy(id="email_create")
	WebElement createEmailId;
	
	@FindBy(id="SubmitCreate")
	WebElement SubmitCreate;
	
	@FindBy(id = "email")
	WebElement loginUsername;
	
	@FindBy(id = "passwd")
	WebElement loginPassword;
	
	@FindBy(id = "SubmitLogin")
	WebElement signIn;
	
	//identify action on webelement
	
	public void enterCreateEmailAddress(String emailAdd)
	{
		createEmailId.sendKeys(emailAdd);
	}
	
	public void clickSubmitCreate()
	{
		SubmitCreate.click();
	}
	
	public void enterLoginEmail(String uemail)
	{
		loginUsername.sendKeys(uemail);
	}
	
	public void enterLoginPassword(String upassword)
	{
		loginPassword.sendKeys(upassword);
	}
	
	public void clickLoginSignin()
	{
		signIn.click();
	}

}
