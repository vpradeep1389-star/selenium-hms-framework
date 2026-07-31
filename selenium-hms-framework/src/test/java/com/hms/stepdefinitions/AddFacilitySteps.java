package com.hms.stepdefinitions;

import com.hms.base.DriverManager;
import com.hms.pages.facility.AddFacilityPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

/**
 * Step definitions for add facility.feature.
 * TODO: add more @When/@Then methods here as you build out real test cases.
 */
public class AddFacilitySteps {

    private final AddFacilityPage addFacilityPage = new AddFacilityPage(DriverManager.getDriver());

    @Given("I am on the add facility page")
    public void i_am_on_the_page() {
        addFacilityPage.goTo();
    }

    @Then("the add facility page should be displayed")
    public void the_page_should_be_displayed() {
        Assert.assertTrue(addFacilityPage.isPageDisplayed(), "AddFacilityPage is not displayed");
    }
}
