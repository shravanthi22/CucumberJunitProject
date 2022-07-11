package com.vcentry.lab.stepDefinition;

import com.vcentry.lab.base.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestSteps extends BaseClass{
	
	
	@Given("User should Open browser as {string}")
	public void user_should_open_browser_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
		openBrowser(string);
		initObject();
		  
	}

	@Given("User should Launch url")
	public void user_should_launch_url() {
	    // Write code here that turns the phrase above into concrete actions
		getDriver.get(Thread.currentThread().getId())
		.get("https://www.saucedemo.com/");
	}

	@When("User enter Username {string}")
	public void user_enter_username(String string) {
	    // Write code here that turns the phrase above into concrete actions
		login.enterUsername(string);
	    
	}

	@When("User enter Password {string}")
	public void user_enter_password(String string) {
	    // Write code here that turns the phrase above into concrete actions
		login.enterPasswork(string);
	    
	}

	@When("Click on Login button")
	public void click_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		login.clickLogin();
	    
	}

	@Then("User should navigate to HomePage")
	public void user_should_navigate_to_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		home.verifyHomePage();
	    
	}
	
	@Then("User should get error message")
	public void User_should_get_error_message()
	{
		login.verifyErrorMessage();
	}
}
