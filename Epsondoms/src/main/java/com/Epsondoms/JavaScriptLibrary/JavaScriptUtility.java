package com.Epsondoms.JavaScriptLibrary;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;

import com.Epsondoms.WebDriverlibrary.WebDriverUtility;

/**
 * This Class Provides The Resuable Methods To Perform JavaScript Operatins
 * 
 * 
 * @author Kallem Akshitha
 * */

public class JavaScriptUtility {
	public static JavascriptExecutor javascriptobj;
	
	
/**
 * This Method is used to Enter the data in DisabledElements
 * @param WebElement element,String data
 * @return void */
	public static void enterData_DisabledElement(WebElement element,String data)
	{
		javascriptobj=(JavascriptExecutor)WebDriverUtility.driver_static;
		javascriptobj.executeScript("arguments[0].value= '"+data+"'",element);
	}
	
	/**
	 * This Method is used to perform Click Operation on DisabledElements
	 * @param WebElement element
	 * @return void */
	
	public static void click_DisabledElement(WebElement element)
	{
		javascriptobj=(JavascriptExecutor)WebDriverUtility.driver_static;	
		javascriptobj.executeScript("arguments[0].click()",element);
		
	}
	
	/**
	 * This Method is used to Perform Scrolling Action by Using ScrollBy Method
	 * @param 
	 * @return void */

	public static void defaultVerticalscrollBy()
	{
		javascriptobj=(JavascriptExecutor)WebDriverUtility.driver_static;
		javascriptobj.executeScript("window.scrollBy(1000,1000)");
		
	}

	/**
	 * This Method is used to Perform Scrolling Action by Using ScrollTo Method
	 * @param 
	 * @return void */	
	
	public static void defaultVerticalscrollTo()
	{
		javascriptobj=(JavascriptExecutor)WebDriverUtility.driver_static;	
		javascriptobj.executeScript("window.scrollTo(1000,1000)");
	}
	

	/**
	 * This Method is used to Perform Scrolling Action by Using ScrollIntoView Method
	 * @param 
	 * @return void */
	public static void scrollUsingView(WebElement element,boolean value)
	{
		javascriptobj=(JavascriptExecutor)WebDriverUtility.driver;
		javascriptobj.executeScript("arguments[0].scrollIntoView("+value+");",element);
	}
	
}
