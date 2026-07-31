package com.hms.stepdefinitions;

import com.hms.base.DriverManager;
import com.hms.pages.inventory.InventoryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

/**
 * Step definitions for inventory.feature.
 * TODO: add more @When/@Then methods here as you build out real test cases.
 */
public class InventorySteps {

    private final InventoryPage inventoryPage = new InventoryPage(DriverManager.getDriver());

    @Given("I am on the inventory page")
    public void i_am_on_the_page() {
        inventoryPage.goTo();
    }

    @Then("the inventory page should be displayed")
    public void the_page_should_be_displayed() {
        Assert.assertTrue(inventoryPage.isPageDisplayed(), "InventoryPage is not displayed");
    }
}
