Feature: The user should be able to add new country under localization

  Background:
    Given the user is logged in as "crmManager"
    And the user navigate to "Contacts" and "Countries"
@wip
  Scenario: User prepares new country
    When the user clicks "Countries" submenu
    And the user clicks "Create" button
    And the user chooses currency as "EUR" from select box
    And the user enters following information
      | Country Name         | Madagaskar |
      | Country Code         | MG         |
      | Country Calling Code | 21         |
      | Vat Label            | KDV        |
    And the user clicks "Save" button
    Then the user should see following info on the page
      | Country Name         | Madagaskar |
      | Country Code         | MG         |
      | Country Calling Code | 21         |
      | Vat Label            | KDV        |

  Scenario: User prepares new country contact but discards
    When the user clicks "Countries" submenu
    And the user clicks "Create" button
    And the user enters following information
      | Country Name         | Assia |
      | Country Code         | A1    |
      | Country Calling Code | 321   |
      | Vat Label            | As    |
    And the user clicks "discard" button
    Then the user should get "The record has been modified, your changes will be discarded. Do you want to proceed?" warning message
    And the user clicks "Ok" button
    Then the user comes back to country-create page

  Scenario: User enter invalid country code
    When the user clicks "Countries" submenu
    And the user clicks "Create" button
    Then the user reach save or discard screen
    And the user enter followings
      | Country Name         | Madagaskar |
      | Currency             | Magda      |
      | Country Code         | MG         |
      | Country Calling Code | 21         |
      | Vat Label            | KDV        |
    Then the user should get "The code of the country must be unique !" warning message

