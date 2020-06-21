
@try
Feature: User should be able to manage contact tags

  Background:
    Given the user is logged in
    And the user navigates to "Contacts" "Contact Tags"
    And the user clicks "Contact Tags" submenu

  Scenario: User creates new "contacts tag"
    When the user clicks "create" button
    And the user enters "tag name"
    And the user chooses "parent category" from the dropdown
    And the user clicks active checkbox
    And the user clicks "Save" button
    Then the user should see the "tag name" as title

  Scenario: the user edits existing  contact tag
    When the user clicks on a tag from the list
    And the user clicks on "edit" button
    And the user enters "tag name"
    And the user chooses "parent category" from the dropdown
    And the user clicks active checkbox
    And the user clicks "Save" button
    Then the user should see the "tag name" as title

  Scenario: the user can Export data
    When user select tags from Contact Tags list
    And user chooses "Export" from "Action" options
    And user selects "necessary fields" from the list
    #  coklu secim ctrl tusuna basili tutarak olur mu?
    And user clicks "add" button
    And user clicks "Export to File" button
    Then user

  Scenario: user imports country/countries from a file

    When the user clicks "import" button
    Then the user sends a CSV file as input
    And the user clicks "Load File" button
    Then the user clicks "Test Import" button
    Then the user should get "Everything seems valid." warning message
    When the user clicks "Import" button
    Then the user should see following data on the file
      | id                   |
      | phone_code           |
      | code                 |
      | country_group_ids/id |
      | name                 |


  Scenario: the user can delete Contacts Tag
    When the user selects one contact "tag" from list
    And selects "Delete" under "Actions" button
    Then the user should get "Are you sure you want to delete this record ?" warning message
    When the user clicks "Ok" button
    Then the user should get "The operation cannot be completed, probably due to the following:" warning message