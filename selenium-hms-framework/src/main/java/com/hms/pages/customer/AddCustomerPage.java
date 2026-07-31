package com.hms.pages.customer;

import com.hms.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * AddCustomerPage
 * ---------------
 * TODO: Replace placeholder locators with real selectors from the site.
 */
public class AddCustomerPage extends BasePage {

    private final By firstNameInput = By.id("firstName");
    private final By lastNameInput = By.id("lastName");
    private final By emailInput = By.id("email");
    private final By phoneInput = By.id("phone");
    private final By addressInput = By.id("address");
    private final By statusDropdown = By.id("status");
    private final By saveButton = By.xpath("//button[text()='Save']");
    private final By successToast = By.xpath("//*[contains(text(),'Customer created successfully')]");

    public AddCustomerPage(WebDriver driver) {
        super(driver);
    }

    public void addCustomer(String firstName, String lastName, String email, String phone, String address, String status) {
        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(emailInput, email);
        type(phoneInput, phone);
        type(addressInput, address);
        if (status != null && !status.isEmpty()) {
            selectByVisibleText(statusDropdown, status);
        }
        click(saveButton);
    }

    public boolean isSuccessToastVisible() {
        return isDisplayed(successToast);
    }
}
