package com.mystore.testCases;
import org.testng.annotations.*;

import com.mystore.pageObject.*;
import com.mystore.utilities.ReadExcelFile;

import java.io.IOException;

import org.testng.*;

public class TC_MyAccountPageTestDataDrivenTesting extends BaseClass {

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


	@Test(dataProvider = "LoginDataProvider")
	public void verifyLogin(String userEmail, String userPassword, String expectedUserName) throws IOException
	{
		indexPage pg1 = new indexPage(driver);
		pg1.clickOnSignIn();
		logger.info("Click on signin");


		myAccount pg = new myAccount(driver);
		
		pg.enterLoginEmail(userEmail);
		logger.info("username entered");
		
		pg.enterLoginPassword(userPassword);
		logger.info("password entered");
		
		pg.clickLoginSignin();
		
		registeredUserAccount regUser = new registeredUserAccount(driver);
		String UserName = regUser.getUserName();
		if(UserName.equals(expectedUserName	))
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

		regUser.clickOnLogout();


	}



	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider() throws IOException
	{
		//System.out.println(System.getProperty("user.dir"));
		String fileName = System.getProperty("user.dir") + "\\TestData\\MyStoreTestData.xlsx";


		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");
	

		String data[][]=new String[ttlRows-1][ttlColumns];

		for(int i=1;i<ttlRows;i++)//rows =1,2
		{
			for(int j=0;j<ttlColumns;j++)//col=0, 1,2
			{

				data[i-1][j]=ReadExcelFile.getCellValue(fileName,"LoginTestData", i,j);
			}

		}
		return data;
	}

}