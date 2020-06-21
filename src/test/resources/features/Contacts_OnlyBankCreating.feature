Feature: the user can create a new bank
  ​
  Background:
    Given the user is logged in
    And the user navigate to "Contacts" "Banks"
    And the user clicks "Create" button
  ​
  Scenario: new bank creation
    When the user enters the following information
      |Name                    |Bank Asya         |
      |Bank Identifier Code    |45858585686       |

    And the user clicks "Save" button
    Then name should contain "Bank Asya"
  ​
  Scenario Outline: new bank creation-negative
    When the user enters the following "<Name>" "<Bank Identifier Code>"
    And bank name is " "
    And the user clicks "Save" button
    Then User should get "The following fields are invalid:"
    Examples:
      |Name           |Bank Identifier Code    |
      |               |45858585686             |