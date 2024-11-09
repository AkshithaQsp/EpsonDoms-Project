package com.Epsondoms.Genericlibrary;

import org.testng.Reporter;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.Epsondoms.Excelfilelibrary.ReadExcelFile;
import com.Epsondoms.PageRepository.PageManagement;
import com.Epsondoms.Propertyfilelibrary.ReadPropertyFile;
import com.Epsondoms.WebDriverlibrary.WebDriverUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This Class is used for Configure All PreCondition and PostCondition For TestScript
 * And Also initializing All The Library-Utility class
 * 
 * 
 * @author Kallem Akshitha
 **/

public class BaseTest {
	public PageManagement pageMangmentobj;
	public  WebDriverUtility webdriverobj;
	public ReadExcelFile excelutilityobj;
	public String username;
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;
	public ReadPropertyFile propertyfileobj;
/**
 * This Method Is Used to SuiteSetUp And Reports SetUp
 * @param
 * @return void */
	
	@BeforeSuite
	public void suiteSetup()
	{
		//Create the SparkReport
		spark=new ExtentSparkReporter("./AdvanceReports/report.html");
		
		//Configure the SparkReport Information
		spark.config().setDocumentTitle("Regression Testing for the Learning Selenium Page");
		spark.config().setReportName("RegressionSuite||Verification of Welcome Page");
		spark.config().setTheme(Theme.STANDARD);
		
		//Create the Extent Report
		report=new ExtentReports();
		
		//Attach the spark report and Extent Report
		report.attachReporter(spark);
		
		//Configure the System Information
		report.setSystemInfo("DeviceName","Harry");
		report.setSystemInfo("OperatingSystems","WINDOWS 11");
		report.setSystemInfo("Browser","Chrome");
		report.setSystemInfo("BrowserVersion","chrome-128.0.6613.85");
		
	}
	/**
	 * This Method Is Used to SuiteTerminateSetUp 
	 * @param
	 * @return void */
		
	
	
	@AfterSuite
	public void suiteTerminateSetup()
	{
		report.flush();
	}
	
	@Parameters({"browsername","weburl"})
	@BeforeClass
	
	/**
	 * This Method Is Used to BrowserSetUp  
	 * @param String browser,String url
	 * @return void */
		
	
	
	public void browserSetup(String browser,String url)
	{
		//create object for all the repositry
		createObjects();
		
		//fetch The UserName from ExcelFile
		
		
		username=excelutilityobj.readSingleData("RegisterData",1,1);
		
      //Launch the Browser Chrome,FireFox,Edge
		webdriverobj.launchBrowser(browser);
		Reporter.log("Launch the Browser Succcessfully",true);
		 
		//Maximize the Browser
		webdriverobj.maximizeTheBrowser();
		Reporter.log("Maximize the browser successfully",true);
		
		//Step 2.Navigating To The Application via URl
		webdriverobj.NavigateToTheApplication(url);
		Reporter.log("Navigating to the application via url is successful",true);
			 }
	
	
	@AfterClass
	
	/**
	 * This Method Is Used to Terminate The Browser
	 * @param 
	 * @return void */

	public  void terminateBrowser() {
		
		//Step 10 Close the Browser
		webdriverobj.closeAllTheBrowser();
		Reporter.log("Close the browser successfully",true);
		
	}
	
	/**
	 * This Method Is Used to Create Objects  
	 * @param 
	 * @return void */
	public void createObjects()
	{
		webdriverobj=new WebDriverUtility();
		excelutilityobj=new ReadExcelFile();
	 propertyfileobj=new ReadPropertyFile();
		
	}

	
	
		 }
		
		
