package com.Epsondoms.PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageManagement {
	public WebDriver driver;
	public LoginPage loginpageobj;
	public RegisterPage registerpageobj;
	public WelcomePage welcomepageobj;
	
	//Intialization
	public PageManagement(WebDriver driver)
	{
		//PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public LoginPage initloginpage()
	{
		loginpageobj=new LoginPage(driver);
		return loginpageobj;
		
	}
	
	public WelcomePage initwelcomepage()
	{
		welcomepageobj=new WelcomePage(driver);
		return welcomepageobj;
		
	}
	
	public RegisterPage initregisterpage() {
		registerpageobj=new RegisterPage(driver);
		return registerpageobj;
		
	}
	

}
