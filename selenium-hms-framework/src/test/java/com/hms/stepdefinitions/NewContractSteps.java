package com.hms.stepdefinitions;

import com.hms.base.DriverManager;
import com.hms.pages.contract.NewContractPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

/**
 * Step definitions for new contract.feature.
 * TODO: add more @When/@Then methods here as you build out real test cases.
 */
public class NewContractSteps {

    private final NewContractPage newContractPage = new NewContractPage(DriverManager.getDriver());

    @Given("I am on the new contract page")
    public void i_am_on_the_page() {
        newContractPage.goTo();
    }

    @Then("the new contract page should be displayed")
    public void the_page_should_be_displayed() {
        Assert.assertTrue(newContractPage.isPageDisplayed(), "NewContractPage is not displayed");
    }
}
