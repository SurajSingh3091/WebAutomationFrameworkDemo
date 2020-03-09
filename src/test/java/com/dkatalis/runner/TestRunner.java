package com.dkatalis.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
				//format = {"pretty", "html:target/cucumber"},
				features = "src/test/java/com/dkatalis/feature/dkatalis.Feature",
				glue = {"com.dkatalis.stepDefinition"},
				tags ="@PositiveScenario", 
				dryRun = false)

public class TestRunner {

}
