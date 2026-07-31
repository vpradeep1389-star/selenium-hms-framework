package com.hms.pages.billing;

import com.hms.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * BillingSummaryPage
 * ------------------
 * Billing summary page
 * Route: /billing/summary
 *
 * TODO: Replace placeholder locators below with real selectors from the
 * HMS site (inspect via browser DevTools), then add page-specific methods.
 */
public class BillingSummaryPage extends BasePage {

    // ----- Locators (placeholders - update these) -----
    private final By pageHeading = By.xpath("//h1[text()='Billing Summary']");
    // private final By someButton = By.xpath("//button[text()='Some Action']");
    // private final By someInput = By.id("someField");

    public BillingSummaryPage(WebDriver driver) {
        super(driver);
    }

    public void goTo() {
        navigateTo("/billing/summary");
    }

    public boolean isPageDisplayed() {
        return isDisplayed(pageHeading);
    }

    // TODO: add page-specific actions (fill form, submit, filter, etc.)
}
