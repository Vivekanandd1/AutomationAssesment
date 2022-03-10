package com.automationpractice.pgobjct;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.Scenario;


public class HomePageObject {
	private static final Logger log = LogManager.getLogger(HomePageObject.class);
	private WebDriver driver;
	public String ActualUrl = "http://automationpractice.com";
	public String ExpectedUrl = "http://automationpractice.com/index.php";
	private By Logo = By.cssSelector("img[alt='My Store']");
	private By WidthHeight  = By.cssSelector("img[alt='My Store']");
	private By MainProductList = By.xpath("//div[@id='block_top_menu']/ul/li");
//	private By ProductCategory1 = By.xpath("//a[@class='sf-with-ul'][text()='Women']");
//	private By ProductCategory2 = By.xpath("//li/ul/li/a[@title='Dresses']");
//	private By ProductCategory3 = By.xpath("//div/ul/li/a[@title='T-shirts']");
	private By ProductCategory1 = By.xpath("//div[@id='block_top_menu']/ul/li[1]");
	private By ProductCategory2 = By.xpath("//div[@id='block_top_menu']/ul/li[2]");
	private By ProductCategory3 = By.xpath("//div[@id='block_top_menu']/ul/li[3]");
	private By Textbox = By.id("search_query_top");
	private By AutoSuggestion = By.cssSelector("div.ac_results");
	private By TwitterBTN = By.cssSelector("li.twitter");
	public int ActualWidth = 350, ActualHieght=99;
	private Scenario scn;
	
	
	  public HomePageObject(WebDriver driver,Scenario scn){
	        this.driver = driver;
	        this.scn= scn;
	    }
	
	public void UrlValidation() {
		String CurrentPageUrl = driver.getCurrentUrl();
		log.info("current page url is "+CurrentPageUrl);		
	}
	
	public void UrlComparison() {
		String CurrentPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(ExpectedUrl, CurrentPageUrl);
		log.info("Both the given and present url are same "+ExpectedUrl+" "+CurrentPageUrl);
		scn.log("Both the given and present url are same "+ExpectedUrl+" "+CurrentPageUrl);
		
	}
	public void LogoVisibilty() {
		boolean logoPresent = driver.findElement(Logo).isDisplayed();
		Assert.assertTrue(logoPresent);
		log.info("logo is visible in top left corner");
	}
	
	public void HieghtWidthValidation() {
		int Width = driver.findElement(WidthHeight).getSize().getWidth();
		  int Height = driver.findElement(WidthHeight).getSize().getHeight();
		  Assert.assertEquals(ActualHieght, Height);
		  Assert.assertEquals(Width, ActualWidth);
		  log.info("Height is - "+Height +  " and Width is - " +Width);
		  scn.log("Height is - "+Height +  " and Width is - " +Width);
	}
	
	public void Mainproductcount() {
		 List<WebElement> MainProduct = driver.findElements(MainProductList);
		 Assert.assertEquals(3,MainProduct.size());
		 log.info("Main Product list count is -"+ MainProduct.size());
		 scn.log("main product count is "+MainProduct.size());
		
	}
	public void MainProductCategory() {
		String Mainproduct_1 = driver.findElement(ProductCategory1).getText();
	    String Mainproduct_2 = driver.findElement(ProductCategory2).getText();
	    String Mainproduct_3 = driver.findElement(ProductCategory3).getText();
	    Assert.assertEquals(Mainproduct_1,"WOMEN");
	    Assert.assertEquals(Mainproduct_2,"DRESSES");
	    Assert.assertEquals(Mainproduct_3,"T-SHIRTS");
	    log.info("the main product in Application is "+Mainproduct_1+" "+Mainproduct_2+" "+Mainproduct_3);
	    scn.log("the main product in Application is "+Mainproduct_1+" "+Mainproduct_2+" "+Mainproduct_3);
	}

	public void Userinput() {
		WebElement Searchox = driver.findElement(Textbox);
		 Searchox.sendKeys("T-shirt");
		 log.info("user searched for T-shirt");
		 scn.log("user searched for T-shirt");
	}
	
	public void AutoSuggestion() {
		WebDriverWait webDriverWait = new WebDriverWait(driver,20);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(AutoSuggestion));
		String AutoText = driver.findElement(AutoSuggestion).getText();
		Assert.assertEquals(AutoText.contains("T-shirt"),true);
		log.info("the text is -"+AutoText);
		scn.log("the text is -"+AutoText);
	}
	public void TwitterButton() {
		 WebElement TwitterBtn = driver.findElement(TwitterBTN);
		  TwitterBtn.click();
		log.info("User clicked on Twitter button");
	   scn.log("User clicked on Twitter button");
		
	}
	
}
