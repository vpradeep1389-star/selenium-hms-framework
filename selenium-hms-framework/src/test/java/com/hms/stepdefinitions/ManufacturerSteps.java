package com.hms.stepdefinitions;

import com.hms.base.DriverManager;
import com.hms.pages.manufacturer.ManufacturerPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

/**
 * Step definitions for manufacturer.feature.
 * TODO: add more @When/@Then methods here as you build out real test cases.
 */
public class ManufacturerSteps {

    private final ManufacturerPage manufacturerPage = new ManufacturerPage(DriverManager.getDriver());

    @Given("I am on the manufacturer page")
    public void i_am_on_the_page() {
        manufacturerPage.goTo();
    }

    @Then("the manufacturer page should be displayed")
    public void the_page_should_be_displayed() {
        Assert.assertTrue(manufacturerPage.isPageDisplayed(), "ManufacturerPage is not displayed");
    }
}
