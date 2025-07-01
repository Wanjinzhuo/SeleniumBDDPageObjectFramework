@Bing @Smoke
Feature: Bing Search
  Scenario: Search for "cucumber test" on Bing and verify first result
    Given User Launch browser
    When User opens URL "https://www.bing.com"
    And I search for "cucumber test"
    And I click the first search result
    Then Page Title should be "Cucumber"
    And close browser