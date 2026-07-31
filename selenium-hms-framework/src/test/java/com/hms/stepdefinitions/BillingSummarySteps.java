package com.hms.stepdefinitions;

import com.hms.base.DriverManager;
import com.hms.pages.billing.BillingSummaryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

/**
 * Step definitions for billing summary.feature.
 * TODO: add more @When/@Then methods here as you build out real test cases.
 */
public class BillingSummarySteps {

    private final BillingSummaryPage billingSummaryPage = new BillingSummaryPage(DriverManager.getDriver());

    @Given("I am on the billing summary page")
    public void i_am_on_the_page() {
        billingSummaryPage.goTo();
    }

    @Then("the billing summary page should be displayed")
    public void the_page_should_be_displayed() {
        Assert.assertTrue(billingSummaryPage.isPageDisplayed(), "BillingSummaryPage is not displayed");
    }
}
