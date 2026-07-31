package com.hms.stepdefinitions;

import com.hms.base.DriverManager;
import com.hms.pages.vendor.AddVendorPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

/**
 * Step definitions for add vendor.feature.
 * TODO: add more @When/@Then methods here as you build out real test cases.
 */
public class AddVendorSteps {

    private final AddVendorPage addVendorPage = new AddVendorPage(DriverManager.getDriver());

    @Given("I am on the add vendor page")
    public void i_am_on_the_page() {
        addVendorPage.goTo();
    }

    @Then("the add vendor page should be displayed")
    public void the_page_should_be_displayed() {
        Assert.assertTrue(addVendorPage.isPageDisplayed(), "AddVendorPage is not displayed");
    }
}
