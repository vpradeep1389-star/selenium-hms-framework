package com.hms.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Entry point that ties Cucumber feature files to TestNG execution.
 * Run via testng.xml, or directly as a TestNG class in your IDE.
 */
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.hms.stepdefinitions"},
        plugin = {
                "pretty",
                "html:test-output/cucumber-report.html",
                "json:test-output/cucumber-report.json"
        },
        monochrome = true
        // tags = "@smoke" // uncomment to run a subset of scenarios by tag
)
public class TestRunner extends AbstractTestNGCucumberTests {

    // Set to true to run scenarios in parallel (requires thread-safe DriverManager, already ThreadLocal-based)
    @Override
    public boolean useDataProviderThreads() {
        return false;
    }
}
