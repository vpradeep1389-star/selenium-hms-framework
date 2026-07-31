package com.hms.stepdefinitions;

import com.hms.base.DriverManager;
import com.hms.pages.facility.FacilitiesPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

/**
 * Step definitions for facilities.feature.
 * TODO: add more @When/@Then methods here as you build out real test cases.
 */
public class FacilitiesSteps {

    private final FacilitiesPage facilitiesPage = new FacilitiesPage(DriverManager.getDriver());

    @Given("I am on the facilities page")
    public void i_am_on_the_page() {
        facilitiesPage.goTo();
    }

    @Then("the facilities page should be displayed")
    public void the_page_should_be_displayed() {
        Assert.assertTrue(facilitiesPage.isPageDisplayed(), "FacilitiesPage is not displayed");
    }
}
