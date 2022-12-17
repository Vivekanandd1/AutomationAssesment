
package com.automationpractice.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
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

public class TestRunner {

}
