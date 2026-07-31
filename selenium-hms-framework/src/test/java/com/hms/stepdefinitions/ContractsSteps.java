package com.hms.stepdefinitions;

import com.hms.base.DriverManager;
import com.hms.pages.contract.ContractsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

/**
 * Step definitions for contracts.feature.
 * TODO: add more @When/@Then methods here as you build out real test cases.
 */
public class ContractsSteps {

    private final ContractsPage contractsPage = new ContractsPage(DriverManager.getDriver());

    @Given("I am on the contracts page")
    public void i_am_on_the_page() {
        contractsPage.goTo();
    }

    @Then("the contracts page should be displayed")
    public void the_page_should_be_displayed() {
        Assert.assertTrue(contractsPage.isPageDisplayed(), "ContractsPage is not displayed");
    }
}
