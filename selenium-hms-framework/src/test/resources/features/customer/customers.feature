Feature: Customers Page

  Background:
    Given I am logged in to the HMS site
    And I am on the customers page

  Scenario: Customers list is displayed
    Then the customers page should be displayed

  Scenario: Search for a customer
    When I search for customer "John"
    Then the customer list should update

  Scenario: Navigate to Add New Customer page
    When I click Add New Customer
    Then I should be on the add customer page
