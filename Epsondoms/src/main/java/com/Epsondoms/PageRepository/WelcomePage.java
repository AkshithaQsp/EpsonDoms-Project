package com.Epsondoms.PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
	//Initialization
		public WelcomePage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		
		//Declaration
		@FindBy(id="name")
		private WebElement NameTextField;
		
		@FindBy(id="email")
		private WebElement EmailTextField;
		
		@FindBy(id="password")
		private WebElement PasswordTextField;
		
		@FindBy(id="mobile")
		private WebElement MobileTextField;
		
		@FindBy(id="dob")
		private WebElement DateOfBirthTextField;
		
		@FindBy(xpath="//input[@id='male']")
		private WebElement GenderRadioButton;
		
		@FindBy(xpath="//input[@id='goa']")
		private WebElement PlaceRadiobutton;
		
		@FindBy(xpath="(//option[text()='INDIA'])[1]")
		private WebElement Country;
		
		@FindBy(xpath="//textarea[@id='feedback']")
		private WebElement FeedbackTextArea;
		
		@FindBy(xpath="//input[@name='photo']")
		private WebElement FileChoosen;
		
		
		@FindBy(xpath="//input[@id='reg']")
		private WebElement Register;
		
		@FindBy(partialLinkText="Contact Us")
		private WebElement ContactUsLink;
		
		//Utilization
		
		 public WebElement getNameTextField()
		 {
			return NameTextField;
		 }
		 public WebElement getEmailTextField()
		 {
			return  EmailTextField;
		 }
		 public WebElement getPasswordTextField()
		 {
			return  PasswordTextField;
		 }
		 
		 public WebElement getMobileTextField()
		 {
			return MobileTextField; 
		 }
		 
		 public WebElement getDateOfBirthTextField()
		 {
			 return DateOfBirthTextField;
		 }
		 
		 public WebElement getLink()
		 {
			return  ContactUsLink;
		 }
		 public WebElement getGenderRadioButton() {
				return GenderRadioButton;
			}
			
			public WebElement getPlaceRadiobutton() {
				return PlaceRadiobutton;
			}
		
			public WebElement getCountry() {
				return Country;
			}
			
			
			public WebElement getFeedbackTextArea() {
				return FeedbackTextArea;
			}
			
			public WebElement getFileChoosen() {
				return FileChoosen;
			}
			
			
			public WebElement getRegister() {
				return Register;
			}
			
		 

}
