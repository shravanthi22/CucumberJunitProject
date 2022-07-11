package com.vcentry.lab.base;

import java.util.HashMap;
import java.util.logging.LogManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import com.vcentry.lab.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
    public static Logger log= LogManager.getLogger(BaseClass.class);
    public static HashMap<Long,WebDriver> getDriver;
    public static LoginPage login;
    
    
    
    public void openBrowser(String browser)  {
    	
    	try  {
    		if(browser.equalsIgnoreCase("chrome"))  
    		{
    			WebDriverManager.chromedriver().setup();
    			driver=new ChromeDriver();  			
    		} else if (browser.equalsIgnoreCase("edge"))  
    		{
    			WebDriverManager.edgedriver().setup();
    			driver= new EdgeDriver();
    		}
    		getDriver=new HashMap<Long, WebDriver>();
    		getDriver.put(Thread.currentThread().getId(), driver);
    		driver.manage().window().maximize();
    		log.info("Browser Opened Successfully");
    		
    	}catch (Exception e)  {
    		e.printStackTrace();
    		log.error("Unable to open browser");
    	}
    }
    public void initObject()
    {
    	login=new LoginPage
    	(getDriver.get(Thread.currentThread().getId()));
    }  
    
    public boolean waitForElement(WebElement element)  
    {
    	boolean flag=false;
    	try {
    		WebDriverWait wait=new WebDriverWait(getDriver.get(Thread.currentThread().getId()),30);
    		wait.until(ExpectedConditions.visibilityOf(element));
    		flag=true;
    		log.info(element+" is visible");
    		return flag;
    	} catch (Exception e)
    	{ 
    			e.printStackTrace();
    			log.error(element+" is not visible");
    		}
    		 return flag;
    		 
    	}
    	public boolean clickElement(WebElement element)
    	{
    		boolean flag=false;
    		try {
    			if(waitForElement(element))
    			{
    				element.click();
    			}
    			flag=true;
    			
    			log.info(element+" is clicked");
    			return flag;
    		} catch(Exception e)
    		{
    			e.printStackTrace();
    			log.error(element+" is not clicked");
    			
    		}
    		return flag;
    	}
    	
    	public boolean enterText(WebElement element,String text)
    	{
    		boolean flag=false;
    		try
    		{
    			if(waitForElement(element))
    			{
    				element.clear();
    				element.sendKeys(text);
    			}
    			flag=true;
    			
    			log.info(text+" is entered in"+ element);
    			return flag;
    		} catch(Exception e)
    		{
    			e.printStackTrace();
    			log.error(text+"is nt entered"+ element);
    		}
    		return flag;
    	}
    	
    	public boolean elementDisplayed(WebElement element)
    	{
    		boolean flag=false;
    		try {
    			waitForElement(element);
    			flag= element.isDisplayed();
    		} catch (Exception e)
    		{
    			e.printStackTrace();
    			log.error(element+" is not displayed");
    		}
    		return flag;
    	}
    	public boolean clickCheckbox(WebElement element)
    	{
    		boolean flag=false;
    		try{
    			if(waitForElement(element))
    			{
    				if (!element.isSelected())
    				{
    					element.click();
    				}
    				else
    				{
    					log.info(element+" checkbox is already clicked");
    				}
    				
    			}
    			flag=true;
    			
    			log.info(element+"checkbox is clicked");
    			return flag;
    		} catch(Exception e)
    		{
    			e.printStackTrace();
    			log.error(element+" checkbox is not clicked");
    		}
    		return flag;
    	}
    }
    				
  