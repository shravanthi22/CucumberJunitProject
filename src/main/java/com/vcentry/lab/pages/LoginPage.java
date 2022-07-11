package com.vcentry.lab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vcentry.lab.base.BaseClass;

public class LoginPage extends BaseClass{
	WebDriver driver;
	
	public LoginPage(WebDriver driver)  
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="user-name")
	private WebElement username;
   
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="login-button")
	private WebElement loginBtn;
	
	public void enterUsername(String uName)
	{
		enterText(username, uName);
	}
	
	public void enterPasswork(String pwd)
	{
		enterText(password, pwd);
	}
	
	public void clickLogin()
	{
		clickElement(loginBtn);
	}
	
}
