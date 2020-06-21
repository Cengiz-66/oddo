Feature: the user can create a new bank account

	# crmManager - invUser - invManager
  @wip
  Scenario: navigation test
    Given the user is logged in as "crmManager"
    And the user navigate to "Contacts" and "Bank Accounts"
    And clicks to bank accounts link
    And the user clicks "Create" button
    Then title should contain "New"


  Scenario: new bank account creation
    When the user enters the following information
      | Account Number | TR9874561230 |
      | ABA/Routing    | 123456789    |
      | Bank           | CAPITAL ONE  |
    And the user clicks "Save" button
    Then title should contain "TR9874561230"



  Scenario Outline: new bank account creation-negative
    When the user enters the following "<Account Number>" "<ABA/Routing>"
    And bank "CAPITAL ONE"
    And the user clicks "Save" button
    Then User should get "xxxx" warning message
    Examples:
      | Account Number | ABA/Routing |
      | TR9874561230   | 123456789   |
      | DE9874563215   | ABA         |