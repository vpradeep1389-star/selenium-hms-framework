package com.hms.stepdefinitions;

import com.hms.base.DriverManager;
import com.hms.pages.inventory.AddInventoryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

/**
 * Step definitions for add inventory.feature.
 * TODO: add more @When/@Then methods here as you build out real test cases.
 */
public class AddInventorySteps {

    private final AddInventoryPage addInventoryPage = new AddInventoryPage(DriverManager.getDriver());

    @Given("I am on the add inventory page")
    public void i_am_on_the_page() {
        addInventoryPage.goTo();
    }

    @Then("the add inventory page should be displayed")
    public void the_page_should_be_displayed() {
        Assert.assertTrue(addInventoryPage.isPageDisplayed(), "AddInventoryPage is not displayed");
    }
}
