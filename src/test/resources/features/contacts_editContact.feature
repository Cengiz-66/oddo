

Feature: modify feature

  Background:
    Given the user logged in
    And the user navigate to "Contacts"

  Scenario:user see contacts information
    When the user click "ABC Company" contact
    Then user should see all information to that contact

  Scenario: the user modify contacts information
    When the user click "ABC CompaKuscubasi Kuscubasi Company" contact
    And the user click "Edit" button
    And the user enter following information
      | Name    | Kuscubasi Company |
      | Phone   | 0987654321        |
      | Mobile  | 0123456789        |
      | Email   | contact@gmail.com |
    And the user click "Save" button
    Then user should see all information to that contact


  Scenario Outline: user should not enter invalid data
    When the user click "ABC Company" contact
    And the user click "Edit" button
    And the user enter following"<mobile>" "<phone>"
    And the user click "Save" button
    Then the user see alert message
    Examples:
      | mobile     | phone      |
      | abcd       | 0123456789 |
      | 0123456789 | abcd       |