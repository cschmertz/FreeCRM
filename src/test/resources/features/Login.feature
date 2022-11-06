@Regression
Feature: login page
    I should be able to login with the correct credentials.
    I should be able to sign up for a new account.
    I should be able to retrieve a forgotten password.
    I should have my password stored in my browser.

    Background: On the login page
    Given I am on the login page

  @Smoke @Valid_login
  Scenario: Login with correct credentials
    When I enter the correct username and password
      |cschmertz@gmail.com|
      |practicePassword123|
    Then I should be signed in and taken to the homepage

  @Smoke @Invalid_login
    Scenario: Login with incorrect credentials
      When I enter invalid credentials
      Then I should see an error message

  @Sign_up
    Scenario: Sign up for new account
      When I sign up for a new account
      Then I am taken to the registration page

  @Forgot_password
    Scenario: Forgot password
      When I request a new password
      Then I am taken to the password reset page

   @Cookies
    Scenario: Check stored password
     When I attempt to sign in
     Then cookies should be enabled