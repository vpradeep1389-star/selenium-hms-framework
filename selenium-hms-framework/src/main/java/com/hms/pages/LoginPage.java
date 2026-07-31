package com.hms.pages;

import com.hms.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * LoginPage
 * ---------
 * TODO: Replace the placeholder locators below with the real selectors
 * from the HMS site (use browser DevTools to inspect).
 */
public class LoginPage extends BasePage {

    // ----- Locators -----
    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.xpath("//button[text()='Login']");
    private final By errorMessage = By.className("error-message");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void goTo() {
        navigateTo("/login");
    }

    public void login(String username, String password) {
        type(usernameInput, username);
        type(passwordInput, password);
        click(loginButton);
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }

    public boolean isLoginPageDisplayed() {
        return isDisplayed(loginButton);
    }
}
