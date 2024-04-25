package com.mystore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

public class registeredUserAccount {
	
	WebDriver ldriver;
	
	public registeredUserAccount(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[@class='account']")
	WebElement userName;
	
	@FindBy(linkText="Sign out")
	WebElement signOut;
	
	@FindBy(name ="search_query")
	WebElement searchBox;
	
	@FindBy(name ="submit_search")
	WebElement submit_search;

	@FindBy(linkText = "Women")
	WebElement WomenMenu;

	@FindBy(linkText="T-shirts")
	WebElement TShirtMenu;
	
	
	public String getUserName()
	{
		String text = userName.getText();
		return text;
	}
	
	
	public void clickOnLogout()
	{
		signOut.click();
	}
	
	public void EnterDataInSearchBox(String searchKey)
	{
		searchBox.sendKeys(searchKey);
	}

	public void ClickOnSearchButton()
	{
		submit_search.click();

	}

	
	public void MouseOverTShirtMenu()
	{
		Actions actions=new Actions(ldriver);
		actions.moveToElement(WomenMenu).moveToElement(TShirtMenu).click().perform();
	}

}
