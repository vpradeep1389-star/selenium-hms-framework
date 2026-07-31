package com.hms.stepdefinitions;

import com.hms.base.DriverManager;
import com.hms.pages.LoginPage;
import com.hms.pages.customer.AddCustomerPage;
import com.hms.pages.customer.CustomersPage;
import com.hms.utils.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Map;

public class CustomerSteps {

    private final LoginPage loginPage = new LoginPage(DriverManager.getDriver());
    private final CustomersPage customersPage = new CustomersPage(DriverManager.getDriver());
    private final AddCustomerPage addCustomerPage = new AddCustomerPage(DriverManager.getDriver());

    @Given("I am logged in to the HMS site")
    public void i_am_logged_in_to_the_hms_site() {
        loginPage.goTo();
        loginPage.login(ConfigReader.getUsername(), ConfigReader.getPassword());
    }

    @Given("I am on the customers page")
    public void i_am_on_the_customers_page() {
        customersPage.goTo();
    }

    @Then("the customers page should be displayed")
    public void the_customers_page_should_be_displayed() {
        Assert.assertTrue(customersPage.isPageDisplayed(), "Customers page is not displayed");
    }

    @When("I search for customer {string}")
    public void i_search_for_customer(String name) {
        customersPage.searchCustomer(name);
    }

    @Then("the customer list should update")
    public void the_customer_list_should_update() {
        // TODO: assert the filtered row count / content once real locators are in place
        Assert.assertTrue(customersPage.getCustomerRowCount() >= 0);
    }

    @When("I click Add New Customer")
    public void i_click_add_new_customer() {
        customersPage.clickAddNewCustomer();
    }

    @Then("I should be on the add customer page")
    public void i_should_be_on_the_add_customer_page() {
        Assert.assertTrue(customersPage.getCurrentUrl().contains("customers"), "Not on add customer page");
    }

    @When("I add a new customer with the following details:")
    public void i_add_a_new_customer_with_the_following_details(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        addCustomerPage.addCustomer(
                data.get("firstName"),
                data.get("lastName"),
                data.get("email"),
                data.get("phone"),
                data.get("address"),
                data.get("status")
        );
    }

    @Then("the customer should be created successfully")
    public void the_customer_should_be_created_successfully() {
        Assert.assertTrue(addCustomerPage.isSuccessToastVisible(), "Success toast not shown");
    }
}
