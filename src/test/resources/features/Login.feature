@login
Feature: Users should be able to login

  Background: the user is on the login page

    # crmManager - invUser - invManager
  Scenario: Login as eventscrmmanager
    When the user enter the "crmManager" information
    Then the user should be able to login

