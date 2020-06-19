Feature: the user should be able to add create Fed.State

  Background:
    Given the user is logged in
    And the user navigate to "contacts" "Localization"


  Scenario:the user prepares new Fed.State in an existing country
    When the user clicks "Fed. States" submenu
    And the user clicks "Create" button
    And the user enters following information
      | State Name | Mada    |
      | State Code | M99     |
      | Country    | England |
    And the user clicks "Save" button
    Then the user should see following info on the page
      | State Name | Mada    |
      | State Code | M99     |
      | Country    | England |


  Scenario Outline: the user enter invalid credentials
    When the user clicks "Fed. States" submenu
    And the user clicks "Create" button
    And the user enters "<state name>" "<state code>" and "<country>" as follows
    Then the user should get "The following fields are invalid:" warning message
    Examples:
      | state name | state code | country |
      |            | M99        | England |
      | Mada       |            | England |
      | Mada       | M99        |         |


  Scenario: the user exports selected Fed.States to CSV file
    When the user selects some Fed.States
    And selects "Export" under Actions button
    Then the user sees "Export Type" as "Import-Compatible Export" and "Export Formats" as "CSV" selected
    And the user selects required fields from available fields
    And add them one by one to Fields to Export
    And the user clicks "Export To File" button
    Then the user sees "res.country.state" file is downloaded under download folder


  Scenario: the user do not enter required fields to export to CSV file
    When the user selects some Fed.States
    And selects "Export" under Actions button
    Then the user sees "Export Type" as "Import-Compatible Export" and "Export Formats" as "CSV" selected
    And the user clicks "Export To File" button
    Then the user should get "Please select fields to export..." warning message




