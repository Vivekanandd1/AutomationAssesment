package com.automationpractice.STEPDEFS;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.automationpractice.core.WebDriverFactory;
import com.automationpractice.pgobjct.HomePageObject;
import com.automationpractice.pgobjct.TwitterPageObject;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class STEPDEFS {
	
	 private static final Logger log = LogManager.getLogger(STEPDEFS.class);
	 WebDriver driver;
	 String url = "http://automationpractice.com";
   	Scenario scn;
   	HomePageObject homePageObject;
   	TwitterPageObject twitterPageObject;
	 
   	@Before
	  public void setUp(Scenario scn) throws Throwable{
		 this.scn = scn; 	
		//Get the browser name by default it is chrome
	        String browserName = WebDriverFactory.getBrowserName();
	        driver = WebDriverFactory.getWebDriverForBrowser(browserName);
	        log.info("Browser invoked.");
			homePageObject = new HomePageObject(driver, scn);
			twitterPageObject = new TwitterPageObject(driver, scn);       
 }
	  @After(order=1)
	  public void cleanup() {
		  WebDriverFactory.quitDriver();
	  }
	  @After(order=2) // 
	    public void takeScreenShot(Scenario s) {
	      if (s.isFailed()) {
	          TakesScreenshot scrnShot = (TakesScreenshot)driver;
	          byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
	          scn.attach(data, "image/png","Failed Step Name: " + s.getName());
	      }else{
	          scn.log("Test case is passed, no screen shot captured");
	      }
	    }
	
	@Given("User navigated to home page url")
	public void user_navigated_to_home_page_url() {
	    WebDriverFactory.navigateToTheUrl(url);
	    scn.log("user landed on home page "+url);
	}
	@When("User validated Application url")
	public void user_validated_application_url() {
		homePageObject.UrlValidation();
	    scn.log("current page url is "+driver.getCurrentUrl());
	}
	@Then("Compared with given url")
	public void compared_with_given_url() {
	    homePageObject.UrlComparison();
	    
	}	

	@When("User validated visibility of Application logo")
	public void user_validated_visibility_of_application_logo() {
		homePageObject.LogoVisibilty();
		scn.log("Logo validation done here");
	  
	}
	@Then("User validated Height and Width of Application logo")
	public void user_validated_height_and_width_of_application_logo() {
	 homePageObject.HieghtWidthValidation();
	}	
	@When("user validated main product count")
	public void user_validated_main_product_count() {
	homePageObject.Mainproductcount();
	}
	
	@Then("user fetched all main product text")
	public void user_fetched_all_main_product_text() {
	    homePageObject.MainProductCategory();
	}
	@When("user entered text in searchbox {string}")
	public void user_entered_text_in_searchbox(String string) {
		homePageObject.Userinput();
	}

	@Then("user validated autosuggestion text")
	public void user_validated_autosuggestion_text() {
		homePageObject.AutoSuggestion();
	}
	@When("User clicked on twitter logo")
	public void user_clicked_on_twitter_logo() {
	     homePageObject.TwitterButton();
	}
	@Then("user validated new tab conatains {string}")
	public void user_validated_new_tab_conatains(String string) throws InterruptedException {
		twitterPageObject.NewTabValidation();
	}
	@Then("user validated account name is {string}")
	public void user_validated_account_name_is(String string) {
		twitterPageObject.AccountHandleValidation();
	}
}
	

