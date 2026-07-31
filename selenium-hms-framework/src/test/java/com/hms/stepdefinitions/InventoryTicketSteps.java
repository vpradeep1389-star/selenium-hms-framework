package com.hms.stepdefinitions;

import com.hms.base.DriverManager;
import com.hms.pages.inventory.InventoryTicketPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

/**
 * Step definitions for inventory ticket.feature.
 * TODO: add more @When/@Then methods here as you build out real test cases.
 */
public class InventoryTicketSteps {

    private final InventoryTicketPage inventoryTicketPage = new InventoryTicketPage(DriverManager.getDriver());

    @Given("I am on the inventory ticket page")
    public void i_am_on_the_page() {
        inventoryTicketPage.goTo();
    }

    @Then("the inventory ticket page should be displayed")
    public void the_page_should_be_displayed() {
        Assert.assertTrue(inventoryTicketPage.isPageDisplayed(), "InventoryTicketPage is not displayed");
    }
}
