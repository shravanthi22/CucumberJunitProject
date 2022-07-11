package com.vcentry.lab.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vcentry.lab.base.BaseClass;

public class HomePage  extends BaseClass {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//span[text()='Products']")
	private WebElement title;
	
	public void verifyHomePage()
	{
		Assert.assertTrue(elementDisplayed(title));
	}

}
