Feature: Login Page
  As a user of the HMS site
  I want to log in
  So that I can access the system

  Background:
    Given I am on the login page

  Scenario: Login page is displayed
    Then the login page should be displayed

  Scenario: Successful login with valid credentials
    When I login with valid credentials
    Then I should be redirected to the dashboard

  Scenario: Unsuccessful login with invalid credentials
    When I login with username "invalid_user" and password "wrong_password"
    Then I should see a login error message
