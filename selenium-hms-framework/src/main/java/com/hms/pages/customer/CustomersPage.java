package com.hms.pages.customer;

import com.hms.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * CustomersPage
 * -------------
 * The listing/view page for Customers.
 * TODO: Replace placeholder locators with real selectors from the site.
 */
public class CustomersPage extends BasePage {

    private final By pageTitle = By.xpath("//h1[text()='Customers']");
    private final By addNewCustomerButton = By.xpath("//button[text()='Add New Customer']");
    private final By searchInput = By.id("customer-search");
    private final By customerRows = By.cssSelector("table tbody tr");

    public CustomersPage(WebDriver driver) {
        super(driver);
    }

    public void goTo() {
        navigateTo("/customers");
    }

    public boolean isPageDisplayed() {
        return isDisplayed(pageTitle);
    }

    public void searchCustomer(String term) {
        type(searchInput, term);
    }

    public void clickAddNewCustomer() {
        click(addNewCustomerButton);
    }

    public int getCustomerRowCount() {
        List<WebElement> rows = driver.findElements(customerRows);
        return rows.size();
    }

    public void openCustomerByName(String name) {
        click(By.xpath("//tr[td[contains(text(),'" + name + "')]]"));
    }
}
