package com.hms.stepdefinitions;

import com.hms.base.DriverManager;
import com.hms.pages.customer.AddCustomerContactPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

/**
 * Step definitions for add customer contact.feature.
 * TODO: add more @When/@Then methods here as you build out real test cases.
 */
public class AddCustomerContactSteps {

    private final AddCustomerContactPage addCustomerContactPage = new AddCustomerContactPage(DriverManager.getDriver());

    @Given("I am on the add customer contact page")
    public void i_am_on_the_page() {
        addCustomerContactPage.goTo();
    }

    @Then("the add customer contact page should be displayed")
    public void the_page_should_be_displayed() {
        Assert.assertTrue(addCustomerContactPage.isPageDisplayed(), "AddCustomerContactPage is not displayed");
    }
}
