package com.hms.stepdefinitions;

import com.hms.base.DriverManager;
import com.hms.pages.ticket.TicketSearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

/**
 * Step definitions for ticket search.feature.
 * TODO: add more @When/@Then methods here as you build out real test cases.
 */
public class TicketSearchSteps {

    private final TicketSearchPage ticketSearchPage = new TicketSearchPage(DriverManager.getDriver());

    @Given("I am on the ticket search page")
    public void i_am_on_the_page() {
        ticketSearchPage.goTo();
    }

    @Then("the ticket search page should be displayed")
    public void the_page_should_be_displayed() {
        Assert.assertTrue(ticketSearchPage.isPageDisplayed(), "TicketSearchPage is not displayed");
    }
}
