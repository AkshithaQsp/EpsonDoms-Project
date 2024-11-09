package com.Epsondoms.WelcomeTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Epsondoms.Genericlibrary.BaseTest;
import com.Epsondoms.Javalibrary.JavaUtility;
import com.Epsondoms.PageRepository.PageManagement;
import com.Epsondoms.PageRepository.WelcomePage;
import com.Epsondoms.WebDriverlibrary.WebDriverUtility;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyWelcomePageTest extends BaseTest {
	
	@Test(priority=1)
	public void verifywelcomepageWithvalidinput()
	{
		
		//Create the Test Information
		test=report.createTest("verifywelcomepageWithvalidinput");
		
		//Step Information
		test.log(Status.INFO,"<<.............Execution Started Successfully.....>>");
		
		//Execute the Precondition-->1.Launch the Browser,Navigate to URL
		test.log(Status.INFO,"Step1:Launching the Browser Successfull");
		
		//Implicit Wait
		webdriverobj.waitImplicitly(20);
		
		
		 //Verify The Welcome page UsingTitle
		 String exptitile="Learning Selenium";
		 
		//Verify The Welcome Page Using Title
			Assert.assertEquals("Learning Selenium", webdriverobj.driver.getTitle());
			test.log(Status.PASS,"Title Verified");
			
		//Create an Object For PageManager
			PageManagement pageManagementobj=new PageManagement(webdriverobj.driver);
					
		//Verify the Name TextField
			boolean result=pageManagementobj.initwelcomepage().getNameTextField().isDisplayed();
			Assert.assertTrue(result);	
			test.log(Status.PASS,"step3:clear Action Done Successfully-Name Textfield");
			
		//Perform Action--clear
			pageManagementobj.initwelcomepage().getNameTextField().clear();
			test.log(Status.PASS,"step3:clear Action Done Successfully-Name TextField");
			
	//Perform SendKeys
			pageManagementobj.initwelcomepage().getNameTextField().sendKeys(username);
			test.log(Status.PASS,"step4:Sendkeys Actions Done Successfully-Name TextField");
			
			//See The Execution
			JavaUtility.pause(3000);
			
			//Soft Assert Statement
			SoftAssert softassertobj=new SoftAssert();
			
			
			//Verify the Contact us"HyperLink
			softassertobj.assertEquals("Contact Us",pageManagementobj.initwelcomepage().getLink().getText());
		     test.log(Status.PASS,"Step4:Verified Text Successfully-contact us HyperLink");
		     softassertobj.assertAll();
		     
		     //Execution Log Or Status
		     test.log(Status.PASS,"<<---Execution Completed Successfully-->>");
	}
		     
		     
		     
		     @Test(priority = 2, invocationCount = 2, enabled = false, dependsOnMethods = "verifywelcomepageWithvalidinput")
		 	public void verifyWelcomepageWithInValidInput() {

		 		// Create the Test Information
		 		test = report.createTest("verifyWelcomepageWithValidInput");

		 		// Steps Information
		 		test.log(Status.INFO, "<<--Execution started successfully-->>");
		 		// Execute the Preconditon-1.Launch the Browser, 2. Navigate to URL

		 		// implicit Wait
		 		webdriverobj.waitImplicitly(20);

		 		// Verify the Welcome Page Using Title
		 		String exptitle = "Learning Selenium";
		 		String acttitle = webdriverobj.driver.getTitle();

		 		Assert.assertEquals(acttitle, exptitle);
		 		test.log(Status.PASS, "----Title Verified:" + acttitle);

		 		// create an Object For PageManager
		 		 pageMangmentobj = new PageManagement(webdriverobj.driver);

		 		// verify the Name TextField
		 		boolean result = pageMangmentobj.initwelcomepage().getNameTextField().isDisplayed();

		 		Assert.assertTrue(result);
		 		test.log(Status.PASS, "Element Verified: Name TextField is Displayed");

		 		// Step 3: Perform Action---Clear
		 		pageMangmentobj.initwelcomepage().getNameTextField().clear();
		 		test.log(Status.PASS, "step3:clear Action Done Successfully -Name Textfield");

		 		// Step 4: Perform actions----sendKeys
		 		pageMangmentobj.initwelcomepage().getNameTextField().sendKeys("adfdfkjdklfj");
		 		test.log(Status.PASS, "step 4:sendKeys Action Done Successfully -name Textfield");

		 		// See the Execution
		 		JavaUtility.pause(3000);

		 		// To Make The Explicit TestScript Fail
		 		// Assert.fail();

		 		// Execute the postcondition--->1.Terminate The Browser
		 		// Execution Log or Status
		 		test.log(Status.INFO, "----Execution completed successfully--->");

	}
}
	 
	
	
	


