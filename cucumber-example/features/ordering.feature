Feature: Ordering
  In order to buy stuff
  As a customer
  I need to place an order

  Scenario: No items
    Given I have an order
    Then I need to pay 0 dollars

  Scenario: A couple of items
    Given I have an order
    And I add for 42 dollars 'Carpets'
    And I add for 15 dollars 'Cleaners'
    Then I need to pay 57 dollars
