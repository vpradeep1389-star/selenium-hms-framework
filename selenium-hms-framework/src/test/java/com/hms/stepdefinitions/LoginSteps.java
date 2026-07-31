package com.hms.stepdefinitions;

import com.hms.base.DriverManager;
import com.hms.pages.LoginPage;
import com.hms.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {

    private final LoginPage loginPage = new LoginPage(DriverManager.getDriver());

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        loginPage.goTo();
    }

    @Then("the login page should be displayed")
    public void the_login_page_should_be_displayed() {
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page is not displayed");
    }

    @When("I login with valid credentials")
    public void i_login_with_valid_credentials() {
        loginPage.login(ConfigReader.getUsername(), ConfigReader.getPassword());
    }

    @When("I login with username {string} and password {string}")
    public void i_login_with_username_and_password(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("I should be redirected to the dashboard")
    public void i_should_be_redirected_to_the_dashboard() {
        Assert.assertTrue(loginPage.getCurrentUrl().contains("dashboard"), "Not redirected to dashboard");
    }

    @Then("I should see a login error message")
    public void i_should_see_a_login_error_message() {
        Assert.assertTrue(!loginPage.getErrorMessage().isEmpty(), "No error message displayed");
    }
}
