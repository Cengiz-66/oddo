
Feature: User should be able to add new contact title under configuration

  Background:
    Given the user is logged in

  Scenario: User prepares new contact title
    When the user clicks Contact Titles submenu
    And the user clicks create button
    And the user enters following information
      | Title        | Doctor |
      | Abbreviation | Mr.    |
    And the user clicks Save button
    Then the user should see the following title
      | Title        | Doctor |
  @wip
  Scenario: user not enter the title
    Given the user clicks Contact Titles submenu
    When the user clicks create button
    And  the user leaves the title box empty
    Then the user get "The following fields are invalid: Title" message