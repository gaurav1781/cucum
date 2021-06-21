Feature: This Feature is to test Place Order function
  
  Scenario: User places the order on cash
    Given User is on icicidirect home page
    When user clicks on Place Order link
    Then user chooses Cash Buy option
    And Selects NSE Option
    And Fills Stock code
    And Fills quantity
    And Fills Limit Price
    And Clicks on Buy
    Then User is routed to Booked order page
