package com.hms.pages.customer;

import com.hms.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * CustomerContactPage
 * -------------------
 * View contacts for a specific customer
 * Route: /customers/1/contacts
 *
 * TODO: Replace placeholder locators below with real selectors from the
 * HMS site (inspect via browser DevTools), then add page-specific methods.
 */
public class CustomerContactPage extends BasePage {

    // ----- Locators (placeholders - update these) -----
    private final By pageHeading = By.xpath("//h1[text()='Customer Contact']");
    // private final By someButton = By.xpath("//button[text()='Some Action']");
    // private final By someInput = By.id("someField");

    public CustomerContactPage(WebDriver driver) {
        super(driver);
    }

    public void goTo() {
        navigateTo("/customers/1/contacts");
    }

    public boolean isPageDisplayed() {
        return isDisplayed(pageHeading);
    }

    // TODO: add page-specific actions (fill form, submit, filter, etc.)
}
