@newproducts
Feature: The user can create a new product

  Background:

    Given the user logged in
    And the user navigate to "Inventory" "Products"
    And the user clicked "Create" button

  Scenario: new product creation
    When  the user enters the following information
      |Name              |Max     |
      |Product Type      | Service  |
      |Internal Reference| Tirana   |
      |Sales Price       | 3.00     |
      |Cost              | 15.00    |
    And the user click "Save" button
    Then title should contain "Max"

  Scenario: new product creation- negative
    When  the user enters the following information
      |Name              |Max    |
      |Product Type      | Service  |
      |Internal Reference| Tirana   |
      |Sales Price       | sales    |
      |Cost              | 15.00    |
    And the user click "Save" button
    Then the user see warning dialog box

  Scenario: new product creation- negative
    When  the user enters the following information
      |Name              |Max   |
      |Product Type      | Service  |
      |Internal Reference| Tirana   |
      |Sales Price       | 3.00     |
      |Cost              | cost     |
    And the user click "Save" button
    Then the user see warning dialog box

  Scenario Outline: new product click funktions
    When the user click "<checkBox>" check box
    Then the user should see "<options>"

  Examples:
  |checkBox        |options  |
  |Can be Sold     |Sales    |
  |Can be Purchased|Purchase |
  |Can be Expensed |Inventory|