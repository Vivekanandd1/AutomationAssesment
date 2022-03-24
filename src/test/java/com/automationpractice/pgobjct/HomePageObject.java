package com.automationpractice.pgobjct;

import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

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
	private By Logo = By.cssSelector("img[alt='My Store']");
	private By WidthHeight = By.cssSelector("img[alt='My Store']");
	private By MainProductList = By.xpath("//div[@id='block_top_menu']/ul/li");
//	private By ProductCategory1 = By.xpath("//div[@id='block_top_menu']/ul/li[1]");
//	private By ProductCategory2 = By.xpath("//div[@id='block_top_menu']/ul/li[2]");
//	private By ProductCategory3 = By.xpath("//div[@id='block_top_menu']/ul/li[3]");
	private By Textbox = By.id("search_query_top");
	static int i = 0;
	private By AutoSuggestion = By.cssSelector("div.ac_results");
	private By TwitterBTN = By.cssSelector("li.twitter");
//	public int ActualWidth = 350, ActualHieght = 99;
	private Scenario scn;

	public HomePageObject(WebDriver driver, Scenario scn) {
		this.driver = driver;
		this.scn = scn;
	}

	public void UrlValidation() {
		String CurrentPageUrl = driver.getCurrentUrl();
		log.info("current page url is " + CurrentPageUrl);
	}

	public void UrlComparison(String RedirectedUrl) {
		String CurrentPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(RedirectedUrl, CurrentPageUrl);
		log.info("Both the given and present url are same " + RedirectedUrl + " " + CurrentPageUrl);
		scn.log("Both the given and present url are same " + RedirectedUrl + " " + CurrentPageUrl);

	}

	public void LogoVisibilty() {
		boolean logoPresent = driver.findElement(Logo).isDisplayed();
		Assert.assertTrue(logoPresent);
		log.info("logo is visible in top left corner");
	}

	public void HieghtWidthValidation(int height,int width) {
		int Width = driver.findElement(WidthHeight).getSize().getWidth();
		int Height = driver.findElement(WidthHeight).getSize().getHeight();
		log.info("Height is - " + Height + " and Width is - " + Width);
		scn.log("Height is - " + Height + " and Width is - " + Width);
		Assert.assertEquals(height, Height);
		Assert.assertEquals(width, Width);
	}

	public void Mainproductcount() {
		List<WebElement> MainProduct = driver.findElements(MainProductList);
		Assert.assertEquals(3, MainProduct.size());
		log.info("Main Product list count is -" + MainProduct.size());
		scn.log("main product count is " + MainProduct.size());

	}

	public void MainProductCategory(String ProductCategoryText) {
		List<WebElement> MainProduct = driver.findElements(MainProductList);
			String ProductText = MainProduct.get(i).getText();
			if (ProductText.equals(ProductCategoryText)) {
				Assert.assertEquals(ProductCategoryText, ProductText);
				scn.log(" product are " + ProductCategoryText + " And " + ProductText);
				log.info(" product are " + ProductCategoryText + " And " + ProductText);
			}
			else {
				scn.log(" product listed in example is " + ProductCategoryText + " And given in WebApp is " + ProductText);
				log.fatal("Product not matched with listed category");
	            Assert.fail("Product not matched with listed category");
			}
			i++;
		}

	public void Userinput(String productname) {
		WebElement Searchox = driver.findElement(Textbox);
		Searchox.sendKeys(productname);
		log.info("user searched for T-shirt");
		scn.log("user searched for T-shirt");
	}

	public void AutoSuggestion(String productname) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(AutoSuggestion));
		String AutoText = driver.findElement(AutoSuggestion).getText();
		Assert.assertEquals(AutoText.contains(productname), true);
		log.info("the Auotsuggestiontext " +AutoText+" Conatains "+productname );
		scn.log("the Auotsuggestiontext " +AutoText+" Conatains "+productname);
	}

	public void TwitterButton() {
		WebElement TwitterBtn = driver.findElement(TwitterBTN);
		TwitterBtn.click();
		log.info("User clicked on Twitter button");
		scn.log("User clicked on Twitter button");

	}

}