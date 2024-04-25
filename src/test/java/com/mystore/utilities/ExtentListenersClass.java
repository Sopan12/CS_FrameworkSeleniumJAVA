package com.mystore.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentListenersClass implements ITestListener {
	
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void configureReport()
	{
		ReadConfig readconfig = new ReadConfig();
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName = "MyStoreTestReport-" + timestamp + ".html";
		
		
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportName);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		
		//add system information/environment info to report
		
		reports.setSystemInfo("Machine", "testpc1");
		reports.setSystemInfo("os", "windows11");
		reports.setSystemInfo("browser", readconfig.getBrowser());
		reports.setSystemInfo("user name:", "Sumit");
		
		//configure to change look and feel of report
		
		htmlReporter.config().setDocumentTitle("ExtentListenerReportDemo");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setTimeStampFormat("EEEE,MMMM dd, yyyy, hh:mm a '('zzz')' ");	
	}
	
	
	//this method execute before that tcs execution on time
	//onStart method is called/start when any test start
	public void onStart(ITestContext Result)
	{
		configureReport();
		
		System.out.println("oNStart method Invoke...");	
		System.out.println("\n");
		
	}
	

	//this method execute after that tcs execution
	//onFinish method is called/start when any test finish
	public void onFinish(ITestContext Result)
	{
		System.out.println("oNFinish method Invoke...");
		reports.flush();// it is used to write report and its mandatory
		System.out.println("\n");
		
	}

	
	//this method execute if that class tcs failed
	//when test case get failed this method will called
	public void onTestFailure(ITestResult Result)
	{
		System.out.println("Name of test methods failed:"+Result.getName());
		test = reports.createTest(Result.getName());  //create entry in html report
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test is :"+Result.getName() + "FAIL", ExtentColor.RED));
		System.out.println("\n");
		
		
		//failed tc report madhe add karnyasathi ha code and capture sathi base class mdhlya code used karne
		String Screenshotpath = System.getProperty("user.dir") + "\\Screenshots\\" + Result.getName() + ".png";
		File  screenShotFile = new File(Screenshotpath);
		if(screenShotFile.exists())
		{
			test.fail("Capture Screenshot is below:" +test.addScreenCaptureFromPath(Screenshotpath));
		}
		
		
		
		//test.addScreenCaptureFromPath(null);
		
	}

	
	//this method execute if that class tcs skiped
	//when test case get skipped this method will called
	public void onTestSkipped(ITestResult Result)
	{
		System.out.println("Name of test methods Skipped:"+Result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip test is :"+Result.getName() + "Skipped", ExtentColor.YELLOW));
		System.out.println("\n");
		
	}

	
	//when test case get started,this method is called
	// jevdhya mthod rahil tevdhya veles execute hoil
	public void onTestStart(ITestResult Result)
	{
		System.out.println("Name of test methods Started:"+Result.getName());
		
	}

	
	//when test case get passed,this method is called
	public void onTestSuccess(ITestResult Result)
	{
		System.out.println("Name of test methods Success:"+Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the Pass test is :"+Result.getName() + "PASS", ExtentColor.GREEN));
		System.out.println("\n");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult Result)
	{
		//System.out.println("");
		//when test case get passed,this method is called
	}

	
	
	
	

}
