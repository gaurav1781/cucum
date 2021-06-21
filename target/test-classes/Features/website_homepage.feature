Feature: Feature to verify icicidirect homepage

    Scenario: Validate ICICIDirect login Functionality
    Given browse is open
    And user is on icicidirect login page
    When user fills mandatory fields and clicks login
    Then user successfully logs in to icicidirect home page

  Scenario: Validate Alerts on ICICIDirect Home Page
    Given User is on ICICIDirect home page and clicks on Alert button
    Then user is taken to current messages