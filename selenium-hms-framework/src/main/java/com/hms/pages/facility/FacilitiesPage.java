package com.hms.pages.facility;

import com.hms.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * FacilitiesPage
 * --------------
 * Facilities listing page
 * Route: /facilities
 *
 * TODO: Replace placeholder locators below with real selectors from the
 * HMS site (inspect via browser DevTools), then add page-specific methods.
 */
public class FacilitiesPage extends BasePage {

    // ----- Locators (placeholders - update these) -----
    private final By pageHeading = By.xpath("//h1[text()='Facilities']");
    // private final By someButton = By.xpath("//button[text()='Some Action']");
    // private final By someInput = By.id("someField");

    public FacilitiesPage(WebDriver driver) {
        super(driver);
    }

    public void goTo() {
        navigateTo("/facilities");
    }

    public boolean isPageDisplayed() {
        return isDisplayed(pageHeading);
    }

    // TODO: add page-specific actions (fill form, submit, filter, etc.)
}
