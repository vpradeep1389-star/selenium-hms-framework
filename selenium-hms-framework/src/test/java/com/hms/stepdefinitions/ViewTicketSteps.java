package com.hms.stepdefinitions;

import com.hms.base.DriverManager;
import com.hms.pages.ticket.ViewTicketPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

/**
 * Step definitions for view ticket.feature.
 * TODO: add more @When/@Then methods here as you build out real test cases.
 */
public class ViewTicketSteps {

    private final ViewTicketPage viewTicketPage = new ViewTicketPage(DriverManager.getDriver());

    @Given("I am on the view ticket page")
    public void i_am_on_the_page() {
        viewTicketPage.goTo();
    }

    @Then("the view ticket page should be displayed")
    public void the_page_should_be_displayed() {
        Assert.assertTrue(viewTicketPage.isPageDisplayed(), "ViewTicketPage is not displayed");
    }
}
