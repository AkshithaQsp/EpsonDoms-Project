package com.Epsondoms.WebDriverlibrary;

import java.awt.Robot;

import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This Class is Used to Provides the Resuable Methods To Perform All Browser Related Actions
 * @author Kallem Akshitha*/

public class WebDriverUtility {
	
	public static WebDriver driver;
	public static Select selectobj;
	public static Actions actionsobj;
	public static Robot   robotobj;
	public static WebDriver driver_static;
	
	/**
	 * This Method is used to Launch the SpecificBrowser
	 * 
	 *@param String BrowserName
	 *@return void*/
	public void launchBrowser(String browser)
	{
		 switch(browser)
		 {
		 case "chrome":
			 WebDriverManager.chromedriver().setup();
		     driver=new ChromeDriver();
		     driver_static=driver;
		     
		      break;
		 
	     case "edge":
	    	 WebDriverManager.edgedriver().setup();
		    driver=new EdgeDriver();
		    driver_static=driver;
		    break;
		 
	     case "firefox":
	    	 WebDriverManager.firefoxdriver().setup();
	        driver=new FirefoxDriver();
	        driver_static=driver;
		    break;
			 
		 default:
			 System.out.println("You have entered incorrect Browser name");
	   
			 }
		 Reporter.log("Step 1:Successfully Launched");
	}
		 public  void NavigateToTheApplication(String Url)
		 {
			 driver.get(Url);
		 }
	/**
	 * This Method is used to Maximize The Browser
	 * 
	 * @param 
	 * @return void*/
	
	public  void maximizeTheBrowser()
	{
		driver.manage().window().maximize();
	}
 /**
  * This Method is used to Close the Browser
  * 
  * @param 
  * @return void*/	
	public  void closeTheBrowser()
	{
		driver.close();
	}
/**
 * This Method is Used To CLose The All The Browsers
 * 
 * @param 
 * @return void*/
	public  void closeAllTheBrowser()
	{
		driver.quit();
	}
/**
 * This Method is Used To Perform ImplicitlyWait
 * @param long duration
 * @return void*/
	
	public void waitImplicitly(long duration)
	{
		driver.manage().timeouts().implicitlyWait(duration,TimeUnit.SECONDS);

}
/**
 * This Method is Used To Perform ExplicitlyWait
 * 
 * @param long duration, WebElement element
 * @return void*/
	public  void waitExplicitly(long duration,WebElement element)
	{
		 WebDriverWait wait = new WebDriverWait(driver,duration);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
/**
 * This Method is Used To Peform DropDown Action by Index Value
 * @param WebElement element, int index
 * @return void*/
	public void selectOptionInDropdown1(WebElement element,int index)
	{
		selectobj.selectByIndex(index);
	}
/**
 *This Method is Used To Peform DropDown Action by VisibleText 
 * @param WebElement element, String visibletext
 * @return void */
	public void selectOptionInDropdown(WebElement element,String visibletext)
	{
		selectobj.selectByVisibleText(visibletext);       
	}
/**
	 *This Method is Used To Peform DropDown Action by Value
	 * @param String value, WebElement element
	 * @return void */	
	
	public void selectOptionInDropdown(String value,WebElement element)
	{
		selectobj.selectByValue(value);       
	}
/**
 * This Method is Used To Perform MouseHovering Action by MoveToElement method
 * @param WebElement element
 * @return void*/	
	
	public void mouseHovering(WebElement element)
	{
		actionsobj.moveToElement(element).perform();
	}
	/**
	 * This Method is Used To Perform MouseHovering Action for left Click by click method
	 * @param WebElement element
	 * @return void*/	
	
	public void leftClick(WebElement element)
	{
		actionsobj.click(element);
	}
	/**
	 * This Method is Used To Perform MouseHovering Action for LeftClick by ContextClick method
	 * @param WebElement element
	 * @return void*/	
	
	public void RightClick(WebElement element)
	{
		actionsobj.contextClick(element).perform();
	}
	/**
	 * This Method is Used To Perform DragAndDrop Actions
	 * @param WebElement element1, WebElement element2
	 * @return void*/	
	public void dragAndDrop(WebElement element1,WebElement element2)
	{
		actionsobj.dragAndDrop(element1, element2).perform();
	}
	/**
	 * This Method is Used To Perform DoubleClick Operation
	 * @param WebElement element
	 * @return void*/	
	public void doubleClick(WebElement element)
	{
		actionsobj.doubleClick().perform();
	}
	/**
	 * This Method is Used To Perform PageDown Operations for Pressing
	 * @param 
	 * @return void*/		 
	public void pressTheKey_pageDown()
	{
	robotobj.keyPress(KeyEvent.VK_PAGE_DOWN);	
	}
	
	/**
	 * This Method is Used To Perform PageDown Operations to Release
	 * @param 
	 * @return void*/	
	public void releaseTheKey_pageDown()
	{
		robotobj.keyPress(KeyEvent.VK_PAGE_DOWN);
	}
	/**
	 * This Method is Used To Perform Alert Accept
	 * @param 
	 * @return void*/
	
	
	public void alertPopupAccept()
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This Method is Used To Perform Alert Dismiss
	 * @param 
	 * @return void*/
	public void alertPopupDismiss()
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This Method is Used To Perform Switch The Control Into The Frame BY Index
	 * @param int index
	 * @return void*/
	public void switchControlToFrame(int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This Method is Used To Perform Switch The Control Into The Frame By Element
	 * @param WebElement element
	 * @return void*/
	public void switchControlToFrame(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This Method is Used To Perform Switch The Control Into The Main 
	 * @param 
	 * @return void*/
	
	
	public void switchBackTheControlToMain()
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This Method is Used To Perform Switch The Control Into The Window 
	 * @param String windowaddress
	 * @return void*/
	public void switchControlToWindow(String windowaddress)
	{
		
		driver.switchTo().window(windowaddress);
	}
	
}
