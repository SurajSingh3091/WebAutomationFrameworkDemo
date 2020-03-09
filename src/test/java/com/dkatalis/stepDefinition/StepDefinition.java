package com.dkatalis.stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.dkatalis.framework.Framework;
import com.dkatalis.framework.ObjectReader;

import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert.*;
import static org.junit.Assert.*;
public class StepDefinition {

	ObjectReader orReader =null;
	Framework framework = null;	
	WebDriver driver;
	@Before
	public void initialSetup() throws Exception{
		framework = new Framework();
		orReader = new ObjectReader();
		framework.readPropertyFile();		
		driver = framework.initialise(framework.getPropertyValue("BROWSER"));		
	}
	@Given("^User is on home page$")
	public void user_is_on_home_page() throws Throwable {
		driver.navigate().to("https://demo.midtrans.com/");
		if(framework.visibilityOfElement("Title")){
			driver.manage().window().maximize();
			assertEquals(driver.getTitle(), "Sample Store");			
		}
		System.out.println(driver.getTitle());		
	}

	@When("^User clicks on buy now button and then clicks on CheckOut$")
	public void user_clicks_on_buy_now_button() throws Throwable {
		if(framework.visibilityOfElement("BuyNow")){
			driver.findElement(By.xpath(orReader.getObjectLocator("BuyNow", "XPATH"))).click();	
			if(framework.visibilityOfElement("CheckOut")){
				driver.findElement(By.xpath(orReader.getObjectLocator("CheckOut", "XPATH"))).click();	
				
			}
		}
	    
	}
	
	@When("^User checks for amount and click continue button$")
	public void user_checks_for_amount_and_click_continue_button() throws Throwable {
	}

	@When("^User selects Payment mode as credit card and enters card details$")
	public void user_selects_Payment_mode_as_credit_card_and_enters_card_details(DataTable cardDetails) throws Throwable {
	    
	}

	@Then("^User clicks on Paynow button and enters otp \"([^\"]*)\"$")
	public void user_clicks_on_Paynow_button_and_enters_otp(String password) throws Throwable {
	    
	}
}
