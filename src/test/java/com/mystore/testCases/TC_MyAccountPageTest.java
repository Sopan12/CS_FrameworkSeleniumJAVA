package com.mystore.testCases;
import org.testng.annotations.*;

import com.mystore.pageObject.*;

import java.io.IOException;

import org.testng.*;

public class TC_MyAccountPageTest extends BaseClass {

	@Test(enabled=false)
	public void verifyUserRegistrationAndLogin() 
	{

		indexPage pg1 = new indexPage(driver);
		pg1.clickOnSignIn();
		logger.info("Click on signin");


		myAccount pg = new myAccount(driver);
		pg.enterCreateEmailAddress("csa123@gmail.com");
		logger.info("Email entered");

		pg.clickSubmitCreate();
		logger.info("Click on create submit");

		accountCreationDetails accCreationPg = new accountCreationDetails(driver);

		accCreationPg.selectTitleMr();
		logger.info("Mr Selected");

		accCreationPg.enterFirstName("Suraj");
		logger.info("Entered first name");

		accCreationPg.enterLastName("Chand");
		logger.info("Enter last name");

		accCreationPg.enterPassword("Med@1234");
		accCreationPg.signupCheckbox();
		accCreationPg.selectDays("25");
		accCreationPg.selectMonth("January");
		accCreationPg.selectYear("2020");
		accCreationPg.clickOnRegister();
		logger.info("clicked on registered button");

		registeredUserAccount regUser = new registeredUserAccount(driver);
		String UserName = regUser.getUserName();

		Assert.assertEquals("Suraj Chand", UserName);

	}


	@Test
	public void verifyLogin() throws IOException
	{
		indexPage pg1 = new indexPage(driver);
		pg1.clickOnSignIn();
		logger.info("Click on signin");


		myAccount pg = new myAccount(driver);
		
		pg.enterLoginEmail("patale@gmail.com");
		logger.info("username entered");
		
		pg.enterLoginPassword("Medrio1234");
		logger.info("password entered");
		
		pg.clickLoginSignin();
		
		registeredUserAccount regUser = new registeredUserAccount(driver);
		String UserName = regUser.getUserName();
		if(UserName.equals("Patale Patale"))
		{
			logger.info("verify user logged in - Passed");
			
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("verify user logged in - Failed");
			captureScreenShot(driver, "verifyLogin");
			Assert.assertTrue(false);
			
		}

	}
	
	
	
	@Test
	public void VerifySignOut() throws IOException 
	{

		logger.info("***************TestCase Verify Sign out starts*****************"); 

		indexPage pg = new indexPage(driver);

		pg.clickOnSignIn();
		logger.info("Clicked on sign in link");

		myAccount myAcpg = new myAccount(driver);

		myAcpg.enterLoginEmail("cs923@gmail.com");
		logger.info("Entered email address");

		myAcpg.enterLoginPassword("cs923");
		logger.info("Entered password");

		myAcpg.clickLoginSignin();;
		logger.info("Clicked on sign in link..");


		registeredUserAccount regUser = new registeredUserAccount(driver);
		regUser.clickOnLogout();

		if(pg.getPageTitle().equals("Login - My Store"))
		{
			logger.info("VerifySignOut - Passed");
			Assert.assertTrue(true);
		}

		else
		{
			logger.info("VerifySignOut - Failed");
			captureScreenShot(driver,"VerifySignOut");
			Assert.assertTrue(false);
		}

	
		logger.info("***************TestCase Verify Sign out ends*****************"); 

	}





}
