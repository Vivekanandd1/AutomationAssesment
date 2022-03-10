package com.automationpractice.pgobjct;

import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.Scenario;


public class TwitterPageObject {
	
	private static final Logger log = LogManager.getLogger(TwitterPageObject.class);
	private WebDriver driver;
	private Scenario scn;
	private By AcountName = By.xpath("//main/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/span/span[@class='css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0']");
	private  String Actual  = "Selenium Framework";
	public TwitterPageObject(WebDriver driver,Scenario scn){
        this.driver = driver;
        this.scn= scn;
    }
	public void NewTabValidation() {
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String ParentWindow = it.next();
		String ChildWindow = it.next();
		driver.switchTo().window(ChildWindow);
		WebDriverWait webDriverWait = new WebDriverWait(driver,20);
        webDriverWait.until(ExpectedConditions.urlContains("https://twitter.com/seleniumfrmwrk"));
        String CurrentPageUrl = driver.getCurrentUrl();
        String Expected = CurrentPageUrl.split("com/")[1];
        Assert.assertEquals("seleniumfrmwrk", Expected);
        log.info("in current page url |"+ CurrentPageUrl+" | word present is "+Expected);
        scn.log("in current page url |"+ CurrentPageUrl+" | word present is "+Expected);
	}
    public void AccountHandleValidation() {
    	WebDriverWait webDriverWait = new WebDriverWait(driver,20);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(AcountName));
    	String HandleName = driver.findElement(AcountName).getText();
		Assert.assertEquals(HandleName, Actual);
	    log.info("Twitter handle is "+HandleName);
		scn.log("Twitter handle is "+HandleName);
    }
	 

}
