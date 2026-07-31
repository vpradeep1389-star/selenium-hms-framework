Feature: Add New Customer Page

  Background:
    Given I am logged in to the HMS site
    And I am on the customers page
    And I click Add New Customer

  Scenario: Add a new customer with valid details
    When I add a new customer with the following details:
      | firstName | John             |
      | lastName  | Doe              |
      | email     | john@example.com |
      | phone     | 9876543210       |
      | address   | 123 Main Street  |
      | status    | Active           |
    Then the customer should be created successfully
