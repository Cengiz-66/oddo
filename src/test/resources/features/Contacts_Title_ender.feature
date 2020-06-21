Feature: User should be able to add new contact title under configuration

  Background:
    Given the user is logged in
    And the user navigate to "contacts" "configuration"

  Scenario: User prepares new contact title
    When the user clicks "Contact Titles" submenu
    And the user clicks "create" button
    And the user enters following information
      | Title        | Doctor |
      | Abbreviation | Mr.    |
    And the user clicks "Save" button
    Then the user should see the "Doctor" as title