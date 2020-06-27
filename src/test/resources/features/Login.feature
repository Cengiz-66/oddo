@login
Feature: Users should be able to login

  Background:
  Given the user is logged in

    # crmManager - invUser - invManager
  Scenario: Login as eventscrmmanager
    When the user enter the "crmManager" information
    Then the user should be able to login

