package com.hms.stepdefinitions;

import com.hms.base.DriverManager;
import com.hms.pages.vendor.VendorPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

/**
 * Step definitions for vendor.feature.
 * TODO: add more @When/@Then methods here as you build out real test cases.
 */
public class VendorSteps {

    private final VendorPage vendorPage = new VendorPage(DriverManager.getDriver());

    @Given("I am on the vendor page")
    public void i_am_on_the_page() {
        vendorPage.goTo();
    }

    @Then("the vendor page should be displayed")
    public void the_page_should_be_displayed() {
        Assert.assertTrue(vendorPage.isPageDisplayed(), "VendorPage is not displayed");
    }
}
