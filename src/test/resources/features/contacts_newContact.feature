

Feature: The user can create a new contact

  Background:
    Given the user logged in
    And the user navigate to "Contacts"
    And the user click "Create" button
<<<<<<< HEAD
  @wip
=======

>>>>>>> 20f83d45f519f0ef3f2505779fed3ac15221ab07
  Scenario: default "Individual" radio button selected
    Then the user can see individual radio button selected
    And company drop down is visible

  Scenario: the user create a new contact with using proper data
    When  the user enters the following information
      | Name         | Mike Smith       |
      | Street       | 125              |
      | City         | Tirana           |
      | Country      | Albania          |
      | Job Position | Sales Manager    |
      | Phone        | 0987654321       |
      | Mobile       | 0123456789       |
      | Email        | msmith@gmail.com |
    And the user click "Save" button
    Then title contains "Mike Smith"


  Scenario: click "Company" radio button selected
    When the user click company radio button
    Then the user can see company radio button selected
    And "Company drop down" is NOT visible
    And "Job Position" is not visible


  Scenario: the user create a new contact with using proper data
    When the user click company radio button
    And  the user enters the following information
      | Name    | Kuscubasi Company |
      | Street  | 521               |
      | City    | Tirana            |
      | Country | Albania           |
      | Phone   | 0987654321        |
      | Mobile  | 0123456789        |
      | Email   | contact@gmail.com |
    And the user click "Save" button
    Then title contains "Kuscubasi Company"

