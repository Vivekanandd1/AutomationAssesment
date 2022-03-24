
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
		}
		else{
			scn.log("Test case is passed, no screen shot captured");
		}
	}

	@Given("User navigated to home page url")
	public void user_navigated_to_home_page_url() {
		WebDriverFactory.navigateToTheUrl(url);
		scn.log("user landed on home page "+url);
	}
	@Then("User should be redirected to {string}")
	public void user_should_be_redirected_to(String RedirectedUrl) {
		homePageObject.UrlComparison(RedirectedUrl);
	}
	
	@When("User validated visibility of Application logo")
	public void user_validated_visibility_of_application_logo() {
		homePageObject.LogoVisibilty();
		scn.log("Logo validation done here");
	}
	@Then("User validated Height is {int} and Width is {int} of Application logo")
	public void user_validated_height_is_and_width_is_of_application_logo(Integer int1, Integer int2) {
		homePageObject.HieghtWidthValidation(int1,int2);
	  }
	@When("user validated main product count")
	public void user_validated_main_product_count() {
		homePageObject.Mainproductcount();
	}
	@Then("user validated main product category should be {string}")
	public void user_validated_main_product_category_should_be(String ProductCategoryText) {
	  homePageObject.MainProductCategory(ProductCategoryText);
	}
	
	@When("user entered text in searchbox {string}")
	public void user_entered_text_in_searchbox(String productname) {
		homePageObject.Userinput(productname);
	}
	@Then("autosuggestion text should contains {string}")
	public void autosuggestion_text_should_contains(String productname) {
		homePageObject.AutoSuggestion(productname);
	}
	@When("User clicked on twitter logo")
	public void user_clicked_on_twitter_logo() {
		homePageObject.TwitterButton();
	}
	@Then("user validated new tab conatains {string}")
	public void user_validated_new_tab_conatains(String content) {
		twitterPageObject.NewTabValidation(content);
	}
	@Then("user validated account name is {string}")
	public void user_validated_account_name_is(String AccountHandle) {
		twitterPageObject.AccountHandleValidation(AccountHandle);
	}
}


