Feature: application login

  Background:
    Given Zoho web loads successfully

  @Smoke
  Scenario: Login with Valid Credentials
    Then user enter valid email address and correct password login should be successful
    Then user logout

  Scenario: Sign Up process-New User
    When click on "sign up" button on homepage
    Then enter valid email address
    And complete the registration form
    Then click "create account" button
    And verify account creation success message