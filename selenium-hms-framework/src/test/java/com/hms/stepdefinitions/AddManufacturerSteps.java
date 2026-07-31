package com.hms.stepdefinitions;

import com.hms.base.DriverManager;
import com.hms.pages.manufacturer.AddManufacturerPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

/**
 * Step definitions for add manufacturer.feature.
 * TODO: add more @When/@Then methods here as you build out real test cases.
 */
public class AddManufacturerSteps {

    private final AddManufacturerPage addManufacturerPage = new AddManufacturerPage(DriverManager.getDriver());

    @Given("I am on the add manufacturer page")
    public void i_am_on_the_page() {
        addManufacturerPage.goTo();
    }

    @Then("the add manufacturer page should be displayed")
    public void the_page_should_be_displayed() {
        Assert.assertTrue(addManufacturerPage.isPageDisplayed(), "AddManufacturerPage is not displayed");
    }
}
