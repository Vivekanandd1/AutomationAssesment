package com.automationpractice.pgobjct;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automationpractice.core.WebDriverFactory;

import io.cucumber.java.Scenario;


public class TwitterPageObject {
	
	private static final Logger log = LogManager.getLogger(TwitterPageObject.class);
	private WebDriver driver;
	private Scenario scn;
	private By AcountName = By.xpath("(//span[contains(text(),'PrestaShop')])[2]");
	private  String Actual  = "PrestaShop";
	WebDriverFactory webDriverFactory = new WebDriverFactory();
	
	public TwitterPageObject(WebDriver driver,Scenario scn){
        this.driver = driver;
        this.scn= scn;
	}
            
    
	public void NewTabValidation(String content) {
		webDriverFactory.SwitchNextTab();
		String CurrentPageUrl = driver.getCurrentUrl();
        String Expected = CurrentPageUrl.split("com/")[1];
        Assert.assertEquals(content, Expected);
        log.info("in current page url |"+ CurrentPageUrl+" | word present is "+Expected);
        scn.log("in current page url |"+ CurrentPageUrl+" | word present is "+Expected);
	}
	
    public void AccountHandleValidation(String AccountHandle) {
    	WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(AcountName));
    	String HandleName = driver.findElement(AcountName).getText();
		Assert.assertEquals(HandleName, AccountHandle);
	    log.info("Twitter handle is "+HandleName);
		scn.log("Twitter handle is "+HandleName);
	 }
	 

}
