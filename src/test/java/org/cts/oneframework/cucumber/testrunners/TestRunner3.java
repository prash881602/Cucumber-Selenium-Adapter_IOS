package org.cts.oneframework.cucumber.testrunners;

import org.cts.oneframework.cucumber.AbstractTestNGCucumberTest;

import cucumber.api.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/TestFeature2.feature",
				 glue = {"org.cts.oneframework.cucumber.stepdefinition" }, 
				 plugin = { "pretty",
						    "json:target/cucumber-report/cucumber.json",
	                        "html:target/cucumber-report/cucumber.html"},						
				 strict=true
				 )
public class TestRunner3 extends AbstractTestNGCucumberTest {
}