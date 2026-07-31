package com.hms.pages.customer;

import com.hms.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * AddCustomerContactPage
 * ----------------------
 * Add a new contact for a customer
 * Route: /customers/1/contacts/new
 *
 * TODO: Replace placeholder locators below with real selectors from the
 * HMS site (inspect via browser DevTools), then add page-specific methods.
 */
public class AddCustomerContactPage extends BasePage {

    // ----- Locators (placeholders - update these) -----
    private final By pageHeading = By.xpath("//h1[text()='Add Customer Contact']");
    // private final By someButton = By.xpath("//button[text()='Some Action']");
    // private final By someInput = By.id("someField");

    public AddCustomerContactPage(WebDriver driver) {
        super(driver);
    }

    public void goTo() {
        navigateTo("/customers/1/contacts/new");
    }

    public boolean isPageDisplayed() {
        return isDisplayed(pageHeading);
    }

    // TODO: add page-specific actions (fill form, submit, filter, etc.)
}
