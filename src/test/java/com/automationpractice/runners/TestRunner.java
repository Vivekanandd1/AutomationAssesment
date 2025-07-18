package com.automationpractice.runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "classpath:Features",
		glue = "com.automationpractice.STEPDEFS",
		tags ="",
		plugin= {
				"pretty",
				"html:target/Reports/htmlrepo.html",
				"json:target/json/file.json",
		},
		monochrome = true,
		publish = true,
		dryRun=false
		
		)

public class TestRunner extends AbstractTestNGCucumberTests{
	


}
