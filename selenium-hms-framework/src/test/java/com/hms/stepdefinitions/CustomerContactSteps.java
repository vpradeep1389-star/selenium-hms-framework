package com.hms.stepdefinitions;

import com.hms.base.DriverManager;
import com.hms.pages.customer.CustomerContactPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

/**
 * Step definitions for customer contact.feature.
 * TODO: add more @When/@Then methods here as you build out real test cases.
 */
public class CustomerContactSteps {

    private final CustomerContactPage customerContactPage = new CustomerContactPage(DriverManager.getDriver());

    @Given("I am on the customer contact page")
    public void i_am_on_the_page() {
        customerContactPage.goTo();
    }

    @Then("the customer contact page should be displayed")
    public void the_page_should_be_displayed() {
        Assert.assertTrue(customerContactPage.isPageDisplayed(), "CustomerContactPage is not displayed");
    }
}
