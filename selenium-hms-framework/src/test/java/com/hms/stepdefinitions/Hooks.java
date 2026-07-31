package com.hms.stepdefinitions;

import com.aventstack.extentreports.Status;
import com.hms.base.DriverManager;
import com.hms.utils.ExtentReportManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * Runs before/after every Cucumber scenario:
 *  - Before: starts the browser, creates an Extent test node for the scenario
 *  - After: takes a screenshot on failure, logs pass/fail to Extent, quits the browser
 */
public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        DriverManager.initDriver();
        ExtentReportManager.createTest(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver())
                        .getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
                ExtentReportManager.getTest().fail("Scenario failed: " + scenario.getName());
            } catch (Exception e) {
                ExtentReportManager.getTest().log(Status.WARNING, "Could not capture screenshot: " + e.getMessage());
            }
        } else {
            ExtentReportManager.getTest().pass("Scenario passed: " + scenario.getName());
        }
        DriverManager.quitDriver();
    }
}
