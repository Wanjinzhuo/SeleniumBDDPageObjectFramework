@NopCommerce @Smoke
Feature: Login
  Scenario: Successful Login with Valid Credentials
    Given User Launch browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email "admin@yourstore.com" and Password "admin"
    And User clicks on Login button
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title should be "Your store. Login"
    And close browser



