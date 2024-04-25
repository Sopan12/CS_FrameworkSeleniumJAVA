package com.mystore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class accountCreationDetails {
	
	
	WebDriver ldriver;
	
	public accountCreationDetails(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="id_gender1")
	WebElement titleMr;
	
	@FindBy(id="customer_firstname")
	WebElement firstName;
	
	@FindBy(id="customer_lastname")
	WebElement lastName;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="newsletter")
	WebElement signup;
	
	@FindBy(id="days")
	WebElement days;
	
	@FindBy(id="months")
	WebElement months;
	
	@FindBy(id="years")
	WebElement years;
	
	@FindBy(id="submitAccount")
	WebElement register;
	
	
	public void selectTitleMr ()
	{
		titleMr.click();
	}
	
	public void enterFirstName(String fname)
	{
		firstName.sendKeys(fname);
	}
	
	public void enterLastName(String lname)
	{
		lastName.sendKeys(lname);
	}
	
	public void enterPassword(String psw)
	{
		password.sendKeys(psw);
	}
	
	public void signupCheckbox()
	{
		signup.click();
	}
	
	public void selectDays(String day)
	{
		Select dayobj = new Select(days);
		dayobj.selectByVisibleText(day);
	}
	
	public void selectMonth(String month)
	{
		Select monthobj = new Select(months);
		monthobj.selectByVisibleText(month);
	}
	
	public void selectYear(String year)
	{
		Select yearobj = new Select(years);
		yearobj.selectByVisibleText(year);
	}
	
	public void clickOnRegister()
	{
		register.click();
	}

}
