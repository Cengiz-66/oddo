@smoke
Feature: the user should be able to manage country informations

  Background:
    Given the user is logged in as "crmManager"
    And the user navigate to "Contacts" and "Countries"

  @wip
  Scenario: User searches country
    When the user clicks "Countries" submenu
    And the user enters "Abhazya" in search box end clicks enter button
    Then the user should see following options
      | Country Name | Abhazya |
      | Country Code | 99      |
      #| Country Name | Abhazya | Abhazya1 | Abhazya2 |
      #| Country Code | 99      | 12       | 66       |

  @wip
  Scenario: user delete some countries
    When the user clicks "Countries" submenu
    And the user selects one country from list
    And selects "Delete" under Actions button
    Then the user should get "Are you sure you want to delete this record ?" warning message
    When the user clicks "Ok" button for confirmation
    Then the user should get "The operation cannot be completed, probably due to the following:" warning message


  Scenario: user imports country/countries from a file
    When the user clicks "Countries" submenu
    And the user clicks "Import" button
    Then the user sends a CSV file as input
    And the user clicks "Load File" button
    Then the user clicks "Test Import" button
    Then the user should get "Everything seems valid." warning message
    When the user clicks "Import" button
    Then the user should see some data under at least following options
      | id                   |
      | phone_code           |
      | code                 |
      | country_group_ids/id |
      | name                 |


