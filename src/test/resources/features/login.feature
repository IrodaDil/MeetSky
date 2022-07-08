
Feature: Login functionality
  As a user, I should be able to login.

@wip
  Scenario: Testing web page
  Given user go to meetSky page
  When user enters valid "username" to the username box

Scenario: Verifying that login functionality with valid credentials
  Given user go to the login page
  When user enters valid "username" to the username box
  And user enters valid "password" to the password box
  And user clicks the log in button
  Then user should be navigate to main page

  Scenario: Verifying that user can not login with invalid password
    Given user go to the login page
    When user enters valid "username" to the username box
    And user enters invalid password to the password box
    And user clicks the log in button
    Then  user should see Wrong username or password

    Scenario: Verifying that user can not login with empty credentials (empty password)
      Given user goes to login page
      When user enters invalid username to username box
      And user clicks the log in button
      Then user should see please fill out this filed message in password box

  Scenario: Verifying that user can see the password in a form of dots by default
    Given user goes to login page
    When user enters valid "password" to the password box
    Then user can see the password in a form of dots by default

  Scenario: Verifying that user can see the password explicitly if needed
    Given user goes to login page
    When user enters valid "password" to the password box
    And user click eye icon next to password
    Then user can see the password explicitly if needed

  Scenario: Verifying that user can see the "Forgot password?" link on the login page
    Given user goes to login page
    When user clicks Forgot password link on the login page
    Then user can see Reset Password button on the next page

  Scenario: Verifying that an see valid placeholders on Username
    Given user goes to login page
    Then user can see valid placeholders on username

  Scenario: Verifying that an see valid placeholders on Password
    Given user goes to login page
    Then user can see valid placeholders on password








