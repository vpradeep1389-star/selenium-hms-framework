package com.hms.pages.ticket;

import com.hms.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * ViewTicketPage
 * --------------
 * View a single ticket for an inventory item
 * Route: /tickets/1
 *
 * TODO: Replace placeholder locators below with real selectors from the
 * HMS site (inspect via browser DevTools), then add page-specific methods.
 */
public class ViewTicketPage extends BasePage {

    // ----- Locators (placeholders - update these) -----
    private final By pageHeading = By.xpath("//h1[text()='View Ticket']");
    // private final By someButton = By.xpath("//button[text()='Some Action']");
    // private final By someInput = By.id("someField");

    public ViewTicketPage(WebDriver driver) {
        super(driver);
    }

    public void goTo() {
        navigateTo("/tickets/1");
    }

    public boolean isPageDisplayed() {
        return isDisplayed(pageHeading);
    }

    // TODO: add page-specific actions (fill form, submit, filter, etc.)
}
