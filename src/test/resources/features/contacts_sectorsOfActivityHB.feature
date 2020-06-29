Feature: Sectors Of Act

  Background:
    Given the user logged in
    When the user navigates to "Contacts"
    And the user clicks to Sectors of Activity

  Scenario: The number of sectors
    Then the numbers of sectors in the list is equal to the number on top right of the page

  @hb
  Scenario Outline: Unauthorized actions
    When the user clicks checkbox on the page
    Then action menu is displayed
    When the user selects following "<options>" from action menu
    Then "Odoo Server Error" is shown on the page
    Examples:
      |options|
      |Archive|
      |Unarchive|