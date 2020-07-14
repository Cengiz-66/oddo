@wip @smoke
Feature: The user should be able to add new country under localization

  Background:
    Given the user is logged in as "crmManager"
    And the user navigate to "Contacts" and "Countries"


  Scenario: User prepares new country
    When the user clicks "Countries" submenu
    And the user clicks "Create" button
    And the user chooses currency as "EUR" from select box
    And the user enters following information
      | Country Name         | Madagaskar |
      | Country Code         | Mg          |
      | Country Calling Code | 21          |
      | Vat Label            | KDV         |
    And the user clicks "Save" button
    Then the user should see following info on the page
      | Country Name         | Madagaskar |
      | Country Code         | Mg          |
      | Country Calling Code | 21          |
      | Vat Label            | KDV         |

  Scenario: User prepares new country contact but discards
    When the user clicks "Countries" submenu
    And the user clicks "Create" button
    And the user enters following information
      | Country Name         | Assia |
      | Country Code         | A1    |
      | Country Calling Code | 321   |
      | Vat Label            | As    |
    And the user clicks "Discard" button
    Then the user should get "The record has been modified, your changes will be discarded. Do you want to proceed?" warning message
    And the user clicks "Ok" button in pop up window
    Then the user comes back to country-create page


  Scenario: User enter invalid country code
    When the user clicks "Countries" submenu
    And the user clicks "Create" button
    And the user enters following information
      | Country Name         | Madagaskar |
      | Country Code         | MG         |
      | Country Calling Code | 21         |
      | Vat Label            | KDV        |
    Then the user clicks "Save" button
    Then the user should get "The code of the country must be unique !" warning message


  Scenario: User enter invalid country calling code
    When the user clicks "Countries" submenu
    And the user clicks "Create" button
    And the user enters following information
      | Country Name         | Madagaskar |
      | Country Code         | MG         |
      | Country Calling Code | asdf       |
      | Vat Label            | KDV        |
    Then the user clicks "Save" button
    Then the user should get "Country Calling Code" alert

  Scenario: User enter no country name
    When the user clicks "Countries" submenu
    And the user clicks "Create" button
    Then the user clicks "Save" button
    Then the user should get "Country Name" alert

