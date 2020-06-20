@sectorsOfActivity
Feature: Sectors of Activity

  Background:

    Given the user logged in
    And the user navigate to "Contacts" "Configuration"
    And the user clicks "Sectors of Activity" button

  Scenario: the number of result check
    Then the row numbers of sectors is equal to result number of the sectors on right top of the page

  Scenario Outline: User should not archive or unarchive the datas
    When the user clicks any checkbox on the page
    Then  action menu show up on the page
    When the user clicks following options
  Examples:
  | Archive |
  |Unarchive|
    Then Access Error is displayed


  Scenario: User can see the details of the sector
    When the user clicks anywhere on the row except for checkbox
    Then the user can see the details of that sector on the page


  Scenario : User should not export the data without selecting
    When the user clicks any checkbox on the page
    Then Export Data pop up is displayed
    When the user clicks Export To File button
    Then "Please select fields to export..." message is displayed in Alert pop up

  Scenario : buttons functionality
    When the user clicks any checkbox on the page
    Then Export Data pop up is displayed
    When the user clicks Export all Data button
    Then Available fields are displayed on Export Data pop up
    When the user select "Active" and click add button
    Then the selction is under the fields to export section
    When the user select "ID" and click add button
    Then the selction is under the fields to export section
    When the user clicks "ID" and clicks move up button
    Then the "ID" is displayed on above the "Active" on fields to export section
    When the user clicks "ID" and clicks remove button
    Then the "ID" is not displayed on fields to export section
    When the user select "Full Name" and click add button
    Then the selction is under the fields to export section
    When the user select "Active" and click move down button
    Then the selction is below the "Full Name" on the fields to export section
    When the user clicks remove all button
    Then the nothing is displayed on the fields to export section

  Scenario : the user export to file to the local computer
    When the user clicks any checkbox on the page
    Then Export Data pop up is displayed
    When the user clicks Last modified on
    And  click add button
    Then the Last modified on is displayed under fields to export section
    When the user clicks the export to file buttons
    Then the file is downloaded to the computer




