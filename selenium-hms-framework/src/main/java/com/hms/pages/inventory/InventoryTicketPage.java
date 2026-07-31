package com.hms.pages.inventory;

import com.hms.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * InventoryTicketPage
 * -------------------
 * Add a ticket for a created inventory item
 * Route: /inventory/1/ticket/new
 *
 * TODO: Replace placeholder locators below with real selectors from the
 * HMS site (inspect via browser DevTools), then add page-specific methods.
 */
public class InventoryTicketPage extends BasePage {

    // ----- Locators (placeholders - update these) -----
    private final By pageHeading = By.xpath("//h1[text()='Inventory Ticket']");
    // private final By someButton = By.xpath("//button[text()='Some Action']");
    // private final By someInput = By.id("someField");

    public InventoryTicketPage(WebDriver driver) {
        super(driver);
    }

    public void goTo() {
        navigateTo("/inventory/1/ticket/new");
    }

    public boolean isPageDisplayed() {
        return isDisplayed(pageHeading);
    }

    // TODO: add page-specific actions (fill form, submit, filter, etc.)
}
