package com.automationpractice.core;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverFactory {

	private static final Logger log = LogManager.getLogger(WebDriverFactory.class);
    private static WebDriver driver=null;
    public static WebDriver getWebDriverForBrowser(String browser) throws Exception {
        switch(browser.toLowerCase()){
            case "chrome":
//            	WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                log.info("Chrome Browser invoked");
                break;
            case "firefox":
//            	WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                log.info("Firefox Browser invoked");
                break;
            default:
                log.fatal("No such browser is implemented.Browser name sent: " + browser);
                throw new Exception("No such browser is implemented.Browser name sent: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        log.info("Driver maximized and implicit time out set to 40 seconds");
        return driver;
    }

    public static void navigateToTheUrl(String url){
        driver.get(url);
        log.info("Browser navigated to the url: " + url);
    }
    
    public void SwitchNextTab() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    	Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String ParentWindow = it.next();
		String ChildWindow = it.next();
		driver.switchTo().window(ChildWindow);
		log.info("Switched on new tab");
    }
    public void SwitchOriginalTab() {
    	Set<String> handles = driver.getWindowHandles();
    	Iterator<String> it = handles.iterator();
		String ParentWindow = it.next();
		String ChildWindow = it.next();
		driver.switchTo().window(ParentWindow);
		log.info("Switched to MainPage");
    	
    }

    public static void quitDriver(){
        driver.quit();
        log.info("Driver closed");
    }
    public static String getBrowserName(){
        String browserDefault = "chrome"; //Set by default
        String browserSentFromCmd = System.getProperty("browser");

        if (browserSentFromCmd==null){
            return browserDefault;
        }else{
            return browserSentFromCmd;
        }
    }


}
