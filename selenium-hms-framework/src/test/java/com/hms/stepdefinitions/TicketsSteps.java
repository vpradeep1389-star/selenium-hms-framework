package com.hms.stepdefinitions;

import com.hms.base.DriverManager;
import com.hms.pages.ticket.TicketsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

/**
 * Step definitions for tickets.feature.
 * TODO: add more @When/@Then methods here as you build out real test cases.
 */
public class TicketsSteps {

    private final TicketsPage ticketsPage = new TicketsPage(DriverManager.getDriver());

    @Given("I am on the tickets page")
    public void i_am_on_the_page() {
        ticketsPage.goTo();
    }

    @Then("the tickets page should be displayed")
    public void the_page_should_be_displayed() {
        Assert.assertTrue(ticketsPage.isPageDisplayed(), "TicketsPage is not displayed");
    }
}
