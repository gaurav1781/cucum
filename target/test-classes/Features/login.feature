Feature: feature to google search functionality

  Scenario: Validate Google search is working
    Given browser is open
    And user is on google home page
    When user enters text on screen
    And hits enter
    Then user is navigated to search results
