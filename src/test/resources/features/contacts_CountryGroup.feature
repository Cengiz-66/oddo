Feature: user should be able to to add new country_group under localization
  ​
  Background:
    Given the user is on the login page
    And the user navigates to "Contacts" "Localization"

  Scenario: User select a country group
    When the user clicks a "Country_Group" submenu
    And the user selects "<Country_Group>" from the table
      |Country_Group|
      |A2           |
    Then the title contains "A2-Odoo"
  ​
  Scenario: User creates a country_group
    When the user clicks a "Country_Group" submenu
    And the user clicks "Create" button
    And the user send "A1" to "Group name"
    And the user selects followings
      |Austria  |
      |Germany  |
    And the user clicks "Add an item"
    And the user selects "Navigation Software" from table
    And the user clicks "Save" button
    Then the user should see "Navigation Software" in the table
  ​

  Scenario: the user delete an item from Pricelist
    When the user clicks a "Country_Group" submenu
    And the user selects "A1" from the table
    And the user clicks "Edit" button
    And the user should see "Navigation Software" in table
    And the user clicks "recycle bin" icon
    And the user clicks "Save" button
    Then the user should not see "Navigation Software" in the table